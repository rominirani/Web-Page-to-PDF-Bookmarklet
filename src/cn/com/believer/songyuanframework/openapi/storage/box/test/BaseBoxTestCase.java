/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
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
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.core.BoxHTTPManager;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import junit.framework.TestCase;

/**
 * @author jjia
 * 
 */
public class BaseBoxTestCase extends TestCase {

    /** the api key. */
    private String apiKey;
    private String incorrectApiKey;
    private String incorrectEmail;
    private String usedEmail;
    private String correctEmail;
    private String loginPassword;
    private String incorrectPassword;
    private String incorrectAuthToken;
    private String incorrectId;
    private String specialCharName;
    private String firstFolderName;
    private String subFolder1Name;
    private String subFolder2Name;
    private String newCreatedFileName;
    private String rootFile1Name;
    private String rootFile2Name;
    // private String subFile1Name;
    // private String subFile2Name;
    private String newCreatedFileContent;
    private String fileDesc;
    private String folderDesc;
    private String[] normalTags;
    private String[] specialCharTags;

    protected BoxExternalAPI boxExternalAPI = new SimpleBoxImpl();

    public void setUp() {
        System.out.println("setUp()");
        apiKey = "e7ak8t2je0rxoq97k9sl2fh2mld1dn6x";
        incorrectApiKey = "e7ak8t2je0rxoq97k9sl2fh2mld1dn6x"
                + System.currentTimeMillis();
        incorrectEmail = "absdr.com@s";
        usedEmail = "paranoid945@gmail.com";
        correctEmail = "temp_test_use_for_box4j_Please_Delete_It_"
                + System.currentTimeMillis() + "@test.com";
        loginPassword = "888888";
        correctEmail = "temp_test_use_for_box4j_Please_Delete_It_"
                + System.currentTimeMillis() + "@test.com";
        loginPassword = "888888";
        incorrectPassword = "888888" + System.currentTimeMillis();
        incorrectAuthToken = "XXXXXXXXXXXXXXXXXXX";
        incorrectId = String.valueOf(Long.parseLong("911")
                + System.currentTimeMillis());
        firstFolderName = "Folder_Name" + System.currentTimeMillis();
        subFolder1Name = firstFolderName + "1";
        subFolder2Name = firstFolderName + "2";
        newCreatedFileName = "File_Name" + System.currentTimeMillis();
        rootFile1Name = newCreatedFileName + "1";
        rootFile2Name = newCreatedFileName + "2";
        // subFile1Name = newCreatedFileName + "3";
        // subFile2Name = newCreatedFileName + "4";
        newCreatedFileContent = "File_Content" + System.currentTimeMillis();
        fileDesc = "File_Description" + System.currentTimeMillis();
        folderDesc = "Folder_Description" + System.currentTimeMillis();
        normalTags = new String[3];
        normalTags[0] = "tag1";
        normalTags[1] = "tag 2";
        normalTags[2] = "tag  3";
        specialCharTags = new String[2];
        specialCharTags[0] = "tag!@#$%^~&*()_+<>{}[]'\";";
        specialCharTags[1] = "tag2";
        specialCharName = "name!@#$%^~&*()_+<>{}[]'\";";
    }

    public void tearDown() {
        System.out.println("tearDown()");
    }

