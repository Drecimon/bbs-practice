<template>
    <div class="loginbox">
      
      <img src="../../assets/学校实验室图标/hulianwangzhuanchang.png" width="132px" top="3px" />
      <br />
      <p class="welcome">欢迎加入实验室</p>
      <br />
      <div id="input" style="line-height:60px">
        <el-input v-model="userid" placeholder="你的杭电账号是什么呀" clearable style="width:296px;"></el-input>
        <br />
        <el-input v-model="password" placeholder="想用什么密码登录实验室呢" show-password style="width:296px; "></el-input>
        <br />
        <el-input v-model="email" placeholder="还可以用邮箱登录"  style="width:296px; "></el-input>
        <br />
        <el-button type="primary" style="width:165px; ">下一步</el-button>
      </div>
      <el-button type="text" style="margin:20px 420px"><u>返回登录</u></el-button>
    </div>
</template>

<script>
export default {
  data() {
    return {
      userid: "",
      password: "",
      email:""
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