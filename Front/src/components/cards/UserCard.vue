<template>
  <div>
  <el-card shadow='hover'>
    <div class="user">
      <img :src="userImg"/>
      <div class="userinfo">
        <p class="name">lulu</p>
        <p class="access">外汇交易VIP</p>
      </div>
    </div>
    <div class="login-info">
      <p>上次登录时间：<span>2022-10-20</span></p>
      <p>上次登录地点：<span>上海</span></p>
    </div>
  </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userImg: require('../../assets/images/user.png'),
    }
  },
  //一进组件就会去请求后端接口 获取首页数据
  created() {
    this.getTableData()
  }
}
</script>
<style lang="scss" scoped>
@import '~@/assets/scss/home.scss';
</style>
