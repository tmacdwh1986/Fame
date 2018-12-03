<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <p> This is an ChrgEndSOC begin </p>
    <p> {{ $store.state.chrgendsoc.data }} </p>
    <p> This is an ChrgEndSOC end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `ChrgEndSOC` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgEndSOC')
    },
    computed: {
      chrgendsoc: function () {
        return this.$store.state.chrgendsoc.data
      }
    }
  }
</script>
