<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an AvgTripDuration begin </p>
    <p> {{ $store.state.avgtirpduration.data }} </p>
    <p> This is an AvgTripDuration end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `AvgTripDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getAvgTripDuration')
    },
    computed: {
      avgtirpduration: function () {
        return this.$store.state.avgtirpduration.data
      }
    }
  }
</script>
