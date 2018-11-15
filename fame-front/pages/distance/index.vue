<template>
  <div>
    <p> This is an ideea </p>
  </div>
</template>
<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `标签` }
    },
    fetch ({ store }) {
      return store.dispatch('getDistance')
    }
  }
</script>
