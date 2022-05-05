import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/Home.vue'),
    meta: { title: '首页'}
  },
  {
    path: '/category/:cate',
    name: 'category',
    component: () => import('@/views/Category.vue'),
    meta: { title: '分类', params: 'cate'}
  },
  {
    path: '/label/:label',
    name: 'label',
    component: () => import('@/views/Label.vue'),
    meta: { title: '分类', params: 'label'}
  },
  {
    path: '/search/:words',
    name: 'search',
    component: () => import('@/views/Search.vue'),
    meta: { title: '搜索', params: 'words'}
  },
  {
    path: '/article/:id',
    name: 'article',
    component: () => import('../views/Articles.vue'),
    meta: { title: '文章'}
  },
  {
    path: '/friend',
    name: 'friend',
    component: () => import('../views/Friend.vue'),
    meta: { title: '友链'}
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/About.vue'),
    meta: { title: '关于'}
  },
  {
    path: '/experiment/csvToHtml',
    name: 'csvToHtml',
    component: () => import('@/views/experiment/CsvToHtml.vue'),
    meta: { title: 'csv转换为Html'}
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// 路径跳转
router.beforeEach((to, from, next) => {
  let title = 'WormFlesh'
  if (to.meta.params){
      title = `${to.meta.title}:${to.params[to.meta.params] || ''} - ${title}`
  }else {
      title = `${to.meta.title} - ${title}`
  }
  document.title = title
  if (to.path !== from.path) {
      store.dispatch('setLoading', true);
  }
  next();
})
// 时间限制
router.afterEach((to, from) => {
  // 最多延迟 关闭 loading
  setTimeout(() => {
      store.dispatch('setLoading', false);
  }, 550)
})


export default router
