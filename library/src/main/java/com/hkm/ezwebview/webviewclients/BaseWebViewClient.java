package com.hkm.ezwebview.webviewclients;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ryan on 1/3/20.
 */
public abstract class BaseWebViewClient extends WebViewClient {
    protected String userName = "internal";
    protected String userPass = "101medialab";

    protected boolean isInternalTest = false;

    public void setInternetTest(boolean internetTest) {
        isInternalTest = internetTest;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, final HttpAuthHandler handler, final String host, final String realm) {
        if (isInternalTest) {
            handler.proceed(userName, userPass);
        }
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }
}
