<template>
  <div class="container" id="main">
    <div class="login-wrap" v-show="showLogin">
      <h2 class="title">Fame Login</h2>
      <el-form :model="userLoginForm" :rules="loginRules" ref="userLoginForm" label-width="0px">
        <el-form-item prop="username">
          <el-input v-model="userLoginForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="密码" v-model="userLoginForm.password"
                    @keyup.enter.native="submitForm('userLoginForm')"></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="Login('userLoginForm')">登录</el-button>
        </div>
        <span v-on:click="ToRegister">没有账号？马上注册</span>
      </el-form>
    </div>
    <div class="login-wrap" v-show="showRegister">
      <h2 class="title">Fame Register</h2>
      <el-form :model="userRegisterForm" :rules="registerRules" ref="userRegisterForm" label-width="0px">
        <el-form-item prop="username">
          <el-input v-model="userRegisterForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="screanName">
          <el-input placeholder="显示名" v-model="userRegisterForm.screanName"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="密码" v-model="userRegisterForm.passwordMd5"></el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input placeholder="邮箱" v-model="userRegisterForm.email"></el-input></el-form-item>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="Register('userRegisterForm')">注册</el-button>
        </div>
        <span v-on:click="ToLogin">已有账号？马上登录</span>        
      </el-form>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    layout: 'full',
    head () {
      return { title: `FAME` }
    },
    data: function () {
      return {
        showLogin: true,
        showRegister: false,
        userLoginForm: {
          username: '',
          password: ''
        },
        loginRules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ]
        },
        userRegisterForm: {
          username: '',
          password: ''
        },
        registerRules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          screanName: [
            { required: true, message: '请输入显示名', trigger: 'blur' }
          ],
          passwordMd5: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '请输入邮箱', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      Login (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$store.dispatch('login', this.userLoginForm).then((res) => {
              console.log(res)
              if (res.success) {
                this.$router.push({ path: '/' })
                this.$message({
                  message: '登录成功!',
                  type: 'success'
                })
              } else {
                this.$message({
                  message: '登录失败',
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
      },
      Register (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$store.dispatch('register', this.userRegisterForm).then((res) => {
              console.log(res)
              if (res.success) {
                this.showRegister = false
                this.showLogin = true
                this.$message({
                  message: '注册成功!',
                  type: 'success'
                })
              } else {
                this.$message({
                  message: '注册失败',
                  type: 'error'
                })
              }
            })
          } else {
            this.$message({
              message: '注册失败',
              type: 'error'
            })
            return false
          }
        })
      },
      ToRegister () {
        this.showRegister = true
        this.showLogin = false
      },
      ToLogin () {
        this.showRegister = false
        this.showLogin = true
      }
    }
  }
</script>

<style scoped>
  .container {
    position: absolute;
    bottom: 0;
    top: 0;
    left: 0;
    right: 0;
    overflow: hidden;
    background-color: #f5f5f5;
  }

  .login-wrap {
    max-width: 330px;
    margin: 100px auto 0;
    background: #fff;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.2);
    text-align:center;
  }

  .title {
    margin: 0;
    padding: 25px 20px;
    text-align: center;
    background: #68dff0;
    border-radius: 5px 5px 0 0;
    -webkit-border-radius: 5px 5px 0 0;
    color: #fff;
    font-size: 20px;
    text-transform: uppercase;
    font-weight: 300;
  }

  .el-form {
    padding: 20px;
  }

  .login-btn button {
    width: 100%;
  }

  span{cursor:pointer;}
  span:hover{color:#41b883;}
</style>
