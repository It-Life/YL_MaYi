<template>
	<view>
		<view class="positon-top">
			<view class="current-location">
				<text>我的位置</text>
				<!-- <image src="../../static/indexImg/address.png"/>: -->
				<view class="iconfont icon-saoyisao"> nihao  </view>
			</view>
			<view class="address">{{Areaaddress}}</view>
		</view>
	</view>
</template>
<script>
	export default {
	   data() {
			return {
				Areaaddress:'' //当前位置
			}
		},
		mounted:function(){
			this.getAuthorizeInfo();
			this.getLocationInfo();
		},
		methods: {
			getAuthorizeInfo(a="scope.userLocation"){  //1. uniapp弹窗弹出获取授权（地理，个人微信信息等授权信息）弹窗
				var _this=this;
				uni.authorize({
					scope: a,
					success() { //1.1 允许授权
						_this.getLocationInfo();
					},
					fail(){    //1.2 拒绝授权
						console.log("你拒绝了授权，无法获得周边信息")
					}
				})
			},
			getLocationInfo(){  //2. 获取地理位置
				var _this=this;
				uni.getLocation({
					type: 'wgs84',
					success (res) {
					    console.log("你当前经纬度是：");
						console.log(res)
						let latitude,longitude;
						latitude = res.latitude.toString();
						longitude = res.longitude.toString();
						uni.request({
							header:{
								"Content-Type": "application/text"
							},
							url:'http://apis.map.qq.com/ws/geocoder/v1/?location='+latitude+','+longitude+'&key=MVGBZ-R2U3U-W5CVY-2PQID-AT4VZ-PDF35',
							success(re) {
								console.log("中文位置")
								console.log(re)	   
								_this.Areaaddress  = re.data.result.address;
								if(re.statusCode === 200){
									console.log("获取中文街道地理位置成功")
								}else{
									console.log("获取信息失败，请重试！")
								}
							 }
						});
					}
				});
			}
		}
	}
</script>

<style>
	 .current-location{
		width: 22%;
		height: 35upx;
		float: left;
		color: dimgray;
	 }
	 .address{
		 width: 69%;
		 height: 35upx;
		 float: left;
		 text-overflow: ellipsis; /* 显示省略号 */
		 white-space: nowrap; /* 强制字体不换行 */
		 overflow: hidden; /* 隐藏 */
		 color: dimgray;
	 }
	 image{
		 height: 30upx;
		 width: 30upx;
	 }
</style>