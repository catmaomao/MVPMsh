package mvp.msh.com.model;

import mvp.msh.com.bean.UserBean;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public class UserModel implements IUserModel {

    @Override
    public void login(final String username, final String password, final ICallBackListener listener) {
//        模拟登陆
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                UserBean userBean = new UserBean();
                if ("msh".equals(username) && "123".equals(password)) {
                    userBean.setUsername(username);
                    userBean.setPassword(password);
                    listener.callSuccess(userBean);
                } else {
                    listener.callFailed(10086, "错误");
                }

            }
        }.start();
    }
}
