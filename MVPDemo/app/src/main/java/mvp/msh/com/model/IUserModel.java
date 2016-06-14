package mvp.msh.com.model;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public interface IUserModel {

    void login(String username, String password, ICallBackListener listener);
}
