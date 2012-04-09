/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.constant;

/**
 * @author Jimmy
 * 
 */
public class BoxConstant {

    // config
    /** config file name. */
    public static final String CONFIG_FILE_NAME = "box4j-config.properties";

    /** default config file name. */
    public static final String CONFIG_FILE_DEFAULT_NAME = "box4j-config-default.properties";

    /** config parameter. */
    public static final String CONFIG_HTTPCLIENT_MAXCONNECTIONSPERHOST = 
        "box4j.config.httpclient.MaxConnectionsPerHost";

    /** config parameter. */
    public static final String CONFIG_HTTPCLIENT_MAXTOTALCONNECTIONS = "box4j.config.httpclient.MaxTotalConnections";

    /** config parameter. */
    public static final String CONFIG_HTTPCLIENT_CONNECTIONTIMEOUT = "box4j.config.httpclient.ConnectionTimeout";

    /** config parameter. */
    public static final String CONFIG_HTTPCLIENT_SOCONNECTIONTIMEOUT = "box4j.config.httpclient.SoConnectionTimeout";

    /** config parameter. */
    public static final String CONFIG_HTTPCLIENT_IGNORECOOKIES = "box4j.config.httpclient.IgnoreCookies";

    /** config parameter. */
    public static final String CONFIG_API_URL_PREFIX = "box4j.config.api.url_prefix";

    /** config parameter. */
    public static final String CONFIG_API_UPLOAD_URL_PREFIX = "box4j.config.api.upload_url_prefix";

    /** config parameter. */
    public static final String CONFIG_API_VERSION = "box4j.config.api.version";

    /** config parameter. */
    public static final String CONFIG_API_REQUEST_FORMAT = "box4j.config.api.requestformat";

    /** config parameter. */
    public static final String CONFIG_API_REQUEST_FORMAT_REST = "rest";

    /** config parameter. */
    public static final String CONFIG_API_REQUEST_FORMAT_XML = "xml";

    /** config parameter. */
    public static final String CONFIG_API_REQUEST_FORMAT_SOAP = "soap";

    // characters
    /** special characters. */
    public static final String SLASH_STRING = "/";

    /** special characters. */
    public static final String QUESTION_MARK_STRING = "?";

    /** special characters. */
    public static final String ACTION_EQUALS_STRING = "action=";

    /** special characters. */
    public static final String AND_SIGN_STRING = "&";

    /** special characters. */
    public static final String EQUALS_SIGN_STRING = "=";

    /** special characters. */
    public static final String AUTH_URL_STRING = "auth";

    // action names
    /** action name. */
    public static final String ACTION_NAME_GET_TICKET = "get_ticket";

    /** action name. */
    public static final String ACTION_NAME_GET_AUTH_TOKEN = "get_auth_token";

    /** action name. */
    public static final String ACTION_NAME_LOGOUT = "logout";

    /** action name. */
    public static final String ACTION_NAME_REGISTER_NEW_USER = "register_new_user";

    /** action name. */
    public static final String ACTION_NAME_VERIFY_REGISTRATION_EMAIL = "verify_registration_email";

    /** action name. */
    public static final String ACTION_NAME_GET_ACCOUNT_TREE = "get_account_tree";

    /** action name. */
    public static final String ACTION_NAME_EXPORT_TAGS = "export_tags";

    /** action name. */
    public static final String ACTION_NAME_CREATE_FOLDER = "create_folder";

    /** action name. */
    public static final String ACTION_NAME_MOVE = "move";

    /** action name. */
    public static final String ACTION_NAME_RENAME = "rename";

    /** action name. */
    public static final String ACTION_NAME_DELETE = "delete";

    /** action name. */
    public static final String ACTION_NAME_PUBLIC_SHARE = "public_share";

    /** action name. */
    public static final String ACTION_NAME_PUBLIC_UNSHARE = "public_unshare";

    /** action name. */
    public static final String ACTION_NAME_PRIVATE_SHARE = "private_share";

    /** action name. */
    public static final String ACTION_NAME_ADD_TO_MYBOX = "add_to_mybox";

    /** action name. */
    public static final String ACTION_NAME_ADD_TO_TAG = "add_to_tag";

    /** action name. */
    public static final String ACTION_NAME_GET_FILE_INFO = "get_file_info";

    /** action name. */
    public static final String ACTION_NAME_SET_DESCRIPTION = "set_description";

    /** action name. */
    public static final String ACTION_NAME_GET_FRIENDS = "get_friends";

    /** action name. */
    public static final String ACTION_NAME_REQUEST_FRIENDS = "request_friends";

