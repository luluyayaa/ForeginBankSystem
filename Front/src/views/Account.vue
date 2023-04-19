<template>
  <div>
    <!--Account信息表-->
    <el-descriptions  :column="3"  border>
      <template slot="extra">
        <el-button type="primary" size="small">操作</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label" >
          <i class="el-icon-user"></i>编号
        </template>29311110
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label" >
          <i class="el-icon-user"></i>姓名
        </template>lulu
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>保证金
        </template>
        181000000
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-location-outline"></i>仓位
        </template>-57.3214
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>成本
        </template>
        <el-tag size="small">-22412.1</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>市值
        </template> 1332.42
      </el-descriptions-item>
    </el-descriptions>

    <!-- 持仓详细信息表 AccountStk-->
    <div style="margin:40px;padding-left: 42%"><i class="el-icon-user"/> 账户持仓详细信息</div>
    <el-table  :data="tableData"  show-summary stripe  style="width: 100%" >
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

  <!--表单弹框Trans表-->
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
import {getAllAccountStk, getSelectedTrans} from "@/api/data";
export default {
  methods: {
    handleSelected(row) {
      getSelectedTrans(row.stkNo).then((res) => {
        this.gridData = res.data.data;
        this.dialogTableVisible = true;
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
    getAllAccountStk().then((res)=>{
      console.log(res);
      this.tableData= res.data.data;
    });
  },
};
</script>
