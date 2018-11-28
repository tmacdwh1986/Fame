<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <p> This is an soc begin </p>
    <p> {{ $store.state.soc.data }} </p>
    <p> This is an soc end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `soc` }
    },
    fetch ({ store }) {
      return store.dispatch('getSoc')
    },
    computed: {
      distance: function () {
        return this.$store.state.soc.data
      }
    }
  }
</script>
