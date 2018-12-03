<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an AvgDayDistance begin </p>
    <p> {{ $store.state.avgdaydistance.data }} </p>
    <p> This is an AvgDayDistance end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `AvgDayDistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getAvgDayDistance')
    },
    computed: {
      acc: function () {
        return this.$store.state.avgdaydistance.data
      }
    }
  }
</script>
