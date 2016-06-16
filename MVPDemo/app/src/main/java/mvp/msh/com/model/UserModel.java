package mvp.msh.com.model;

import android.content.Context;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;
import mvp.msh.com.bean.UserBean;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public class UserModel implements IUserModel {

    @Override
    public void login(final Context context, final String username, final String password, final ICallBackListener listener) {
//        模拟登陆
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final UserBean userBean = new UserBean();
                if ("msh".equals(username) && "123".equals(password)) {
                    userBean.setUsername(username);
                    userBean.setPassword(password);
                    userBean.save(context, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            listener.callSuccess(userBean);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(context,"fialed",Toast.LENGTH_LONG).show();
                        }
                    });

                } else {
                    listener.callFailed(10086, "错误");
                }

            }
        }.start();
    }
}
