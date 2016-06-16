package mvp.msh.com.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import mvp.msh.com.presenter.BasePresenter;
import mvp.msh.com.ui.IView.IBase;
import mvp.msh.com.utils.AppManager;
import mvp.msh.com.utils.ContextUtils;

public abstract class BaseActivity extends AppCompatActivity implements IBase {

    private BasePresenter presenter;
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        presenter = getPresenter();

        mRootView = createView(null, null, savedInstanceState);
        setContentView(mRootView);
        bindView(savedInstanceState);

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = ContextUtils.inflate(this, getContentLayout());
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public View getView() {
        return mRootView;
    }
}
