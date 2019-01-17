<template>
  <div>
    <nuxt-link class="Home" :to="{ path: '/status' }">Status Home</nuxt-link>
    <demo-charts id="chart1" :option="acceleratorOption"/>
  </div>
</template>
<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  export default {
    head () {
      return { title: `Accel` }
    },
    fetch ({ store }) {
      return store.dispatch('getAcc')
    },
    computed: {
      acc: function () {
        return this.$store.state.accel.data
      }
    },
    data () {
      return {
        acceleratorOption: {
          title: {
            text: 'Accelerator',
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
        var json = this.acc
        this.acceleratorOption.xAxis.data = json[0].xAxis
        this.acceleratorOption.series[0].data = json[0].yAxis
        this.acceleratorOption.series[1].data = json[1].yAxis
        this.acceleratorOption.series[2].data = json[2].yAxis
      }
    }
  }
</script>
