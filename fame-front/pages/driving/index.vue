<template>
</div>
  <ul>
    <li> <nuxt-link class="Journey Distance" :to="{ path: '/distance' }">Driving Distance</nuxt-link> </li>
    <li> <nuxt-link class="Trip" :to="{ path: '/trip' }">Driving Trip</nuxt-link> </li>
    <li> <nuxt-link class="Duration" :to="{ path: '/TripDuration' }">Driving Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgTripDistance" :to="{ path: '/avgTripDistance' }">Average Trip Distance</nuxt-link> </li>
    <li> <nuxt-link class="AvgTripDuration" :to="{ path: '/avgTripDuration' }">Average Trip Duration</nuxt-link> </li>
    <li> <nuxt-link class="DayDistance" :to="{ path: '/DayDistance' }">Driving Trip</nuxt-link> </li>
    <li> <nuxt-link class="DayDuration" :to="{ path: '/DayDuration' }">Day Duration</nuxt-link> </li>
    <li> <nuxt-link class="AvgDayDistance" :to="{ path: '/avgDayDistance' }">Average Day Distance</nuxt-link> </li>
    <li> <nuxt-link class="AvgDayDuration" :to="{ path: '/avgDayDuration' }">Average Day Duration</nuxt-link> </li>
    <li> <nuxt-link class="Peak Hour" :to="{ path: '/period' }">Peak Hour</nuxt-link> </li>
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
