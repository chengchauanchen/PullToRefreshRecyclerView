package com.androidkun.pulltorefreshlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Kun on 2017/2/8.
 * GitHub: https://github.com/AndroidKun
 * CSDN: http://blog.csdn.net/a1533588867
 * Description:加载更多
 */

public class LoadMoreView extends LinearLayout{
    private ImageView imageLoadMore;
    public LoadMoreView(Context context) {
        this(context,null);
    }

    public LoadMoreView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View loadMoreContentView =  LayoutInflater.from(getContext()).inflate(
                R.layout.layout_load_more_view, null);
        imageLoadMore = (ImageView) loadMoreContentView.findViewById(R.id.imageLoadMore);
        addView(loadMoreContentView);
    }

    public void setLoadMoreResource(int resId){
        imageLoadMore.setImageResource(resId);
    }

    public void startAnimation() {
        RotateAnimation animation = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        imageLoadMore.startAnimation(animation);
    }
    public void stopAnimation() {
        imageLoadMore.clearAnimation();
    }
}
