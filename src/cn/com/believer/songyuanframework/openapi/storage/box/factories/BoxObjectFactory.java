/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.factories;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.Box;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFriend;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxSubscription;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxTag;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.UploadResult;

/**
 * @author Jimmy
 * 
 */
public class BoxObjectFactory extends BaseBoxFactory {

    /**
     * create a BoxFile object.
     * 
     * @return BoxFile object.
     */
    public static BoxFile createBoxFile() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxFile");
        return (BoxFile) obj;
    }

    /**
     * create a BoxFolder object.
     * 
     * @return BoxFolder object.
     */
    public static BoxFolder createBoxFolder() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxFolder");
        return (BoxFolder) obj;
    }

    /**
     * create a BoxFriend object.
     * 
     * @return BoxFriend object.
     */
    public static BoxFriend createBoxFriend() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxFriend");
        return (BoxFriend) obj;
    }

    /**
     * create a Box object.
     * 
     * @return Box object.
     */
    public static Box createBox() {
        Object obj = newInstanceOf("box4j.config.objectfactory.Box");
        return (Box) obj;
    }

    /**
     * create a BoxSubscription object.
     * 
     * @return BoxSubscription object.
     */
    public static BoxSubscription createBoxSubscription() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxSubscription");
        return (BoxSubscription) obj;
    }

    /**
     * create a BoxTag object.
     * 
     * @return BoxTag object.
     */
    public static BoxTag createBoxTag() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxTag");
        return (BoxTag) obj;
    }

    /**
     * create a BoxUser object.
     * 
     * @return BoxUser object.
     */
    public static BoxUser createBoxUser() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxUser");
        return (BoxUser) obj;
    }

    /**
     * create a UploadResult object.
     * 
     * @return UploadResult object.
     */
    public static UploadResult createUploadResult() {
        Object obj = newInstanceOf("box4j.config.objectfactory.UploadResult");
        return (UploadResult) obj;
    }

    /**
     * create a BoxAbstractFile object.
     * 
     * @return BoxAbstractFile object.
     */
    public static BoxAbstractFile createBoxAbstractFile() {
        Object obj = newInstanceOf("box4j.config.objectfactory.BoxAbstractFile");
        return (BoxAbstractFile) obj;
    }
}
