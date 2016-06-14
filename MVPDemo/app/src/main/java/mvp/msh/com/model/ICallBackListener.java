package mvp.msh.com.model;

import mvp.msh.com.bean.UserBean;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public interface ICallBackListener {

    void callSuccess(UserBean userBean);

    void callFailed(int code, String message);
}
