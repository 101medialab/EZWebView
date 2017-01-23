package com.hkm.ezwebviewsample;

import android.os.Bundle;
import android.view.View;

import com.hkm.ezwebview.Util.Fx9C;
import com.hkm.ezwebview.Util.In32;
import com.hkm.ezwebview.app.BasicWebView;

import java.net.URLEncoder;

/**
 * Created by zJJ on 11/9/2015.
 */
public class DisqusCommentFragment extends BasicWebView {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String template = In32.cssRawName(getActivity(), R.raw.template_disqus_comment);

        String appName = "appName";
        String url = "http://fqdn.for.disqus/full/path";
        int disqusIdentifier = 123456;
        String disqusUrl = "http://domain.com/?p=123456";

        String queryString = String.format(
                "shortname=%s&url=%s&identifier=%d %u",
                appName,
                url,
                disqusIdentifier,
                disqusUrl
        );

        try {
            Fx9C.setup_embedded_js_template(framer, block, betterCircleBar, template, queryString, 3000, getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}