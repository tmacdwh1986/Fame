<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <p> This is an accel begin </p>
    <p> {{ $store.state.accel.data }} </p>
    <p> This is an accel end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `Acc` }
    },
    fetch ({ store }) {
      return store.dispatch('getAcc')
    },
    computed: {
      acc: function () {
        return this.$store.state.accel.data
      }
    }
  }
</script>
