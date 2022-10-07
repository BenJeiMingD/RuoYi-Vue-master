<template>
  <div>
    <div>
      <el-row border style="width: 99%; margin: 15px auto">
        <el-col
          style="display: flex; justify-content: flex-end; padding-right: 10px"
        >
          <el-button
            type="primary"
            plain
            icon="el-icon-circle-plus-outline"
            size="medium"
            >新增</el-button
          >
        </el-col>
      </el-row>
      <el-table
        :data="tableData"
        border
        style="
          width: 99%;
          margin: 10px auto;
          box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
          text-align: center;
        "
      >
        <el-table-column
          fixed
          prop="id"
          label="ID"
          width="80"
        ></el-table-column>
        <el-table-column prop="issueNumber" label="期数" width="80">
        </el-table-column>
        <el-table-column prop="startTime" label="开始日期" width="140">
        </el-table-column>
        <el-table-column prop="endTime" label="结束日期" width="140">
        </el-table-column>
        <el-table-column prop="state" label="确认状态" width="80">
        </el-table-column>
        <el-table-column prop="confirmedTime" label="确认日期" width="140">
        </el-table-column>
        <el-table-column prop="confirmedBy" label="确认人" width="140">
        </el-table-column>
        <el-table-column prop="" label="创建人" width="140"> </el-table-column>
        <el-table-column prop="" label="创建日期" width="140">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              @click="handleClick(scope.$index, scope.row)"
              type="text"
              size="medium"
              >查看</el-button
            >
            <el-button type="text" size="medium">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
import Vue from 'vue'
import router from '../../../router'
export default {
  name: 'AssignmentConfirmation',
  data () {
    return {
      tableData: [],
      id: 0,                          //期表ID
      issueNumber: 0,                      //期数编号
      startTime: 0,                   //开始日期
      endTime: 0,                     //结束日期
      state: true,                   //确认状态
      confirmedTime: 0,               //确认日期
      confirmedBy: '',                //确认人
      tempData: {},                   //临时数据
      username: ''                     //当前用户名
    }
  },
  methods: {

    //获取后台数据
    getConfirmList () {
      let that = this
      Vue.axios.get('http://paichan.free.svipss.top/system/deptform/list', {

      }).then(function (response) {
        console.log(response)
        //创建派单确认列表
        that.createList(response)
      }).catch(function (error) {
        console.log(error)
      })
    },

    //创建派单确认列表
    createList (res) {
      var tempList = res.data.rows
      console.log(tempList)
      for (let i = 0; i < tempList.length; i++) {
        this.tempData.id = tempList[i].id
        this.tempData.issueNumber = tempList[i].issueNumber
        this.tempData.startTime = tempList[i].startTime
        this.tempData.endTime = tempList[i].updateTime
        this.tempData.state = tempList[i].state
        this.tempData.confirmedTime = tempList[i].confirmedTime
        this.tempData.confirmedBy = tempList[i].confirmedBy
        // this.tempData.
        this.tableData.push(this.tempData)
        this.tempData = {}
      }
      console.log(this.tableData)
    },


    //点击确认跳转
    handleClick (index, row) {
      console.log("跳转产派单Excel页面")
      // console.log(row)
      router.push({ path: 'FilloutAssignment', query: { id: row.id } })
    }
  },


  mounted () {
    this.getConfirmList()
  }
}
</script>

<style>
</style>
