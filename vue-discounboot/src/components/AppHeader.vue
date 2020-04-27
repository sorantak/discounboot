<template>
  <div>
    <nav>
      <p>Discounboot</p>
      <!-- <router-link to="/">Home</router-link> |
      <router-link to="/signup">Sign Up</router-link> |
      <router-link to="/signin">Sign In</router-link> |
      <router-link to="/basket">My Basket</router-link> -->
      <a href="/"><button>Home</button></a>
      <a v-if="isCookie"></a>
      <a v-else href="/signup"><button>Sign Up</button></a>
      <a v-if="isCookie" v-on:click.prevent="deleteCookie" href="/"><button>Sign Out</button></a>
      <a v-else href="/signin"><button>Sign In</button></a>
      <a v-if="isCookie" href="/basket"><button>My Basket</button></a>

      <!-- <div v-for="item in array" :key="item.idx">
        {{item}}
        <br/>
      
      </div> -->
    </nav>
  </div>
</template>

<script>
/* 쿠키 검사
    if 있으면 = basket 보이기
    if 없으면 = basket x
*/
export default {
  data() {
    return {
      isCookie: null,
    };
  },
  created() {
    this.isCookie = document.cookie;
    
  },
  methods: {
    deleteCookie() {
      this.$cookie.delete("accesstoken");
      this.isCookie = document.cookie;
      alert("로그아웃 되었습니다.");
    },
  },
};
</script>

<style></style>
