<template>
  <div class="num">
    <!--shadow属性设置卡片阴影出现的时机-->
    <el-card shadow="hover" v-for="item in countData" :key="item.name" :body-style="{ display: 'flex', padding: 0}">
      <i class="icon" :class="`el-icon-${item.icon}`" :style="{ background: item.color }"></i>
      <div class="detail">
        <p class="num">￥ {{ item.value }}</p>
        <p class="txt">{{ item.name }}</p>
      </div>
    </el-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userImg: require('../../assets/images/user.png'),
      countData: [
        {
          name: '今日支付订单',
          value: 1234,
          icon: 'success',
          color: '#2ec7c9'
        },
        {
          name: '今日收藏订单',
          value: 210,
          icon: 'star-on',
          color: '#ffb980'
        },
        {
          name: '今日未支付订单',
          value: 1234,
          icon: 's-goods',
          color: '#5ab1ef'
        },
        {
          name: '本月支付订单',
          value: 1234,
          icon: 'success',
          color: '#2ec7c9'
        },
        {
          name: '本月收藏订单',
          value: 210,
          icon: 'star-on',
          color: '#ffb980'
        },
        {
          name: '本月未支付订单',
          value: 1234,
          icon: 's-goods',
          color: '#5ab1ef'
        }
      ],
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
