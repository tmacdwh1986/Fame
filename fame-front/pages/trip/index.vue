<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/driving' }">Driving Home</nuxt-link>
    <demo-charts id="chart1" :option="chart1Option"/>
    <demo-charts id="chart2" :option="chart2Option"/>
    <demo-charts id="chart3" :option="chart3Option"/>
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
    computed: {
      distance: function () {
        return this.$store.state.trip.data
      }
    },
    data () {
      return {
        chart1Option: {
          title: {
            text: 'Chart 1',
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
            data: [ ]
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
              name: '',
              type: 'bar',
              barGap: 0,
              data: [ ]
            }
          ]
        },
        chart2Option: {
          title: {
            text: 'Chart 2',
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
            data: [ ]
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
              name: '',
              type: 'bar',
              barGap: 0,
              data: [ ]
            }
          ]
        },
        chart3Option: {
          title: {
            text: 'Chart 3',
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
            data: [ ]
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
      this.refreshData()
    },
    methods: {
      refreshData () {
        var json = this.distance
        this.chart1Option.xAxis.data = json[0].xAxis
        this.chart1Option.series[0].data = json[0].yAxis
        this.chart2Option.xAxis.data = json[1].xAxis
        this.chart2Option.series[0].data = json[1].yAxis
        this.chart3Option.xAxis.data = json[2].xAxis
        this.chart3Option.series[0].data = json[2].yAxis
      }
    }
  }
</script>
