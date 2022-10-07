<template>
  <div>
    <el-row
      :span="24"
      style="margin: 10px; display: flex; justify-content: flex-end"
    >
      <el-button type="primary" icon="el-icon-folder-add" @click="addRow()"
        >添加组</el-button
      >
      <el-button
        type="primary"
        icon="el-icon-document-add"
        @click="addChildRowData()"
        :plain="true"
        >添加数据</el-button
      >
    </el-row>
    <el-table
      :data="tableData"
      style="width: 99%; margin: 10px 5px 10px 5px"
      row-key="indexId"
      border
      default-expand-all
      current-row-key
      max-height="800px"
      ref="singleTable"
      highlight-current-row
      :cell-class-name="cellClassName"
      @row-click="handleClickRow"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column
        prop="primaryId"
        label="组序号"
        width="80"
      ></el-table-column>

      <el-table-column
        prop="childId"
        label="子序号"
        width="80"
      ></el-table-column>

      <el-table-column label="限制条件" width="320">
        <el-table-column prop="mouldValue" label="成型方式" width="180">
          <template slot-scope="scope">
            <!-- <el-select v-model="options.value" placeholder="请输入值"> -->
            <el-select
              ref="mouldSelect"
              v-model="scope.row.mouldValue"
              placeholder="请选择成型方式"
              @change="changeMouldValue"
              @click.native="clickMouldType($event)"
            >
              <el-option
                v-for="item in mouldType"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </template>
        </el-table-column>

        <el-table-column prop="TyreSelect" label="寸别" width="140">
          <template slot-scope="scope">
            <!-- <el-select v-model="options.value" placeholder="请输入值"> -->
            <el-select v-model="scope.row.TyreSelect" placeholder="请选择值">
              <span>
                <el-option
                  v-for="item in TyreSize"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </span>
            </el-select>
          </template>
        </el-table-column>
      </el-table-column>

      <el-table-column
        prop="Max_day_output_sum"
        label="最大日产值"
        sortable
        width="180"
      >
        <template slot-scope="scope">
          <!-- <el-select v-model="options.value" placeholder="请输入值"> -->
          <el-input
            @click.stop.native="rowOnBlur($event)"
            @change.native="getMaxOutput($event)"
            v-model="scope.row.Max_day_output"
            placeholder="请输入最大日产值"
          >
          </el-input>
        </template>
      </el-table-column>

      <el-table-column prop="totalSum" label="类型" width="140">
        <template slot-scope="scope">
          <!-- <el-select v-model="options.value" placeholder="请输入值"> -->
          <el-select
            v-model="scope.row.Mode"
            placeholder="请选择类型"
            ref="modeTypeSelect"
            @change="modeSelect"
            @click.native="clickModeType"
          >
            <span>
              <el-option
                v-for="item in ModeType"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </span>
          </el-select>
        </template>
      </el-table-column>

      <el-table-column prop="" label="操作">
        <template slot-scope="scope">
          <el-button
            type="primary"
            plain
            @click.stop="SendRequest(scope.$index, scope.row)"
            >确认</el-button
          >
          <el-button
            type="danger"
            plain
            @click.stop="DeleteRow(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>



<script>
import axios, { Axios } from 'axios'
import Vue from 'vue'
import { param } from '../../../utils'

