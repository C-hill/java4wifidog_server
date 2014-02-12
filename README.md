开发环境：windows,myeclipse,mysql。<br>
说明：本项目基于apfree业务实现。<br>

该项目使用的端口是8080，可以根据使用情况自己修改：<br>
在server.xml文件中找到以下节点，修改port属性即可更改端口号<br>
<Connector port="8080" protocol="HTTP/1.1" 
               connectionTimeout="20000" 
               redirectPort="8443" />

2.wifidog.sql:数据库脚本
使用步骤：
1.修改tomcat server.xml文件配置：<br>
<code>
<Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false"><br>
		<Context path="" docBase="D:\MyWorkSpace\.metadata\.me_tcat\webapps\wifidogServer" debug="0" reloadable="true"/><br>
/Host></code>
docBase为应用的路径，请根据实际情况更改。<br>

2.执行数据库脚本wifidog.sql
反馈问题请加qq群：331230369 ，验证：github