/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author jjia
 * 
 */
public class Box4JTestSuite extends TestCase {

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RestTestCase.class);
        suite.addTestSuite(XMLTestCase.class);
        suite.addTestSuite(SoapTestCase.class);

        return suite;
    }
}
