package com.coucouapp.customViews;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import com.coucouapp.R;

public class PinEntryEditText extends AppCompatEditText {
    public static final String DEFAULT_MASK = "\u25CF";
    private static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    protected String msMask = null;
    protected StringBuilder msMaskChars = null;
    protected String msSingleCharHint = null;
    protected int miAnimatedType = 0;
    protected float mfSpace = 12; //24 dp by default, space between the lines
    protected float mfCharSize;
    protected float mfNumChars = 4;
    protected float mfTextBottomPadding = 4; //8dp by default, height of the text from our lines
    protected int miMaxLength = 4;
    protected RectF[] moLineCoords;
    protected float[] mfCharBottom;
    protected Paint moCharPaint;
    protected Paint moLastCharPaint;
    protected Paint moSingleCharPaint;
    protected Drawable moPinBackground;
    protected Rect moTextHeight = new Rect();
    protected boolean mbIsDigitSquare = false;

    protected OnClickListener moClickListener;
    protected OnPinEnteredListener moOnPinEnteredListener = null;

    protected float mfLineStroke = 1; //1dp by default
    protected float mfLineStrokeSelected = 2; //2dp by default
    protected Paint moLinesPaint;
    protected boolean mbAnimate = false;
    protected boolean mbHasError = false;
    protected ColorStateList moOriginalTextColors;
    protected int[][] miStates = new int[][]{
            new int[]{android.R.attr.state_selected}, // selected
            new int[]{android.R.attr.state_active}, // error
            new int[]{android.R.attr.state_focused}, // focused
            new int[]{-android.R.attr.state_focused}, // unfocused
    };

    protected int[] mColors = new int[]{
            Color.GREEN,
            Color.RED,
            Color.BLACK,
            Color.GRAY
    };
    protected ColorStateList mColorStates = new ColorStateList(miStates, mColors);
    private KeyImeChange keyImeChangeListener;
    private boolean isTouchable = true;

    public PinEntryEditText(Context foContext) {
        super(foContext);
    }

    public PinEntryEditText(Context foContext, AttributeSet foAttrs) {
        super(foContext, foAttrs);
        init(foContext, foAttrs);
    }

    public PinEntryEditText(Context foContext, AttributeSet foAttrs, int fiDefStyleAttr) {
        super(foContext, foAttrs, fiDefStyleAttr);
        init(foContext, foAttrs);
    }

    public boolean isTouchable() {
        return isTouchable;
    }

    public void setTouchable(boolean isTouchable) {
        this.isTouchable = isTouchable;
    }

    public void setMaxLength(final int fiMaxLength) {
        miMaxLength = fiMaxLength;
        mfNumChars = fiMaxLength;

        setFilters(new InputFilter[]{new InputFilter.LengthFilter(fiMaxLength)});

        setText(null);
        invalidate();
    }

    public void setMask(String fsMask) {
        msMask = fsMask;
        msMaskChars = null;
        invalidate();
    }

    public void setSingleCharHint(String fsHint) {
        msSingleCharHint = fsHint;
        invalidate();
    }

