<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <p> This is an ChrgStartSOC begin </p>
    <p> {{ $store.state.chrgstartsoc.data }} </p>
    <p> This is an ChrgStartSOC end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `ChrgStartSOC` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgStartSOC')
    },
    computed: {
      chrgstartsoc: function () {
        return this.$store.state.chrgstartsoc.data
      }
    }
  }
</script>