    public void testAll() {
        try {
            String firstFolderId = "";
            // String subFolder1Id = "";
            // String subFolder2Id = "";
            String rootFile1Id = "";
            String rootFile2Id = "";
            // String subFile1Id = "";
            // String subFile2Id = "";

            /** get_ticket */
            GetTicketResponse getTicketResponse;
            GetTicketRequest getTicketRequest;

            // incorrect API key
            getTicketRequest = BoxRequestFactory
                    .createGetTicketRequest(incorrectApiKey);
            getTicketResponse = boxExternalAPI.getTicket(getTicketRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    getTicketResponse.getStatus());

            // correct API key
            getTicketRequest = BoxRequestFactory.createGetTicketRequest(apiKey);
            getTicketResponse = boxExternalAPI.getTicket(getTicketRequest);
            assertEquals(BoxConstant.STATUS_GET_TICKET_OK, getTicketResponse
                    .getStatus());
            assertNotNull(getTicketResponse.getTicket());

            /** verify_registration_email */
            VerifyRegistrationEmailResponse verifyEmailResponse;
            VerifyRegistrationEmailRequest verifyEmailRequest;

            // check wrong API key
            verifyEmailRequest = BoxRequestFactory
                    .createVerifyRegistrationEmailRequest(incorrectApiKey,
                            correctEmail);
            verifyEmailResponse = boxExternalAPI
                    .verifyRegistrationEmail(verifyEmailRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    verifyEmailResponse.getStatus());

            // check wrong email format
            verifyEmailRequest = BoxRequestFactory
                    .createVerifyRegistrationEmailRequest(apiKey,
                            incorrectEmail);
            verifyEmailResponse = boxExternalAPI
                    .verifyRegistrationEmail(verifyEmailRequest);
            assertEquals(BoxConstant.STATUS_EMAIL_INVALID, verifyEmailResponse
                    .getStatus());

            // check already registered email
            verifyEmailRequest = BoxRequestFactory
                    .createVerifyRegistrationEmailRequest(apiKey, usedEmail);
            verifyEmailResponse = boxExternalAPI
                    .verifyRegistrationEmail(verifyEmailRequest);
            assertEquals(BoxConstant.STATUS_EMAIL_ALREADY_REGISTERED,
                    verifyEmailResponse.getStatus());

            // check success
            verifyEmailRequest = BoxRequestFactory
                    .createVerifyRegistrationEmailRequest(apiKey, correctEmail);
            verifyEmailResponse = boxExternalAPI
                    .verifyRegistrationEmail(verifyEmailRequest);
            assertEquals(BoxConstant.STATUS_EMAIL_OK, verifyEmailResponse
                    .getStatus());

            /** register_new_user */
            RegisterNewUserResponse registerNewUserResponse;
            RegisterNewUserRequest registerNewUserRequest;

            // check wrong API key
            registerNewUserRequest = BoxRequestFactory
                    .createRegisterNewUserRequest(incorrectApiKey,
                            correctEmail, loginPassword);
            registerNewUserResponse = boxExternalAPI
                    .registerNewUser(registerNewUserRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    registerNewUserResponse.getStatus());

            // wrong email format
            registerNewUserRequest = BoxRequestFactory
                    .createRegisterNewUserRequest(apiKey, incorrectEmail,
                            loginPassword);
            registerNewUserResponse = boxExternalAPI
                    .registerNewUser(registerNewUserRequest);
            assertEquals(BoxConstant.STATUS_EMAIL_INVALID,
                    registerNewUserResponse.getStatus());

            // registered email
            registerNewUserRequest = BoxRequestFactory
                    .createRegisterNewUserRequest(apiKey, usedEmail,
                            loginPassword);
            registerNewUserResponse = boxExternalAPI
                    .registerNewUser(registerNewUserRequest);
            assertEquals(BoxConstant.STATUS_EMAIL_ALREADY_REGISTERED,
                    registerNewUserResponse.getStatus());

            // register successfully
            registerNewUserRequest = BoxRequestFactory
                    .createRegisterNewUserRequest(apiKey, correctEmail,
                            loginPassword);
            registerNewUserResponse = boxExternalAPI
                    .registerNewUser(registerNewUserRequest);
            assertEquals(BoxConstant.STATUS_SUCCESSFUL_REGISTER,
                    registerNewUserResponse.getStatus());
            assertEquals(registerNewUserResponse.getUser().getEmail(),
                    correctEmail);

            /** authentication(login) */
            GetAuthTokenResponse getAuthTokenResponse;

            // wrong API key
            getAuthTokenResponse = simAuthentication(correctEmail,
                    loginPassword, incorrectApiKey);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    getAuthTokenResponse.getStatus());

            // wrong email format
            getAuthTokenResponse = simAuthentication(
                    incorrectEmail, loginPassword, apiKey);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, getAuthTokenResponse
                    .getStatus());

            // wrong password
            getAuthTokenResponse = simAuthentication(correctEmail,
                    incorrectPassword, apiKey);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, getAuthTokenResponse
                    .getStatus());

            // login OK
            getAuthTokenResponse = simAuthentication(correctEmail,
                    loginPassword, apiKey);
            assertEquals(BoxConstant.STATUS_GET_AUTH_TOKEN_OK,
                    getAuthTokenResponse.getStatus());
            assertNotNull(getAuthTokenResponse.getUser());
            assertEquals(correctEmail, getAuthTokenResponse.getUser()
                    .getEmail());
            String authToken = getAuthTokenResponse.getAuthToken();

            /** add to my box. */
            AddToMyBoxRequest addToMyBoxRequest;
            AddToMyBoxResponse addToMyBoxResponse;

            // wrong API key
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    incorrectApiKey, authToken, "f_135700509", "3qk29e88pf",
                    "0", normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    addToMyBoxResponse.getStatus());

            // wrong auth token
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, incorrectAuthToken, "f_135700509", "3qk29e88pf",
                    "0", normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, addToMyBoxResponse
                    .getStatus());

            // wrong file id
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, authToken, "f_135700509"
                            + System.currentTimeMillis(), "3qk29e88pf", "0",
                    normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
             assertEquals(BoxConstant.STATUS_ADD_TO_MY_BOX_ERROR, addToMyBoxResponse
             .getStatus());

            // wrong public name
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, authToken, "f_135700509", "3qk29e88pf"
                            + System.currentTimeMillis(), "0", normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
             assertEquals(BoxConstant.STATUS_ADD_TO_MY_BOX_ERROR, addToMyBoxResponse
             .getStatus());

            // wrong folder id
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, authToken, "f_135700509", "3qk29e88pf",
                    incorrectId, normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
             assertEquals(BoxConstant.STATUS_ADD_TO_MY_BOX_ERROR, addToMyBoxResponse
             .getStatus());

            // special character tags
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, authToken, "f_135700509", "3qk29e88pf", "0",
                    specialCharTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
             assertEquals(BoxConstant.STATUS_ADD_TO_MY_BOX_ERROR, addToMyBoxResponse
             .getStatus());

            // success add to my box
            addToMyBoxRequest = BoxRequestFactory.createAddToMyBoxRequest(
                    apiKey, authToken, "f_135700509", "3qk29e88pf", "0",
                    normalTags);
            addToMyBoxResponse = boxExternalAPI.addToMyBox(addToMyBoxRequest);
            // TODO bugs? not working at all
