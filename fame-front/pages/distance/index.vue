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
      return { title: `Distance` }
    },
    fetch ({ store }) {
      return store.dispatch('getDistance')
    },
    computed: {
      distance: function () {
        return this.$store.state.distance.data
      }
    },
    data () {
      return {
        chart1Option: {
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
        chart2Option: {
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
      this.refreshData()
    },
    methods: {
      refreshData () {
        var json = this.distance
        this.chart1Option.xAxis.data = json[0].xAxis
        this.chart1Option.series[0].data = json[0].yAxis
        this.chart1Option.series[1].data = json[1].yAxis
        this.chart1Option.series[2].data = json[2].yAxis
        this.chart2Option.xAxis.data = json[0].xAxisAccu
        this.chart2Option.series[0].data = json[0].yAxisAccu
        this.chart2Option.series[1].data = json[0].yAxisAccu
        this.chart2Option.series[2].data = json[0].yAxisAccu
      }
    }
  }
</script>
