import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuelidate from 'vuelidate'
import VueCookie from 'vue-cookie'
// import 'bootstrap/dist/css/bootstrap.min.css'

Vue.use(Vuelidate)
Vue.use(VueCookie)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
