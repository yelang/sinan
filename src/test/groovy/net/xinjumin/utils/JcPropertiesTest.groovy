package net.xinjumin.utils

import groovy.sql.GroovyRowResult
import groovy.sql.Sql

/**
 * JcPropertiesTest.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-05 16:39
 */
class JcPropertiesTest extends GroovyTestCase {
    def connectionDef
    def sql
    def static SQL = "SELECT 0 FROM DUAL"

    void setUp() {
        connectionDef = TestConnection.connectionDef
        sql = Sql.newInstance(connectionDef.url, JcProperties.getProperties(connectionDef), connectionDef.driver)
    }

    void testGetProperties() {
        GroovyRowResult row = sql.firstRow(SQL)
        assertNotNull(row[0])
        assertEquals(0, row[0])
    }

    void tearDown() {
        sql.close()
    }
}
