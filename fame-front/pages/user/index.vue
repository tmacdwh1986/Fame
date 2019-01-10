<template>
  <div class="container" id="main">
    <div class="login-wrap">
      <h2 class="title">Fame Login</h2>
      <el-form :model="userForm" :rules="rules" ref="userForm" label-width="0px">
        <el-form-item prop="username">
          <el-input v-model="userForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="密码" v-model="userForm.password"
                    @keyup.enter.native="submitForm('userForm')"></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm('userForm')">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data: function () {
      return {
        userForm: {
          username: '',
          password: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitForm (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$api.api.login(this.userForm).then(data => {
              if (data.success) {
                this.$router.push('/admin')
                this.$message({
                  message: '登录成功!',
                  type: 'success'
                })
              } else {
                this.$message({
                  message: '登录失败,' + data.msg,
                  type: 'error'
                })
              }
            })
          } else {
            this.$message({
              message: '登录失败',
              type: 'error'
            })
            return false
          }
        })
      }
    }
  }
</script>


