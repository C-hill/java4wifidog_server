开发环境：windows,myeclipse,mysql。<br>
1.tomcat server.xml文件配置：<br>
&ltHost name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false">
		&ltContext path="" docBase="D:\MyWorkSpace\.metadata\.me_tcat\webapps\wifidogServer" debug="0" reloadable="true"/&gt
&lt/Host&gt
docBase为应用的路径，请根据实际情况更改。<br>

该项目使用的端口是8080，可以根据使用情况自己修改：<br>
在server.xml文件中找到以下节点，修改port属性即可更改端口号<br>
<Connector port="8080" protocol="HTTP/1.1" 
               connectionTimeout="20000" 
               redirectPort="8443" /&gt

2.wifidog.sql:数据库脚本