    /** action name. */
    public static final String ACTION_NAME_DOWNLOAD = "download";

    /** action name. */
    public static final String ACTION_NAME_UPLOAD = "upload";

    // param names
    /** parameter name. */
    public static final String PARAM_NAME_API_KEY = "api_key";

    /** parameter name. */
    public static final String PARAM_NAME_AUTH_TOKEN = "auth_token";

    /** parameter name. */
    public static final String PARAM_NAME_RESPONSE = "response";

    /** parameter name. */
    public static final String PARAM_NAME_REQUEST = "request";

    /** parameter name. */
    public static final String PARAM_NAME_STATUS = "status";

    /** parameter name. */
    public static final String PARAM_NAME_FILES = "files";

    /** parameter name. */
    public static final String PARAM_NAME_TICKET = "ticket";

    /** parameter name. */
    public static final String PARAM_NAME_USER = "user";

    /** parameter name. */
    public static final String PARAM_NAME_LOGIN = "login";

    /** parameter name. */
    public static final String PARAM_NAME_PASSWORD = "password";

    /** parameter name. */
    public static final String PARAM_NAME_EMAIL = "email";

    /** parameter name. */
    public static final String PARAM_NAME_EMAILS = "emails";

    /** parameter name. */
    public static final String PARAM_NAME_ACCESS_ID = "access_id";

    /** parameter name. */
    public static final String PARAM_NAME_USER_ID = "user_id";

    /** parameter name. */
    public static final String PARAM_NAME_SPACE_AMOUNT = "space_amount";

    /** parameter name. */
    public static final String PARAM_NAME_SPACE_USED = "space_used";

    /** parameter name. */
    public static final String PARAM_NAME_FOLDER_ID = "folder_id";

    /** parameter name. */
    public static final String PARAM_NAME_FILE_ID = "file_id";

    /** parameter name. */
    public static final String PARAM_NAME_FILE_NAME = "file_name";

    /** parameter name. */
    public static final String PARAM_NAME_FOLDER_NAME = "folder_name";

    /** parameter name. */
    public static final String PARAM_NAME_FOLDER_TYPE_ID = "folder_type_id";

    /** parameter name. */
    public static final String PARAM_NAME_PARENT_FOLDER_ID = "parent_folder_id";

    /** parameter name. */
    public static final String PARAM_NAME_PARAMS = "params";

    /** parameter name. */
    public static final String PARAM_NAME_PARAMS_PARAMS = "params[]";

    /** parameter name. */
    public static final String PARAM_NAME_PARAMS_EMAILS = "emails[]";

    /** parameter name. */
    public static final String PARAM_NAME_TREE = "tree";

    /** parameter name. */
    public static final String PARAM_NAME_TAG_XML = "tag_xml";

    /** parameter name. */
    public static final String PARAM_NAME_TAGS = "tags";

    /** parameter name. */
    public static final String PARAM_NAME_PARAMS_TAGS = "tags[]";

    /** parameter name. */
    public static final String PARAM_NAME_PARENT_ID = "parent_id";

    /** parameter name. */
    public static final String PARAM_NAME_NAME = "name";

    /** parameter name. */
    public static final String PARAM_NAME_SHARE = "share";

    /** parameter name. */
    public static final String PARAM_NAME_SHARED = "shared";

    /** parameter name. */
    public static final String PARAM_NAME_SHARED_NAME = "shared_name";

    /** parameter name. */
    public static final String PARAM_NAME_FOLDER = "folder";

    /** parameter name. */
    public static final String PARAM_NAME_PATH = "path";

    /** parameter name. */
    public static final String PARAM_NAME_DESCRIPTION = "description";

    /** parameter name. */
    public static final String PARAM_NAME_PUBLIC_NAME = "public_name";

    /** parameter name. */
    public static final String PARAM_NAME_SHOW_COMMENTS = "show_comments";

    /** parameter name. */
    public static final String PARAM_NAME_TARGET = "target";

    /** parameter name. */
    public static final String PARAM_NAME_TARGET_ID = "target_id";

    /** parameter name. */
    public static final String PARAM_NAME_DESTINATION_ID = "destination_id";

    /** parameter name. */
    public static final String PARAM_NAME_NEW_NAME = "new_name";

    /** parameter name. */
    public static final String PARAM_NAME_MESSAGE = "message";

    /** parameter name. */
    public static final String PARAM_NAME_NOTIFY = "notify";

    /** parameter name. */
    public static final String PARAM_NAME_INFO = "info";

    /** parameter name. */
    public static final String PARAM_NAME_SIZE = "size";

