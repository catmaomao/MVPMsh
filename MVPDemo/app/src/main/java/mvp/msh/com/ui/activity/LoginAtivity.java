package mvp.msh.com.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import mvp.msh.com.R;
import mvp.msh.com.presenter.LoginPresenter;
import mvp.msh.com.ui.IView.ILoginView;

public class LoginAtivity extends AppCompatActivity implements ILoginView {

    EditText etUsername;
    EditText etPassword;
    Button btLogin;

    LoginPresenter presenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ativity);
        Bmob.initialize(this, "8f2623c0e5587f2f0deafa56959aa06d");
        ButterKnife.bind(this);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(LoginAtivity.this);
            }
        });
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loadingSuccess() {
//        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loadingFailed() {

    }
}
