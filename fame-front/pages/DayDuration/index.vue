<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="dayDurationOption"/>
    <demo-charts id="chart2" :option="dayDurationAcculOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `DayDuration` }
    },
    fetch ({ store }) {
      return store.dispatch('getDayDuration')
    },
    computed: {
      dayduration: function () {
        return this.$store.state.dayduration.data
      }
    },
    data () {
      return {
        dayDurationOption: {
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
        dayDurationAcculOption: {
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
        var json = this.dayduration
        this.dayDurationOption.xAxis.data = json[0].xAxis
        this.dayDurationOption.series[0].data = json[0].yAxis
        this.dayDurationOption.series[1].data = json[1].yAxis
        this.dayDurationOption.series[2].data = json[2].yAxis
        this.dayDurationAcculOption.xAxis.data = json[0].xAxisAccu
        this.dayDurationAcculOption.series[0].data = json[0].yAxisAccu
        this.dayDurationAcculOption.series[1].data = json[1].yAxisAccu
        this.dayDurationAcculOption.series[2].data = json[2].yAxisAccu
      }
    }
  }
</script>
