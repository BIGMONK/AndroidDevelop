package com.djf.app.androiddevelop.customview;/**
 * Created by Administrator on 2016/5/20.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.djf.app.androiddevelop.R;

/**
 * ProjectName：AndroidDevelop
 * PackageName:com.djf.app.androiddevelop.view
 * FileName:CustomTitleView
 * Administrator  2016/5/20   20:24
 */
public class MyCustomView extends View {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;

    private Paint mPaint;
    private Bitmap bitmapBg;

    public MyCustomView(Context context, AttributeSet attrs)
    {

        this(context, attrs, 0);
        initListener();
    }

    public MyCustomView(Context context)
    {
        this(context, null);
        initListener();
    }
    private void initListener() {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                updateUITitleText();
            }
        });
    }

    /**
     * 更新控件
     */
    private void updateUITitleText() {

        mTitleText=getRandomText();
        //更新文本范围
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
        // 通知系统 ，刷新页面，会导致 onDraw 方法的执行
        invalidate();
    }

    /**
     * 获得四位随机数字符串
     * @return
     */
    private String getRandomText() {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public MyCustomView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        /**
         * 获得我们所定义的自定义样式属性
         */
//        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView, defStyle, 0);
//        int n = a.getIndexCount();
//        for (int i = 0; i < n; i++)
//        {
//            int attr = a.getIndex(i);
//            switch (attr)
//            {
//                case R.styleable.CustomTitleView_customTitle:
//                    mTitleText = a.getString(attr);
//                    break;
//                case R.styleable.CustomTitleView_customTitleColor:
//                    // 默认颜色设置为黑色
//                    mTitleTextColor = a.getColor(attr, Color.BLACK);
//                    break;
//                case R.styleable.CustomTitleView_customTitleSize:
//                    // 默认设置为16sp，TypeValue也可以把sp转化为px
//                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
//                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
//                    break;
//
//            }
//
//        }
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.MyCustomView,defStyle,0);
        mTitleText=a.getString(R.styleable.MyCustomView_customView);
        mTitleTextColor = a.getColor(R.styleable.MyCustomView_customViewColor, Color.BLACK);
        mTitleTextSize = a.getDimensionPixelSize(R.styleable.MyCustomView_customViewSize,15);

        BitmapDrawable bgDrawable = (BitmapDrawable) a.getDrawable(R.styleable.MyCustomView_customViewBackgroundIcon);
        bitmapBg = bgDrawable.getBitmap();

        a.recycle();

        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        // mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

    }

    //如果我们把布局文件的宽和高写成wrap_content，系统帮我们测量的高度和宽度都是MATCH_PARNET，
    // 当我们设置明确的宽度和高度时，系统帮我们测量的结果就是我们设置的结果，
    // 当我们设置为WRAP_CONTENT,或者MATCH_PARENT系统帮我们测量的结果就是MATCH_PARENT的长度。
    // 所以，当设置了WRAP_CONTENT时，我们需要自己进行测量，即重写onMesure方法”：
    // 重写之前先了解MeasureSpec的specMode,一共三种类型：
    // EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
    // AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
    // UNSPECIFIED：表示子布局想要多大就多大，很少使用
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
        } else
        {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

            float textWidth = mBound.width();
            float backgroundIconWidth=bitmapBg.getWidth();


            int desired = (int) (getPaddingLeft() + (textWidth>backgroundIconWidth?textWidth:backgroundIconWidth)
                    + getPaddingRight());

            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

            float textHeight = mBound.height();
            float backgroundIconHeight=bitmapBg.getHeight();

            int desired = (int) (getPaddingTop() + (textHeight>backgroundIconHeight?textHeight:backgroundIconHeight)
                    + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    Paint bgPaint=new Paint();
    @Override
    protected void onDraw(Canvas canvas)
    {

        //绘制控件
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        //绘制控件背景图标
        canvas.drawBitmap(bitmapBg, getWidth() / 2-bitmapBg.getWidth()/2, 0, bgPaint);
        //绘制控件字体
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }


}
