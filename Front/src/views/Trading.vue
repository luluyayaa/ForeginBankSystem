<template>
  <div>
    <el-card>
      <el-form :inline="true" :model="formInline">
        <el-form-item  prop="resource">
          <el-radio-group v-model="formInline.select">
            <el-radio label="买入"></el-radio>
            <el-radio label="卖出"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="委托数量"><el-input v-model="formInline.number" ></el-input></el-form-item>
        <el-form-item label="委托价格"><el-input v-model="formInline.price" ></el-input></el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit" size="small">提交委托</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <el-card>
    <!-- Order表 -->
      <header align="center" style="location:fixed">近期交易外汇品种与汇率</header>
    <el-table  :data="tableData"  stripe  style="width: 100%" >
      <el-table-column prop="stkId" label="外汇编号" align="center" />
      <el-table-column prop="stkName" label="外汇名称" align="center" />
      <el-table-column prop="stkPrice" label="当前汇率" align="center" />
      <el-table-column prop="stkDate" label="日期" align="center" />
      <el-table-column label="撮合队列" align="center">
      <template #default="scope">
        <el-button type="primary" size="mini"  @click="handleSelected(scope.row)">查看</el-button>
      </template>
      </el-table-column>
    </el-table>
    </el-card>

<el-col>
  <!--order_detail select * where order_type=buy-->
    <el-card style="width: 33%;float:left;">
      <header align="center" style="location:fixed">买盘队列</header>
          <el-table  :data="buyData"  :row-class-name="tableRowClassName">
            <el-table-column prop="orderId" label="单号" align="center" />
            <el-table-column prop="userNo" label="客户" align="center" />
            <el-table-column prop="transDate" label="时间" align="center" />
            <el-table-column prop="transSum" label="数量" align="center" />
            <el-table-column prop="transPrice" label="价格" align="center" />
          </el-table>
    </el-card>
<!--trans-->
    <el-card style="width: 34%;float: left">
      <header align="center" style="location:fixed">撮合成交记录</header>
        <el-table  :data="transData" :row-class-name="tableRowClassName">
          <el-table-column prop="transId" label="序号" align="center" />
          <el-table-column prop="transDate" label="时间" align="center" />
          <el-table-column prop="transSum" label="数量" align="center" />
          <el-table-column prop="transPrice" label="价格" align="center" />
          <el-table-column prop="orderIdBuy" label="买号" align="center" />
          <el-table-column prop="orderIdSell" label="卖号" align="center" />
        </el-table>
    </el-card>
<!--order_detail select * where order_type=sell-->
    <el-card style="width: 33%;float:right">
      <header align="center" style="location:fixed">卖盘队列</header>
        <el-table  :data="sellData"  style="float: right" :row-class-name="tableRowClassName">
          <el-table-column prop="orderId" label="单号" align="center" />
          <el-table-column prop="userNo" label="客户" align="center" />
          <el-table-column prop="transDate" label="时间" align="center" />
          <el-table-column prop="transSum" label="数量" align="center" />
          <el-table-column prop="transPrice" label="价格" align="center" />
        </el-table>
    </el-card>
</el-col>

    </div>
</template>

<script>
import {getAllValues,getAllTrans,selectSell, selectBuy} from "@/api/data";

export default {
  methods: {
    tableRowClassName({rowIndex}) {
      if (rowIndex % 2 === 0) {
        return 'warning-row';
      } else {
        return '';
      }
    }
  },
  data(){
    return{
      tableData:[],
      buyData:[],
      sellData:[],
      transData:[],
      formInline:{},
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  mounted() {
    getAllValues().then((res)=>{
      this.tableData= res.data.data;
    });
    selectSell().then((res)=>{
      this.sellData= res.data.data;
    });
    selectBuy().then((res)=>{
      this.buyData= res.data.data;
    });
    getAllTrans().then((res)=>{
      this.transData= res.data.data;
    });

  },
};
</script>
  <style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>
