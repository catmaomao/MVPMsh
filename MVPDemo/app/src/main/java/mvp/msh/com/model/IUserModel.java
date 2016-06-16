package mvp.msh.com.model;

import android.content.Context;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public interface IUserModel {

    void login(Context context,String username, String password, ICallBackListener listener);
}
