<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an AvgTripDistance begin </p>
    <p> {{ $store.state.avgtirpdistance.data }} </p>
    <p> This is an AvgTripDistance end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `AvgTripDistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getAvgTripDistance')
    },
    computed: {
      avgtirpdistance: function () {
        return this.$store.state.avgtirpdistance.data
      }
    }
  }
</script>
