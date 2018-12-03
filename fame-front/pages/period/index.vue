<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="peakHourOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `trip` }
    },
    fetch ({ store }) {
      return store.dispatch('getPeriod')
    },
    computed: {
      period: function () {
        return this.$store.state.period.data
      }
    },
    data () {
      return {
        peakHourOption: {
          title: {
            text: 'Peak Hour',
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
              rotate: 0
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
        var json = this.period
        this.peakHourOption.xAxis.data = json[0].xAxis
        this.peakHourOption.series[0].data = json[0].yAxis
        this.peakHourOption.series[1].data = json[1].yAxis
        this.peakHourOption.series[2].data = json[2].yAxis
      }
    }
  }
</script>
