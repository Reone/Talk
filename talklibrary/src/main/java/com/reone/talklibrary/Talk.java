package com.reone.talklibrary;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by wangxingsheng on 2018/4/3.
 *
 */

public class Talk {
    private static String lastToast = "";
    private static Handler handler;
    private static Toast mToast;
    private Context appContext;
    private final static long sameTime = 2000;
    public Talk(Context appContext){
        this.appContext = appContext;
        handler = new Handler(appContext.getMainLooper());
    }

    /**
     * toast三秒内相同内容不会显示多次
     */
    private void handlerToastDissmiss() {
        handler.removeCallbacks(toastTimer);
        handler.postDelayed(toastTimer,sameTime);
    }

    private Runnable toastTimer = new Runnable() {
        @Override
        public void run() {
            lastToast = "";
        }
    };

    public void talk(final String text) {
        if (text == null || text.isEmpty()) return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(lastToast.equals(text)){
                    return;
                }
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(appContext, text, Toast.LENGTH_SHORT);
                mToast.show();
                handlerToastDissmiss();
                lastToast = text;
            }
        });
    }

    public String getResourcesString(int stringId) {
        return appContext.getResources().getString(stringId);
    }

    public void talk(int stringId) {
        talk(getResourcesString(stringId));
    }
}
