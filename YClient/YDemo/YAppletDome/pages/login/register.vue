<template>
		<view class="page login-fixed-pos" style="background-color: rgb(14,14,14); top: 0;left: 0;right: 0; bottom: 0;">
			<view >
				<image class="justify-center margin-bottom-lg margin-left-xxl " src="../../static/logo/logo.jpg" mode=""></image>
			</view>
			<view class="" style="bottom: 200upx; flex-direction: row;">
				<view class=" login-int">
					<input class="justify-center login-input text-black" name="input" type="number" value="" v-model="loginPhone" placeholder="请输入手机号" />
				</view>
				<view class="login-int">
					<input class="justify-center login-input text-black" name="input" type="text" value="" v-model="loginname" placeholder="请输入用户名" />
				</view>
				<view class="login-int">
					<input class="justify-center login-input text-black" name="input" type="text" value="" v-model="loginpassword" placeholder="请输入密码" />
				</view>
				<view class="login-int login-btn" style="display: flex;">
					<button class="border-radius-lg" type="default" @click="btnReg()">立即注册</button>
					<button class="border-radius-lg" type="default" @click="btnCancel()">取消注册</button>
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
				loginname: '',
				loginpassword: ''
			}
		},
		methods:{
			btnReg()
			{
				this.$request.post({
				    url: 'register',
					data:{
						'userPhone':this.loginPhone,
						'password':this.loginpassword,
						'userName':this.loginname,
					}
					}).then(
						res =>{
							 console.log('success');
							 //that.json = JSON.stringify(res);
							 uni.reLaunch({
							 	url:"./login"
							 });
						},
						res =>{
							console.log('failure');
							//that.json = JSON.stringify(res);
						}
					);
			},
			btnCancel()
			{
				uni.navigateTo({
					url:"./login" 
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
	margin-left: 100upx;
	margin-right: 100upx;
}
.login-int{
	padding-top: 20upx;
}

.login-fixed-pos{
	position: fixed;
}

</style>
