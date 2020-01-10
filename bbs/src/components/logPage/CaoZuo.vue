<template>
  
    <div id="FangWen" class="logTable">
        <p
        style="color: rgba(0, 59, 144, 1);font-size: 28px;font-family: SourceHanSansSC-regular;"
      >登录纪录</p>
      <el-table :data="tableData" style="width: 100%" height="100%">
        <el-table-column fixed prop="date" label="用户id" min-width="100"></el-table-column>
        <el-table-column prop="name" label="用户昵称" min-width="120"></el-table-column>
        <el-table-column prop="province" label="操作时间" min-width="120"></el-table-column>
        <el-table-column prop="city" label="操作类型" min-width="180"></el-table-column>
        <el-table-column prop="zip" label="操作" min-width="100"></el-table-column>
      </el-table>
    </div>
</template>

<style>

.logTable {
  margin-top: 73px;
  margin-right: 95px;
 height: 737px;
 
  width: 890px;
  left: 379px;
  line-height: 20px;

  text-align: center;
  border: 1px solid rgba(191, 191, 191, 1);
}
</style>