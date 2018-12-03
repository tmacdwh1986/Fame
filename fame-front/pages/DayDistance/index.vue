<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <p> This is an DayDistance begin </p>
    <p> {{ $store.state.daydistance.data }} </p>
    <p> This is an DayDistance end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `DayDistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getDayDistance')
    },
    computed: {
      daydistance: function () {
        return this.$store.state.daydistance.data
      }
    }
  }
</script>
