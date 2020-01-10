<template>
  <div style="width:380px">
    <div class="info-head">
      <el-avatar :size="190" src="../../assets/学校实验室图标/user-s.png"></el-avatar>
    </div>
    <div>
      <el-button type="primary" style="width:165px; ">管理员</el-button>
      <br />
      <el-button type="text" style="margin-left: 210px">
        <u>编辑资料</u>
      </el-button>
      <div class="info">
        <div style="display: flex; justify-content: space-between;">
          <div style="margin:12px">个人资料</div>
          <div style="margin:12px">ID:233</div>
        </div>

        <hr />  
        <div style="text-align:left;margin:15px;line-height:36px">
        昵称：
        <br>
        手机:
        <br>
        邮箱:
        <br>
        注册时间:
        <br>
        个人介绍:
        <br>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.info-head {
  margin-top: 58px;
  margin-bottom: 32px;
}
.info {
  margin-left: 67px;
  width: 254px;
  height: 325px;
  line-height: 20px;
  border-radius: 10px;
  font-size: 14px;
  text-align: center;
  font-family: Roboto;
  border: 1px solid rgba(187, 187, 187, 1);
}
</style>