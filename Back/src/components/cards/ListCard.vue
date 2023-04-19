<template>
  <el-card style="height: 460px ; margin-top: 20px">
    <el-table :data="tableData">
      <el-table-column show-overflow-tooltip v-for="(val, key) in tableLabel" :key="key" :prop="key"
                       :label="val"></el-table-column>
    </el-table>
  </el-card>
</template>

<script>
import {getData} from "@/api/data";
export default {
  name: "ListCard",
  data() {
    return {
      //提取mock中的静态数据
      tableData: [],
      // 定义列的相关名称
      tableLabel: {
        name: '币种',
        todayBuy: '今日购买',
        monthBuy: '本月购买',
        totalBuy: '总购买'
      }
    }
  },
  mounted() {
    getData().then(res => {
      const{code,data}=res.data
      if (code === 20000)
      {
        this.tableData = data.tableData
      }
    })
  },
  //一进组件就会去请求后端接口 获取首页数据
  created() {
    this.getTableData()
  }
}
</script>

