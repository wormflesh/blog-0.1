<template>
  <div id="app" v-cloak>
    <loading></loading>
    <layout-header></layout-header>
    <layout-body></layout-body>
    <layout-footer></layout-footer>
  </div>
</template>
<script>
import LayoutHeader from "@/components/layout/layout-header.vue"
import LayoutBody from "@/components/layout/layout-body.vue"
import LayoutFooter from "@/components/layout/layout-footer.vue"
import Loading from '@/components/loading.vue'
export default {
  name: "app",
  components: {
    LayoutHeader,
    LayoutBody,
    LayoutFooter,
    Loading
  }
}
</script>
<style lang="less">
    #app {
        font-size: 17px;
        color: #6f6f6f;
    }
</style>
