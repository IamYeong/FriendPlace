package com.iamyeong.myfriendplace;

import android.app.Application;
import android.provider.Settings;
import android.util.Log;

import com.kakao.auth.KakaoSDK;

public class GlobalApplication extends Application {

    private static GlobalApplication instance;

    private GlobalApplication() {
    }

    public static GlobalApplication getGlobalApplicationContext() {

       if (instance == null) {
           Log.d("GlobalApplication :", "Application is already created");
       }

        return instance;

    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        instance = null;
    }

}