//            assertEquals(BoxConstant.STATUS_ADD_TO_MY_BOX_OK,
//                    addToMyBoxResponse.getStatus());

            /** request_friends */
            RequestFriendsResponse requestFriendsResponse;
            RequestFriendsRequest requestFriendsRequest;
            String[] emails = { correctEmail, usedEmail, incorrectEmail };
            String[] params = { "box_auto_subscribe", "no_email" };

            // wrong API key
            requestFriendsRequest = BoxRequestFactory
                    .createRequestFriendsRequest(incorrectApiKey, authToken,
                            emails, "welcome", params);
            requestFriendsResponse = boxExternalAPI
                    .requestFriends(requestFriendsRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    requestFriendsResponse.getStatus());

            // wrong auth token
            requestFriendsRequest = BoxRequestFactory
                    .createRequestFriendsRequest(apiKey, incorrectAuthToken,
                            emails, "welcome", params);
            requestFriendsResponse = boxExternalAPI
                    .requestFriends(requestFriendsRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN,
                    requestFriendsResponse.getStatus());

            // wrong email format is ignored by box.net
            requestFriendsRequest = BoxRequestFactory
                    .createRequestFriendsRequest(apiKey, authToken, emails,
                            "welcome!", params);
            requestFriendsResponse = boxExternalAPI
                    .requestFriends(requestFriendsRequest);
            assertEquals(BoxConstant.STATUS_S_REQUEST_FRIENDS,
                    requestFriendsResponse.getStatus());

            /** get_friends */
            GetFriendsResponse getFriendsResponse;
            GetFriendsRequest getFriendsRequest;

            // wrong API key
            getFriendsRequest = BoxRequestFactory.createGetFriendsRequest(
                    incorrectApiKey, authToken, null);
            getFriendsResponse = boxExternalAPI.getFriends(getFriendsRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    getFriendsResponse.getStatus());

            // wrong auth token
            getFriendsRequest = BoxRequestFactory.createGetFriendsRequest(
                    apiKey, incorrectAuthToken, null);
            getFriendsResponse = boxExternalAPI.getFriends(getFriendsRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, getFriendsResponse
                    .getStatus());

            // normal condition, no zip
            String[] fparams = { "nozip" };
            getFriendsRequest = BoxRequestFactory.createGetFriendsRequest(
                    apiKey, authToken, fparams);
            getFriendsResponse = boxExternalAPI.getFriends(getFriendsRequest);
            assertEquals(BoxConstant.STATUS_S_GET_FRIENDS, getFriendsResponse
                    .getStatus());
            assertNull(getFriendsResponse.getEncodedFriends());
            assertTrue(getFriendsResponse.getFriendList().size() > 0);

            // TODO, it's a bug, return nothing from server.
            // normal condition, zip with base64 encoded string
//             getFriendsRequest = BoxRequestFactory.createGetFriendsRequest(
//             apiKey, authToken, null);
//             getFriendsResponse =
//             boxExternalAPI.getFriends(getFriendsRequest);
//             assertEquals(BoxConstant.STATUS_S_GET_FRIENDS, getFriendsResponse
//             .getStatus());
//             assertNotNull(getFriendsResponse.getEncodedFriends());
//             assertTrue(getFriendsResponse.getEncodedFriends().length() > 0);

            /** create a folder */
            CreateFolderResponse createFolderResponse;
            CreateFolderRequest createFolderRequest;

            // wrong api key
            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    incorrectApiKey, authToken, "0", firstFolderName, true);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    createFolderResponse.getStatus());

            // wrong auth token
            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    apiKey, incorrectAuthToken, "0", firstFolderName, true);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, createFolderResponse
                    .getStatus());

            // parent folder id not exist
            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    apiKey, authToken, incorrectId, firstFolderName, true);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            assertEquals(BoxConstant.STATUS_E_NO_PARENT_FOLDER,
                    createFolderResponse.getStatus());

            // special character folder name
