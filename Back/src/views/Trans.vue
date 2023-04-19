<!--
交易委托Order表
-->

<template>
  <div>
    <!-- 搜索条件栏 -->
    <div class="filter-container">
      <el-input  style="width: 200px;" class="filter-item"></el-input>
      <el-button type="primary" @click="handleSearch()" size="small" style="margin:20px">查询</el-button>
    </div>

    <!--表单弹框Trans表-->
      <el-table :data="tableData" stripe
                style="width: 100%">
        <el-table-column prop="transId" label="序号" align="center" ></el-table-column>
        <el-table-column prop="stkNo" label="货币" align="center" ></el-table-column>
        <el-table-column prop="transDate" label="成交时间" align="center" ></el-table-column>
        <el-table-column prop="transPrice" label="成交价格" align="center" ></el-table-column>
        <el-table-column prop="transSum" label="成交数量" align="center" ></el-table-column>
        <el-table-column prop="orderIdSell" label="卖单号" align="center" ></el-table-column>
        <el-table-column prop="userNoSell" label="卖方用户" align="center" ></el-table-column>
        <el-table-column prop="orderIdBuy" label="买单号" align="center" ></el-table-column>
        <el-table-column prop="userNoBuy" label="买方用户" align="center" ></el-table-column>
      </el-table>
  </div>
</template>

<script>
import {getAllTrans} from "@/api/data";
// import axios from "axios";

export default {
  data(){
    return{
      tableData:[],
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  mounted() {
    getAllTrans().then((res)=>{
      this.tableData= res.data.data;
    });
  },
};
</script>
