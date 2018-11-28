<template>
</div>
  <ul>
    <li> <nuxt-link class="ChrgDistance" :to="{ path: '/ChrgDistance' }">Charging Distance</nuxt-link> </li>
    <li> <nuxt-link class="ChrgTime" :to="{ path: '/ChrgTime' }">Charging Time</nuxt-link> </li>
    <li> <nuxt-link class="ChrgDuration" :to="{ path: '/ChrgDuration' }">Charging Duration</nuxt-link> </li>
    <li> <nuxt-link class="Home" :to="{ path: '/' }">HOME</nuxt-link> </li>
  </ul>
</div>
</template>

<script type="text/ecmascript-6">

  export default {
    head () {
      return { title: `Charging` }
    }

  }
</script>
