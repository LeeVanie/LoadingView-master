package cxy.com.loadingview.menu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cxy.com.loadingview.R;

public class MenuStyle01 extends RelativeLayout implements View.OnClickListener {

    private ImageView center,pic1,pic2,pic3,pic4;

    private List<ImageView> oViews;

    private boolean mFlag = true;

    private float mHiddenViewMeasuredHeight;

    
    public MenuStyle01(Context context) {
        super(context);
        initView(context);
    }

    public MenuStyle01(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MenuStyle01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.menu_layout, this);
        center=(ImageView) findViewById(R.id.center);
        pic1=(ImageView) findViewById(R.id.pic1);
        pic2=(ImageView) findViewById(R.id.pic2);
        pic3=(ImageView) findViewById(R.id.pic3);
        pic4=(ImageView) findViewById(R.id.pic4);

        //将四个Imageview放在集合里，方便管理
        oViews=new ArrayList<ImageView>();
        oViews.add(center);
        oViews.add(pic1);
        oViews.add(pic2);
        oViews.add(pic3);
        oViews.add(pic4);

        center.setOnClickListener(this);
        pic1.setOnClickListener(this);
        pic2.setOnClickListener(this);
        pic3.setOnClickListener(this);
        pic4.setOnClickListener(this);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mHiddenViewMeasuredHeight = (int) (w*1/12);
        Anim(mHiddenViewMeasuredHeight,-mHiddenViewMeasuredHeight ,0.5f, 1f, 0f, 90f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.center:
                if (mFlag) {
                    Anim(-mHiddenViewMeasuredHeight,mHiddenViewMeasuredHeight, 1f, 0.5f, 90f, 0f);;
                    mFlag=false;
                }else {
                    Anim(mHiddenViewMeasuredHeight, -mHiddenViewMeasuredHeight,0.5f, 1f, 0f, 90f);
                    mFlag=true;
                }
                break;
            case R.id.pic1:
                if (listener!=null) {
                    listener.Pic1();
                }
                break;
            case R.id.pic2:
                if (listener!=null) {
                    listener.Pic2();
                }
                break;

            case R.id.pic3:
                if (listener!=null) {
                    listener.Pic3();
                }
                break;

            case R.id.pic4:
                if (listener!=null) {
                    listener.Pic4();
                }
                break;

            default:
                break;
        }
    }


    private void Anim(float mHiddenViewMeasuredHeightBegin,float mHiddenViewMeasuredHeightyClose,float x,float y,float anglex,float angley){

        //设置动画。用于弹出和收回
        ObjectAnimator animator0=ObjectAnimator.ofFloat(oViews.get(0), "alpha", x,y);

        ObjectAnimator animator1=ObjectAnimator.ofFloat(oViews.get(1), "translationY",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator2=ObjectAnimator.ofFloat(oViews.get(2), "translationX",mHiddenViewMeasuredHeightBegin);

        ObjectAnimator animator3=ObjectAnimator.ofFloat(oViews.get(3), "translationX",mHiddenViewMeasuredHeightyClose);
        
        ObjectAnimator animator4=ObjectAnimator.ofFloat(oViews.get(4), "translationY",mHiddenViewMeasuredHeightyClose);


        //设置动画，用于旋转效果
        ObjectAnimator animator5=ObjectAnimator.ofFloat(oViews.get(0), "rotation", anglex,120f,angley);

        ObjectAnimator animator6=ObjectAnimator.ofFloat(oViews.get(1), "rotationY", anglex,120f,angley);

        ObjectAnimator animator7=ObjectAnimator.ofFloat(oViews.get(2), "rotationX", anglex,120f,angley);

        ObjectAnimator animator8=ObjectAnimator.ofFloat(oViews.get(3), "rotationX", anglex,120f,angley);
        
        ObjectAnimator animator9=ObjectAnimator.ofFloat(oViews.get(4), "rotationY", anglex,120f,angley);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new OvershootInterpolator());
        set.playTogether(animator0,animator1,animator2,animator3,animator4,animator5,animator6,animator7,animator8,animator9);
        set.start();


    }
    onMenuClickListener listener;
    //定义回调接口
    public interface onMenuClickListener {
        void Pic1();
        void Pic2();
        void Pic3();
        void Pic4();
    }
    //设置事件回调
    public void setonMenuClickListener( onMenuClickListener listener){
        this.listener=listener;
    }

}
