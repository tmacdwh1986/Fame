<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an ideea begin </p>
    <p> {{ $store.state.trip.data }} </p>
    <p> This is an ideea end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `trip` }
    },
    fetch ({ store }) {
      return store.dispatch('getTrip')
    },
    computed: {
      distance: function () {
        return this.$store.state.trip.data
      }
    }
  }
</script>
