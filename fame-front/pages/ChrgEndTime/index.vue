<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/charging' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="chrgEndTimeOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `ChrgEndTime` }
    },
    fetch ({ store }) {
      return store.dispatch('getChrgEndTime')
    },
    computed: {
      chrgendtime: function () {
        return this.$store.state.chrgendtime.data
      }
    },
    data () {
      return {
        chrgEndTimeOption: {
          title: {
            text: 'Charging End Time',
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
        var json = this.chrgendtime
        this.chrgEndTimeOption.xAxis.data = json.xAxis
        this.chrgEndTimeOption.series[0].data = json.yAxis
      }
    }
  }
</script>
