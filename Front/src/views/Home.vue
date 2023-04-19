<template>
    <el-row class="home" :gutter="20">

    <el-col :span="8" style="margin-top: 20px">
      <user-card/>
      <list-card/>
    </el-col>

    <el-col :span="16" style="margin-top: 20px">
        <order-card/>
        <graph-card/>
    </el-col>

    </el-row>
</template>

<script>
import UserCard from "../components/cards/UserCard";
import OrderCard from "../components/cards/OrderCard"
import ListCard  from "@/components/cards/ListCard";
import GraphCard from "@/components/cards/GraphCard";
import {getMenu} from "@/api/data";
  export default {
      components: {UserCard,OrderCard,ListCard,GraphCard},
      name: "Home",
      mounted(){
        getMenu().then(res =>{
          console.log(res);
        })
      }
    }
</script>
