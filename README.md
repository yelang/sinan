sinan
===================================

Sinan是什么？
-------------------------
Sinan是用Groovy语言开发的Oracle大数据批量调整客户端工具，主要用于行政区划代码调整，包括但不局限于行政区划、乡镇街道、公安派出所、社区村（居）委会，以及性别、民族、文化程度等代码。

为什么要用Sinan？
-------------------------

其实用一条简单的数据库Update语句或者是写一个存储过程（Procedure），也可以完成数据调整工作；但是用Sinan更加简单、通用一些，适合以下情形：

* 新旧代码存在交叉：如将330326002调整到330316，330316调整到330302；
* 关联到其它字段：如将某条路的单号调整到A区、双号调整到B区；
* 在数据库进行ETL操作时，需要自动地对数据进行批量转换：如电子政务数据整合时，需要将公安以派出所为单位的居委会代码，转换为以乡镇街道为单位的居委会代码。

如何使用Sinan?
-------------------------
### 定义配置文件(sinan.xml)
    <node>
        <datasource>
            <connection_url>
                jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcp)(host=127.0.0.1)(port=1521)))(connect_data=(service_name=orcl)))
            </connection_url>
            <driver_class>oracle.jdbc.driver.OracleDriver</driver_class>
            <user_name>MY_USER</user_name>
            <password>MY_PASSWORD</password>
            <encrypt>false</encrypt>
        </datasource>
        <ruleFile name="rule.xml">
            <table>
            </table>
        </ruleFile>
    </node>
### 定义规则文件(rule.xml)
    <rules>
        <rule oldCode="330302" newCode="330304" match="">
        </rule>
    </rules>


相关项目
-------------------------
1.[Yelang]:  标准代码管理系统（基于SpringMVC和Groovy的Web系统）<br />
2.[Wujiang]: Oracle数据迁移校对工具（Groovy客户端）<br />
3.[Sinan]:   Oracle大数据批量调整工具（Groovy客户端）<br />
