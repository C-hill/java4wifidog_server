java4wifidog_server
===================

wifidog认证服务器java实现

开发环境：windows,myeclipse,mysql。
说明：本项目基于apfree wifidog业务实现。<br>
1.tomcat server.xml文件配置：<br>
<code><Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true" xmlValidation="false" xmlNamespaceAware="false">
<Context path="" docBase="D:\MyWorkSpace.metadata.me_tcat\webapps\wifidogServer" debug="0" reloadable="true"/>
/Host></code> 
docBase为应用的路径，请根据实际情况更改。<br>

该项目使用的端口是8080，可以根据使用情况自己修改：
在server.xml文件中找到以下节点，修改port属性即可更改端口号
<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" /> hill 2.wifidog.sql:数据库脚本
