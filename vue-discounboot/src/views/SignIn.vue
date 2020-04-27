<template>
  <!-- 버튼 눌렀을 때 submitForm이라는 메서드 실행. -->
  <form v-on:submit.prevent="signIn">
    <p>Please fill out the form below.</p>
    <br />
    <div>
      <label for="email">Email: </label>
      <!-- v-model을 해줘야 바로 data의 username에 반영됨. -->
      <input
        id="email"
        type="text"
        v-model="email"
        placeholder="you@example.com"
      />
    </div>
    <br />
    <div>
      <label for="password">Password: </label>
      <input id="password" type="password" v-model="password" />
    </div>
    <br />
    <button type="submit">
      <!-- <router-link to="/"> -->
      Sign In
      <!-- </router-link> -->
    </button>
  </form>
</template>

<script>
// post로 서버에 데이터 전송하기 위해 axios 사용.
import axios from "axios";
// import VueCookie from "vue-cookie";

export default {
  data() {
    return {
      email: "",
      password: "",
      token: "",
    };
  },

  methods: {
    signIn() {
      var data = {
        email: this.email,
        password: this.password,
      };
      var router = this.$router;

      if (!data.email || !data.password) {
        alert("Your email or password is empty.");
      }

      axios
        .post("http://localhost:8080/user/signin", data)
        .then((res) => {
          if (res.status === 200) {
            this.result = res.data;
            console.log(this.result);
            this.token = this.result.data.token;
            console.log("토큰입니다: " + this.token);

            this.$cookie.set("accesstoken", res.data.data.token, 1);

            axios.defaults.headers.common["x-access-token"] = res.data.data.token;
            alert("Welcome!");
            router.push("/");
          }
        })
        .catch((err) => {
          alert("Sign in Failure: " + err);
        });
    },
  },
};
</script>

<style></style>
