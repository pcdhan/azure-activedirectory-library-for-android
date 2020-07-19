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
    private String codeChallenge;
    private String codeVerifier;
    private String extraParamsInTokenURL;
    private String resource;
    private String scope;

    //support exisitng method calls
    private String loginHint;
    private PromptBehavior prompt;
    private String extraQp;

    //avoid direct instance creation
    private GenericOpenIDConnectProvider() { }

    private GenericOpenIDConnectProvider(Builder builder) {
        this.tokenURL = builder.tokenURL;
        this.authorizationURL = builder.authorizationURL;
        this.clientID=builder.clientID;
        this.redirectURL=builder.redirectURL;
        this.codeChallenge=builder.codeChallenge;
        this.codeVerifier=builder.codeVerifier;
        this.extraParamsInTokenURL=builder.extraParamsInTokenURL;
        this.resource=builder.resource;
        this.scope=builder.scope;
        this.loginHint=builder.loginHint;
        this.prompt=builder.prompt;
        this.extraQp=builder.extraQp;
    }

    public String getTokenURL() { return tokenURL; }
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
        return codeChallenge;
    }

    public String getCodeVerifier() {
        return codeVerifier;
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

    //Get authority of a URL
    public String getAuthority(){
        return tokenURL;
    }

    public static class Builder {
        private String tokenURL;
        private String authorizationURL;
        private String clientID;
        private String redirectURL;
        private String codeChallenge;
        private String codeVerifier;
        private String extraParamsInTokenURL;
        private String resource;
        private String scope;
        PkceChallenge pkceChallenge = PkceChallenge.newPkceChallenge();

        //support- exisitng method calls
        private String loginHint;
        private PromptBehavior prompt;
        private String extraQp;

        public Builder setTokenURL(String tokenURL) {
            this.tokenURL = tokenURL;
            return this;
        }

        public Builder setAuthorizationURL(String authorizationURL) {
            this.authorizationURL = authorizationURL;
            return this;
        }

        public Builder setClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }

        public Builder setRedirectURL(String redirectURL) {
            this.redirectURL = redirectURL;
            return this;
        }

        public Builder setCodeChallenge(String codeChallenge) {
            this.codeChallenge = codeChallenge;
            return this;
        }

        public Builder setCodeVerifier(String codeVerifier) {
            this.codeVerifier = codeVerifier;
            return this;
        }
        public Builder setResource(String resource) {
            this.resource = resource;
            return this;
        }
        public Builder setScope(String scope) {
            this.scope = scope;
            return this;
        }

        public Builder setExtraParamsInTokenURL(String extraParamsInTokenURL) {
            try {
                this.extraParamsInTokenURL = StringExtensions.urlFormEncode(extraParamsInTokenURL);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unable to encode extra parameters token URL: "+e.getMessage());
            }
            return this;
        }

        public Builder setLoginHint(String loginHint) {
            this.loginHint = loginHint;
            return this;
        }

        public Builder setPrompt(PromptBehavior prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder setExtraQp(String extraQp) {
            this.extraQp = extraQp;
            return this;
        }

        private String generateCodeVerifier() {
            return "5okMxn-s4_kcc_6vS6AF6WHck1NbqluNJ2nG67qefXo";
            //return pkceChallenge.getCodeVerifier();
        }

        private String codeChallenge() {
            return  "K1rG1TnHES3yMviuGA7y6m0r7CvLgaSblcJub_S5zbA";
                    // return pkceChallenge.getCodeChallenge();
        }

        public GenericOpenIDConnectProvider build() {
            this.setCodeVerifier(generateCodeVerifier());
            this.setCodeChallenge(codeChallenge());
            return new GenericOpenIDConnectProvider(this);
        }
    }
}
