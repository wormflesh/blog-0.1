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
    path: '/search/:words',
    name: 'search',
    component: () => import('@/views/Home.vue'),
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
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})




export default router
