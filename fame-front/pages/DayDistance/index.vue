<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="dayDistanceOption"/>
    <demo-charts id="chart2" :option="dayDistanceAcculOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `DayDistance` }
    },
    fetch ({ store }) {
      return store.dispatch('getDayDistance')
    },
    computed: {
      daydistance: function () {
        return this.$store.state.daydistance.data
      }
    },
    data () {
      return {
        dayDistanceOption: {
          title: {
            text: 'Day Distance',
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
        dayDistanceAcculOption: {
          title: {
            text: 'Day Distance Accumulation',
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
        var json = this.daydistance
        this.dayDistanceOption.xAxis.data = json[0].xAxis
        this.dayDistanceOption.series[0].data = json[0].yAxis
        this.dayDistanceOption.series[1].data = json[1].yAxis
        this.dayDistanceOption.series[2].data = json[2].yAxis
        this.dayDistanceAcculOption.xAxis.data = json[0].xAxisAccu
        this.dayDistanceAcculOption.series[0].data = json[0].yAxisAccu
        this.dayDistanceAcculOption.series[1].data = json[1].yAxisAccu
        this.dayDistanceAcculOption.series[2].data = json[2].yAxisAccu
      }
    }
  }
</script>
