<template>
  <div
    id="luckysheet"
    style="
      margin: 0 0 0 0;
      padding: 0px;
      /* position: absolute; */
      width: 100vw;
      height: 82vh;
      /* left: 0px;
      top: 0px; */
    "
  ></div>
</template>

<script>
import { from } from 'readable-stream'
import { options } from 'runjs'
import { parseMapToJSON } from 'source-map-resolve'
import Vue from 'vue'

export default {

  name: 'FilloutAssignment',
  data () {
    return {

      sendData: [],
      sheetData: {},
      // headerData: [{
      //   r: 0, c: 0, v: { ct: { fa: 'General', t: 'g' }, m: '销售订单日期', v: '销售订单日期' }
      // },
      // {
      //   r: 0,
      //   c: 1,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '需求分类',
      //     v: '需求分类',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 2,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '料号',
      //     v: '料号',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 3,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '名称',
      //     v: '名称',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 4,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '规格',
      //     v: '规格',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 5,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '番号',
      //     v: '番号',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 6,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '花纹',
      //     v: '花纹',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 7,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '商标',
      //     v: '商标',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 8,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '工艺',
      //     v: '工艺',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 9,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '订单数量',
      //     v: '订单数量',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 10,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '累计排产量',
      //     v: '累计排产量',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 11,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '可排产量',
      //     v: '可排产量',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 12,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '销售需求',
      //     v: '销售需求',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 13,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '备注',
      //     v: '备注',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 14,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '夏季硫化定额',
      //     v: '夏季硫化定额',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 15,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '模具总量',
      //     v: '模具总量',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 16,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '模具号',
      //     v: '模具号',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 17,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '最大产能',
      //     v: '最大产能',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 18,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '已填数值',
      //     v: '已填数值',
      //   }
      // },
      // {
      //   r: 0,
      //   c: 19,
      //   v: {
      //     ct: { fa: 'General', t: 'g' },
      //     m: '是否超过',
      //     v: '是否超过',
      //   }
      // },]
    }

  },
  methods: {
    //点击保存
    upDate () {
      var dataList = luckysheet.getAllSheets()
      console.log(dataList)
      let that = this
      //发送更新
      Vue.axios.post('http://paichan.free.svipss.top/salesexcel/adds', {
        dataList
      }).then(function (response) {
        console.log(response)
      }).catch(function (error) {
        console.log(error)
      })
    },


  },

  mounted () {

    var options = {
      container: 'luckysheet', //luckysheet为容器id
      // gridKey: 'excel001',
      title: 'wanda', // 设定表格名称
      lang: 'zh', // 设定表格语言
      allowEdit: true,//作用：是否允许前台编辑
      showinfobar: true,//作用：是否显示顶部信息栏
      defaultRowHeight: 28, //自定义行高,单位px
      defaultColWidth: 200, //自定义列宽,单位px
      myFolderUrl: "/getList",//作用：左上角<返回按钮的链接
      functionButton: '<button id="upDateButton" class="btn btn-primary" onclick="upDate()" style="padding:3px 6px;font-size: 12px;margin-right: 10px;">保存</button> <button id="" class="btn btn-primary btn-danger" style=" padding:3px 6px; font-size: 12px; margin-right: 85px;" onclick="downExcelData()">下载</button>',
      // loadUrl: "http://paichan.free.svipss.top/deptwanda/list",
      // data: eval(Object.data),
      loadUrl: "http://paichan.free.svipss.top/system/deptsalesexcel/list",
    }
    $(function () {
      luckysheet.create(options)
    }
    )
    window.upDate = this.upDate



  },

}

</script>

<style>
.luckysheet-share-logo {
  display: none;
}
.luckysheet_info_detail_input {
  width: 200px !important;
  text-align: center;
}
</style>
