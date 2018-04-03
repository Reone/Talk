package com.reone.talklibrary;

import android.annotation.SuppressLint;
import android.app.Application;

/**
 * Created by wangxingsheng on 2018/4/3.
 *
 */

public class TalkApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Talk talk;

    @Override
    public void onCreate() {
        super.onCreate();
        talk = new Talk(getApplicationContext());
    }

    public static void talk(String text){
        talk.talk(text);
    }

    public static void talk(int textId){
        talk.talk(textId);
    }
}
