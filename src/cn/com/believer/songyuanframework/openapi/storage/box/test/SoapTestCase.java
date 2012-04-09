/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.test;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.core.BoxHTTPManager;

/**
 * @author Jimmy
 * 
 */
public class SoapTestCase extends BaseBoxTestCase {

    public void setUp() {
        super.setUp();
        BoxHTTPManager.getBoxHTTPManager().getConfig().setProperty(
                BoxConstant.CONFIG_API_REQUEST_FORMAT, "soap");
        this.boxExternalAPI = new SimpleBoxImpl();
    }

    public void tearDown() {
        super.tearDown();
    }

    public void testAll() {
        super.testAll();
    }
}
