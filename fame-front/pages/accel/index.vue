<template>
  <div>
    <p> This is an accel begin </p>
    <p> {{ $store.state.acc.data }} </p>
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
        return this.$store.state.acc.data
      }
    }
  }
</script>
