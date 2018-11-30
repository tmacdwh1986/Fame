<template>
  <div class="search-panel">
    <el-row class="header-searchbar">
      <el-col
        :span="45"
        class="center">
        <div class="wrapper">
          <el-input
            v-model="search"
            placeholder="search by vehicle or type"
            @focus="focus"
            @blur="blur"
            @input="input"/>
          <button class="el-button el-button--primary"><i class="el-icon-search"/></button>
          <dl
            v-if="isHotSearch"
            class="hotSearch">
            <dt>hot search</dt>
            <dd
             v-for="(item, idx) in hotSearch" :key="idx">{{ item }}</dd>
          </dl>
          <dl
            v-if="isSearchList"
            class="searchList">
            <dd
             v-for="(item, idx) in searchList" :key="idx">{{ item }}</dd>
          </dl>
        </div>
        <p class="suggest">
          <a href="#">Lincon</a>
          <a href="#">New Focus</a>
        </p>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      search: '',
      isFocus: false,
      hotSearch: ['New Foucs', 'New Foucs', 'New Foucs'],
      searchList: ['Lincon', 'Lincon', 'Lincon']
    }
  },
  computed: {
    isHotSearch: function () {
      return this.isFocus && !this.search
    },
    isSearchList: function () {
      return this.isFocus && this.search
    }
  },
  methods: {
    focus: function () {
      this.isFocus = true
    },
    blur: function () {
      let self = this
      setTimeout(function () {
        self.isFocus = false
      }, 200)
    },
    input: function () {
      console.log('reserved interface for future interaction')
    }
  }
}
</script>

<style lang="css">
</style>
