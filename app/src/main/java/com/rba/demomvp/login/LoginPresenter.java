package com.rba.demomvp.login;

import android.util.Log;

import com.rba.demomvp.R;
import com.rba.demomvp.app.MVPProjectApplication;
import com.rba.demomvp.model.response.LoginResponse;
import com.rba.demomvp.storage.SessionManager;
import com.rba.demomvp.util.Constant;

import java.util.Map;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public class LoginPresenter implements LoginCallback {

    private LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(Map<String, String> data) {
        loginView.showProgress();
        LoginInteractor.login(data, this);
    }


    @Override
    public void onResponse(LoginResponse loginResponse) {
        if(loginResponse.get_meta().getStatus().equals(Constant.KEY_SUCCESS)){
            SessionManager.addSession(MVPProjectApplication.getAppContext(),
                    loginResponse.getData().get(0));
            loginView.hideProgress();
            loginView.nextActivity();
        }else{
            loginView.showErrorMessage(MVPProjectApplication.getAppContext().getString(R.string.message_login));
        }
    }

    @Override
    public void onFailure(String error) {
        Log.i("x- onError", error);
        loginView.showErrorMessage(error);
    }
}
