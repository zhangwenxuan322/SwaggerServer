# Swagger服务端
## Api
### 短信验证码
#### 获取短信验证码
- 请求URL：`/swagger/code/{phone}`
- 请求方式：`GET`
- 请求参数：`phone=123456789`
### 用户
#### 根据手机号查询用户
- 请求URL：`/swagger/user/phone/{phone}`
- 请求方式：`GET`
- 请求参数：`phone=123456789`
#### 根据SwaggerId查询用户
- 请求URL：`/swagger/user/swaggerId/{swaggerid}`
- 请求方式：`GET`
- 请求参数：`swaggerid=t123`
#### 根据id查询用户
- 请求URL：`/swagger/user/id/{id}`
- 请求方式：`GET`
- 请求参数：`id=1`
#### 注册
- 请求URL：`/swagger/user`
- 请求方式：`POST`
- 请求参数：
```json
{
  "userId": 0,
  "userName": "测试112",
  "userSex": "男",
  "userPassword": "888",
  "userPhone": "1112223111",
  "userSwaggerId": null,
  "userPortrait": "111.jpg",
  "userBio": null,
  "userCreateTime": null,
  "userModifyTime": null,
  "userLoginInfoId": 0,
  "userToken": null
}
```
#### 登录
- 请求URL：`/swagger/user/auth`
- 请求方式：`GET`
- 请求参数：`account=test&password=test&ip=192.168.0.1&long=104.01&lat=30.40&device=000-2222011`
#### 修改密码
- 请求URL：`/swagger/user/password`
- 请求方式：`PUT`
- 请求参数：
```json
{
  "phone": 123123,
  "password": 233
}
```
#### 修改SwaggerId
- 请求URL：`/swagger/user/swaggerId`
- 请求方式：`PUT`
- 请求参数：
```json
{
	"userId":2,
	"userName":"friend",
	"userSex":"男",
	"userPassword":"123",
	"userPhone":"13851567613",
	"userSwaggerId":"friend",
	"userPortrait":"",
	"userBio":null,
	"userCreateTime":null,
	"userModifyTime":null,
	"userLoginInfoId":0,
	"userToken":null
}
```
#### 修改性别
- 请求URL：`/swagger/user/sex`
- 请求方式：`PUT`
- 请求参数：
```json
{
	"userId":2,
	"userName":"friend",
	"userSex":"女",
	"userPassword":"123",
	"userPhone":"13851567613",
	"userSwaggerId":"friend",
	"userPortrait":"",
	"userBio":null,
	"userCreateTime":null,
	"userModifyTime":null,
	"userLoginInfoId":0,
	"userToken":null
}
```
#### 修改个性签名
- 请求URL：`/swagger/user/bio`
- 请求方式：`PUT`
- 请求参数：
```json
{
	"userId":2,
	"userName":"friend",
	"userSex":"女",
	"userPassword":"123",
	"userPhone":"13851567613",
	"userSwaggerId":"friend",
	"userPortrait":"",
	"userBio":"内部测试",
	"userCreateTime":null,
	"userModifyTime":null,
	"userLoginInfoId":0,
	"userToken":null
}
```
#### 登出
- 请求URL：`/swagger/user/unauth`
- 请求方式：`POST`
- 请求参数：`{"loginId": 1}`
### 头像
#### 上传头像
- 请求URL：`/swagger/user/portrait`
- 请求方式：`POST`
- 请求参数：
```json
{
  "file": "file",
  "filename": "test.png"
}
```
#### 下载头像
- 请求URL：`/swagger/user/portrait/{filename}`
- 请求方式：`GET`
- 请求参数：`filename=test.png`
### 附近的人
#### 获取附近的用户
- 请求URL：`/swagger/nearby/list`
- 请求方式：`GET`
- 请求参数：`lon=-122.08400000000002&lat=37.421998333333335&limit=10000&name=test&sex=男`
### 好友管理
#### 查询好友关系
- 请求URL：`/swagger/friend/filter`
- 请求方式：`GET`
- 请求参数：`mainUserId=1&friendUserId=2`
#### 建立好友关系
- 请求URL：`/swagger/friend/making`
- 请求方式：`POST`
- 请求参数：
```json
{
	"id": 0,
	"mainUserId": 11,
	"friendUserId": 12,
	"remarkName": null,
	"groupName": null,
	"createTime": null,
	"modifyTime": null
}
```
#### 修改好友关系
- 请求URL：`/swagger/friend/modification`
- 请求方式：`PUT`
- 请求参数：
```json
{
	"id": 2,
	"mainUserId": 2,
	"friendUserId": 1,
	"remarkName": "嘿嘿",
	"groupName": "不解释",
	"createTime": null,
	"modifyTime": null
}
```
#### 删除好友
- 请求URL：`/swagger/friend/release`
- 请求方式：`DELETE`
- 请求参数：
```json
{
	"id": 2,
	"mainUserId": 2,
	"friendUserId": 1,
	"remarkName": "嘿嘿",
	"groupName": "不解释",
	"createTime": null,
	"modifyTime": null
}
```
### 好友请求
#### 发布请求
- 请求URL：`/swagger/request`
- 请求方式：`POST`
- 请求参数：
```json
{
	"reqId": 0,
	"reqMainId": 3,
	"reqSubId": 6,
	"reqMsg": "内部测试",
	"reqCode": 0
}
```
#### 查询请求列表
- 请求URL：`/swagger/request/list`
- 请求方式：`GET`
- 请求参数：`mainId=3`
#### 更新请求信息
- 请求URL：`/swagger/request/operation`
- 请求方式：`PUT`
- 请求参数：
```json
{
	"reqId": 2,
	"reqMainId": 3,
	"reqSubId": 4,
	"reqMsg": "内部测试",
	"reqCode": 1
}
```
### Apk
#### Apk上传
- 请求URL：`/swagger/apk`
- 请求方式：`POST`
- 请求参数：
```json
{
    "apk": "file",
    "apkCode": "v1.0.0",
    "apkName": "test.apk",
    "apkDesc": "描述"
}
```
#### 获取最新Apk
- 请求URL：`/swagger/apk/latest`
- 请求方式：`GET`
- 请求参数：无