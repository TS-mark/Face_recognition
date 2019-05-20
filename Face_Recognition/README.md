# 基于百度Ai的人脸识别接口程序
-----
### 本项目采用SpringBoot框架，使用人脸识别V3版本，人脸查找暂时仅仅支持在用户组的用户，不支持用户组的修改、添加、删除以及新建用户组的功能
输入输出默认为Json流
-----
## 人脸查找（FaceSearch）
人脸查找功能为输入一个.jpg图片的Url地址（注：此地址为网络Url地址），通过已经建立的人脸库对该人物进行查找并返回相应参数值。
#### 人脸查找的传入传出地址为服务器地址/Face/FaceSear
例如本地配置服务器，服务器地址为localhost:8080/Face/FaceSear
##### 请求输入参数如下：   
key|value
-|-
path|传入的图片Url地址，此地址为网络地址
##### 返回值：
key|value
-|-
group_id|人脸库组名（程序中默认值为TS-Mark）
user_id|人脸库中用户名
user_info|注册人脸库时的用户信息
score|人脸匹配得分值（分值越高代表人脸相似度越高)
warn|警告（当score低于50时会出现提示，否则缺省）
###### 特殊情况，当人脸库中没有完全匹配到用户或者存在其他图片情况时的返回值为：*未匹配到人物，错误信息：error_msg*

-----
## 人脸检测（FaceDetect）
人脸检测功能为输入一个.jpg图片的Url地址（注：此地址为网络Url地址），探测检测人物的相关信息属性。
#### 人脸检测的传入传出地址为服务器地址/Face/FaceDet
例如本地配置服务器，服务器地址为localhost:8080/Face/FaceDet
##### 请求输入参数如下：   
key|value
-|-
path|传入的图片Url地址，此地址为网络地址
##### 返回值：
key|value
-|-
error_code|错误编码（相关错误信息详见[本链接](https://ai.baidu.com/docs#/Face-ErrorCode-V3/top))
error_msg|错误信息
user_info|注册人脸库时的用户信息
result|人脸检测相关信息

##### result返回值如下：
key|value
-|-
face_num|检测到图片中人脸的数量
face_list|人脸信息列表

##### 人脸信息列表以及其他特殊参数参见[百度Ai人脸检测文档](https://ai.baidu.com/docs#/Face-Detect-V3/top)
