package mvp.msh.com.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import mvp.msh.com.R;

/**
 * Created by mashaohu on 16/6/16.
 * Description
 */
public class MainAdapter extends PagerAdapter {

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(container.getContext(), R.layout.main_page_item, null);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
