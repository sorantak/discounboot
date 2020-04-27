<template>
  <div>
    <p>This is my Basket.</p>
    <!-- <li v-for="prod in prods" v-bind:key="prod.name">{{ prod.name }}</li> -->
    <!-- <ul>
      <li v-bind="data">
          {{ name }}
          {{ thumbnail }}
          <button>Delete</button>
      </li>
  </ul> -->
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      prods: [],
    };
  },
  created() {
    axios.get("http://localhost:8080/prod").then((res) => {
      this.result = res.data;
      console.log(this.result);

      this.prods = this.result.data;
      console.log(this.prods);

      console.log(`status code: ${res.status}`);
      console.log(`headers: ${res.headers}`);
      // console.log(`data: ${JSON.stringify(res.data)}`);
      // var data = res.data.data;
      // console.log('객체 data: ' + data);
      // var parseData = JSON.parse(data);
      // console.log('parse한 data: ' + parseData.data(1));
      // localStorage.setItem('product', res.data);
      // var name = localStorage.getItem(localStorage.product.data(1));
      // console.log('prod name: ' + name);
      // this.posts = data;
      // console.log(this.posts.name);
    });
  },
  // data() {
  //     return {
  //         name: 'c',
  //         thumbnail: 'd'
  //     }
  // },
  // methods: {
  //     hehe() {
  //         this.name = 'a';
  //         this.thumbnail = 'b';
  //         console.log(this.name + this.thumbnail);
  //     }
  // }
};
</script>

<style></style>
