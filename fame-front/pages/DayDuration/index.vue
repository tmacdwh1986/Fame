<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an DayDuration begin </p>
    <p> {{ $store.state.dayduration.data }} </p>
    <p> This is an DayDuration end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `DayDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getDayDuration')
    },
    computed: {
      acc: function () {
        return this.$store.state.dayduration.data
      }
    }
  }
</script>
