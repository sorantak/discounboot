<template>
  <div class="home">
    <p>This is Home.</p>
    <Banner></Banner>
    <ProductList></ProductList>
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import Banner from '@/components/Banner.vue'
import ProductList from '@/components/ProductList.vue'


export default {
  name: 'Home',
  components: {
    // HelloWorld,
    Banner,
    ProductList
  }
}
</script>
