# 系统分析组队作业
================================= 
本机用mac os10.11系统，所以我安装的都是mac os的软件，可能软件的布局会和windows的不一样
注：最后附有感想
=================================
详细配置
###
0.环境配置
	配置java，jdk环境
	安装Eclipse Java EE IDE for Web Developers.     Version: Mars.2 Release (4.5.2) （可以eciplse官网下载），并选择java环境路径
	安装mysql服务器并启动（可去mysql的官网下载Server version: 5.7.12 MySQL Community Server (GPL)），配置路径path，配置账号和密码
	下载java连接mysql的驱动jdbc即mysql-connector-java-5.1.38-bin.jar（code文件中额lib下，已经带我，故可跳过）
###
1.导入项目
	打开eciplse， File->Import...->选择General下Archive file选项，然后选择文件包中的xitongfenxi.zip, 完成导入项目到eciplse中
	在菜单栏中Run->run configurations->classpath->user entrys 选择添加外部jar包，然后选择mysql-connector-java-5.1.38-bin.jar（在lib中）
	在mysql的bin路径下，导入我的数据库文件databases.sql， 采用命名为mysql -u[mysql的账户名] -p[mysql的密码] < [databases.sql路径], (确保mysql已加入环境变量path中)
	已经启动mysql服务器
	选择com.zhoutengteng.message下的runServer.java运行，这就是运行服务器，host：127.0.0.1， port:10000，可在config.java文件中修改
	选择com.zhoutengteng.message下的runClient.java运行，这就是客户端， 
###
2.代码说明
	com.zhoutengteng.control
		adminControl.java, 管理员操作所有用户的信息以及其活动的增删改查
		catRecordControl.java 查询一个用户的活动记录，以及向用户推送，热门活动
		contactPeopleControl.java 管理好友，读取好友列表
		editRecordControl.java 编辑一条活动记录
		loginControl.java 登录验证
		registerControl.java 注册
	com.zhoutengteng.model
		CommentModel.java 数据库评论管理，同时也是联系用户和记录的关系表
		RecordModel.java 操作活动记录的增删改查
		UserModel.java 操作用户的增删改查
	com.zhoutengteng.view
		EidtRecord.java 编辑活动记录的视图文件
		LoginView.java 	登录的视图文件
		MaimView.java 个人主页的视图文件
		PeopleDetail.java 好友的主页文件，和MaimView.java文件有些类似
		RecordDetail.java 详细查看一条记录的视图文件
		RegisterView.java 注册界面的视图文件
		RenderForList.java 渲染一个JList控件格式渲染类
		RenderForListListener.java 为一个JList中的每个条目设置，监听函数
		RenderForListModel.java 为一个JList总的每个条目设置内容
	com.zhoutengteng.message
		Config.java 全局配置文件
		IOUtil.java 封装socket和socket中间的输入输出的关闭函数
		MyClient.java 为客户端socket连接服务端的接口类
		MyClientNIOImpl.java 为继承接口MyClient使用非阻塞的tcp连接实现
		MyServer.java 服务器启动的接口文件
		MyServerNIOImpl.java 用非阻塞的方式显示MyServer接口
		MyErrro.java 封装各种错误提示（未完成）
		MyRquest.java 客户端发起的请求封装接口（表示要请求服务端的哪个类的方法的，并返回对应的数据类型）
		MyGenericRequest.java  具体实现接口MyRequest
		MyResponse.java 服务器端返回响应的封装接口
		MyGenericResponse.java 具体实现接口MyResponse
		MyResponseHandler.java 接口
		MyGenericResponseHandler.java 这个实在具体实现接口MyResponse以及接口MyResponseHandler的基础上，进一步对返回的信息，进行方法的处理
		SerializableUtil.java 字符流转对象，对象转字符流，用来客户端和服务端通信
###
3.项目的github地址 https://github.com/zhoutengteng/xitongfenxi
###
4项目说明：
	本实现，未采用任何框架，采用的是纯java lib库，所以迁移很方便
	由于未使用什么spring之类的框架，导致前后端的交互需要自己完成一个类似http协议的socket通信，基本message中就是完成通信的代码，这里就耗费了大量
的时间
	另外大家都知道，java做界面，不如web那种html做界面舒服，可以说我用java写一个界面，web可以写好几个界面，而且web的效果还比java好看，我这里只想
说明一点，做一个好看的java不容易界面，关键java不存在嵌套空间(而web得div是可以嵌套的)，所以有些设计实现不了，导致功能什么的全部收到限制，故没有完成
	虽然类文件好几十个，代码量超过5000行，但是没有足够的时间串起来加上我们前后端协调有问题，接口参数没有想象的那么好，大部分功能，都是隔离的（即有一个
流程框架，但是不能称为完整的功能实现）
###
5感想：
	感想颇多，花了时间，效果还不理想，具体我总结好几点
		
		



