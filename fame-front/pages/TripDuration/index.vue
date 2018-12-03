<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an TripDuration begin </p>
    <p> {{ $store.state.tripduration.data }} </p>
    <p> This is an TripDuration end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `TripDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getTripDuration')
    },
    computed: {
      acc: function () {
        return this.$store.state.tripduration.data
      }
    }
  }
</script>
