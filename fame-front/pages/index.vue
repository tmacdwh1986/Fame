<template>
  <div>
    <demo-charts id="chart1" :option="option1"/>
    <demo-charts id="chart2" :option="option2"/>
    <demo-charts id="chart3" :option="option3"/>
    

    <div v-for="article in articles" :key="article.id" class="article-item">
      <h2 class="article-head text-bold">
        <nuxt-link :to="{ path: '/article/'+article.id }">{{article.title}}</nuxt-link>
      </h2>
      <p class="article-date"><span class="icon-folder"></span> {{article.category | formatCategory}}</p>
      <p class="article-date text-italic"><span class="icon-calendar"></span> {{article.created | time('yyyy-MM-dd')}}
      </p>
      <p class="article-date"><span class="icon-eye"></span> {{article.hits}}</p>
      <div class="article-tags">
        <label v-for="tag in $util.stringToTags(article.tags)" :key="tag" class="chip">
          {{tag}}
        </label>
      </div>
      <div class="article-summary markdown-body" v-html="article.content" v-highlight>
      </div>
      <nuxt-link class="article-more text-primary" :to="{ path: '/article/'+article.id }">Read more</nuxt-link>
    </div>
    <div class="front-page">
      <div class="pre text-primary" v-if="currentPage > 1">
        <nuxt-link :to="{path:'', query: { page: currentPage-1 }}">← Pre</nuxt-link>
      </div>
      <div class="next text-primary" v-if="currentPage < totalPage">
        <nuxt-link :to="{path:'', query: { page: currentPage+1 }}">Next →</nuxt-link>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import DemoCharts from '~/components/DemoCharts.vue'
  
  export default {
    watchQuery: ['page'],
    key: (to) => to.fullPath,
    transition (to, from) {
      return 'move'
    },
    head () {
      return { title: `Blog` }
    },
    fetch ({ store, query }) {
      return store.dispatch('getArticles', query.page)
    },
    data () {
      // Fake data to validate
      return {
        // Line Chart
        chartData1: {
          xData: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
          sData: [5, 20, 36, 10, 10, 70]
        },
        option1: {
          title: {
            text: 'Line Chart'
          },
          legend: {
            data: ['销量']
          },
          xAxis: {
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
          },
          yAxis: [{
            type: 'value'
          }],
          series: [{
            name: '销量',
            type: 'line',
            data: [5, 20, 36, 10, 10, 70]
          }]
        },
        // Pie Chart
        chartData2: {
          xData: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
          sData: [5, 20, 36, 10, 10, 70]
        },
        option2: {
          title: {
            text: 'Pie Chart'
          },
          legend: {
            data: ['销量']
          },
          xAxis: {
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
          },
          yAxis: [{
            type: 'value'
          }],
          series: [{
            name: '销量',
            type: 'pie',
            data: [5, 20, 36, 10, 10, 70]
          }]
        },
        // Bar Chart
        chartData3: {
          xData: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
          sData: [5, 20, 36, 10, 10, 70]
        },
        option3: {
          title: {
            text: 'Bar Chart'
          },
          legend: {
            data: ['销量']
          },
          xAxis: {
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
          },
          yAxis: [{
            type: 'value'
          }],
          series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 70]
          }]
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
        let chartData = [this.chartData1, this.chartData2, this.chartData3]
        let option = [this.option1, this.option2, this.option3]
        for (let i = 0; i < chartData.length; i++) {
          for (let j = 0; j < chartData[i].length; j++) {
            option[i].xAxis.data.push(chartData[i].xData[j])
            option[i].series[0].data.push(chartData[i].sData[j])
          }
        }
      }
    },
    computed: {
      articles () {
        return this.$store.state.article.list.data
      },
      totalPage () {
        return this.$store.state.article.list.totalPage
      },
      currentPage () {
        return this.$store.state.article.list.currentPage
      }
    }
  }
</script>

<style scoped>

  .article-item {
    padding-bottom: 30px;
  }

  .article-item:first-child {
    margin-top: 30px;
  }

  .article-head {
    line-height: 1.2;
    font-size: 1.6rem;
    margin: 0;
  }

  .article-head > a {
    color: #34495e;
    outline: none;
    text-decoration: none;
  }

  .article-head > a:hover {
    outline-width: 0;
    text-decoration: underline;
  }

  .article-item .article-date {
    display: inline-block;
    color: #7f8c8d;
    margin: 5px 5px;
    font-size: 0.9em;
  }

  .article-item .article-tags {
    margin-bottom: 10px;
  }

  .article-item .article-more {
    font-weight: bold;
    font-size: 16px;
    text-decoration: none;
    display: inline-block;
    transition: all 0.3s;
  }

  .article-item .article-more:hover {
    transform: translateX(10px);
  }

  .front-page {
    margin: 4em 3em;
    font-size: 15px;
  }

  .front-page a {
    font-weight: bold;
    color: #5764c6;
    text-decoration: none;
  }

  .front-page .pre {
    float: left;
  }

  .front-page .next {
    float: right;
  }
</style>
