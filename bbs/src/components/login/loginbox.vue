<template>
    <div class="loginbox">
      <p class="welcome">欢迎来到实验室</p>
      <br />
      <img src="../../assets/学校实验室图标/hulianwangzhuanchang.png" width="132px" top="3px" />
      <br />
      <div id="input" style="line-height:80px">
        <el-input v-model="userid" placeholder="请输入用户名" clearable style="width:296px;"></el-input>
        <br />
        <el-input v-model="password" placeholder="请输入密码" show-password style="width:296px; "></el-input>
        <br />
        <el-button type="primary" style="width:165px; ">立即登陆</el-button>
      </div>
      <el-button type="text" style="margin:20px 380px"><u>没有账号?这里注册</u></el-button>
    </div>  
</template>

<script>
export default {
  data() {
    return {
      userid: "",
      password: ""
    };
  }
};
</script>

<style>


.loginbox {
  margin: auto;
  width: 519px;
  height: 535px;
  line-height: 17px;
  border-radius: 20px;
  background-color: rgba(255, 255, 255, 1);
  text-align: center;
  border: 1px solid rgba(187, 187, 187, 1);
}
.welcome {
  margin: 44px 62px 0px;
  left: 522px;
  top: 382px;
  width: 391px;
  height: 42px;
  font-family: SourceHanSansSC-regular;
  font-size: 28px;
  text-align: center;
  font-family: SourceHanSansSC-regular;
}
</style>