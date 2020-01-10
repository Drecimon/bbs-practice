<template>
  <div class="head">
    <div class="head-left">
      <div class="logo-container">
        <img src="../assets/学校实验室图标/school-logo.png" class="school-logo" />
        <div class="logo-text">
          <div class="school-name">杭州电子科技大学</div>
          <div class="school-subname">Hangzhou Dianzi University</div>
        </div>
        <div class="word2">计算机实验室</div>
      </div>
    </div>

    <div class="head-right">
      <div class="menu">
        <el-menu mode="horizontal" active-text-color="#f54785">
          <el-menu-item index="1">首页</el-menu-item>
          <el-menu-item index="2">通知公告</el-menu-item>
          <el-menu-item index="3">部门介绍</el-menu-item>
          <el-menu-item index="4">成员介绍</el-menu-item>
          <el-menu-item index="5">招生信息</el-menu-item>
        </el-menu>
      </div>
      <div class="userhead">
        <el-popover></el-popover>
        <!--bug:除去此行点击头像弹出框无法正常使用-->
        <el-popover placement="top" width="224" >
          <p style="text-align:center">用户未登录，请登录</p>
          <div style="text-align: center; margin: 0">
            <el-button type="primary">登录</el-button>
          </div>
          <el-button type="text" slot="reference">
            <el-avatar :size="60" icon="el-icon-user"></el-avatar>
          </el-button>
        </el-popover>
      </div>
    </div>
  </div>
</template>

<style scoped>
.head {
  display: flex;
  margin: auto;
  align-self: center;
  align-items: center;
  border: 1px solid rgba(187, 187, 187, 1);
  height: 102px;
  width: 100%;
  min-width: 1439px;
  justify-content: space-between;
}
.head-right {
  display: flex;
}
.logo-text {
  margin-left: 30px;
}
.logo-container img {
  margin-left: 24px;
  width: 84px;
  height: 84px;
}
.logo-container {
  display: flex;
  align-items: center;
}
.school-name {
  color: #003b90;
  font-size: 36px;
  font-weight: 600;
}
.school-subname {
  color: #003b90;
  font-size: 16px;
}
.word2 {
  margin-left: 30px;
  font-size: 23px;
  font-weight: 600;
  color: #f54785;
}
.menu {
  align-items: center;
  font-size: 16px;
}
.userhead {
  margin-right: 37px;
  margin-top: 12px;
  margin-left: 30px;
}
</style>
<style>
.head .menu .el-menu-item {
  height: 100px;
  line-height: 100px;
}
</style>