//            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
//                    apiKey, authToken, "0", specialCharName, true);
//            createFolderResponse = boxExternalAPI
//                    .createFolder(createFolderRequest);
//            assertEquals(specialCharName, createFolderResponse.getFolder()
//                    .getFolderName());

            // normal create folder
            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    apiKey, authToken, "0", firstFolderName, true);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            assertEquals(BoxConstant.STATUS_CREATE_OK, createFolderResponse
                    .getStatus());
            assertEquals(firstFolderName, createFolderResponse.getFolder()
                    .getFolderName());
            assertEquals("1", createFolderResponse.getFolder().getShared());
            firstFolderId = createFolderResponse.getFolder().getFolderId();

            // create another 2 folders in created folder
            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    apiKey, authToken, firstFolderId, subFolder1Name, false);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            // subFolder1Id = createFolderResponse.getFolder().getFolderId();
            assertEquals(BoxConstant.STATUS_CREATE_OK, createFolderResponse
                    .getStatus());
            assertEquals(subFolder1Name, createFolderResponse.getFolder()
                    .getFolderName());
            assertEquals("0", createFolderResponse.getFolder().getShared());

            createFolderRequest = BoxRequestFactory.createCreateFolderRequest(
                    apiKey, authToken, firstFolderId, subFolder2Name, false);
            createFolderResponse = boxExternalAPI
                    .createFolder(createFolderRequest);
            // subFolder2Id = createFolderResponse.getFolder().getFolderId();
            assertEquals(BoxConstant.STATUS_CREATE_OK, createFolderResponse
                    .getStatus());
            assertEquals(subFolder2Name, createFolderResponse.getFolder()
                    .getFolderName());
            assertEquals("0", createFolderResponse.getFolder().getShared());

            /** upload */

            // upload multiple bytes arrays
            UploadResponse uploadResponse;
            UploadRequest uploadRequest;
            
            // upload special character file name
            HashMap nameByteHashMapSpecialChar = new HashMap();
            nameByteHashMapSpecialChar.put(specialCharName, (newCreatedFileContent + "1")
                    .getBytes());
            uploadRequest = BoxRequestFactory.createUploadRequest(authToken,
                    false, "0", nameByteHashMapSpecialChar);
            uploadResponse = boxExternalAPI.upload(uploadRequest);
            
            HashMap nameByteHashMap = new HashMap();
            nameByteHashMap.put(rootFile1Name, (newCreatedFileContent + "1")
                    .getBytes());
            nameByteHashMap.put(rootFile2Name, (newCreatedFileContent + "2")
                    .getBytes());
            uploadRequest = BoxRequestFactory.createUploadRequest(authToken,
                    false, "0", nameByteHashMap);
            uploadResponse = boxExternalAPI.upload(uploadRequest);
            assertTrue(uploadResponse.getUploadResultList().size() == 2);

            // upload multiple files

            Map fileMap = new HashMap();
            File tmpFile = File
                    .createTempFile(newCreatedFileName + "3", ".txt");
            String subFile1Name = tmpFile.getName();
            tmpFile.deleteOnExit();
            fileMap.put(subFile1Name, tmpFile);
            tmpFile = File.createTempFile(newCreatedFileName + "4", ".txt");
            String subFile2Name = tmpFile.getName();
            tmpFile.deleteOnExit();
            fileMap.put(subFile2Name, tmpFile);
            uploadRequest = BoxRequestFactory.createUploadRequest(authToken,
                    true, firstFolderId, fileMap);
            uploadResponse = boxExternalAPI.upload(uploadRequest);
            assertTrue(uploadResponse.getUploadResultList().size() == 2);

            /** get account tree. by the way check the create file & folder. */
            GetAccountTreeResponse getAccountTreeResponse;
            GetAccountTreeRequest getAccountTreeRequest;

            // wrong api key
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(incorrectApiKey, authToken,
                            "0", null);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    getAccountTreeResponse.getStatus());

            // wrong auth token
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, incorrectAuthToken,
                            "0", null);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN,
                    getAccountTreeResponse.getStatus());

            // wrong folder id
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken,
                            incorrectId, null);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            assertEquals(BoxConstant.STATUS_E_FOLDER_ID, getAccountTreeResponse
                    .getStatus());

            // successfully get account tree, param = null, means zip content
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0", null);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            assertNotNull(getAccountTreeResponse.getEncodedTree());

            // successfully get account tree, nozip
            String[] gatActTreeParams = { "nozip" };
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0",
                            gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            DefaultMutableTreeNode rootTree = getAccountTreeResponse.getTree();

            boolean existFirstFolder = false, existFirstFile1 = false, existFirstFile2 = false;
            boolean existSubFolder1 = false, existSubFolder2 = false, existSubFile1 = false, existSubFile2 = false;

            assertTrue(rootTree.getChildCount() > 0);
            for (int i = 0; i < rootTree.getChildCount(); i++) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) rootTree
                        .getChildAt(i);
                BoxAbstractFile aFile = (BoxAbstractFile) treeNode
                        .getUserObject();
                String fileName = aFile.getName();
                if (fileName.equals(firstFolderName)) {
                    existFirstFolder = true;
                    for (int j = 0; j < treeNode.getChildCount(); j++) {
                        DefaultMutableTreeNode subTreeNode = (DefaultMutableTreeNode) treeNode
                                .getChildAt(j);
                        BoxAbstractFile subFile = (BoxAbstractFile) subTreeNode
                                .getUserObject();
                        String subFileName = subFile.getName();
                        if (subFileName.equals(firstFolderName + "1")) {
                            existSubFolder1 = true;
                        }
                        if (subFileName.equals(firstFolderName + "2")) {
                            existSubFolder2 = true;
                        }
                        if (subFileName.equals(subFile1Name)) {
                            existSubFile1 = true;
                            // subFile1Id = subFile.getId();
                        }
                        if (subFileName.equals(subFile2Name)) {
                            existSubFile2 = true;
                            // subFile2Id = subFile.getId();
                        }
                    }
                }
                if (fileName.equals(newCreatedFileName + "1")) {
                    existFirstFile1 = true;
                    rootFile1Id = aFile.getId();
                }
                if (fileName.equals(newCreatedFileName + "2")) {
                    existFirstFile2 = true;
                    rootFile2Id = aFile.getId();
                }
            }

            assertTrue(existFirstFolder);
            assertTrue(existFirstFile1);
            assertTrue(existFirstFile2);
            assertTrue(existSubFolder1);
            assertTrue(existSubFolder2);
            assertTrue(existSubFile1);
            assertTrue(existSubFile2);

            /** download */
            DownloadResponse downloadResponse;
            DownloadRequest downloadRequest;

            // download bytes array
            downloadRequest = BoxRequestFactory.createDownloadRequest(
                    authToken, rootFile1Id, false, null);
            downloadResponse = boxExternalAPI.download(downloadRequest);
            assertEquals(newCreatedFileContent + "1", new String(
                    downloadResponse.getRawData()));

            // download file
            File rootFile2File = new File("tmp" + System.currentTimeMillis());
            downloadRequest = BoxRequestFactory.createDownloadRequest(
                    authToken, rootFile2Id, true, rootFile2File);
            boxExternalAPI.download(downloadRequest);
            assertEquals((newCreatedFileContent + "1").getBytes().length,
                    rootFile2File.length());
            rootFile2File.delete();

            /** set description */
            SetDescriptionResponse setDescriptionResponse;
            SetDescriptionRequest setDescriptionRequest;

            // wrong api key
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(incorrectApiKey, authToken,
                            "folder", firstFolderId, folderDesc);
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    setDescriptionResponse.getStatus());

            // wrong auth token
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(apiKey, incorrectAuthToken,
                            "folder", firstFolderId, "");
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN,
                    setDescriptionResponse.getStatus());

            // wrong file id
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(apiKey, authToken, "file",
                            incorrectId, "");
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_E_SET_DESCRIPTION,
                    setDescriptionResponse.getStatus());

            // wrong folder id
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(apiKey, authToken, "folder",
                            incorrectId, "");
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_E_SET_DESCRIPTION,
                    setDescriptionResponse.getStatus());

            // correct set file description
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(apiKey, authToken, "file",
                            rootFile1Id, fileDesc);
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_S_SET_DESCRIPTION,
                    setDescriptionResponse.getStatus());

            // correct set folder description
            setDescriptionRequest = BoxRequestFactory
                    .createSetDescriptionRequest(apiKey, authToken, "folder",
                            firstFolderId, folderDesc);
            setDescriptionResponse = boxExternalAPI
                    .setDescription(setDescriptionRequest);
            assertEquals(BoxConstant.STATUS_S_SET_DESCRIPTION,
                    setDescriptionResponse.getStatus());

            /** get file info */
            GetFileInfoResponse getFileInfoResponse;
            GetFileInfoRequest getFileInfoRequest;

            // wrong api key
            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    incorrectApiKey, authToken, rootFile1Id);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    getFileInfoResponse.getStatus());

            // wrong auth token
            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    apiKey, incorrectAuthToken, rootFile1Id);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, getFileInfoResponse
                    .getStatus());

            // wrong file id
            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    apiKey, authToken, incorrectId);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            assertEquals(BoxConstant.STATUS_E_ACCESS_DENIED, getFileInfoResponse
                    .getStatus());

            // correct
            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    apiKey, authToken, rootFile1Id);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            assertEquals(BoxConstant.STATUS_S_GET_FILE_INFO,
                    getFileInfoResponse.getStatus());
             assertEquals(fileDesc, getFileInfoResponse.getFile()
             .getDescription());

            /** public share */
            PublicShareResponse publicShareResponse;
            PublicShareRequest publicShareRequest;

            // wrong api key
            publicShareRequest = BoxRequestFactory.createPublicShareRequest(
                    incorrectApiKey, authToken, "file", rootFile1Id,
                    "password", "testMessage", emails);
            publicShareResponse = boxExternalAPI
                    .publicShare(publicShareRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    publicShareResponse.getStatus());

            // wrong auth token
            publicShareRequest = BoxRequestFactory.createPublicShareRequest(
                    apiKey, incorrectAuthToken, "file", rootFile1Id,
                    "password", "testMessage", emails);
            publicShareResponse = boxExternalAPI
                    .publicShare(publicShareRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, publicShareResponse
                    .getStatus());

            // share it
            publicShareRequest = BoxRequestFactory.createPublicShareRequest(
                    apiKey, authToken, "file", rootFile1Id, "password",
                    "testMessage", emails);
            publicShareResponse = boxExternalAPI
                    .publicShare(publicShareRequest);
            assertEquals(BoxConstant.STATUS_SHARE_OK, publicShareResponse
                    .getStatus());
            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    apiKey, authToken, rootFile1Id);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            // TODO, bug, XML version public_share not working...
             assertTrue(getFileInfoResponse.getFile().isShared());

            /** public unshare */
            PublicUnshareResponse publicUnshareResponse;
            PublicUnshareRequest publicUnshareRequest;

            // wrong api key
            publicUnshareRequest = BoxRequestFactory
                    .createPublicUnshareRequest(incorrectApiKey, authToken,
                            "file", rootFile1Id);
            publicUnshareResponse = boxExternalAPI
                    .publicUnshare(publicUnshareRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    publicUnshareResponse.getStatus());

            // wrong auth token
            publicUnshareRequest = BoxRequestFactory
                    .createPublicUnshareRequest(apiKey, incorrectAuthToken,
                            "file", rootFile1Id);
            publicUnshareResponse = boxExternalAPI
                    .publicUnshare(publicUnshareRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN,
                    publicUnshareResponse.getStatus());

            // unshare it
            publicUnshareRequest = BoxRequestFactory
                    .createPublicUnshareRequest(apiKey, authToken, "file",
                            rootFile1Id);
            publicUnshareResponse = boxExternalAPI
                    .publicUnshare(publicUnshareRequest);
            assertEquals(BoxConstant.STATUS_UNSHARE_OK, publicUnshareResponse
                    .getStatus());

            getFileInfoRequest = BoxRequestFactory.createGetFileInfoRequest(
                    apiKey, authToken, rootFile1Id);
            getFileInfoResponse = boxExternalAPI
                    .getFileInfo(getFileInfoRequest);
            assertFalse(getFileInfoResponse.getFile().isShared());

            /** private share */
            PrivateShareResponse privateShareResponse;
            PrivateShareRequest privateShareRequest;

            // wrong api key
            privateShareRequest = BoxRequestFactory.createPrivateShareRequest(
                    incorrectApiKey, authToken, "file", rootFile1Id, emails,
                    "PrivateShareMessage", true);
            privateShareResponse = boxExternalAPI
                    .privateShare(privateShareRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    privateShareResponse.getStatus());

            // wrong auth token
            privateShareRequest = BoxRequestFactory.createPrivateShareRequest(
                    apiKey, incorrectAuthToken, "file", rootFile1Id, emails,
                    "PrivateShareMessage", true);
            privateShareResponse = boxExternalAPI
                    .privateShare(privateShareRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, privateShareResponse
                    .getStatus());

            // wrong file id
            privateShareRequest = BoxRequestFactory.createPrivateShareRequest(
                    apiKey, authToken, "file", incorrectId, emails,
                    "PrivateShareMessage", true);
            privateShareResponse = boxExternalAPI
                    .privateShare(privateShareRequest);
            assertEquals(BoxConstant.STATUS_WRONG_NODE, privateShareResponse
                    .getStatus());

            // correct private share
            privateShareRequest = BoxRequestFactory.createPrivateShareRequest(
                    apiKey, authToken, "file", rootFile1Id, emails,
                    "PrivateShareMessage", true);
            privateShareResponse = boxExternalAPI
                    .privateShare(privateShareRequest);
            assertEquals(BoxConstant.STATUS_PRIVATE_SHARE_OK,
                    privateShareResponse.getStatus());

            /** add to tag */
            AddToTagResponse addToTagResponse;
            AddToTagRequest addToTagRequest;

            // wrong api key
            addToTagRequest = BoxRequestFactory
                    .createAddToTagRequest(incorrectApiKey, authToken,
                            normalTags, "file", rootFile1Id);
            addToTagResponse = boxExternalAPI.addToTag(addToTagRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    addToTagResponse.getStatus());

            // wrong auth token
            addToTagRequest = BoxRequestFactory.createAddToTagRequest(apiKey,
                    incorrectAuthToken, normalTags, "file", rootFile1Id);
            addToTagResponse = boxExternalAPI.addToTag(addToTagRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, addToTagResponse
                    .getStatus());

            // tags contains special characters
            addToTagRequest = BoxRequestFactory.createAddToTagRequest(apiKey,
                    authToken, specialCharTags, "file", rootFile1Id);
            addToTagResponse = boxExternalAPI.addToTag(addToTagRequest);
            assertEquals(BoxConstant.STATUS_ADD_TO_TAG_OK, addToTagResponse
                    .getStatus());

            // successful add tags
            addToTagRequest = BoxRequestFactory.createAddToTagRequest(apiKey,
                    authToken, normalTags, "file", rootFile1Id);
            addToTagResponse = boxExternalAPI.addToTag(addToTagRequest);
            assertEquals(BoxConstant.STATUS_ADD_TO_TAG_OK, addToTagResponse
                    .getStatus());

            /** export tags */
            ExportTagsResponse exportTagsResponse;
            ExportTagsRequest exportTagsRequest;

            // wrong api key
            exportTagsRequest = BoxRequestFactory.createExportTagsRequest(
                    incorrectApiKey, authToken);
            exportTagsResponse = boxExternalAPI.exportTags(exportTagsRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    exportTagsResponse.getStatus());

            // wrong auth token
            exportTagsRequest = BoxRequestFactory.createExportTagsRequest(
                    apiKey, incorrectAuthToken);
            exportTagsResponse = boxExternalAPI.exportTags(exportTagsRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, exportTagsResponse
                    .getStatus());

            // successful export tags
            exportTagsRequest = BoxRequestFactory.createExportTagsRequest(
                    apiKey, authToken);
            exportTagsResponse = boxExternalAPI.exportTags(exportTagsRequest);
            assertEquals(BoxConstant.STATUS_EXPORT_TAGS_OK, exportTagsResponse
                    .getStatus());

            assertTrue(exportTagsResponse.getTagList().size() > 0);
            // TODO, bug, not a base64 encoded XML
