<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an AvgDayDuration begin </p>
    <p> {{ $store.state.avgdayduration.data }} </p>
    <p> This is an AvgDayDuration end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `AvgDayDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getAvgDayDuration')
    },
    computed: {
      avgdayduration: function () {
        return this.$store.state.avgdayduration.data
      }
    }
  }
</script>
