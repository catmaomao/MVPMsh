package mvp.msh.com.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
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
        ButterKnife.bind(this);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
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
        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();

    }

    @Override
    public void loadingFailed() {

    }
}
