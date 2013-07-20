package net.xinjumin.sinan

import groovy.util.logging.Slf4j
import net.xinjumin.utils.DesEncrypt

/**
 * Batch Data Changing Tools.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2021-06-26 21:16
 */
@Slf4j
class Sinan {

    void runLoader() {
        def xmlfile = "sinan.xml"
        def config = new XmlParser().parse(xmlfile)
        String password
        if (config.datasource.encrypt.text() == "true") {
            password = config.datasource.password.text()
        } else {
            password = DesEncrypt.encode(config.datasource.password.text())
            config.datasource.password[0].value = password
            config.datasource.encrypt[0].value = "true"
            //store to file
            new XmlNodePrinter(new PrintWriter(new FileWriter(xmlfile))).print(config)
        }
        log.info "startup"
        //TODO
    }

    static void main(String[] args) {
        new Sinan().runLoader()
    }
}
