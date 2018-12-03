<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="tripDurationOption"/>
    <demo-charts id="chart2" :option="tripDurationAccuOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `TripDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getTripDuration')
    },
    computed: {
      tripduration: function () {
        return this.$store.state.tripduration.data
      }
    },
    data () {
      return {
        tripDurationOption: {
          title: {
            text: 'Trip Duration',
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
        tripDurationAccuOption: {
          title: {
            text: 'Trip Duration Accumulation',
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
      setTimeout (() => {
        this.refreshData()
      }, 0)
    },
    methods: {
      refreshData () {
        var json = this.tripduration
        this.tripDurationOption.xAxis.data = json[0].xAxis
        this.tripDurationOption.series[0].data = json[0].yAxis
        this.tripDurationOption.series[1].data = json[1].yAxis
        this.tripDurationOption.series[2].data = json[2].yAxis
        this.tripDurationAccuOption.xAxis.data = json[0].xAxisAccu
        this.tripDurationAccuOption.series[0].data = json[0].yAxisAccu
        this.tripDurationAccuOption.series[1].data = json[1].yAxisAccu
        this.tripDurationAccuOption.series[2].data = json[2].yAxisAccu
      }
    }
  }
</script>
