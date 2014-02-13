java4wifidog_server
===================

wifidog认证服务器java实现

开发环境：windows,myeclipse,mysql。<br><br>
说明：本项目基于apfree wifidog业务实现。使用此项目需要刷apfree固件<br><br>

使用步骤：<br>
1.获取apfree固件并刷到合适的路由器上.<br><br>

2.tomcat server.xml文件配置：<br>
\<Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true" xmlValidation="false" xmlNamespaceAware="false"><br>
    \<Context path="" docBase="D:\MyWorkSpace.metadata.me_tcat\webapps\wifidogServer" debug="0" reloadable="true"/><br>
</Host>
docBase为应用的路径，请根据实际情况更改。<br>

该项目使用的端口是8080，可以根据使用情况自己修改,但必须与wifidog中端口配置一致.<br>
在server.xml文件中找到以下节点，修改port属性即可更改端口号:<br>
\<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />  <br><br>

3.执行数据库脚本wifidog.sql。<br><br>

4.调试。<br><br>

反馈问题请加qq群：331230369 ，验证：github
