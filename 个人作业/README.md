# FeimaSat
Java 飞马星球大作业


### 实现功能
+ 一个主菜单应该向用户提供一个操作选项列表
+	能够根据 ID 封锁或激活卫星 
+	显示当前卫星列表。
+	注册添加新卫星。 
+	可查询每个卫星的详细信息，卫星都有一个id、名称、轨道半径以及可用性。 
+	编辑现有卫星信息。 
+	搜索所有卫星名称，并显示所有匹配卫星的列表。 
+	可以删除卫星
+	可合适的退出应用程序。 
+	程序开始应该至少有5个卫星已经预加载到数组列表中 
+	数组列表的开始大小应该为10。


### 限制条件
1. 最低卫星轨道为1.2
2. 卫星轨道之间的距离不得小于0.2
3. 每一个卫星必须有一个唯一的COSPARID，总长度为6位，由两位国家编码加上四位数字组成
4. 卫星可以有两种状态，一种状态是处于激活可用状态，另一种是处于封锁非激活状态，但卫星任然在固定轨道飞行，只是处于不可用状态。


主菜单应该询问用户想要选择哪个选项并执行该操作。完成后，应将用户带回主菜单。主菜单还应允许用户干净地退出应用程序


### 注意
后进行了改进，加入了文件操作。卫星数据从文件中读入，程序结束后保存到文件中
