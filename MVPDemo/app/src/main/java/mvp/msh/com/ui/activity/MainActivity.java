package mvp.msh.com.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import mvp.msh.com.R;
import mvp.msh.com.presenter.BasePresenter;
import mvp.msh.com.ui.IView.IMainView;
import mvp.msh.com.ui.adapter.MainAdapter;

public class MainActivity extends BaseActivity implements IMainView {

    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        viewpager.setOffscreenPageLimit(4);
        viewpager.setPageMargin(-130);
        MainAdapter mainAdapter = new MainAdapter();
        viewpager.setAdapter(mainAdapter);
    }
}
