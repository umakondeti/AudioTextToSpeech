package com.example.user1.audiotexttospeech.retrofit;

import android.content.Context;

import com.example.user1.audiotexttospeech.models.ServerUrlModel;

import java.net.URI;
import java.net.URISyntaxException;

public class Util {
        public MemberDetailsApi getBaseClassService(Context ctx, String url){
            return new RetroHelper().getAdapter(ctx,url).create(MemberDetailsApi.class);
        }
    public static ServerUrlModel getServerUrlModel(String url) {
        try {
            URI uri = new URI(url.replaceAll(" ", "%20"));
            ServerUrlModel serverUrlModel = new ServerUrlModel();
            serverUrlModel.setBaseUrl(uri.getScheme() + "://" + uri.getHost());
            serverUrlModel.setEndUrl(uri.getPath());
            return serverUrlModel;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}