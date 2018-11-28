<template>
  <div>
    <p> This is an chargingdistance begin </p>
    <p> {{ $store.state.chrgdistance.data }} </p>
    <p> This is an chargingdistance end </p>
    <nuxt-link class="Home" :to="{ path: '/charging' }">Charging home</nuxt-link>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `chargdistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgDistance')
    },
    computed: {
      distance: function () {
        return this.$store.state.chrgdistance.data
      }
    }
  }
</script>
