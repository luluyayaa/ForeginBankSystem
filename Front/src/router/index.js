import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

// 完整路由代码
export default new VueRouter({
  mode:'history',
  routes: [
    {
      path: '/',
      component: () => import('@/views/Main'),
      children: [
        {
          path: '/',
          name: 'home',
          component: () => import('@/views/Home'),
        }, {
          path: '/trading',
          name: 'trading',
          component: () => import('@/views/Trading'),
        }, {
          path: '/value',
          name: 'value',
          component: () => import('@/views/Value'),
        }, {
          path: '/order',
          name: 'order',
          component: () => import('@/views/Order'),
        }, {
          path: '/trans',
          name: 'trans',
          component: () => import('@/views/Trans'),
        }, {
          path: '/account',
          name: 'account',
          component: () => import('@/views/Account'),
        }
      ]
    },{
      // 匹配不到就走*
      path:'*',
      name:'notfound',
      component: () => import('@/views/NotFound'),
    }
  ]
})
