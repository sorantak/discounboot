<template>
  <div id="app">
    <!-- <div class="card">
      <h3 class="card-header text-center">Register Area</h3>
      <div class="card-body">
        <form>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label>First Name</label>
              <input type="text" class="form-control" v-model.trim="$v.firstname$model" :class="{
                'is-invalid' :$v.firstname.$error, 'is-valid':!$v.firstname$invalid}">
            </div>
          </div>
        </form>
      </div>
    </div> -->
    <AppHeader></AppHeader>
    <router-view/>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue"
// import { reqired, minLength, maxLength, between } from 'vuelidate/lib/validators'

export default {
  components: {
    AppHeader
  }
}
</script>

<style>
#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif; */
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

AppHeader {
  padding: 30px;
}

nav {
  font-weight: bold;
  color: #2c3e50;
}
nav.router-link-exact-active {
  color: #42b983;
}

body {
  text-align: center;
  background-color: #f6f6f6;
}
input {
  border-style: groove;
  /* width: 200px; */
}
button {
  border-style: groove;
}
/* .shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
} */

/* .router-link-active {
  color: #42b983;
} */
</style>
