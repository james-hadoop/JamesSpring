# https configuration:
1. 第一步就是用JDK的keytool工具来创建一个密钥存储（keystore）
`keytool -keystore mykeys.jks -genkey -alias tomcat -keyalg RSA`
记住输入的Enter keystore password（该项目为james），剩下的一路回车，直到：
` Is CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown correct?`
输入yes

2. 把证书添加到项目中
[`src/main/resources/mykeys.jks`]

3. 修改配置文件application.properties，加入如下配置
```
server.port= 8443
server.ssl.key-store= classpath:mykeys.jks
server.ssl.key-store-password= james
server.ssl.key-password= james
```