<template>
</div>
  <ul>
    <li> <nuxt-link class="SOC" :to="{ path: '/soc' }">SOC</nuxt-link> </li>
    <li> <nuxt-link class="ChrgStartSOC" :to="{ path: '/ChrgStartSOC' }">Charging Start SOC</nuxt-link> </li>
    <li> <nuxt-link class="ChrgEndSOC" :to="{ path: '/ChrgEndSOC' }">Charging End SOC</nuxt-link> </li>
    <li> <nuxt-link class="ChrgDeltaSOC" :to="{ path: '/ChrgDeltaSOC' }">Charging Delta SOC</nuxt-link> </li>
    <li> <nuxt-link class="ACC" :to="{ path: '/accel' }">ACC</nuxt-link> </li>
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
