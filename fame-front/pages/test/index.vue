<template>
  <div id="test">
		<demo-charts id="chart"/>
  </div>
</template>

<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'

  const pageTitle = 'Test'

  export default {
    head () {
      return { title: `测试` }
    },
    fetch ({ store, params }) {
      return store.dispatch('getPage', pageTitle)
    },
    data () {
      return {
      }
    },
    components: {
      DemoCharts
    },
    computed: {
      content () {
        return this.$store.state.article.page.content
      }
    },
    methods: {
    },
    mounted () {
    }
  }
</script>
