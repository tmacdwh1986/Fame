<template>
 <div :id="id" :style="style">
 </div>
</template>

<script type="text/javascript">
export default {
  name: 'Chart',
  data () {
    return {
      chart: ''
    }
  },
  props: {
    id: {
      type: String
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '400px'
    },
    marginLeft: {
      type: String,
      default: 'auto'
    },
    marginRight: {
      type: String,
      default: 'auto'
    },
    float: {
      type: String,
      default: 'center'
    },
    option: {
      type: Object,
      default () {
        return {
          title: { text: 'Default Chart' },
          tooltip: {},
          xAxis: {
            data: []
          },
          yAxis: {},
          series: [{
            name: '',
            type: 'line',
            data: []
          }]
        }
      }
    }
  },
  computed: {
    style () {
      return {
        height: this.height,
        width: this.width,
        marginLeft: this.marginLeft,
        marginRight: this.marginRight,
        float: this.float
      }
    }
  },
  watch: {
    option: {
      handler (newVal, oldVal) {
        if (this.chart) {
          if (newVal) {
            this.chart.setOption(newVal)
          }
        } else {
          this.init()
        }
      },
      deep: true
    }
  },
  methods: {
    init () {
      this.chart = this.$echarts.init(document.getElementById(this.id))
      this.chart.setOption(this.option)
      // resize chart with window
      window.addEventListener('resize', this.chart.resize)
    }
  },
  mounted () {
    this.init()
  }
}
</script>