    private void init(Context foContext, AttributeSet foAttrs) {
        float lfMulti = foContext.getResources().getDisplayMetrics().density;
        mfLineStroke = lfMulti * mfLineStroke;
        mfLineStrokeSelected = lfMulti * mfLineStrokeSelected;
        mfSpace = lfMulti * mfSpace; //convert to pixels for our density
        mfTextBottomPadding = lfMulti * mfTextBottomPadding; //convert to pixels for our density

        TypedArray loTypedArray = foContext.obtainStyledAttributes(foAttrs, R.styleable.PinEntryEditText, 0, 0);
        try {
            TypedValue outValue = new TypedValue();
            loTypedArray.getValue(R.styleable.PinEntryEditText_pinAnimationType, outValue);
            miAnimatedType = outValue.data;
            msMask = loTypedArray.getString(R.styleable.PinEntryEditText_pinCharacterMask);
            msSingleCharHint = loTypedArray.getString(R.styleable.PinEntryEditText_pinRepeatedHint);
            mfLineStroke = loTypedArray.getDimension(R.styleable.PinEntryEditText_pinLineStroke, mfLineStroke);
            mfLineStrokeSelected = loTypedArray.getDimension(R.styleable.PinEntryEditText_pinLineStrokeSelected, mfLineStrokeSelected);
            mfSpace = loTypedArray.getDimension(R.styleable.PinEntryEditText_pinCharacterSpacing, mfSpace);
            mfTextBottomPadding = loTypedArray.getDimension(R.styleable.PinEntryEditText_pinTextBottomPadding, mfTextBottomPadding);
            mbIsDigitSquare = loTypedArray.getBoolean(R.styleable.PinEntryEditText_pinBackgroundIsSquare, mbIsDigitSquare);
            moPinBackground = loTypedArray.getDrawable(R.styleable.PinEntryEditText_pinBackgroundDrawable);
            ColorStateList colors = loTypedArray.getColorStateList(R.styleable.PinEntryEditText_pinLineColors);
            if (colors != null) {
                mColorStates = colors;
            }
        } finally {
            loTypedArray.recycle();
        }

        moCharPaint = new Paint(getPaint());
        moLastCharPaint = new Paint(getPaint());
        moSingleCharPaint = new Paint(getPaint());
        moLinesPaint = new Paint(getPaint());
        moLinesPaint.setStrokeWidth(mfLineStroke);

        TypedValue loOutValue = new TypedValue();
       // foContext.getTheme().resolveAttribute(R.attr.colorControlActivated, loOutValue, true);
        int liColorSelected = loOutValue.data;
        mColors[0] = liColorSelected;

        int liColorFocused = isInEditMode() ? Color.GRAY : ContextCompat.getColor(foContext, R.color.primary);
        mColors[1] = liColorFocused;

        int liColorUnfocused = isInEditMode() ? Color.GRAY : ContextCompat.getColor(foContext, R.color.primary);
        mColors[2] = liColorUnfocused;

        setBackgroundResource(0);

        miMaxLength = foAttrs.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4);
        mfNumChars = miMaxLength;

        //Disable copy paste
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onPrepareActionMode(ActionMode foActionMode, Menu foMenu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode foActionMode) {
            }

