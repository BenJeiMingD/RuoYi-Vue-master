
<template>
  <div>
    <el-table
      :data="tableData"
      style="
        width: 99%;
        margin: 10px auto;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
        text-align: center;
      "
      rowKey="indexId"
      border
      default-expand-all
      :cell-class-name="cellClassName"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="IssueNumber" label="期号" width="80">
      </el-table-column>
      <el-table-column prop="primaryId" label="组序号" width="80">
      </el-table-column>
      <el-table-column prop="childId" label="子序号" width="80">
      </el-table-column>
      <el-table-column prop="mouldType" label="成型" width="140">
      </el-table-column>
      <el-table-column prop="TyreSize" label="寸别" width="100">
      </el-table-column>
      <el-table-column prop="ModeType" label="类型" width="140">
      </el-table-column>
      <el-table-column prop="Max_day_output" label="日产值" width="140">
      </el-table-column>
      <el-table-column prop="duration" label="天数" width="80">
      </el-table-column>
      <el-table-column prop="MaxSum" label="本期最大产能" width="140">
        <template slot-scope="scope">
          <el-input v-model="scope.row.MaxSum"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <el-button type="success" plain size="medium">保存</el-button>
        <el-button type="danger" plain size="medium">删除</el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

import Vue from 'vue'
import router from '../../../router'
import editTable from '../../tool/gen/editTable.vue'

export default {
  components: { editTable },
  name: "OutputAdjustment",
  data () {
    return {
      tableData: [],                                                    //存放接收的数据库数据
      id: 0,                                                            //id(编号/存放产能估算传递的id)
      IssueNumber: '',                                                  //期号
      primaryId: 0,                                                     //组序号
      childId: 0,                                                       //子序号
      mouldType: '',                                                    //成型方式选项
      TyreSize: '',                                                     //寸别
      ModeType: '',                                                     //类型
      Max_day_output: 0,                                                //日产能
      duration: 0,                                                      //天数
      MaxSum: 0,                                                        //本期产能合计
      tempDate: {}                                                      //临时存放数据
    }
  },
  mounted () {
    this.getEvaluationDate()
    // this.reloadPage()
  },
  // watch () {

  // },
  methods: {
    // reloadPage () {
    //   location.reload()
    // },

    getEvaluationDate () {

      let that = this
      console.log("跳转至产能调整页面")
      console.log(this.$route.query.issueNumber)
      this.IssueNumber = this.$route.query.issueNumber
      let issueNumber = this.$route.query.issueNumber
      let CyDeptpo = {}
      CyDeptpo.issueNumber = issueNumber
      CyDeptpo = JSON.stringify(CyDeptpo)
      console.log(CyDeptpo)
      Vue.axios.post('http://paichan.free.svipss.top/deptpo/list', {
        data: { CyDeptpo }
      }).then(function (response) {
        console.log(response)
        var resData = response.data
        that.setTableData(resData)
        // console.log(resData)
      }).catch(function (error) {
        console.log(error)
      })
    },

    //tableData存入获取的值
    setTableData (data) {

      console.log(data)
      // console.log(data[0].sumProductive)



      for (let i = 0; i < data.length; i++) {

        // if (data[i].issueNumber == this.$route.query.IssueNumber) { }

        this.tempDate.IssueNumber = data[i].issueNumber              //期号
        this.tempDate.indexId = data[i].indexId                      //获取组indexId
        this.tempDate.primaryId = data[i].indexId                    //组序号
        if (data[i].type == 1) {                                     //成型方式
          this.tempDate.mouldType = "胶囊反包"
        } else if (data[i].type == 2) {
          this.tableData.mouldType = "弹簧反包"
        } else {
          this.tempDate.mouldType = "二次法成型"
        }

        // this.tempDate.mouldType = data[i].type
        if (data[i].classification == 1) {                            //类型
          this.tempDate.ModeType = "半钢"
        } else {
          this.tempDate.ModeType = "斜胶"
        }
        // this.tempDate.ModeType = data[i].classification
        this.tempDate.Max_day_output = data[i].todayNumber           //日产值
        this.tempDate.duration = data[i].duration                    //天数
        this.tempDate.MaxSum = data[i].sumProductive                 //本期最大产能
        this.tempDate.level = data[i].level                          //组子标识
        this.tempDate.children = []
        if (data[i].children != null) {
          for (let j = 0; j < data[i].children.length; j++) {
            let tempChildren = {}
            tempChildren.indexId = data[i].children[j].indexId       //获取子indexId
            tempChildren.childId = data[i].children[j].indexId % 10  //子序号
            if (data[i].children[j].type == 1) {                        //成型方式
              tempChildren.mouldType = "胶囊反包"
            } else if (data[i].children[j].type == 2) {
              tempChildren.mouldType = "弹簧反包"
            } else {
              tempChildren.mouldType = "二次法成型"
            }
            // tempChildren.mouldType = data[i].children[j].type
            tempChildren.TyreSize = data[i].children[j].size            //寸别
            if (data[i].children[j].classification == 1) {              //类型
              tempChildren.ModeType = "半钢"
            } else {
              tempChildren.ModeType = "斜胶"
            }
            // tempChildren.ModeType = data[i].children[j].classification
            tempChildren.Max_day_output = data[i].children[j].todayNumber  //最大日产值
            tempChildren.level = data[i].children[j].level        //组子标识
            this.tempDate.children.push(tempChildren)
            console.log(data[i].children[j].indexId)
          }
          this.tempDate.children
        }
        console.log(this.tempDate)
        this.tableData.push(this.tempDate)
        console.log(this.tableData)
        this.tempDate = {}
      }

      this.tempDate                        //寸别
    },

    //操作单元格样式
    cellClassName (row, column, rowIndex, columnIndex) {
      console.log(row)
      if (row.row.level == 2 && row.column.label == '本期最大产能') {
        return "hideInput"
      }
    }
  }
}
</script>

<style>
.hideInput .el-input {
  visibility: hidden;
}
</style>
