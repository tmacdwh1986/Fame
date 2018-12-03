<template>
</div>
  <ul>
    <li> <nuxt-link class="Jernoury Distance" :to="{ path: '/distance' }">Driving Distance</nuxt-link> </li>
    <li> <nuxt-link class="Trip" :to="{ path: '/trip' }">Driving Trip</nuxt-link> </li>
    <li> <nuxt-link class="Duration" :to="{ path: '/Tripduration' }">Driving Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgTripDistance" :to="{ path: '/avgTripDistance' }">Average Trip Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgTripDuration" :to="{ path: '/avgTripDuration' }">Average Trip Duration</nuxt-link> </li>
    <li> <nuxt-link class="DayDistance" :to="{ path: '/DayDistance' }">Driving Trip</nuxt-link> </li>
    <li> <nuxt-link class="DayDuration" :to="{ path: '/DayDuration' }">Driving Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgDayDistance" :to="{ path: '/avgDayDistance' }">Average Trip Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgDayDuration" :to="{ path: '/avgDayDuration' }">Average Trip Duration</nuxt-link> </li>
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