import { formatDate } from '../../../utils'
export default {
  data () {
    return {
      level: '',            //层级
      primaryId: 0,         //组序号
      childId: 0,           //子序号
      indexId: 0,           //索引
      TyreSelect: 0,       //选择的寸别
      TyreSize: [
        { value: '1', label: '4' }, { value: '2', label: '5' }, { value: '3', label: '6' },
        { value: '4', label: '7' }, { value: '5', label: '8' }, { value: '6', label: '9' },
        { value: '7', label: '10' }, { value: '8', label: '11' }, { value: '9', label: '12' },
        { value: '10', label: '14' }, { value: '11', label: '15' }, { value: '12', label: '18' },
        { value: '13', label: '20' }], //寸别

      Mode: '',                //选择类型
      ModeType: [{ value: '1', label: '半钢' }, { value: '2', label: '斜胶' }],       //类型

      Max_day_output_sum: 0,  //本组中最大日产能合计
      Max_day_output: 0,   //最大日产能
      totalSum: '',         //合计总数
      tempData: {},
      tempChildren: {},
      // tempChildData: [], //子数据
      tableData: [],        //组数据
      currentRow: null,     //当前的选中的行
      oldCurrentRow: null,

      mouldValue: '',       //选择的成型方式
      mouldType: [{         //成型方式选项
        value: '1',
        label: '胶囊反包'
      },
      {
        value: '2',
        label: '弹簧反包'
      },
      {
        value: '3',
        label: '二次法成型'
      }],
      timeArray: '',           //系统时间

      deptzhuId: 0,             //后端组数据ID字段
      deptId: 0,                 //后端子数据ID字段
    }
  },


  // created () {

  // },

  // computed: {

  // },

  mounted: function () {
    //加载产能模板页面时调用获取已有模板
    this.getModuleList()
  },

  // watch: {
  //   tableData: {
  //     handler (newValue, oldValue) {
  //       if (newValue != oldValue) {
  //         this.$forceUpDate()
  //       }
  //     },
  //     deep: true,
  //     immediate: true
  //   }
  // },

  methods: {
    //加载页面时获取已有的模板
    getModuleList () {
      let that = this
      Vue.axios.get('http://paichan.free.svipss.top/capacity/template/selectDeptList', {

      }).then(function (response) {
        console.log(response)
        var dataList = response.data
        console.log(dataList)
        for (let i = 0; i < dataList.length; i++) {
          that.tempData.deptzhuId = dataList[i].id
          that.tempData.indexId = dataList[i].indexId
          that.tempData.level = dataList[i].level
          that.tempData.primaryId = dataList[i].indexId
          that.tempData.mouldValue = dataList[i].type
          that.tempData.Max_day_output = dataList[i].todayNumber
          that.tempData.Mode = dataList[i].classification
          that.tempData.children = []
          console.log(that.tempData)
          if (dataList[i].children != null) {
            for (let j = 0; j < dataList[i].children.length; j++) {
              console.log(dataList[i].children[j])
              that.tempChildren.deptId = dataList[i].children[j].deptId
              that.tempChildren.indexId = dataList[i].children[j].indexId
              that.tempChildren.level = dataList[i].children[j].level
              that.tempChildren.childId = j + 1
              that.tempChildren.mouldValue = dataList[i].children[j].type
              that.tempChildren.TyreSelect = dataList[i].children[j].size
              that.tempChildren.Max_day_output = dataList[i].children[j].todayNumber
              that.tempChildren.Mode = dataList[i].children[j].classification
              that.tempData.children.push(that.tempChildren)
              that.tempChildren = {}
              console.log(that.tempData.children)
            }
          }
          that.tableData.push(that.tempData)
          that.tempData = {}
          console.log(that.tableData)
        }
      }).catch(function (error) {
        console.log(error)
      })
    },

    //添加组
    addRow () {

      var tempId = this.tableData.length + 1
      this.tempData.id = tempId
      this.tempData.level = 1 //组数据为1
      this.tempData.primaryId = tempId //初始化组序号
      this.tempData.indexId = tempId //初始化索引
      this.tempData.Date = this.getDate() //初始化添加组时间
      this.tempData.isActivated = false //初始化选中状态
      this.tempData.Max_day_output_sum = this.Max_day_output_sum  //初始化本组最大日产能合计
      this.tempData.Max_day_output = this.Max_day_output //初始化本组最大日产能合计
      this.tempData.mouldValue = this.mouldValue
      this.tempData.Mode = this.Mode
      this.tempData.children = [] //初始化子数据对象

      let obj = JSON.parse(JSON.stringify(this.tempData))
      this.tableData.push(obj) //添加到组数组对象
      this.getPrimaryID()  //发送get请求获取组ID
      console.log(this.tableData)
      this.tempData = {} //置空
      tempId = 0 //置空

    },


    //添加子数据

    addChildRowData (currentRow, row) {
      // console.log(this.oldCurrentRow)
      console.log(this.currentRow)
      // this.nextTick(() => {

      // })
      if (this.currentRow && this.currentRow.level == 1) {
        var tempId = this.currentRow.children.length + 1
        this.tempData.level = 2 //子数据为2
        this.tempData.primaryRowId = this.currentRow.indexId - 1 //子数据所属组数据ID
        this.tempData.childId = tempId //初始化childID

        this.tempData.indexId = this.currentRow.primaryId * 10 + tempId //初始化索引
        this.tempData.Date = this.getDate() //初始化添加子数据时间
        // this.tempData.mouldType = this.mouldType //初始化成型方式
        this.tempData.mouldValue = this.currentRow.mouldValue //选择的成型方式
        this.tempData.TyreSize = this.TyreSelect //初始化寸别
        this.tempData.Max_day_output = this.Max_day_output //初始化最大日产值
        this.tempData.Mode = this.currentRow.Mode //初始化类型
        this.tempData.isActivated = false //初始化选中状态
        this.tempData.deptzhuId = this.currentRow.deptzhuId //本组ID
        let obj = JSON.parse(JSON.stringify(this.tempData))
        console.log(this.tableData)
        this.tableData[this.currentRow.indexId - 1].children.push(obj) //当前组数据中插入子数据
        this.getChildId()  //添加子数据时获取子数据ID
        console.log(this.tableData)
        this.tempData = {}
        tempId = 0
        console.log(this.currentRow)

      } else {
        this.$notify({
          title: '操作错误',
          message: '请先选择组再添加数据',
          type: 'warning'
        })
      }

    },


    //取消选中行状态
    setCurrent (row) {
      this.$refs.singleTable.setCurrentRow()
    },

    //点击行触发事件
    handleClickRow (row, column, event) {
      console.log(this.tableData)
      if (this.currentRow) {
        if (this.currentRow.level == 1) {  //currentRow是否是组数据
          if (row.level == 1) {  //currentRow是组数据，点击的是组数据
            if (row.index == this.currentRow.index) {  //两次点击是同一组数据
              this.tableData[row.indexId - 1].isActivated = false
              this.setCurrent(row)
              this.oldCurrentRow = this.currentRow
              this.currentRow = null
              console.log("currentRow是组数据，再次选中此组，取消激活组数据")
            } else {  //两次点击不同组数据
              this.tableData[row.indexId - 1].isActivated = true
              this.tableData[this.currentRow.indexId - 1].isActivated = false
              this.currentRow = row
              console.log(this.currentRow)
              console.log("两次点击不同组数据走这里")
            }
          } else { //currentRow是组数据，点击的是子数据
            this.tableData[this.currentRow.indexId - 1].isActivated = false
            this.tableData[row.primaryRowId].children[row.childId - 1].isActivated = true
            // this.setCurrent(this.tableData[row.primaryRowId].children[row.childId - 1])
            this.currentRow = row
            this.oldCurrentRow = this.currentRow
            console.log(this.currentRow)
            console.log("currentRow是组数据，激活的是子数据")
          }
        } else {  //currentRow是子数据

          if (row.level == 2) {  //currentRow是子数据,再次选中子数据
            console.log(row.childId)
            console.log(this.currentRow.childId)
            console.log(row)
            if (row.indexId == this.currentRow.indexId) {  //选中的是同一子数据
              console.log(this.tableData[row.primaryRowId].children[row.childId - 1])
              this.tableData[row.primaryRowId].children[row.childId - 1].isActivated = false
              this.setCurrent()
              this.currentRow = null
              console.log("currentRow是子数据,再次选中子数据取消选中")
            } else {  //选中的是不同的子数据
              console.log(this.currentRow)
              console.log(row)
              this.tableData[row.primaryRowId].children[row.childId - 1].isActivated = true
              this.tableData[this.currentRow.primaryRowId].children[this.currentRow.childId - 1].isActivated = false
              this.currentRow = row
              console.log("current是子数据，再次选中不同的子数据")
            }
          } else {  //currentRow是子数据，选中组数据
            this.tableData[this.currentRow.primaryRowId].children[this.currentRow.childId - 1].isActivated = false
            this.tableData[row.indexId - 1].isActivated = true
            this.currentRow = row
          }
        }
      }
      else {  //第一次进入走这里，currentRow里还未存放数据

        if (row.level == 1) {  //判断是否是组数据
          this.currentRow = row
          this.tableData[this.currentRow.indexId - 1].isActivated = true
          console.log("激活组数据")
        } else {  //找到子数据的位置
          this.currentRow = row
          console.log(this.currentRow)
          this.tableData[this.currentRow.primaryRowId].children[this.currentRow.childId - 1].isActivated = true
          console.log("激活子数据")
        }
      }


    },

    //添加组数据时获取组ID
    getPrimaryID () {
      let that = this
      var Data = that.tableData[that.tableData.length - 1]
      var reqData = this.translateSet(Data)
      var rowData = JSON.stringify(reqData)
      console.log(rowData)
      Vue.axios.post('http://paichan.free.svipss.top/capacity/template',
        {
          data: { rowData }
        }
      ).then(function (response) {
        console.log(response)
        that.deptzhuId = response.data.data   //创建组时获取组ID
        that.tableData[that.tableData.length - 1].deptzhuId = response.data.data
      }).catch(function (error) {
        console.log(error)
      })
    },

    //添加子数据时获取子数据ID
    getChildId () {
      let that = this
      let Data = that.tableData[that.currentRow.indexId - 1].children[that.currentRow.children.length - 1]
      console.log(Data)
      let reqData = this.translateSet(Data, that.deptzhuId)
      var data = {}
      data.rowData = JSON.stringify(reqData)
      data = JSON.stringify(data)
      console.log(data)
      Vue.axios.post('http://paichan.free.svipss.top/capacity/templateInfo',
        {
          data
        }
      ).then(function (response) {
        console.log(response)
        that.deptId = response.data.data
        that.tableData[that.currentRow.indexId - 1].children[that.currentRow.children.length - 1].deptId = response.data.data

      }).catch(function (error) {
        console.log(error)
      })

    },

    //发送行数据
    SendRequest (index, row) {
      let that = this
      console.log(index)
      console.log(row)
      var rowData = JSON.stringify(this.translateRow(row)[0])
      // var newData = JSON.parse(rowData)
      // var str = newData[0]
      // console.log(str)
      // console.log(newData)
      console.log(rowData)
      Vue.axios.post('http://paichan.free.svipss.top/capacity/templateupdate', {
        data: { rowData }
      }).then(function (response) {
        console.log(response)
      }).catch(function (error) {
        console.log(error)
      })
      // if (row.level == 1) {
      //   Vue.axios.post('http://testpaichan.free.svipss.top/capacity/templateupdate', {
      //     data
      //   }).then(function (response) {
      //     console.log(response)
      //   }).catch(function (error) {
      //     console.log(error)
      //   })
      // }
      // if (this.currentRow) {
      //   if (this.currentRow.level == 1) {
      //     let rowData = this.translateSet(this.currentRow)
      //     console.log(rowData)

      //     Vue.axios.post('http://testpaichan.free.svipss.top/capacity/templateupdate',
      //       {
      //         data: { rowData }
      //       }
      //     )
      //       .then(function (response) {
      //         console.log(response)
      //       }).catch(function (error) {
      //         console.log(error)
      //       })
      //   } else {
      //     let rowData = this.currentRow
      //     console.log(rowData)
      //     Vue.axios.post('http://testpaichan.free.svipss.top/capacity/templateupdate',
      //       {
      //         data: { rowData }
      //       }
      //     )
      //       .then(function (response) {
      //         console.log(response)
      //       }).catch(function (error) {
      //         console.log(error)
      //       })
      //   }
      // } else {
      //   this.$notify({
      //     title: '操作错误',
      //     message: '请先选将要发送的行数据再点确定',
      //     type: 'error'
      //   })
      // }
    },

    //删除选中行
    DeleteRow (index, row) {
      let that = this
      console.log(row)
      if (row.level == 1) {
        let data = {}
        data.deptzhuId = row.deptzhuId                 //删除时发送的组ID
        data.deptzis = []                               //删除时发送的子ID数组
        if (row.children.length != null) {
          for (let i = 0; i < row.children.length; i++) {
            data.deptzis.push(row.children[i].deptId)
          }
        }
        data = JSON.stringify(data)
        console.log(data)
        Vue.axios.post('http://paichan.free.svipss.top/capacity/templatedelete', {
          data
        }).then(function (response) {
          console.log(response)
          if (response.data.code == 200) {
            that.tableData.splice(index, 1)
          } else {
            that.$notify({
              title: '无法删除',
              message: '删除出现错误',
              type: 'error'
            })
          }
        }).catch(function (error) {
          console.log(error)
        })
      }

    },


    //通过每一行的row-class-name判断是否是组数据，组数据改变样式
    // tableRowClassName ({ row, rowIndex }) {
    //   console.log(row)
    //   // console.log(rowIndex)
    //   if (row.level == 1) {
    //     return 'primaryRowStyle'
    //   }
    // },

    //获取当前时间
    getDate () {
      this.timeArray = formatDate(new Date())
      return this.timeArray
    },

    //点击成型方式判断聚焦
    clickMouldType (event) {
      if (!this.currentRow || this.currentRow.level == 2) {
        this.$refs.mouldSelect.blur()
        this.$notify({
          title: '操作错误',
          message: '请选择组数据再选择成型方式',
          type: 'error'
        })
      }
    },


    //更改同一组数据的成型方式
    changeMouldValue (event) {
      if (this.currentRow) {
        if (this.currentRow.level == 1) {
          if (this.currentRow.children.length > 0) {
            for (let i = 0; i < this.currentRow.children.length; i++) {
              this.tableData[this.currentRow.indexId - 1].children[i].mouldValue = this.tableData[this.currentRow.indexId - 1].mouldValue
            }
          }
        }
      }
    },

    //获取每一条数据最大日产值
    getMaxOutput (event) {

      for (let i = 0; i < this.tableData[this.currentRow.primaryRowId].children.length; i++) {
        this.Max_day_output_sum += Number(this.tableData[this.currentRow.primaryRowId].children[i].Max_day_output)
      }
      this.tableData[this.currentRow.primaryRowId].Max_day_output = this.Max_day_output_sum
      this.Max_day_output_sum = 0
    },

    //选择子数据填写最大日产值判断聚焦
    rowOnBlur (event) {
      if (this.currentRow && this.currentRow.level != 1) {
        event.srcElement.focus()
        console.log("blur")
      } else {
        event.srcElement.blur()
        this.$notify({
          title: '操作错误',
          message: '请选择子数据进行填写',
          type: 'error'
        })
      }
    },

    //点击类型判断聚焦
    clickModeType () {
      if (!this.currentRow || this.currentRow.level == 2) {
        this.$refs.modeTypeSelect.blur()
        this.$notify({
          title: '操作错误',
          message: '请选择组数据再选择类型',
          type: 'error'
        })
      }
    },

    //选择类型
    modeSelect () {
      if (this.currentRow) {
        if (this.currentRow.level == 1) {
          if (this.currentRow.children.length > 0) {
            for (let i = 0; i < this.currentRow.children.length; i++) {
              this.tableData[this.currentRow.indexId - 1].children[i].Mode = this.tableData[this.currentRow.indexId - 1].Mode
            }
          }
        }
      }
    },


    //添加组/子的时候转换字段
    translateSet (row, deptzhuId) {
      console.log(row)
      console.log(this.tableData)

      if (row.level == 1) {
        var reqData = {}
        reqData.id = row.primaryId                       //组ID
        // if (row.mouldValue == 1) {                       //成型方式
        //   reqData.type = "胶囊反包"
        // } else if (row.mouldValue == 2) {
        //   reqData.type = "弹簧反包"
        // } else {
        //   reqData.type = "二次发成型"
        // }
        reqData.type = row.mouldValue
        reqData.todayNumber = row.Max_day_output         //最大日产值
        reqData.classification = row.Mode                //类型
        reqData.level = row.level                        //组子标识
        reqData.indexId = row.indexId                    //索引
        console.log(reqData)
        return reqData
      } else if (row.level == 2) {
        var reqChildren = {}
        reqChildren.deptzhuId = row.deptzhuId
        reqChildren.deptId = row.childId                    //子ID
        reqChildren.size = row.TyreSize                     //寸别
        reqChildren.todayNumber = row.Max_day_output        //最大日产值
        reqChildren.classification = row.Mode               //类型
        reqChildren.type = row.mouldValue                   //成型方式
        reqChildren.level = row.level                       //组子标识
        reqChildren.indexId = row.indexId                   //索引
        // reqChildren.id = this.tableData[row.primaryRowId].

        console.log(reqChildren)
        return reqChildren
      }

    },

    //发送行数据时转换字段
    translateRow (row) {
      console.log(row)
      var reqTableData = []
      var reqData = {}
      var tempChildren = {}

      //点击组数据的确认按钮时调用此函数
      if (row.level == 1) {
        reqData.id = row.primaryId
        if (row.mouldValue == 1) {                       //成型方式
          reqData.type = "胶囊反包"
        } else if (row.mouldValue == 2) {
          reqData.type = "弹簧反包"
        } else {
          reqData.type = "二次发成型"
        }
        // reqData.type = row.mouldValue
        reqData.size = row.size
        reqData.todayNumber = row.Max_day_output
        if (row.Mode == 1) {                    //类型
          reqData.classification = "半钢"
        } else {
          reqData.classification = "斜胶"
        }
        // reqData.classification = row.Mode
        reqData.deptzhuId = row.deptzhuId
        reqData.level = row.level
        reqData.indexId = row.indexId
        reqData.children = []
        console.log(row)
        if (row.children.length > 0) {
          for (let j = 0; j < row.children.length; j++) {
            console.log(row.children)
            tempChildren.deptId = row.children[j].deptId
            if (row.children[j].mouldValue == 1) {                       //成型方式
              tempChildren.type = "胶囊反包"
            } else if (row.children[j].mouldValue == 2) {
              tempChildren.type = "弹簧反包"
            } else {
              tempChildren.type = "二次发成型"
            }
            // tempChildren.type = row.children[j].mouldValue
            tempChildren.size = row.children[j].TyreSelect
            tempChildren.todayNumber = row.children[j].Max_day_output
            if (row.children[j].Mode == 1) {                    //类型
              tempChildren.classification = "半钢"
            } else {
              tempChildren.classification = "斜胶"
            }
            // tempChildren.classification = row.children[j].Mode
            tempChildren.level = row.children[j].level
            tempChildren.indexId = row.children[j].indexId
            console.log(tempChildren)
            reqData.children.push(tempChildren)
            tempChildren = {}
          }
        }
        reqTableData.push(reqData)
        console.log(reqTableData)
        reqData = {}
        return reqTableData
      } else if (row.level == 2) {            //点击子数据确认按钮时调用此函数
        reqData.id = this.tableData[row.primaryRowId].primaryId
        reqData.type = this.tableData[row.primaryRowId].mouldValue
        reqData.size = this.tableData[row.primaryRowId].TyreSelect
        reqData.todayNumber = this.tableData[row.primaryRowId].Max_day_output
        reqData.classification = this.tableData[row.primaryRowId].Mode
        reqData.deptzhuId = this.tableData[row.primaryRowId].deptzhuId
        reqData.level = this.tableData[row.primaryRowId].level
        reqData.indexId = this.tableData[row.primaryRowId].indexId
        reqData.children = []
        for (let j = 0; j < this.tableData[row.primaryRowId].children.length; j++) {
          tempChildren.deptId = this.tableData[row.primaryRowId].children[j].deptId
          tempChildren.type = this.tableData[row.primaryRowId].children[j].mouldValue
          tempChildren.size = this.tableData[row.primaryRowId].children[j].TyreSelect
          tempChildren.todayNumber = this.tableData[row.primaryRowId].children[j].Max_day_output
          tempChildren.classification = this.tableData[row.primaryRowId].children[j].Mode
          tempChildren.level = this.tableData[row.primaryRowId].children[j].level
          tempChildren.indexId = this.tableData[row.primaryRowId].children[j].indexId
          console.log(tempChildren)
          reqData.children.push(tempChildren)
          tempChildren = {}
        }

        reqTableData.push(reqData)
        console.log(reqTableData)
        reqData = {}
        return reqTableData
      }


    },

    //第一次进入页面获取数据
    translateGet (response) {
      console.log(that.tableData)

    },


    cellClassName (row, column, rowIndex, columnIndex) {
      //隐藏组数据寸别选项
      if (row.row.level == 1 && row.column.label == '寸别') {
        return "hideSelect"
      }

      //组数据最大日产值不可编辑
      if (row.row.level == 1 && row.column.label == '最大日产值') {
        return "hideInput"
      }

      //子数据成型方式不可选取
      if (row.row.level == 2 && row.column.label == '成型方式') {
        return "hideSelectType"
      }

      //子数据类型不可选取
      if (row.row.level == 2 && row.column.label == '类型') {
        return "hideSelectMode"
      }
    }
  }
}

</script>

<style>
table thead tr th {
  text-align: center !important;
}

.hideSelect .el-select {
  visibility: hidden;
}

.hideInput .el-input {
  pointer-events: none;
  opacity: 0.45;
}

.hideSelectType .el-select {
  pointer-events: none;
  opacity: 0.45;
}

.hideSelectMode .el-select {
  pointer-events: none;
  opacity: 0.45;
}
</style>

