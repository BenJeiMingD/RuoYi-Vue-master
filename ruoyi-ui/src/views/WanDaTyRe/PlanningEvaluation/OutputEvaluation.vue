<template>
  <div>
    <el-row
      style="margin: 15px 20px"
      :gutter="16"
      type="flex"
      justify="space-between"
    >
      <el-col :span="8" style="display: flex; align-items: center">
        <span style="width: 160px; text-align: center">选择起始结束日期:</span>
        <el-date-picker
          v-model="tempDate"
          value-format="yyyy-MM-dd"
          time-arrow-control:true
          type="daterange"
          align="left"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        >
        </el-date-picker>
      </el-col>

      <el-col :span="5" style="display: flex; align-items: center" :pull="4">
        <span style="width: 50px; text-align: center">天数:</span>
        <el-input placeholder="请输入时长" v-model="duration"></el-input
      ></el-col>
      <el-button
        type="primary"
        plain
        icon="el-icon-circle-plus-outline"
        @click="addRow"
        >添加期数</el-button
      >
    </el-row>
    <el-table
      :data="tableData"
      border
      style="
        width: 99%;
        margin-left: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
      "
    >
      <el-table-column label="编号" width="80" property="id"> </el-table-column>

      <el-table-column
        sortable
        label="期号"
        width="80"
        property="IssueNumber"
      ></el-table-column>

      <el-table-column label="起始时间" width="180" prop="startTime">
      </el-table-column>

      <el-table-column
        label="结束时间"
        width="180"
        prop="endTime"
      ></el-table-column>

      <el-table-column
        label="天数"
        width="140"
        prop="duration"
      ></el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            label="确认生成"
            size="medium"
            icon="el-icon-check"
            type="primary"
            @click="handleConfirm(scope.$index, scope.row)"
            >确认生成</el-button
          >
          <el-button
            label="查看调整"
            size="medium"
            icon="el-icon-search"
            type="info"
            @click="handleCheck(scope.$index, scope.row)"
            >查看调整</el-button
          >
          <el-button
            size="medium"
            icon="el-icon-delete"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { query } from 'quill'
import Vue from 'vue'
import router from '../../../router'
import OutputAdjustment from './OutputAdjustment.vue'

export default {

  data () {
    return {

      id: '',                        //编号
      startTime: '',                 //起始时间
      endTime: '',                   //结束时间
      duration: '',                  //天数
      yerCode: '',                   //年号
      IssueNumber: '',               //期号
      deptOrder: '',                 //是否生效
      tempData: {},                  //临时存储对象

      tableData: [],                 //绑定的数据源
      pickerOptions: { shortcuts: [] },
      value1: '',
      tempDate: ''                    //选择日期临时存放
    }
  },

  //页面加载执行遍历数据渲染
  mounted () {
    //获取往期期数表数据
    this.getPastIssueData()

  },

  // computed: {

  // },

  //watch
  watch: {
    tempDate (newValue, oldValue) {
      this.duration = this.getDuration(newValue)
      // console.log(this.duration)
    }
  },

  methods: {

    //编辑所选行数据
    handleEdit (index, row) {
      console.log(index, row)
    },

    //删除所选行数据
    handleDelete (index, row) {
      console.log(index, row)
      let that = this
      let id = row.id
      Vue.axios.delete('http://paichan.free.svipss.top/capacity/templatedelete/delete/' + id, {
      }).then(function (response) {
        console.log(response)
        console.log(that.tableData)
        if (response.data.code == 200) {
          that.tableData.splice(index, 1)
        } else {
          that.$notify({
            title: '删除错误',
            message: '已被引用无法删除',
            type: 'error'
          })
        }
      }).catch(function (error) {
        console.log(error)
      })
    },

    //发送所选行数据
    handleConfirm (index, row) {
      let that = this
      // console.log(row)

      let rowData = {}
      rowData.issueNumber = row.IssueNumber
      rowData.deptqiId = row.id


      let data = JSON.stringify(rowData)
      console.log(data)
      Vue.axios.post('http://paichan.free.svipss.top/deptpo/insert',
        {
          data
        }).then(function (response) {
          console.log(response)
          if (response.data.code == 200) {
            console.log("发送成功")
          }
        }).catch(function (error) {
          console.log(error)
        })
    },

    //查看调整
    handleCheck (index, row) {
      console.log("在估算页面输出")
      console.log(row)
      router.push({ path: 'OutputAdjustment', query: { issueNumber: row.IssueNumber } })
    },


    //添加期数执行函数
    addRow () {
      // console.log(this.tempDate)
      // console.log(this.duration)
      this.tempData.startTime = this.tempDate[0]   //初始化起始日期
      this.tempData.endTime = this.tempDate[1]     //初始化结束日期
      this.tempData.duration = this.duration       //初始化天数
      this.tempData.username = this.$store.state.user.name   //获取用户名
      this.getIssueNumber()                        //发送请求获取期数和ID

      console.log(this.tableData)
    },

    //根据选择日期计算天数
    getDuration (newValue) {
      let firstTime = new Date(newValue[0])
      let secondTime = new Date(newValue[1])
      let str = new Date(secondTime - firstTime)
      let newDuration = str / (1000 * 3600 * 24)
      return newDuration
    },

    //添加期数时发送请求获取ID和期号
    getIssueNumber () {
      let that = this
      console.log(this.tempData)
      let Data = {}
      Data = JSON.stringify(this.tempData)

      Vue.axios.post('http://paichan.free.svipss.top/capacity/templatedate', {
        Data
      }).then(function (response) {
        console.log(response)
        that.tempData.id = response.data.id                       //后台获取id
        that.tempData.IssueNumber = response.data.IssueNumber     //后台获取IssueNumber
        that.tableData.push(that.tempData)                        //推进tableDate中渲染
        that.tempData = {}                                        //清空临时存储对象
      }).catch(function (error) {
        console.log(error)
      })
    },


    //获取往期期数表数据
    getPastIssueData () {
      let that = this
      Vue.axios.get('http://paichan.free.svipss.top/capacity/templatedelete/select', {
      }).then(function (response) {
        console.log(response)
        for (let i = 0; i < response.data.rows.length; i++) {
          that.tempData.id = response.data.rows[i].id
          that.tempData.IssueNumber = response.data.rows[i].issueNumber
          that.tempData.startTime = response.data.rows[i].startTime
          that.tempData.endTime = response.data.rows[i].endTime
          that.tempData.duration = response.data.rows[i].duration
          that.tableData.push(that.tempData)
          // console.log(that.tempData)
          // console.log(that.tableData)
          that.tempData = {}
        }
      }).catch(function (error) {
        console.log(error)
      })
    },


  }
}

</script>

<style>
.hiddenStyle .el-input {
  pointer-events: none;
}
</style>
