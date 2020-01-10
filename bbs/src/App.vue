<template>
  <div id="app">
    <mymenu></mymenu>
    
    <login></login>

    <test></test>
  </div>
</template>

<script>
import mymenu from './components/head.vue'
import login from './components/login.vue'
import test from  './components/test.vue'

export default {
  name: 'app',
  components: {
    mymenu,
    login,
    test
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