    /** parameter name. */
    public static final String PARAM_NAME_SHA1 = "sha1";

    /** parameter name. */
    public static final String PARAM_NAME_CREATED = "created";

    /** parameter name. */
    public static final String PARAM_NAME_UPDATED = "updated";

    /** parameter name. */
    public static final String PARAM_NAME_FRIENDS = "friends";

    /** parameter name. */
    public static final String PARAM_NAME_ACTION = "action";

    /** parameter name. */
    public static final String PARAM_NAME_ITEM = "item";

    /** parameter name. */
    public static final String PARAM_NAME_SOAP_ENVELOPE = "soap:Envelope";

    /** parameter name. */
    public static final String PARAM_NAME_SOAP_BODY = "soap:Body";

    // soap use
    /** soap element. */
    public static final String SOAP_TYPE_STRING = "xsd:string";

    // status string
    /** status code. */
    public static final String STATUS_GET_TICKET_OK = "get_ticket_ok";

    /** status code. */
    public static final String STATUS_APPLICATION_RESTRICTED = "application_restricted";

    /** status code. */
    public static final String STATUS_GET_AUTH_TOKEN_OK = "get_auth_token_ok";

    /** status code. */
    public static final String STATUS_GET_AUTH_TOKEN_ERROR = "get_auth_token_error";

    /** status code. */
    public static final String STATUS_NOT_LOGGED_IN = "not_logged_in";

    /** status code. */
    public static final String STATUS_LOGOUT_OK = "logout_ok";

    /** status code. */
    public static final String STATUS_SUCCESSFUL_REGISTER = "successful_register";

    /** status code. */
    public static final String STATUS_E_REGISTER = "e_register";

    /** status code. */
    public static final String STATUS_E_NO_PARENT_FOLDER = "e_no_parent_folder";

    /** status code. */
    public static final String STATUS_E_FOLDER_ID = "e_folder_id";

    /** status code. */
    public static final String STATUS_E_FILE_ID = "e_file_id";

    /** status code. */
    public static final String STATUS_E_ACCESS_DENIED = "e_access_denied";

    /** status code. */
    public static final String STATUS_WRONG_NODE = "wrong_node";

    /** status code. */
    public static final String STATUS_E_SET_DESCRIPTION = "e_set_description";

    /** status code. */
    public static final String STATUS_EMAIL_OK = "email_ok";

    /** status code. */
    public static final String STATUS_EMAIL_INVALID = "email_invalid";

    /** status code. */
    public static final String STATUS_EMAIL_ALREADY_REGISTERED = "email_already_registered";

    /** status code. */
    public static final String STATUS_LISTING_OK = "listing_ok";

    /** status code. */
    public static final String STATUS_EXPORT_TAGS_OK = "export_tags_ok";

    /** status code. */
    public static final String STATUS_CREATE_OK = "create_ok";

    /** status code. */
    public static final String STATUS_S_FOLDER_EXISTS = "s_folder_exists";

    /** status code. */
    public static final String STATUS_S_MOVE_NODE = "s_move_node";

    /** status code. */
    public static final String STATUS_S_RENAME_NODE = "s_rename_node";

    /** status code. */
    public static final String STATUS_S_DELETE_NODE = "s_delete_node";

    /** status code. */
    public static final String STATUS_SHARE_OK = "share_ok";

    /** status code. */
    public static final String STATUS_UNSHARE_OK = "unshare_ok";

    /** status code. */
    public static final String STATUS_PRIVATE_SHARE_OK = "private_share_ok";

    /** status code. */
    public static final String STATUS_ADD_TO_MY_BOX_OK = "addtomybox_ok";

    /** status code. */
    public static final String STATUS_ADD_TO_MY_BOX_ERROR = "addtomybox_error";

    /** status code. */
    public static final String STATUS_ADD_TO_TAG_OK = "addtotag_ok";

    /** status code. */
    public static final String STATUS_S_GET_FILE_INFO = "s_get_file_info";

    /** status code. */
    public static final String STATUS_S_SET_DESCRIPTION = "s_set_description";

    /** status code. */
    public static final String STATUS_S_GET_FRIENDS = "s_get_friends";

    /** status code. */
    public static final String STATUS_S_REQUEST_FRIENDS = "s_request_friends";

    /** status code. */
    public static final String STATUS_UPLOAD_OK = "upload_ok";

