<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/charging' }">Driving Home</nuxt-link>
    <p> This is an ChrgEndTime begin </p>
    <p> {{ $store.state.chrgendtime.data }} </p>
    <p> This is an ChrgEndTime end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `ChrgEndTime` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgEndTime')
    },
    computed: {
      acc: function () {
        return this.$store.state.chrgendtime.data
      }
    }
  }
</script>
