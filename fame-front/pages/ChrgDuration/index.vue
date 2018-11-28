<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/charging' }">Charging Home</nuxt-link>
    <p> This is an chargingduration begin </p>
    <p> {{ $store.state.chrgduration.data }} </p>
    <p> This is an chargingduration end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `chargduration` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgDuration')
    },
    computed: {
      distance: function () {
        return this.$store.state.chrgduration.data
      }
    }
  }
</script>
