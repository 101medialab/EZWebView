package com.hkm.ezwebview.webviewleakfix;

import android.app.Activity;

import com.hkm.ezwebview.webviewclients.BaseWebViewClient;

import java.lang.ref.WeakReference;

/**
 * Created by hesk on 21/5/15.
 */
public class PreventLeakClient<A extends Activity> extends BaseWebViewClient {
    protected WeakReference<A> activityRef;
    protected A activity;

    public PreventLeakClient(A activity) {
        activityRef = new WeakReference<A>(activity);
        this.activity = activityRef.get();
    }

}
