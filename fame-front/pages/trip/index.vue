<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="tripDistOption"/>
    <demo-charts id="chart2" :option="tripDistAccuOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'

  export default {
    head () {
      return { title: `trip` }
    },
    fetch ({ store }) {
      return store.dispatch('getTrip')
    },
    data () {
      return {
        tripDistOption: {
          title: {
            text: 'Trip Distance',
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
            data: ['Holiday', 'Work day', '', 'Natural day']
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
              formatter: '{value} %'
            },
            show: true
          },
          series: [
            {
              name: 'Holiday',
              type: 'bar',
              barGap: 0,
              data: [ ]
            },
            {
              name: 'Work day',
              type: 'bar',
              data: [ ]
            },
            {
              name: 'Natural day',
              type: 'bar',
              data: [ ]
            }
          ]
        },
        tripDistAccuOption: {
          title: {
            text: 'Trip Distance Accumulation',
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
            data: ['Holiday', 'Work day', '', 'Natural day']
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
              formatter: '{value} %'
            },
            show: true
          },
          series: [
            {
              name: 'Holiday',
              type: 'bar',
              barGap: 0,
              data: [ ]
            },
            {
              name: 'Work day',
              type: 'bar',
              data: [ ]
            },
            {
              name: 'Natural day',
              type: 'bar',
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
        var json = this.$store.state.trip.data
        console.log(json)
        this.tripDistOption.xAxis.data = json[0].xAxis
        this.tripDistOption.series[0].data = json[0].yAxis
        this.tripDistOption.series[1].data = json[1].yAxis
        this.tripDistOption.series[2].data = json[2].yAxis
        this.tripDistAccuOption.xAxis.data = json[0].xAxisAccu
        this.tripDistAccuOption.series[0].data = json[0].yAxisAccu
        this.tripDistAccuOption.series[1].data = json[1].yAxisAccu
        this.tripDistAccuOption.series[2].data = json[2].yAxisAccu
      }
    }
  }
</script>
