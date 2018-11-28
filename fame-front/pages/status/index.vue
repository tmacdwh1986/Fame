<template>
</div>
  <ul>
    <li> <nuxt-link class="SOC" :to="{ path: '/soc' }">SOC</nuxt-link> </li>
    <li> <nuxt-link class="Home" :to="{ path: '/' }">HOME</nuxt-link> </li>
  </ul>
</div>
</template>

<script type="text/ecmascript-6">
  export default {
    head () {
      return { title: `Status` }
    }
  }
</script>
