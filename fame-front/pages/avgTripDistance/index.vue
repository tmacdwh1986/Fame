<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="avgTripDistanceOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `AvgTripDistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getAvgTripDistance')
    },
    computed: {
      avgtirpdistance: function () {
        return this.$store.state.avgtirpdistance.data
      }
    },
    data () {
      return {
        avgTripDistanceOption: {
          title: {
            text: 'Average Trip Distance',
            x: 'center',
            align: 'right'
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              crossStyle: {
                color: '#999'
              }
            }
          },
          legend: {
            x: 'right',
            data: []
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: {
            type: 'category',
            boundaryGap: true,
            data: [ ],
            axisLabel: {
              interval: 0,
              rotate: 270
            }
          },
          yAxis: {
            type: 'value',
            axisLabel: {
              show: true,
              interval: 'auto',
              formatter: '{value} km'
            },
            show: true
          },
          series: [
            {
              name: '',
              type: 'bar',
              barGap: 0,
              data: [ ]
            }
          ]
        }
      }
    },
    components: {
      DemoCharts
    },
    mounted () {
      setTimeout(() => {
        this.refreshData()
      }, 0)
    },
    methods: {
      refreshData () {
        var json = this.avgtirpdistance
        this.avgTripDistanceOption.xAxis.data = json.xAxis
        this.avgTripDistanceOption.series[0].data = json.yAxis
      }
    }
  }
</script>
