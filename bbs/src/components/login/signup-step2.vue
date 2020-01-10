<template>
  <div class="loginbox">
    <img src="../../assets/学校实验室图标/hulianwangzhuanchang.png" width="132px" top="3px" />
    <br />
    <p class="welcome">欢迎加入实验室</p>
    <br />
    <div id="input" style="line-height:60px">
      <el-input v-model="username" placeholder="给自己取个昵称吧" clearable style="width:296px;"></el-input>
      <br />
      <el-input v-model="telephone" placeholder="输入你的手机号码" show-password style="width:296px; "></el-input>
      <br />
      <el-input v-model="introduction" placeholder="来一句自我介绍呗" style="width:296px; "></el-input>
      <br />
      <div v-if="username||telephone||introduction">
        <el-button type="primary" style="width:165px; ">下一步</el-button>
      </div>
      <div v-else>
        <el-button type="danger" style="width:165px; ">不想填，跳过</el-button>
      </div>
    </div>
    <el-button type="text" style="margin:20px 420px">
      <u>返回登录</u>
    </el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      telephone: "",
      introduction: ""
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