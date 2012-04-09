/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.core.BoxHTTPManager;

/**
 * @author Jimmy
 * 
 */
public class BaseBoxFactory {

    /** log4j object. */
    protected static final Logger LOGGER = Logger
            .getLogger(BaseBoxFactory.class);

    /** box config. */
    private static final Properties CONFIG = BoxHTTPManager.getBoxHTTPManager()
            .getConfig();

    /** fall-safe config. */
    private static Properties defaultConfig;

    /**
     * 
     * @param interfaceKey
     *            interface key
     * @return implement object
     */
    protected static Object newInstanceOf(String interfaceKey) {
        Object obj = null;
        String className = CONFIG.getProperty(interfaceKey);
        try {
            Class clazz = Class.forName(className);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            LOGGER
                    .info("ClassNotFoundException, will use default implementation. (interfaceKey="
                            + interfaceKey + ")");
        } catch (InstantiationException e) {
            LOGGER
                    .info("InstantiationException, will use default implementation. (interfaceKey="
                            + interfaceKey + ")");
        } catch (IllegalAccessException e) {
            LOGGER
                    .info("IllegalAccessException, will use default implementation. (interfaceKey="
                            + interfaceKey + ")");
        }
        if (obj == null) {
            obj = getDefaultImpl(interfaceKey);
        }
        return obj;
    }

    /**
     * @param interfaceKey
     *            interface key
     * @return object
     */
    private static Object getDefaultImpl(String interfaceKey) {
        Object obj = null;
        if (defaultConfig == null) {
            defaultConfig = new Properties();
            InputStream in = BoxHTTPManager.class
                    .getResourceAsStream(BoxConstant.CONFIG_FILE_DEFAULT_NAME);
            try {
                defaultConfig.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String implString = (String) defaultConfig.get(interfaceKey);

        try {
            Class clazz = Class.forName(implString);
            obj = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            LOGGER.error("error!!! ", e);
        } catch (InstantiationException e) {
            LOGGER.error("error!!! ", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("error!!! ", e);
        }
        return obj;
    }
}
