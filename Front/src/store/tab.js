/*
控制是否展开的state属性
 */

export default {
  //默认展开状态
  state: {
    isCollapse: false
  },
  //收起事件触发，进行展开取反即可
  mutations: {
    collapseMenu(state) {
      state.isCollapse = !state.isCollapse
    }
  },
  actions: {}
}