            public boolean onCreateActionMode(ActionMode foActionMode, Menu foMenu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode foActionMode, MenuItem foMenuItem) {
                return false;
            }
        });
        // When tapped, move cursor to end of text.
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View foView) {
                setSelection(getText().length());
                if (moClickListener != null) {
                    moClickListener.onClick(foView);
                }
            }
        });

        super.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View foView) {
                setSelection(getText().length());
                return true;
            }
        });

        //If input type is password and no mask is set, use a default mask
        if ((getInputType() & InputType.TYPE_TEXT_VARIATION_PASSWORD) == InputType.TYPE_TEXT_VARIATION_PASSWORD && TextUtils.isEmpty(msMask)) {
            msMask = DEFAULT_MASK;
        } else if ((getInputType() & InputType.TYPE_NUMBER_VARIATION_PASSWORD) == InputType.TYPE_NUMBER_VARIATION_PASSWORD && TextUtils.isEmpty(msMask)) {
            msMask = DEFAULT_MASK;
        }

        if (!TextUtils.isEmpty(msMask)) {
            msMaskChars = getMaskChars();
        }

        //Height of the characters, used if there is a background drawable
        getPaint().getTextBounds("|", 0, 1, moTextHeight);

        mbAnimate = miAnimatedType > -1;
    }

    @Override
    public void setInputType(int fiType) {
        super.setInputType(fiType);

        if ((fiType & InputType.TYPE_TEXT_VARIATION_PASSWORD) == InputType.TYPE_TEXT_VARIATION_PASSWORD
                || (fiType & InputType.TYPE_NUMBER_VARIATION_PASSWORD) == InputType.TYPE_NUMBER_VARIATION_PASSWORD) {
            // If input type is password and no mask is set, use a default mask
            if (TextUtils.isEmpty(msMask)) {
                setMask(DEFAULT_MASK);
            }
        } else {
            // If input type is not password, remove mask
            setMask(null);
        }

    }

    @Override
    protected void onSizeChanged(int fiWidth, int fiHeight, int fiOldWidth, int fiOldHeight) {
        super.onSizeChanged(fiWidth, fiHeight, fiOldWidth, fiOldHeight);
        moOriginalTextColors = getTextColors();
        if (moOriginalTextColors != null) {
            moLastCharPaint.setColor(moOriginalTextColors.getDefaultColor());
            moCharPaint.setColor(moOriginalTextColors.getDefaultColor());
            moSingleCharPaint.setColor(getCurrentHintTextColor());
        }
        int liAvailableWidth = getWidth() - ViewCompat.getPaddingEnd(this) - ViewCompat.getPaddingStart(this);
        if (mfSpace < 0) {
            mfCharSize = (liAvailableWidth / (mfNumChars * 2 - 1));
        } else {
            mfCharSize = (liAvailableWidth - (mfSpace * (mfNumChars - 1))) / mfNumChars;
        }
        moLineCoords = new RectF[(int) mfNumChars];
        mfCharBottom = new float[(int) mfNumChars];
        int liStartX;
        int liBottom = getHeight() - getPaddingBottom();
        int liRtlFlag;
        final boolean lbIsLayoutRtl = ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL;
        if (lbIsLayoutRtl) {
            liRtlFlag = -1;
            liStartX = (int) (getWidth() - ViewCompat.getPaddingStart(this) - mfCharSize);
        } else {
            liRtlFlag = 1;
            liStartX = ViewCompat.getPaddingStart(this);
        }
        for (int liCount = 0; liCount < mfNumChars; liCount++) {
            moLineCoords[liCount] = new RectF(liStartX, liBottom, liStartX + mfCharSize, liBottom);
            if (moPinBackground != null) {
                if (mbIsDigitSquare) {
                    moLineCoords[liCount].top = getPaddingTop();
                    moLineCoords[liCount].right = liStartX + moLineCoords[liCount].width();
                } else {
                    moLineCoords[liCount].top -= moTextHeight.height() + mfTextBottomPadding * 2;
                }
            }

            if (mfSpace < 0) {
                liStartX += liRtlFlag * mfCharSize * 2;
            } else {
                liStartX += liRtlFlag * (mfCharSize + mfSpace);
            }
            mfCharBottom[liCount] = moLineCoords[liCount].bottom - mfTextBottomPadding;
        }
    }

    @Override
    protected void onMeasure(int fiWidthMeasureSpec, int fiHeightMeasureSpec) {
        if (mbIsDigitSquare) {
            int liWidthMode = MeasureSpec.getMode(fiWidthMeasureSpec);
            int liHeightMode = MeasureSpec.getMode(fiHeightMeasureSpec);
            int liMeasuredWidth = 0;
            int liMeasuredHeight = 0;
            // If we want a square or circle pin box, we might be able
            // to figure out the dimensions outselves
            // if width and height are set to wrap_content or match_parent
            if (liWidthMode == MeasureSpec.EXACTLY) {
                liMeasuredWidth = MeasureSpec.getSize(fiWidthMeasureSpec);
                liMeasuredHeight = (int) ((liMeasuredWidth - (mfNumChars - 1 * mfSpace)) / mfNumChars);
            } else if (liHeightMode == MeasureSpec.EXACTLY) {
                liMeasuredHeight = MeasureSpec.getSize(fiHeightMeasureSpec);
                liMeasuredWidth = (int) ((liMeasuredHeight * mfNumChars) + (mfSpace * mfNumChars - 1));
            } else if (liWidthMode == MeasureSpec.AT_MOST) {
                liMeasuredWidth = MeasureSpec.getSize(fiWidthMeasureSpec);
                liMeasuredHeight = (int) ((liMeasuredWidth - (mfNumChars - 1 * mfSpace)) / mfNumChars);
            } else if (liHeightMode == MeasureSpec.AT_MOST) {
                liMeasuredHeight = MeasureSpec.getSize(fiHeightMeasureSpec);
                liMeasuredWidth = (int) ((liMeasuredHeight * mfNumChars) + (mfSpace * mfNumChars - 1));
            } else {
                // Both unspecific
                // Try for a width based on our minimum
                liMeasuredWidth = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();

                // Whatever the width ends up being, ask for a height that would let the pie
                // get as big as it can
                liMeasuredHeight = (int) ((liMeasuredWidth - (mfNumChars - 1 * mfSpace)) / mfNumChars);
            }

            setMeasuredDimension(
                    resolveSizeAndState(liMeasuredWidth, fiWidthMeasureSpec, 1), resolveSizeAndState(liMeasuredHeight, fiHeightMeasureSpec, 0));
        } else {
            super.onMeasure(fiWidthMeasureSpec, fiHeightMeasureSpec);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener foOnClickListener) {
        moClickListener = foOnClickListener;
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback foActionModeCallback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    @Override
    protected void onDraw(Canvas foCanvas) {
        //super.onDraw(canvas);
        CharSequence loText = getFullText();
        int liTextLength = loText.length();
        float[] liTextWidths = new float[liTextLength];
        getPaint().getTextWidths(loText, 0, liTextLength, liTextWidths);

        float lfHintWidth = 0;
        if (msSingleCharHint != null) {
            float[] hintWidths = new float[msSingleCharHint.length()];
            getPaint().getTextWidths(msSingleCharHint, hintWidths);
            for (float i : hintWidths) {
                lfHintWidth += i;
            }
        }
        for (int i = 0; i < mfNumChars; i++) {
            //If a background for the pin characters is specified, it should be behind the characters.
            if (moPinBackground != null) {
                updateDrawableState(i < liTextLength, i == liTextLength);
                moPinBackground.setBounds((int) moLineCoords[i].left, (int) moLineCoords[i].top, (int) moLineCoords[i].right, (int) moLineCoords[i].bottom);
                moPinBackground.draw(foCanvas);
            }
            float middle = moLineCoords[i].left + mfCharSize / 2;
            if (liTextLength > i) {
                if (!mbAnimate || i != liTextLength - 1) {
                    foCanvas.drawText(loText, i, i + 1, middle - liTextWidths[i] / 2, mfCharBottom[i], moCharPaint);
                } else {
                    foCanvas.drawText(loText, i, i + 1, middle - liTextWidths[i] / 2, mfCharBottom[i], moLastCharPaint);
                }
            } else if (msSingleCharHint != null) {
                foCanvas.drawText(msSingleCharHint, middle - lfHintWidth / 2, mfCharBottom[i], moSingleCharPaint);
            }
            //The lines should be in front of the text (because that's how I want it).
            if (moPinBackground == null) {
                updateColorForLines(i <= liTextLength);
                foCanvas.drawLine(moLineCoords[i].left, moLineCoords[i].top, moLineCoords[i].right, moLineCoords[i].bottom, moLinesPaint);
            }
        }
    }

    private CharSequence getFullText() {
        if (TextUtils.isEmpty(msMask)) {
            return getText();
        } else {
            return getMaskChars();
        }
    }

    private StringBuilder getMaskChars() {
        if (msMaskChars == null) {
            msMaskChars = new StringBuilder();
        }
        int textLength = getText().length();
        while (msMaskChars.length() != textLength) {
            if (msMaskChars.length() < textLength) {
                msMaskChars.append(msMask);
            } else {
                msMaskChars.deleteCharAt(msMaskChars.length() - 1);
            }
        }
        return msMaskChars;
    }


    private int getColorForState(int... states) {
        return mColorStates.getColorForState(states, Color.GRAY);
    }

    /**
     * @param hasTextOrIsNext Is the color for a character that has been typed or is
     *                        the next character to be typed?
     */
    protected void updateColorForLines(boolean hasTextOrIsNext) {
        if (mbHasError) {
            moLinesPaint.setColor(getColorForState(android.R.attr.state_active));
        } else if (isFocused()) {
            moLinesPaint.setStrokeWidth(mfLineStrokeSelected);
            moLinesPaint.setColor(getColorForState(android.R.attr.state_focused));
            if (hasTextOrIsNext) {
                moLinesPaint.setColor(getColorForState(android.R.attr.state_selected));
            }
        } else {
            moLinesPaint.setStrokeWidth(mfLineStroke);
            moLinesPaint.setColor(getColorForState(-android.R.attr.state_focused));
        }
    }

    protected void updateDrawableState(boolean hasText, boolean isNext) {
        if (mbHasError) {
            moPinBackground.setState(new int[]{android.R.attr.state_active});
        } else if (isFocused()) {
            moPinBackground.setState(new int[]{android.R.attr.state_focused});
            if (isNext) {
                moPinBackground.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected});
            } else if (hasText) {
                moPinBackground.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_checked});
            }
        } else {
            if (hasText) {
                moPinBackground.setState(new int[]{-android.R.attr.state_focused, android.R.attr.state_checked});
            } else {
                moPinBackground.setState(new int[]{-android.R.attr.state_focused});
            }
        }
    }

    public boolean isError() {
        return mbHasError;
    }

    public void setError(boolean hasError) {
        mbHasError = hasError;
        invalidate();
    }

    /**
     * Request focus on this PinEntryEditText
     */
    public void focus() {
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(this, 0);
    }

    @Override
    public void setTypeface(@Nullable Typeface tf) {
        super.setTypeface(tf);
        setCustomTypeface(tf);
    }

    @Override
    public void setTypeface(@Nullable Typeface tf, int style) {
        super.setTypeface(tf, style);
        setCustomTypeface(tf);
    }

    private void setCustomTypeface(@Nullable Typeface tf) {
        if (moCharPaint != null) {
            moCharPaint.setTypeface(tf);
            moLastCharPaint.setTypeface(tf);
            moSingleCharPaint.setTypeface(tf);
            moLinesPaint.setTypeface(tf);
        }
    }

    public void setPinLineColors(ColorStateList colors) {
        mColorStates = colors;
        invalidate();
    }

    public void setPinBackground(Drawable pinBackground) {
        moPinBackground = pinBackground;
        invalidate();
    }

    @Override
    protected void onTextChanged(CharSequence text, final int start, int lengthBefore, final int lengthAfter) {
        setError(false);
        if (moLineCoords == null || !mbAnimate) {
            if (moOnPinEnteredListener != null && text.length() == miMaxLength) {
                moOnPinEnteredListener.onPinEntered(text);
            }
            return;
        }

        if (miAnimatedType == -1) {
            invalidate();
            return;
        }

        if (lengthAfter > lengthBefore) {
            if (miAnimatedType == 0) {
                animatePopIn();
            } else {
                animateBottomUp(text, start);
            }
        }
    }

    private void animatePopIn() {
        ValueAnimator va = ValueAnimator.ofFloat(1, getPaint().getTextSize());
        va.setDuration(200);
        va.setInterpolator(new OvershootInterpolator());
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                moLastCharPaint.setTextSize((Float) animation.getAnimatedValue());
                PinEntryEditText.this.invalidate();
            }
        });
        if (getText().length() == miMaxLength && moOnPinEnteredListener != null) {
            va.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    moOnPinEnteredListener.onPinEntered(getText());
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });
        }
        va.start();
    }

    private void animateBottomUp(CharSequence text, final int start) {
        mfCharBottom[start] = moLineCoords[start].bottom - mfTextBottomPadding;
        ValueAnimator animUp = ValueAnimator.ofFloat(mfCharBottom[start] + getPaint().getTextSize(), mfCharBottom[start]);
        animUp.setDuration(300);
        animUp.setInterpolator(new OvershootInterpolator());
        animUp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                mfCharBottom[start] = value;
                PinEntryEditText.this.invalidate();
            }
        });

        moLastCharPaint.setAlpha(255);
        ValueAnimator animAlpha = ValueAnimator.ofInt(0, 255);
        animAlpha.setDuration(300);
        animAlpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                moLastCharPaint.setAlpha(value);
            }
        });

        AnimatorSet set = new AnimatorSet();
        if (text.length() == miMaxLength && moOnPinEnteredListener != null) {
            set.addListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    moOnPinEnteredListener.onPinEntered(getText());
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        set.playTogether(animUp, animAlpha);
        set.start();
    }

    public void setAnimateText(boolean animate) {
        mbAnimate = animate;
    }

    public void setOnPinEnteredListener(OnPinEnteredListener l) {
        moOnPinEnteredListener = l;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isTouchable) {
            return super.onTouchEvent(event); // Enable touch event
        }
        return false; // Block touch event
    }

    public void setKeyImeChangeListener(KeyImeChange listener) {
        keyImeChangeListener = listener;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyImeChangeListener != null) {
            keyImeChangeListener.onKeyIme(keyCode, event);
        }
        return true;
    }

    public interface OnPinEnteredListener {
        void onPinEntered(CharSequence str);
    }

    public interface KeyImeChange {
        void onKeyIme(int keyCode, KeyEvent event);
    }
}