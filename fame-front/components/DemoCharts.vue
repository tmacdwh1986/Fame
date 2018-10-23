<template>
 <div id="echarts">
   <div id="myChart"></div>
 </div>
</template>

<script type="text/javascript">
export default {
  name: 'Echarts',
  data () {
    return {}
  },
  methods: {
    echartsInit () {
      let myChart = this.$echarts.init(document.getElementById('myChart'))
      myChart.setOption({
        title: { text: 'Using echarts in Vue' },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [{
          name: '销量',
          type: 'bar',
          data: [5, 20, 36, 10, 10, 20]
        }]
      })
    },
  },
  mounted () {
    this.echartsInit()
  }
}
</script>
<style scoped lang="less">
  #myChart{
    width: 600px;
    height: 300px;
    margin-left: auto;
    margin-right: auto;
    float: left;
  }
</style>
