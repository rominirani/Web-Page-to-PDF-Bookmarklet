/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.factories;

import org.apache.log4j.Logger;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.LogoutResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicUnshareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SetDescriptionResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailResponse;

/**
 * @author Jimmy
 * 
 */
public class BoxResponseFactory extends BaseBoxFactory {

    /** log4j object. */
    protected static final Logger LOGGER = Logger
            .getLogger(BoxResponseFactory.class);

    /**
     * create response object.
     * 
     * @return response object
     */
    public static AddToMyBoxResponse createAddToMyBoxResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.AddToMyBoxResponse");
        return (AddToMyBoxResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static AddToTagResponse createAddToTagResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.AddToTagResponse");
        return (AddToTagResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static CreateFolderResponse createCreateFolderResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.CreateFolderResponse");
        return (CreateFolderResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static DeleteResponse createDeleteResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.DeleteResponse");
        return (DeleteResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static DownloadResponse createDownloadResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.DownloadResponse");
        return (DownloadResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static ExportTagsResponse createExportTagsResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.ExportTagsResponse");
        return (ExportTagsResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static GetAccountTreeResponse createGetAccountTreeResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.GetAccountTreeResponse");
        return (GetAccountTreeResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static GetAuthTokenResponse createGetAuthTokenResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.GetAuthTokenResponse");
        return (GetAuthTokenResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static GetFileInfoResponse createGetFileInfoResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.GetFileInfoResponse");
        return (GetFileInfoResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static GetFriendsResponse createGetFriendsResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.GetFriendsResponse");
        return (GetFriendsResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static GetTicketResponse createGetTicketResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.GetTicketResponse");
        return (GetTicketResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static LogoutResponse createLogoutResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.LogoutResponse");
        return (LogoutResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static MoveResponse createMoveResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.MoveResponse");
        return (MoveResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static PrivateShareResponse createPrivateShareResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.PrivateShareResponse");
        return (PrivateShareResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static PublicShareResponse createPublicShareResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.PublicShareResponse");
        return (PublicShareResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static PublicUnshareResponse createPublicUnshareResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.PublicUnshareResponse");
        return (PublicUnshareResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static RegisterNewUserResponse createRegisterNewUserResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.RegisterNewUserResponse");
        return (RegisterNewUserResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static RenameResponse createRenameResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.RenameResponse");
        return (RenameResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static RequestFriendsResponse createRequestFriendsResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.RequestFriendsResponse");
        return (RequestFriendsResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static SetDescriptionResponse createSetDescriptionResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.SetDescriptionResponse");
        return (SetDescriptionResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static UploadResponse createUploadResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.UploadResponse");
        return (UploadResponse) obj;
    }

    /**
     * create response object.
     * 
     * @return response object
     */
    public static VerifyRegistrationEmailResponse createVerifyRegistrationEmailResponse() {
        Object obj = newInstanceOf("box4j.config.responsefactory.VerifyRegistrationEmailResponse");
        return (VerifyRegistrationEmailResponse) obj;
    }

}
