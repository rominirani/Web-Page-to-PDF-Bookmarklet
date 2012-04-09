/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

/**
 * @author jjia
 * 
 */
public class URLUtils {

    /**
     * 
     */
    private static URLCodec iso88591Codec = new URLCodec("ISO-8859-1");

    /**
     * encode a string to url namespace.
     * 
     * @param input
     *            input string
     * @return encoded string
     */
    public static String encodeUrl(String input) {
        String output = null;
        try {
            output = iso88591Codec.encode(input);
        } catch (EncoderException e) {
            // unreachable code because "ISO-8859-1" is a valid encoding.
            e.printStackTrace();
        }
        return output;
    }
}
