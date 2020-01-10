<template>
  <div class="logPage">
    <div id="logTitle">
      <el-menu
        default-active="activeIndex"
        @select="handleOpen"
        active-text-color="#F54785"
      >
        <el-menu-item index="1">访问记录</el-menu-item>
        <el-menu-item index="2">登录记录</el-menu-item>
        <el-menu-item index="3">操作记录</el-menu-item>
      </el-menu>
    </div>
    <div v-if="activeIndex === '1'">
      <FangWen></FangWen>
    </div>
    <div v-if="activeIndex === '2'">
      <DengLu></DengLu>
    </div>
    <div v-if="activeIndex === '3'">
      <CaoZuo></CaoZuo>
    </div>
  </div>
</template>

<script>
import CaoZuo from "./logPage/CaoZuo.vue";
import DengLu from "./logPage/DengLu.vue";
import FangWen from "./logPage/FangWen.vue";
export default {
  name: "logTitle",
  components: {
    CaoZuo,
    DengLu,
    FangWen
  },
  data() {
    return {
      activeIndex: "1"
    };
  },
  methods: {
    handleOpen(key) {
      /* eslint-disable no-alert, no-console */
      this.activeIndex = key;
    }
  }
};
</script>

<style>
#logTitle {
  height: 168px;
  width: 191px;
  margin: 73px 76px 0 38px;
  background-color: rgba(246, 245, 245, 1);
  text-align: center;
  border: 1px solid rgba(191, 191, 191, 1);
}
.logPage{
  display: flex;
  width: 100%;
}
</style>
