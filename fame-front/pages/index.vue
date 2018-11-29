<template>
  <div>
   <div class="container">
    <el-row>
      <el-col>
        <search-bar/>
      </el-col>
      </el-row>
   </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import searchBar from '~/components/SearchBar.vue'

  export default {
    head () {
      return { title: `FAME` }
    },
    components: {
      searchBar
    }
  }
</script>

<style lang="scss">
  @import "@/assets/css/index.scss"
</style>