//             assertNotNull(exportTagsResponse.getEncodedTags());

            /** move */
            MoveResponse moveResponse;
            MoveRequest moveRequest;

            // wrong api key
            moveRequest = BoxRequestFactory.createMoveRequest(incorrectApiKey,
                    authToken, "file", rootFile2Id, firstFolderId);
            moveResponse = boxExternalAPI.move(moveRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    moveResponse.getStatus());

            // wrong auth token
            moveRequest = BoxRequestFactory.createMoveRequest(apiKey,
                    incorrectAuthToken, "file", rootFile2Id, firstFolderId);
            moveResponse = boxExternalAPI.move(moveRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, moveResponse
                    .getStatus());

            // move root second file to root first folder
            moveRequest = BoxRequestFactory.createMoveRequest(apiKey,
                    authToken, "file", rootFile2Id, firstFolderId);
            moveResponse = boxExternalAPI.move(moveRequest);
            assertEquals(BoxConstant.STATUS_S_MOVE_NODE, moveResponse
                    .getStatus());

            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0",
                            gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            rootTree = getAccountTreeResponse.getTree();
            boolean rootFile2Exist = false;
            for (int i = 0; i < rootTree.getChildCount(); i++) {
                DefaultMutableTreeNode nodeTree = (DefaultMutableTreeNode) rootTree
                        .getChildAt(i);
                BoxAbstractFile aFile = (BoxAbstractFile) nodeTree
                        .getUserObject();
                if (aFile.getName().equals(rootFile2Name)) {
                    rootFile2Exist = true;
                }
            }
            assertFalse(rootFile2Exist);

            rootFile2Exist = false;
            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken,
                            firstFolderId, gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            rootTree = getAccountTreeResponse.getTree();
            for (int i = 0; i < rootTree.getChildCount(); i++) {
                DefaultMutableTreeNode nodeTree = (DefaultMutableTreeNode) rootTree
                        .getChildAt(i);
                BoxAbstractFile aFile = (BoxAbstractFile) nodeTree
                        .getUserObject();
                if (aFile.getName().equals(rootFile2Name)) {
                    rootFile2Exist = true;
                }
            }
            assertTrue(rootFile2Exist);

            /** rename */
            RenameResponse renameResponse;
            RenameRequest renameRequest;
            String firstFolderNewName = "FirstFolderNewName"
                    + System.currentTimeMillis();

            // wrong api key
            renameRequest = BoxRequestFactory.createRenameRequest(
                    incorrectApiKey, authToken, "folder", firstFolderId,
                    firstFolderNewName);
            renameResponse = boxExternalAPI.rename(renameRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    renameResponse.getStatus());

            // wrong auth token
            renameRequest = BoxRequestFactory.createRenameRequest(apiKey,
                    incorrectAuthToken, "folder", firstFolderId,
                    firstFolderNewName);
            renameResponse = boxExternalAPI.rename(renameRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, renameResponse
                    .getStatus());

            // successful rename
            renameRequest = BoxRequestFactory.createRenameRequest(apiKey,
                    authToken, "folder", firstFolderId, firstFolderNewName);
            renameResponse = boxExternalAPI.rename(renameRequest);
            assertEquals(BoxConstant.STATUS_S_RENAME_NODE, renameResponse
                    .getStatus());

            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0",
                            gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            rootTree = getAccountTreeResponse.getTree();
            boolean rootFolderNameFound = false;
            for (int i = 0; i < rootTree.getChildCount(); i++) {
                DefaultMutableTreeNode nodeTree = (DefaultMutableTreeNode) rootTree
                        .getChildAt(i);
                BoxAbstractFile aFile = (BoxAbstractFile) nodeTree
                        .getUserObject();
                if (aFile.getName().equals(firstFolderNewName)) {
                    rootFolderNameFound = true;
                }
            }
            assertTrue(rootFolderNameFound);

            /** delete */
            DeleteResponse deleteResponse;
            DeleteRequest deleteRequest;

            // wrong api key
            deleteRequest = BoxRequestFactory.createDeleteRequest(
                    incorrectApiKey, authToken, "file", rootFile1Id);
            deleteResponse = boxExternalAPI.delete(deleteRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    deleteResponse.getStatus());

            // wrong auth token
            deleteRequest = BoxRequestFactory.createDeleteRequest(apiKey,
                    incorrectAuthToken, "file", rootFile1Id);
            deleteResponse = boxExternalAPI.delete(deleteRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, deleteResponse
                    .getStatus());

            // successful delete
            deleteRequest = BoxRequestFactory.createDeleteRequest(apiKey,
                    authToken, "file", rootFile1Id);
            deleteResponse = boxExternalAPI.delete(deleteRequest);
            assertEquals(BoxConstant.STATUS_S_DELETE_NODE, deleteResponse
                    .getStatus());

            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0",
                            gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            rootTree = getAccountTreeResponse.getTree();
            boolean rootFile1Exist = false;
            for (int i = 0; i < rootTree.getChildCount(); i++) {
                DefaultMutableTreeNode nodeTree = (DefaultMutableTreeNode) rootTree
                        .getChildAt(i);
                BoxAbstractFile aFile = (BoxAbstractFile) nodeTree
                        .getUserObject();
                if (aFile.getName().equals(rootFile1Name)) {
                    rootFile1Exist = true;
                }
            }
            assertFalse(rootFile1Exist);

            /** logout */
            LogoutResponse logoutResponse;
            LogoutRequest logoutRequest;

            // wrong api key
            logoutRequest = BoxRequestFactory.createLogoutRequest(
                    incorrectApiKey, authToken);
            logoutResponse = boxExternalAPI.logout(logoutRequest);
            assertEquals(BoxConstant.STATUS_APPLICATION_RESTRICTED,
                    logoutResponse.getStatus());

            // wrong auth token
            logoutRequest = BoxRequestFactory.createLogoutRequest(apiKey,
                    incorrectAuthToken);
            logoutResponse = boxExternalAPI.logout(logoutRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN, logoutResponse
                    .getStatus());

            // successfully logout
            logoutRequest = BoxRequestFactory.createLogoutRequest(apiKey,
                    authToken);
            logoutResponse = boxExternalAPI.logout(logoutRequest);
            assertEquals(BoxConstant.STATUS_LOGOUT_OK, logoutResponse
                    .getStatus());

            getAccountTreeRequest = BoxRequestFactory
                    .createGetAccountTreeRequest(apiKey, authToken, "0",
                            gatActTreeParams);
            getAccountTreeResponse = boxExternalAPI
                    .getAccountTree(getAccountTreeRequest);
            assertEquals(BoxConstant.STATUS_NOT_LOGGED_IN,
                    getAccountTreeResponse.getStatus());

        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (BoxException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    

    /**
     * This method is used to simulate authorization process.
     * 
     * @param boxUName
     *            login name
     * @param boxPWord
     *            login password
     * @param apiKey
     *            api key
     * @return response
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    private GetAuthTokenResponse simAuthentication(String boxUName,
            String boxPWord, String apiKey) throws IOException, BoxException {
        GetTicketRequest getTicketRequest = BoxRequestFactory
                .createGetTicketRequest(apiKey);
        GetTicketResponse getTicketResponse = boxExternalAPI
                .getTicket(getTicketRequest);
        if (!BoxConstant.STATUS_GET_TICKET_OK.equals(getTicketResponse
                .getStatus())) {
            GetAuthTokenResponse getAuthTokenResponse = BoxResponseFactory
                    .createGetAuthTokenResponse();
            getAuthTokenResponse.setStatus(getTicketResponse.getStatus());
            return getAuthTokenResponse;
        } else {
            Properties config = BoxHTTPManager.getBoxHTTPManager().getConfig();
            String apiUrlPrefix = config
                    .getProperty(BoxConstant.CONFIG_API_URL_PREFIX);
            String apiVersion = config
                    .getProperty(BoxConstant.CONFIG_API_VERSION);

            // first redirect that page
            HttpClient hc = new HttpClient();

            StringBuffer urlBuff = new StringBuffer();
            urlBuff.append(apiUrlPrefix);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(apiVersion);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(BoxConstant.AUTH_URL_STRING);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(getTicketResponse.getTicket());
            GetMethod gMethod = new GetMethod(urlBuff.toString());
            hc.executeMethod(gMethod);

            // login use username/password
            PostMethod pMethod = new PostMethod(urlBuff.toString());

            NameValuePair unamePair = new NameValuePair("login", boxUName);
            NameValuePair pwordPair = new NameValuePair("password", boxPWord);
            NameValuePair dologinPair = new NameValuePair("dologin", "1");
            pMethod.setRequestBody(new NameValuePair[] { unamePair, pwordPair,
                    dologinPair });
            pMethod.addRequestHeader("Referer", urlBuff.toString());
            hc.executeMethod(pMethod);

            GetAuthTokenRequest getAuthTokenRequest = BoxRequestFactory
                    .createGetAuthTokenRequest(apiKey, getTicketResponse
                            .getTicket());
            GetAuthTokenResponse getAuthTokenResponse = boxExternalAPI
                    .getAuthToken(getAuthTokenRequest);
            return getAuthTokenResponse;
        }
    }
}
