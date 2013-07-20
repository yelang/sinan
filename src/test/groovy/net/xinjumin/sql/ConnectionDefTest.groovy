package net.xinjumin.sql
/**
 * 测试数据库连接定义.
 *
 * @author <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-06 19:56
 */
class ConnectionDefTest extends GroovyTestCase {
    def connectionDef

    void setUp() {
        connectionDef = new ConnectionDef(
                url: "jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcp)(host=127.0.0.1)(port=1521)))(connect_data=(service_name=orcl)))",
                driver: "oracle.jdbc.driver.OracleDriver",
                user: "ZZRK2004",
                password: "88923678"
        )
    }

    void testGetUrl() {
        assertEquals("jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcp)(host=127.0.0.1)(port=1521)))(connect_data=(service_name=orcl)))", connectionDef.url)
    }

    void testSetUrl() {
        connectionDef.setUrl("ZSL")
        assertEquals("ZSL", connectionDef.url)
    }

    void testGetDriver() {
        assertEquals("oracle.jdbc.driver.OracleDriver", connectionDef.driver)
    }

    void testSetDriver() {
        connectionDef.setDriver("ZSL")
        assertEquals("ZSL", connectionDef.driver)
    }

    void testGetUser() {
        assertEquals("ZZRK2004", connectionDef.user)
    }

    void testSetUser() {
        connectionDef.setUser("ZSL")
        assertEquals("ZSL", connectionDef.user)
    }

    void testGetPassword() {
        assertEquals("88923678", connectionDef.password)
    }

    void testSetPassword() {
        connectionDef.setPassword("ZSL")
        assertEquals("ZSL", connectionDef.password)
    }
}
