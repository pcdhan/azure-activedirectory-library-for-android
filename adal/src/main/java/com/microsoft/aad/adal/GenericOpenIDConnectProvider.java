package com.microsoft.aad.adal;

import android.util.Base64;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.providers.oauth2.PkceChallenge;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GenericOpenIDConnectProvider implements Serializable {

    private String tokenURL;
    private String authorizationURL;
    private String clientID;
    private String redirectURL;
    private String extraParamsInTokenURL;
    private String resource;
    private String scope;
    private String loginHint;
    private PromptBehavior prompt;
    private String extraQp;
    private String authority;

    //PKCE
    PkceChallenge pkceChallenge = PkceChallenge.newPkceChallenge();

    public GenericOpenIDConnectProvider() {}

    public String getTokenURL() {
        return tokenURL;
    }
    public String getAuthorizationURL() {
        return authorizationURL;
    }

    public String getClientID() {
        return clientID;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public String getCodeChallenge() {
        return pkceChallenge.getCodeChallenge();
    }

    public String getCodeVerifier() {
        return pkceChallenge.getCodeVerifier();
    }

    public String getExtraParamsInTokenURL() {
        return extraParamsInTokenURL;
    }

    public String getResource() {
        return resource;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLoginHint() {
        return loginHint;
    }

    public PromptBehavior getPrompt() {
        return prompt;
    }

    public String getExtraQp() {
        return extraQp;
    }

    public void setTokenURL(String tokenURL) {
        this.tokenURL = tokenURL;
    }

    public void setAuthorizationURL(String authorizationURL) {
        this.authorizationURL = authorizationURL;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public void setExtraParamsInTokenURL(String extraParamsInTokenURL) {
        this.extraParamsInTokenURL = extraParamsInTokenURL;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setLoginHint(String loginHint) {
        this.loginHint = loginHint;
    }

    public void setPrompt(PromptBehavior prompt) {
        this.prompt = prompt;
    }

    public void setExtraQp(String extraQp) {
        this.extraQp = extraQp;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}