<template>
		<view class="page login-fixed-pos" style="background-color: rgb(14,14,14); top: 0;left: 0;right: 0; bottom: 0;">
			<view >
				<image class="justify-center margin-bottom-lg margin-left-xxl animate__bounceIn animate__fast" src="../../static/logo/logo.jpg" mode=""></image>
			</view>
			<view class="" style="bottom: 200upx; flex-direction: row;">
				<view class="justify-center login-int">
					<input class="justify-center login-input text-black" name="input" type="number" value="" v-model="loginPhone" placeholder="请输入手机号" />
				</view>
				<view class="login-int">
					<input class="justify-center login-input text-black" name="input" type="text" value="" v-model="loginpassword" placeholder="请输入密码" />
				</view>
				<view class="login-int login-btn" style="display: flex;">
					<button class="border-radius-lg" type="default" @click="btnLogin()">立即登录</button>
					<button class="border-radius-lg" style="color: rgb(14,14,14);" type="default" plain="true" @click="btnReg()">
							<text class="margin-top-sm text-white" style="font-size: 30upx;">去注册？</text>
					</button>
				</view>
			</view>

		</view>
</template>

<script>
	export default{
		data()
		{
			return{
				title: '用户登录',
				loginPhone: '',
				loginpassword: '',
				list:[]
			}
		},
		methods:{
			btnLogin(full)
			{
				
				console.log(this.loginPhone);
				console.log(this.loginpassword);
				this.$request.get
/* 				this.api.doLogin(this.loginPhone,this.loginpassword).then(res =>{
					this.list = res.data;
					uni.reLaunch({
						url:"../index/index"
					})
				}) */
				this.$request.post({
				    url: 'login',
					data:{
						'userPhone':this.loginPhone,
						'password':this.loginpassword,
					},
					header: {
					            "Content-Type": "application/x-www-form-urlencoded"
					}, // 请求头
				    business: full ? null : 'data',
				    success: res => {
				        console.log('success');
				        that.json = JSON.stringify(res);
						uni.reLaunch({
							url:"../index/index"
						});
				    },
				    fail: res => {
				        console.log('failure');
				        that.json = JSON.stringify(res);
				    },
				    complete: res=> {
				        // since 1.2.0
				        //console.log('complete', res);
				    }
				});
			},
			btnReg()
			{
				uni.navigateTo({
					url: "./register"
				})
			}
		}
	}
	
</script>

<style>

.login-input
{
	background-color: #FFFFFF;
	height: 80upx;
	margin-left: 80upx;
	margin-right: 80upx;
}
.login-btn{
	height: 80upx;
	margin-left: 250upx;
	margin-right: 60upx;
}
.login-int{
	padding-top: 20upx;
}

.login-fixed-pos{
	position: fixed;
}

</style>
