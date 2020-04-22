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

// import axios from 'axios';

export default {
  name: 'Home',
  components: {
    // HelloWorld,
    Banner,
    ProductList
  },
  created(){
    // this.test();
  },
  // data: function() {
  //   return {
  //     id: '',
  //     name: '',
  //     thumbnailUrl: '',
  //     originPrice: '',
  //     discPrice: '',
  //     description: ''
  //   }
  // },
  // methods: {
  //   test: function() {
  //     var url = 'http://localhost:8080/post';

  //     axios.get(url)
  //       .then(function(response) {
  //         console.log(response);
          
  //       })
  //       .catch(function(error) {
  //         console.log(error);
          
  //       })
  //       var data = {
  //       id: this.id,
  //       name: this.name,
  //       thumbnailUrl: this.thumbnailUrl,
  //       originPrice: this.originPrice,
  //       discPrice: this.discPrice,
  //       description: this.description
  //     };
  //     console.log(data);
      
  //   }
  // }
}
</script>
