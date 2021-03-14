package com.iamyeong.myfriendplace;

import android.util.Log;

import com.kakao.auth.ISessionCallback;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;

public class SessionCallback implements ISessionCallback {

    @Override
    public void onSessionOpened() {

        requestMe();
    }

    @Override
    public void onSessionOpenFailed(KakaoException exception) {

    }

    private void requestMe() {

        UserManagement.getInstance()
                .me(new MeV2ResponseCallback() {
                    @Override
                    public void onSessionClosed(ErrorResult errorResult) {

                        Log.d("Session : ", "Closed");
                    }

                    @Override
                    public void onSuccess(MeV2Response result) {

                        UserAccount account = result.getKakaoAccount();
                        Profile profile = account.getProfile();

                        String knickname = profile.getNickname();
                        String profileImageURL = profile.getProfileImageUrl();
                        String thumbnailImageURL = profile.getThumbnailImageUrl();

                        System.out.println(knickname + ", " + profileImageURL + ", " + thumbnailImageURL);
                    }
                });


    }

}
