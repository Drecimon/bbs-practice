<template>
  <div class="loginpage">
    <div class="opacity-black">
      <loginbox></loginbox>
    </div>
  </div>
</template>

<script>
import loginbox from "./login/loginbox.vue";
//import step1 from "./login/signup-step1.vue";
export default {
  components: {
    loginbox,
 //   step1
  }
};
</script>

<style>
.loginpage {
  
  margin: 0;
  left: 0px;
  top: 0;
  min-width: 1439px;
  min-height: 1200px;
  width: 100%;
  line-height: 20px;
  position: relative;
  text-align: center;
  background: url("../assets/学校实验室图标/login.jpg");
  background-size: 100%;
  border: 1px solid rgba(187, 187, 187, 1);
}
.opacity-black {
  align-items: center;
  display: flex;
  width: 100%;
  height: 100%;
  min-height: 1200px;
  background-color: #000000;
  opacity: 0.8;
}
</style>