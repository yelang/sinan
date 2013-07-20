package net.xinjumin.utils

/**
 * DesEncryptTest.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-06 17:51
 */
class DesEncryptTest extends GroovyTestCase {

    String expected

    String encryptPassword

    String decryptPassword

    void testSetEncode() {
        expected = "123456781"
        encryptPassword = DesEncrypt.encode(expected)
        assertFalse(expected == encryptPassword)
    }

    void testEncrypt() {
        expected = "12345678"
        encryptPassword = DesEncrypt.encode(expected)
        decryptPassword = DesEncrypt.decode(encryptPassword)

        assertEquals(expected, decryptPassword)
    }

    void testEncrypt2() {
        expected = "sinan"
        encryptPassword = DesEncrypt.encode(expected)
        decryptPassword = DesEncrypt.decode(encryptPassword)

        assertEquals(expected, decryptPassword)
    }

    void testEncrypt3() {
        expected = "12"
        encryptPassword = DesEncrypt.encode(expected)
        decryptPassword = DesEncrypt.decode(encryptPassword)

        assertEquals(expected, decryptPassword)
    }

    void testEncrypt4() {
        def passsword = ""
        encryptPassword = DesEncrypt.encode(passsword)
        decryptPassword = DesEncrypt.decode(encryptPassword)

        assertNull(decryptPassword)
    }

    void testEncryptNull() {
        expected = null
        encryptPassword = DesEncrypt.encode(expected)
        decryptPassword = DesEncrypt.decode(encryptPassword)

        assertEquals(expected, decryptPassword)
    }
}
