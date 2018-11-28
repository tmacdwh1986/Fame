<template>
  <div>
    <p> This is an period begin </p>
    <p> {{ $store.state.period.data }} </p>
    <p> This is an period end </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `trip` }
    },
    fetch ({ store }) {
      return store.dispatch('getPeriod')
    },
    computed: {
      distance: function () {
        return this.$store.state.period.data
      }
    }
  }
</script>
