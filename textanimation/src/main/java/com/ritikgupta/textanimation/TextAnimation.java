package com.ritikgupta.textanimation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


/**
 * Created by ritik on 8/20/2018.
 */

public class TextAnimation extends android.support.v7.widget.AppCompatTextView {

    private CharSequence mText;
    private int mIndex = 0;
    private long mDelay = 100; //delayed time
    private int mType;
    public static int CharWiseTransition = 0;
    public static int WordWiseTransition = 1;
    android.os.Handler mHandler = new android.os.Handler();
    final Runnable adder = new Runnable() {
        @Override
        public void run() {
            if (mType == CharWiseTransition) {
                mIndex++;
                setText(mText.subSequence(0, mIndex));
            } else if (mType == WordWiseTransition) {
                if (mIndex < mText.length() - 1) {
                    if (mText.charAt(mIndex) != ' ' && (mText.charAt(mIndex + 1) == ' ')) {
                        setText(mText.subSequence(0, mIndex + 1));
                    } else if (mText.charAt(mIndex) != ' ' && (mIndex == mText.length() - 2)) {


                        setText(mText.subSequence(0, mIndex + 2));

                    }
                } else setText(mText);
                mIndex++;

            } else throw new IllegalArgumentException("Invalid type error");

            if (mIndex < mText.length()) {
                mHandler.postDelayed(adder, mDelay);
            }
        }
    };


    public TextAnimation(Context context) {
        super(context);
    }

    public TextAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDelay(long mDelay) {
        this.mDelay = mDelay;
    }

    public void animateText(CharSequence text, int type) {
        mIndex = 0;
        mType = type;
        mText = text;
        mHandler.removeCallbacks(adder, new TextAnimation(getContext()));

        mHandler.postDelayed(adder, mDelay);

    }
}
