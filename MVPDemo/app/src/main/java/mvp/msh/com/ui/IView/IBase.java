package mvp.msh.com.ui.IView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvp.msh.com.presenter.BasePresenter;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public interface IBase {

    BasePresenter getPresenter();

    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void bindView(Bundle savedInstanceState);

    View getView();

    int getContentLayout();

}
