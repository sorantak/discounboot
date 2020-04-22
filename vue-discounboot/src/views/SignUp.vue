<template>
  <form v-on:submit.prevent="submitForm">
    <p>Welcome! Please fill out the form below.</p>
    <br>
    <div>
      <label for="email">Email: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input id="email" type="text" v-model="email" placeholder="you@example.com" v-on:keyup.enter="checkEmail" /> 
      <button v-on:click="checkEmail">Check Email</button>
    </div>
    <br>
    <div>
      <label for="name">Name: </label>
      <input id="name" type="text" v-model="name">
    </div>
    <br>
    <div>
      <label>Birth: </label>
      <input id="birthYear" type="number" v-model="birthYear" placeholder="0000" min="1900" max="2020">
      <input id="birthMonth" type="number" v-model="birthMonth" placeholder="00" min="1" max="12">
      <input id="birthDate" type="number" v-model="birthDate" placeholder="00" min="1" max="31">
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
      <input id="M" name="gender" type="radio" v-model="gender" value="M">
      <label for="M">Male</label>
      <input id="F" name="gender" type="radio" v-model="gender" value="F">
      <label for="F">Female</label>
    </div>
    <br>
    <button type="submit">Sign Up</button>
    <!-- <p>버튼 누르고 sign up 페이지로 넘어가기</p> -->
  </form>
</template>

<script>
import axios from 'axios';

export default {
  data: function() {
    return {
      email: '',
      name: '',
      birthYear: '',
      birthMonth: '',
      birthDate: '',
      password: '',
      passwordCheck: '',
      gender: ''
    }
  },
  methods: {
    checkEmail: function(){
      event.preventDefault();
      var url = 'http://localhost:8080/user/signup/email';
      var data = {
        email: this.email
      };
      axios
        .post(url, data)
        .then(function(res) {
          if (res.data.data == 0) {
            alert('사용할 수 있는 email입니다.');
          }
          else {
            alert('중복된 email입니다.');
          }
          // console.log(res.data.data);
          
        })
        .catch((err) => {
          alert("Email Check Failure: " + err);
        });
    },
    submitForm: function() {
      // submit 하고 나서 페이지가 새로고침되는 것을 방지.
      // event.preventDefault();
    //   console.log(this.email, this.name, this.birth, this.password, this.gender);
      var url = 'http://localhost:8080/user/signup';
      var data = {
        email: this.email,
        name: this.name,
        birth: this.birthYear + '-' + this.birthMonth + '-' + this.birthDate,
        password: this.password,
        passwordCheck: this.passwordCheck,
        gender: this.gender
      };
      // var vm = this;
      // axios는 http 프로토콜을 사용하는 통신 라이브러리.
      axios.post(url, data)
        .then(function(response) {
          
          console.log(response);
          this.changeView();
        })
        .catch(function(error) {
          console.log(error);
          alert('에러');
        });
      
    },
    changeView: function() {
      this.$router.push('/signin');
 }  }
};
</script>
// 2. 연령 체크
// 3. 비밀번호 확인
<style>

</style>