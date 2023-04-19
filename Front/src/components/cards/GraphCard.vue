<template>
  <div>
  <el-card shadow="hover">
    <!--图表一 这里的数据是折线图-->
    <echart style="height: 280px" :chartData="echartData.order"></echart>
  </el-card>
  <div class="graph" >
    <el-card shadow="hover">
      <!--图表二 这里的数据是柱状图-->
      <echart :chartData="echartData.user" style="height: 260px"></echart>
    </el-card>
    <el-card shadow="hover">
      <!--图表三 这里的数据是饼状图 因为饼状图是不用x轴的 所以这里isAxisChart为false-->
      <echart :chartData="echartData.mall" style="height: 260px" :isAxisChart="false"></echart>
    </el-card>
  </div>
  </div>
</template>

<script>
import Echart from '@/components/utils/EChart'
import {getData} from "@/api/data"
export default {
  components: {Echart},
  data() {
    return {
      echartData: {
        order: {
          xData: [],
          series: []
        },
        user: {
          xData: [],
          series: []
        },
        mall: {
          series: []
      }
      }
    }
  },
  mounted(){
      getData().then(res => {
        const{code,data}=res.data
        if (code === 20000) {
          // 订单折线图
          const order = data.orderData
          //x轴数据 为日前
          //x轴数据 为日前
          this.echartData.order.xData = order.date
          // 第一步取出series中的name部分——小米,三星、苹果...
          let keyArray = Object.keys(order.data[0])
          // 第二步，循环添加数据
          keyArray.forEach(key => {
            this.echartData.order.series.push({
              //如果有需要还可以做一步抓换比如：后台返回性别是1、2。那这里key === 1 ? '男' : 女,
              name: key === 'wechat' ? '小程序' : key,
              data: order.data.map(item => item[key]),
              type: 'line'
            })
          })
          // 用户柱状图
          this.echartData.user.xData = data.userData.map(item => item.date)
          this.echartData.user.series.push({
            name: '新增用户',
            data: data.userData.map(item => item.new),
            type: 'bar'
          })
          this.echartData.user.series.push({
            name: '活跃用户',
            data: data.userData.map(item => item.active),
            type: 'bar',
            barGap: 0
          })
          // 商品饼图
          this.echartData.mall.series.push({
            data: data.mallData,
            type: 'pie'
          })
        }
      })
    }
}
</script>
<style lang="scss" scoped>
@import '~@/assets/scss/home.scss';
</style>
