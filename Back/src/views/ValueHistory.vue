<template>
  <el-row class="home" :gutter="20" :span="16" style="margin-top: 30px">
    <graph-card/>
  </el-row>
</template>

<script>
import GraphCard from "@/components/cards/GraphCard";
import {getMenu} from "@/api/data";
export default {
  components: {GraphCard},
  name: "Home",
  mounted(){
    getMenu().then(res =>{
      console.log(res);
    })
  }
}
</script>
