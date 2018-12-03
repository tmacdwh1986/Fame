<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <p> This is an ChrgDeltaSOC begin </p>
    <p> {{ $store.state.chrgdeltasoc.data }} </p>
    <p> This is an ChrgDeltaSOC end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `ChrgDeltaSOC` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgDeltaSOC')
    },
    computed: {
      chrgdeltasoc: function () {
        return this.$store.state.chrgdeltasoc.data
      }
    }
  }
</script>
