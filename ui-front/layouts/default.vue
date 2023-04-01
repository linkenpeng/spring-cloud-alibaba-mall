<template>
  <div id="app-container">
    <div id="main">

      <header/>

      <div class="main-container">
        <el-scrollbar class="page-component__scroll">

          <nuxt/>

        </el-scrollbar>
      </div>

      <footer/>

    </div>

  </div>
</template>

<script>
import '~/assets/css/app.css'
import '~/assets/css/chunk.css'
import '~/assets/css/iconfont.css'
import '~/assets/css/main.css'

import header from './header'
import footer from './footer'
export default {
  components: {
    header, footer
  }
}
</script>

