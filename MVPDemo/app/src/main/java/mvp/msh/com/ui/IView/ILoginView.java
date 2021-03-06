package mvp.msh.com.ui.IView;

/**
 * Created by mashaohu on 16/6/14.
 * Description
 */
public interface ILoginView extends IBaseView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void loadingSuccess();

    void loadingFailed();

}