    // request factory interface key
    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_ADD_TO_MY_BOX_REQUEST = 
        "box4j.config.requestfactory.AddToMyBoxRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_ADD_TO_TAG_REQUEST = "box4j.config.requestfactory.AddToTagRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_CREATE_FOLDER_REQUEST = 
        "box4j.config.requestfactory.CreateFolderRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_DELETE_REQUEST = "box4j.config.requestfactory.DeleteRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_DOWNLOAD_REQUEST = "box4j.config.requestfactory.DownloadRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_EXPORT_TAGS_REQUEST = 
        "box4j.config.requestfactory.ExportTagsRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_GET_ACCOUNT_TREE_REQUEST = 
        "box4j.config.requestfactory.GetAccountTreeRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_GET_AUTH_TOKEN_REQUEST = 
        "box4j.config.requestfactory.GetAuthTokenRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_GET_FILE_INFO_REQUEST = 
        "box4j.config.requestfactory.GetFileInfoRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_GET_FRIENDS_REQUEST = 
        "box4j.config.requestfactory.GetFriendsRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_GET_TICKET_REQUEST = "box4j.config.requestfactory.GetTicketRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_LOGOUT_REQUEST = "box4j.config.requestfactory.LogoutRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_MOVE_REQUEST = "box4j.config.requestfactory.MoveRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_PRIVATE_SHARE_REQUEST = 
        "box4j.config.requestfactory.PrivateShareRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_PUBLIC_SHARE_REQUEST = 
        "box4j.config.requestfactory.PublicShareRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_PUBLIC_UNSHARE_REQUEST = 
        "box4j.config.requestfactory.PublicUnshareRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_REGISTER_NEW_USER_REQUEST = 
        "box4j.config.requestfactory.RegisterNewUserRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_RENAME_REQUEST = "box4j.config.requestfactory.RenameRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_REQUEST_FRIENDS_REQUEST = 
        "box4j.config.requestfactory.RequestFriendsRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_SET_DESCRIPTION_REQUEST = 
        "box4j.config.requestfactory.SetDescriptionRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_UPLOAD_REQUEST = "box4j.config.requestfactory.UploadRequest";

    /** request factory key. */
    public static final String REQUEST_FACTORY_KEY_VERIFY_REGISTRATION_EMAIL_REQUEST = 
        "box4j.config.requestfactory.VerifyRegistrationEmailRequest";

    // response factory interface key
    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_ADD_TO_MY_BOX_RESPONSE = 
        "box4j.config.responsefactory.AddToMyBoxResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_ADD_TO_TAG_RESPONSE = 
        "box4j.config.responsefactory.AddToTagResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_CREATE_FOLDER_RESPONSE = 
        "box4j.config.responsefactory.CreateFolderResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_DELETE_RESPONSE = "box4j.config.responsefactory.DeleteResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_DOWNLOAD_RESPONSE = "box4j.config.responsefactory.DownloadResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_EXPORT_TAGS_RESPONSE = 
        "box4j.config.responsefactory.ExportTagsResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_GET_ACCOUNT_TREE_RESPONSE = 
        "box4j.config.responsefactory.GetAccountTreeResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_GET_AUTH_TOKEN_RESPONSE = 
        "box4j.config.responsefactory.GetAuthTokenResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_GET_FILE_INFO_RESPONSE = 
        "box4j.config.responsefactory.GetFileInfoResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_GET_FRIENDS_RESPONSE = 
        "box4j.config.responsefactory.GetFriendsResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_GET_TICKET_RESPONSE = 
        "box4j.config.responsefactory.GetTicketResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_LOGOUT_RESPONSE = "box4j.config.responsefactory.LogoutResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_MOVE_RESPONSE = "box4j.config.responsefactory.MoveResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_PRIVATE_SHARE_RESPONSE = 
        "box4j.config.responsefactory.PrivateShareResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_PUBLIC_SHARE_RESPONSE = 
        "box4j.config.responsefactory.PublicShareResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_PUBLIC_UNSHARE_RESPONSE = 
        "box4j.config.responsefactory.PublicUnshareResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_REGISTER_NEW_USER_RESPONSE = 
        "box4j.config.responsefactory.RegisterNewUserResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_RENAME_RESPONSE = "box4j.config.responsefactory.RenameResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_REQUEST_FRIENDS_RESPONSE = 
        "box4j.config.responsefactory.RequestFriendsResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_SET_DESCRIPTION_RESPONSE = 
        "box4j.config.responsefactory.SetDescriptionResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_UPLOAD_RESPONSE = "box4j.config.responsefactory.UploadResponse";

    /** response factory key. */
    public static final String RESPONSE_FACTORY_KEY_VERIFY_REGISTRATION_EMAIL_RESPONSE = 
        "box4j.config.responsefactory.VerifyRegistrationEmailResponse";
}
