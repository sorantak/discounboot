<template>
<!-- 버튼 눌렀을 때 submitForm이라는 메서드 실행. -->
  <form v-on:submit.prevent="submitForm">
    <div>
      <label for="email">Email: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input id="email" type="text" v-model="email" placeholder="you@example.com">
    </div>
    <br>
    <div>
      <label for="password">Password: </label>
      <input id="password" type="password" v-model="password">
    </div>
    <br>
    <button type="submit">Sign In</button>
  </form>
</template>

<script>
// post로 서버에 데이터 전송하기 위해 axios 사용.
import axios from 'axios';

export default {
  data: function() {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    submitForm: function() {
      // submit 하고 나서 페이지가 새로고침되는 것을 방지.
      // event.preventDefault();
      console.log(this.email, this.password);
      var url = 'http://localhost:8080/user/signin';
      var data = {
        email: this.email,
        password: this.password
      };
      // axios는 http 프로토콜을 사용하는 통신 라이브러리.
      axios.post(url, data)
        .then(function(response) {
          console.log(response);
          
        })
        .catch(function(error) {
          console.log(error);
        });
      
    }
  }
};
</script>

<style>

</style>