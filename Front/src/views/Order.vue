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

    <!-- Order表 -->
    <el-table  :data="tableData" highlight-current-row>
      <el-table-column prop="orderId" label="序号" align="center" />
      <el-table-column prop="stkNo" label="货币" align="center" />
      <el-table-column prop="orderType" label="交易类型" align="center" />
      <el-table-column prop="userNo" label="用户编号" align="center" />
      <el-table-column prop="orderDate" label="委托日期" align="center" />
      <el-table-column prop="orderSum" label=" 委托数量" align="center" />
      <el-table-column prop="orderPrice" label=" 委托价格" align="center" />
      <el-table-column prop="orderRemainSum" label=" 剩余" align="center" />
      <el-table-column prop="orderStatus" label=" 委托状态" align="center" />
      <el-table-column label="查看" align="center">
        <template #default="scope">
          <el-button type="primary" size="mini"  @click="handleSelected(scope.row)">详细</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--表单弹框Trans表-->
    <el-dialog title="详细信息" :visible.sync="dialogTableVisible">
      <el-table :data="gridData">
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
    </el-dialog>
  </div>
</template>

<script>
import {getAllOrder,getTransById} from "@/api/data";
// import axios from "axios";

export default {
  methods: {
    handleSelected(row) {
      getTransById(row.orderId).then((res) => {
        console.log(res.data.data);
        // JSON对象转为数组
         var resarr = [];
         resarr.push(res.data.data);
         this.gridData = resarr ;
         this.dialogTableVisible= true;
      });
    }
  },
  data(){
    return{
      tableData:[],
      gridData:[],
      dialogTableVisible : false,
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  mounted() {
    getAllOrder().then((res)=>{
      console.log(res);
      this.tableData= res.data.data;
      });
  },
};
</script>
