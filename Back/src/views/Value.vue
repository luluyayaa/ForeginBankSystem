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
    <el-table  :data="tableData"  stripe  style="width: 100%" >
      <el-table-column prop="stkId" label="外汇编号" align="center" />
      <el-table-column prop="stkName" label="外汇名称" align="center" />
      <el-table-column prop="stkPrice" label="当前汇率" align="center" />
      <el-table-column prop="minPerc" label="浮动下限%" align="center" />
      <el-table-column prop="maxPerc" label="浮动上限%" align="center" />
      <el-table-column prop="minQty" label=" 最小数量" align="center" />
      <el-table-column prop="maxQty" label="最大数量" align="center" />
      <el-table-column prop="stkDate" label="汇率日期" align="center" />
      <el-table-column prop="stkUnit" label=" 单位" align="center" />
      <el-table-column prop="stkSrc" label=" 来源" align="center" />
    </el-table>
  </div>
</template>

<script>
import { getAllValues} from "@/api/data";

export default {
  data(){
    return{
      tableData:[],
    }
  },
  //钩子函数，VUE对象初始化完成后自动执行
  mounted() {
    getAllValues().then((res)=>{
      this.tableData= res.data.data;
    });
  },
};
</script>

