package mvp.msh.com.presenter;


import android.os.Handler;

import mvp.msh.com.bean.UserBean;
import mvp.msh.com.model.ICallBackListener;
import mvp.msh.com.model.UserModel;
import mvp.msh.com.ui.IView.ILoginView;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public class LoginPresenter extends BasePresenter {

    private ILoginView loginView;
    private final UserModel userModel;
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        userModel = new UserModel();
    }

    public void login() {

        userModel.login(loginView.getUserName(), loginView.getPassword(), new ICallBackListener() {

            @Override
            public void callSuccess(UserBean userBean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loadingSuccess();
                    }
                });
            }

            @Override
            public void callFailed(int code, String message) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loadingFailed();
                    }
                });
            }
        });
    }
}
