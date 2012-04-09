/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box;

import java.io.IOException;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFriendsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.LogoutRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.LogoutResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicUnshareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicUnshareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SetDescriptionRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SetDescriptionResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public interface BoxExternalAPI {

    /**
     * This method is used in the authorization process. You should call this
     * method after the user has authorized themself on box.net site. Pass
     * ticket that you get when called get_ticket method. On a successful
     * result, method will return 'get_auth_token_ok' as status, auth_token to
     * use in other method calls, and user struct which describes logged user.
     * Request.
     * 
     * @param getAuthTokenRequest
     *            request object
     * @return getAuthTokenResponse response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    GetAuthTokenResponse getAuthToken(GetAuthTokenRequest getAuthTokenRequest)
            throws IOException, BoxException;

    /**
     * This method is used in the authorization process.
     * 
     * @param getTicketRequest
     *            request object
     * @return getTicketResponse response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetTicketResponse getTicket(GetTicketRequest getTicketRequest)
            throws IOException, BoxException;

    /**
     * This method is used to logout a user. On successful logout method will
     * return 'logout_ok' as status. If logout wasn't successful, then status
     * filed can be: 'invalid_auth_token' when auth_token is invalid.
     * 
     * @param logoutRequest
     *            request object
     * @return LogoutResponse object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    LogoutResponse logout(LogoutRequest logoutRequest) throws IOException,
            BoxException;

    /**
     * This method is used to register a user. Upon a successful registration,
     * the status param will be 'successful_register'. If registration wasn't
     * successful, status field can be: 'e_register', 'email_invalid',
     * 'email_already_registered', 'application_restricted'.
     * 
     * @param registerNewUserRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    RegisterNewUserResponse registerNewUser(
            RegisterNewUserRequest registerNewUserRequest) throws IOException,
            BoxException;

    /**
     * This method is used to verify user registration email . Upon a not used
     * and right registration email, the status param will be 'email_ok'. Else
     * status field can be: 'email_invalid', 'email_already_registered',
     * 'application_restricted'.
     * 
     * @param verifyRegistrationEmailRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    VerifyRegistrationEmailResponse verifyRegistrationEmail(
            VerifyRegistrationEmailRequest verifyRegistrationEmailRequest)
            throws IOException, BoxException;

    /**
     * This method is used to get a user's files and folders tree.
     * 
     * 'folder_id' param defines root folder from which the tree begins.
     * 'params' is array of string where you can set additional parameters,
     * which are: onelevel - make a tree of one level depth, so you will get
     * only files and folders stored in folder which folder_id you have
     * provided. nofiles - include folders only in result tree, no files. nozip
     * - do not zip tree xml.
     * 
     * On successful result you will receive 'listing_ok' as status and base64
     * encoded zipped tree xml. So you have to decode the received tree, then
     * unzip it (if you haven't set 'nozip' param) and you will get xml like
     * this: (note that updatedand createdare UNIX timestamps in PST).
     * 
     * @param getAccountTreeRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetAccountTreeResponse getAccountTree(
            GetAccountTreeRequest getAccountTreeRequest) throws IOException,
            BoxException;

    /**
     * This method returns all the user's tags.
     * 
     * On successful a result, you will receive 'export_tags_ok' and tag_xml
     * will be base64 encoded tags xml. After decoding tag_xml you will get xml
     * like this:
     * 
     * <?xml version="1.0"?> <tags> <tag id="37"> music </tag> <tag id="38"> mp3
     * </tag> </tags> If the result wasn't successful, status field can be:
     * not_logged_id, application_restricted.
     * 
     * @param exportTagsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    ExportTagsResponse exportTags(ExportTagsRequest exportTagsRequest)
            throws IOException, BoxException;

    /**
     * This method creates a new folder.
     * 
     * 'parent_id' param is the id of a folder in which a new folder will be
     * created, 'name' param is the name of a new folder. Set 'share' to 1 if
     * you want to share a folder publicly.
     * 
     * On a successful result, the status will be 'create_ok'.
     * 
     * If the result wasn't successful, status field can be:
     * 'e_no_parent_folder', 'not_logged_in', 'application_r'stricted'.
     * 
     * @param createFolderRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    CreateFolderResponse createFolder(CreateFolderRequest createFolderRequest)
            throws IOException, BoxException;

    /**
     * This method moves a file or folder to another folder.
     * 
     * 'target' param can be either 'file' or 'folder' depending on what do you
     * want to move, 'target_id' is the id of a file or folder to be moved,
     * 'destination_id' is the destination folder id.
     * 
     * On a successful result, status will be 's_move_node'. If the result
     * wasn't successful, status field can be: 'e_move_node', 'not_logged_in',
     * 'application_restricted'.
     * 
     * @param moveRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    MoveResponse move(MoveRequest moveRequest) throws IOException, BoxException;

    /**
     * This method renames a file or folder.
     * 
     * 'target' param can be either 'file' or 'folder' depending on what you
     * want to rename, 'target_id' is the id of a file or folder to be renamed,
     * 'new_name' is the new name for a file or folder.
     * 
     * On a successful result, status will be 's_rename_node'. If result wasn't
     * successful, stat's field can be: 'e_rename_node', 'not_logged_in',
     * 'application_restricted'.
     * 
     * @param renameRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    RenameResponse rename(RenameRequest renameRequest) throws IOException,
            BoxException;

    /**
     * This method deletes a file or folder.
     * 
     * 'target' param can be either 'file' or 'folder' depending on what you
     * want to delete, 'target_id' is id of a file or folder to be deleted.
     * 
     * On a successful result, the status will be 's_delete_node'. If the result
     * wasn't successful, status field can be: 'e_delete_node', 'not_logged_in',
     * 'application_restricted'.
     * 
     * @param deleteRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    DeleteResponse delete(DeleteRequest deleteRequest) throws IOException,
            BoxException;

    /**
     * This method publicly shares a file or folder. 'target' param should be
     * either 'file' or 'folder', 'target_id' is id of the file or folder to be
     * shared. 'password' param is to protect sharing with a password, 'emails'
     * params is array of emails to notify about a new share, 'message' param is
     * some message to be included in a notification email.
     * 
     * On a successful result, the status will be 'share_ok' and 'public_name'
     * param will be a unique identifier of a publicly shared file or folder. If
     * the result wasn't successful, the status field can be: 'share_error',
     * 'wrong_node', 'not_logged_in', 'application_restricted'.
     * 
     * @param publicShareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PublicShareResponse publicShare(PublicShareRequest publicShareRequest)
            throws IOException, BoxException;

    /**
     * This method unshares a shared file or folder. 'target' param shoud be
     * either 'file' or 'folder', 'target_id' is id of a file or folder to be
     * unshared.
     * 
     * On a successful result, the status will be 'unshare_ok'. If the result
     * wasn't successful, the status field can be: 'unshare_error',
     * 'wrong_node', 'not_logged_in', 'application_restricted'.
     * 
     * @param publicUnshareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PublicUnshareResponse publicUnshare(
            PublicUnshareRequest publicUnshareRequest) throws IOException,
            BoxException;

    /**
     * This method privately shares a file or folder with another user(s).
     * 'target' param should be either 'file' or 'folder', 'target_id' is the id
     * of the file or folder to be shared. 'emails' params is an array of emails
     * of users' to share files with. if 'notify' param is true, then a
     * notification email will be sent to users, 'message' param is a message to
     * be included in the notification email.
     * 
     * Note: currently only files can be shared privately.
     * 
     * On a successful result, the status will be 'private_share_ok'. If the
     * result wasn't successful, the status field can be: 'private_share_error',
     * 'wrong_node', 'not_logged_in', 'application_restricted'.
     * 
     * @param privateShareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PrivateShareResponse privateShare(PrivateShareRequest privateShareRequest)
            throws IOException, BoxException;

    /**
     * This method copies a file publicly shared by someone to a user's mybox.
     * 'file_id' and 'public_name' params identify a publicly shared file, you
     * should provide either file_id or public name (like '31nhke0ahp') as a
     * parameter. 'folder_id' is the id of a user's folder, where files are to
     * be copied.
     * 
     * On a successful result, the status will be 'addtomybox_ok'. If the result
     * wasn't successful, the status field can be: 'addtomybox_error',
     * 'not_logged_id', 'application_restricted', 's_link_exists'.
     * 
     * @param addToMyBoxRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    AddToMyBoxResponse addToMyBox(AddToMyBoxRequest addToMyBoxRequest)
            throws IOException, BoxException;

    /**
     * This method adds file or folder to tags list. 'target' param can be
     * either 'file' or 'folder' depending on what do you want to add,
     * 'target_id' is the id of a file or folder to be added, 'tags' array of
     * tags where target will be added.
     * 
     * On successful a result, you will receive 'addtotag_ok'. If the result
     * wasn't successful, status field can be: addtotag_error.
     * 
     * @param addToTagRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    AddToTagResponse addToTag(AddToTagRequest addToTagRequest)
            throws IOException, BoxException;

    /**
     * This method gets file info. 'file_id' param should contain valid if of
     * user file.
     * 
     * On successful a result, you will receive status 's_get_file_info' and
     * file info in 'info'. If the result wasn't successful, status field can
     * be: e_access_denied.
     * 
     * @param getFileInfoRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetFileInfoResponse getFileInfo(GetFileInfoRequest getFileInfoRequest)
            throws IOException, BoxException;

    /**
     * This method sets a description to a file or folder. 'target' can be a
     * 'file' or 'folder', 'target_id' - id of file or folder, description -
     * string that should be set as description.
     * 
     * On successful a result, you will receive status 's_set_description'. If
     * the result wasn't successful, status field can be: e_set_description.
     * 
     * @param setDescriptionRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    SetDescriptionResponse setDescription(
            SetDescriptionRequest setDescriptionRequest) throws IOException,
            BoxException;

    /**
     * This method is used to retrieve a list of freinds.
     * 
     * 'params' is an array of the string where you can set additional
     * parameters, which are: nozip - do not zip tree xml.
     * 
     * On a successful result you will receive 's_get_friends' as the status and
     * base64 encoded (and zipped) friends xml. Friends xml looks like this:
     * ......
     * 
     * @param getFriendsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetFriendsResponse getFriends(GetFriendsRequest getFriendsRequest)
            throws IOException, BoxException;

    /**
     * This method requests new friends to be added to your network. 'emails' -
     * array of emails. 'message' - text message that you want to send to
     * freinds. 'params' is an array of string where you can set additional
     * parameters, which are: box_auto_subscribe - subscribe to public boxes of
     * inveted users. no_email - don't send emails to invited users.
     * 
     * On a successful result, you will receive status 's_request_friends'. If
     * the result wasn't successful, status field can be: e_request_friends.
     * 
     * @param requestFriendsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    RequestFriendsResponse requestFriends(
            RequestFriendsRequest requestFriendsRequest) throws IOException,
            BoxException;

    /**
     * download a file.
     * 
     * @param downloadRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    DownloadResponse download(DownloadRequest downloadRequest)
            throws IOException, BoxException;

    /**
     * upload files.
     * 
     * @param uploadRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    UploadResponse upload(UploadRequest uploadRequest) throws IOException,
            BoxException;

}
