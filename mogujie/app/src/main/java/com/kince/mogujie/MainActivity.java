package com.kince.mogujie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;


public class MainActivity extends Activity {

    private ImageView mAnimImageView;
    private ImageView mAnimImageView2;
    private TextView mTextView;
    private TextView mNumTextView;
    private Animation mAnimation;
    private PopupWindow mPopupWindow;
    private int goodsNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_frame_layout);

        mAnimImageView = (ImageView) findViewById(R.id.cart_anim_icon);
        mAnimImageView2 = (ImageView) findViewById(R.id.cart_anim_icon_two);
        mTextView = (TextView) findViewById(R.id.detail_cart_btn);
        mTextView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                mAnimImageView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = Bitmap.createBitmap(mAnimImageView.getDrawingCache());
                mAnimImageView.setDrawingCacheEnabled(false);
                mAnimImageView2.setImageBitmap(drawingCache);

                mAnimImageView2.startAnimation(mAnimation);
            }
        });
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.cart_anim);
    }

    private void createPopbWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentview = inflater.inflate(R.layout.cart_popup_layout, null);
        contentview.setFocusable(true);
        contentview.setFocusableInTouchMode(true);
        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setContentView(contentview);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mPopupWindow.setWidth(LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
    }

}
