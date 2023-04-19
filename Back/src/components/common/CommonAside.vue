<template>
  <!--collapse 是否水平折叠收起菜单-->
  <el-menu
    :collapse="isCollapse"
    :default-active="$route.path"
    class="el-menu-vertical-demo"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <!--是否水平折叠收起菜单 会影响这里字段的显示 -->
    <h3 v-show="isCollapse">lulu</h3>
    <h3 v-show="!isCollapse">lulu后台管理系统</h3>
    <el-menu-item :index="item.path" v-for="item in noChildren" :key="item.path" @click="clickMenu(item)">
      <i :class="'el-icon-' + item.icon"></i>
      <span slot="title">{{ item.label }}</span>
    </el-menu-item>
    <el-submenu :index="item.label" v-for="(item, index) in hasChildren" :key="index">
      <template slot="title">
        <i :class="'el-icon-' + item.icon"></i>
        <span slot="title">{{ item.label }}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item :index="subItem.path" v-for="(subItem, subIndex) in item.children" :key="subIndex" @click="clickMenu(subItem)">
          <i :class="'el-icon-' + subItem.icon"></i>
          <span slot="title">{{ subItem.label }}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  //计算属性
  computed: {
    //没有子菜单
    noChildren() {
      return this.menu.filter(item => !item.children)
    },
    //有子菜单 (这样设置会有一个问题 就是有子菜单的 永远会在没有子菜单的下面
    hasChildren() {
      return this.menu.filter(item => item.children)
    },
    isCollapse() {
      // 这里的数据就是从vuex取得
      return this.$store.state.tab.isCollapse
    }
  },

  data() {
    return {
      menu: [
        {
          path: '/',
          name: 'home',
          label: '首页',
          icon: 's-home',
        }, {
          label: '用户',
          icon: 'video-play',
          children: [{
            path: '/account',
            name: 'account',
            label: '用户信息',
            icon: 'money',
            },{
            label: '用户导入',
            icon: 'video-play',
            }]
        }, {
          label: '外汇',
          icon: 'video-play',
          children: [{
            path: '/value',
            name: 'value',
            label: '外汇行情',
            icon: 'money',
          },{
            path:'/ValueHistory',
            name: 'valueHistory',
            label: '历史行情',
            icon: 'video-play',
          }]
       }, {
          label: '交易',
          icon: 'user',
          children: [{
            path: '/account',
            name: 'account',
            label: '交易账户',
            icon: 'money',
          },{
            path: '/order',
            name: 'order',
            label: '委托记录',
            icon: 'video-play',
          },{
            path: '/trans',
            name: 'trans',
            label: '撮合记录',
            icon: 'video-play',
          }]
        }, {
          label: '管理',
          icon: 'user',
          children: [{
            label: '账户初始化',
            icon: 'money',
          },{
            label: '仓位计算',
            icon: 'video-play',
          },{
            label: '账户平仓',
            icon: 'video-play',
          },{
            label: '平仓记录',
            icon: 'video-play',
          }]
        }, {
          label: '统计',
          icon: 'user',
          children: [{
            label: '交易统计',
            icon: 'money',
          }]
        }, {
          label: '系统',
          icon: 'user',
          children: [{
            label: '系统管理',
            icon: 'money',
          },{
            label: '应用配置',
            icon: 'video-play',
          }]
        }, {
          label: '其他',
          icon: 'location',
          children: [
          ],
            }
          ]
    }
  },
  methods: {
    //跳转路由 根据名称跳转
    clickMenu(item) {
      this.$router.push({ name: item.name })
    }
  }
}
</script>

<style lang="scss" scoped>
.el-menu {
  height: 100%;
  border: none;
  h3 {
    color: #ffffff;
    text-align: center;
    line-height: 48px;
  }
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>
