<template>
  <div>
    <div style="margin:40px;padding-left: 42%"><i class="el-icon-user"/> 账户持仓详细信息</div>
<!--Account表-->
    <el-table  :data="AccounteData" stripe>
      <el-table-column prop="sid" label="用户编号" align="center" />
      <el-table-column prop="deposit" label="保证金" align="center" />
      <el-table-column prop="balance" label="盈亏" align="center" />
      <el-table-column prop="balanceCost" label="成本" align="center" />
      <el-table-column prop="balanceReal" label="市值" align="center" />
      <el-table-column prop="balanceDate" label="计算日期" align="center" />
      <el-table-column label="持仓头寸详细信息" align="center" width="500px">
<!--account-stk表-->
        <el-table :data="tableData"  show-summary >
        <el-table-column prop="userNo" label="名称" align="center" />
        <el-table-column prop="stkNo" label="货币编号" align="center" />
        <el-table-column prop="stkCost" label="成本" align="center" />
        <el-table-column prop="stkQty" label="市值" align="center" />
        <el-table-column prop="balance" label=" 数量" align="center" />
        <el-table-column label="详细" align="center">
          <template #default="scope">
            <el-button type="primary" size="mini"  @click="handleSelected(scope.row)">查看</el-button>
          </template>
        </el-table-column>
        </el-table>
      </el-table-column>
    </el-table>

  <!--Trans表-->
  <el-dialog title="成交记录" :visible.sync="dialogTableVisible">
    <el-table :data="gridData">
      <el-table-column prop="stkNo" label="货币编号" align="center" ></el-table-column>
      <el-table-column prop="transId" label="成交序号" align="center" ></el-table-column>
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
import {getAllAccountStk, getSelectedTrans,getAllAccount} from "@/api/data";
export default {
  methods: {
    handleSelected(row) {
      getSelectedTrans(row.stkNo).then((res) => {
        this.gridData = res.data.data ;
        this.dialogTableVisible= true;
      });
    }
  },
  data(){
    return{
      tableData:[],
      gridData:[],
      AccounteData:[],
      dialogTableVisible : false,
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  mounted() {
    getAllAccountStk().then((res)=>{
      this.tableData= res.data.data;
    });
    getAllAccount().then((res)=>{
      this.AccounteData= res.data.data;
    });
  },
};
</script>
