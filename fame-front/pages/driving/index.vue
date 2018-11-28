<template>
</div>
  <ul>
    <li> <nuxt-link class="Distance" :to="{ path: '/distance' }">Driving Distance</nuxt-link> </li>
    <li> <nuxt-link class="Trip" :to="{ path: '/trip' }">Driving Trip</nuxt-link> </li>
    <li> <nuxt-link class="Home" :to="{ path: '/' }">HOME</nuxt-link> </li>
  </ul>
</div>
</template>

<script type="text/ecmascript-6">

  export default {
    head () {
      return { title: `Driving` }
    }

  }
</script>
