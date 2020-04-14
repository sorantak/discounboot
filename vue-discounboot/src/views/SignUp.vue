<template>
  <form v-on:submit.prevent="submitForm">
    <p>Welcome! Please fill out the form below.</p>
    <div>
      <label for="email">Email: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input id="email" type="text" v-model="email" placeholder="you@example.com">
    </div>
    <br>
    <div>
      <label for="name">Name: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input id="name" type="text" v-model="name">
    </div>
    <br>
    <div>
      <label for="birth">Birth: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input id="birth" type="text" v-model="birth" placeholder="0000-00-00">
    </div>
    <br>
    <div>
      <label for="password">Password: </label>
      <input id="password" type="password" v-model="password">
    </div>
    <br>
    <div>
      <label for="passwordCheck">Password Check: </label>
      <input id="passwordCheck" type="password" v-model="passwordCheck">
    </div>
    <!-- <br> -->
    <div>
        <p>Gender: </p>
        <!-- 중복 방지로 같은 name 설정 -->
        <div>
            <input id="M" name="gender" type="radio" v-model="gender" value="M">
            <label for="M">Male</label>
        </div>
        <div>
            <input id="F" name="gender" type="radio" v-model="gender" value="F">
            <label for="F">Female</label>
        </div>
    </div>
    <br>
    <button type="submit">Sign Up</button>
    <p>버튼 누르고 sign up 페이지로 넘어가기</p>
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data: function() {
    return {
      email: '',
      name: '',
      birth: '',
      password: '',
      passwordCheck: '',
      gender: ''
    }
  },
  methods: {
    submitForm: function() {
      // submit 하고 나서 페이지가 새로고침되는 것을 방지.
      // event.preventDefault();
    //   console.log(this.email, this.name, this.birth, this.password, this.gender);
      var url = 'http://localhost:8080/user/signup';
      var data = {
        email: this.email,
        name: this.name,
        // birth: this.birth + '-' + this.name
        birth: this.birth,
        password: this.password,
        passwordCheck: this.passwordCheck,
        gender: this.gender
      };
      // axios는 http 프로토콜을 사용하는 통신 라이브러리.
      axios.post(url, data)
        .then(function(response) {
          console.log(response);
          
        })
        .catch(function(error) {
          console.log(error);
          alert('에러');
        });
      
    }
  }
};
</script>

<style>

</style>