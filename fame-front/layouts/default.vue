<template>
  <el-container class="layout-default">
  <el-header height="85px">
    <fame-header/>
  </el-header>
  <el-main>
    <div class="m-container">
      <transition name="flow" mode="out-in">
      <nuxt/>
        </transition>
    </div>
    <fame-scroll-top/>
  </el-main>
  <el-footer height="100%">
    <fame-footer/>
  </el-footer>
</el-container>


</template>

<script>
  import FameHeader from '~/components/Header.vue'
  import FameFooter from '~/components/Footer.vue'
  import FameScrollTop from '~/components/ScrollTop.vue'

  export default {
    components: {
      FameHeader,
      FameFooter,
      FameScrollTop
    }
  }
</script>

<style>
  .m-container {
    padding: 2em 1em;
    margin: 30px auto 0;
    height: 100%;
    max-width: 1980px;
    font-size: 16px;
    position: relative;
    animation: flow;
    animation-duration: .5s;
  }
</style>
