<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/charging' }">Driving Home</nuxt-link>
    <p> This is an ChrgStartTime begin </p>
    <p> {{ $store.state.chrgstarttime.data }} </p>
    <p> This is an ChrgStartTime end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `ChrgStartTime` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgStartTime')
    },
    computed: {
      chrgstarttime: function () {
        return this.$store.state.chrgstarttime.data
      }
    }
  }
</script>
