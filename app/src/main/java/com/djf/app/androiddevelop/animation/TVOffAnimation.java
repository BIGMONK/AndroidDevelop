package com.djf.app.androiddevelop.animation;/**
 * Created by Administrator on 2016/5/19.
 */

import android.graphics.Matrix;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * ProjectName：AndroidDevelop
 * PackageName:com.djf.app.androiddevelop.animation
 * FileName:TVOffAnimation
 * Administrator  2016/5/19   15:20
 */
public class TVOffAnimation extends Animation {

    private int halfWidth;
    private int halfHeight;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(500);
        setFillAfter(true);
        //保存中心点
        halfWidth = width / 2;
        halfHeight = height / 2;
        setInterpolator(new AccelerateDecelerateInterpolator());

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Matrix matrix=t.getMatrix();
        if(interpolatedTime<0.8){
            matrix.preScale(1+0.625f*interpolatedTime,1-interpolatedTime/0.8f,halfWidth,halfHeight);
        }else{
            matrix.preScale(7.5f*(1-interpolatedTime),0.01f,halfWidth,halfHeight);
        }
    }
}
