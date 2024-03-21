package com.tds.sampleapp2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomEditTextView extends androidx.appcompat.widget.AppCompatEditText {
    public String expectedAnswer = "Marega";
    private boolean isWrong = false;
    private static final int color_wrong = Color.RED;
    private static final int color_neutral = Color.BLACK;

    private static final int color_right = Color.GREEN;


    public CustomEditTextView(@NonNull Context context) {
        super(context);
    }

    public CustomEditTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isWrong() {
        return isWrong;
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
        if (isWrong){
            this.setBorderColor(color_wrong);
        }
        else{
            this.setBorderColor(color_right);
            expectedAnswer = this.getText() != null? this.getText().toString() : "";
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (expectedAnswer == null){
            return;
        }
        if (!expectedAnswer.equalsIgnoreCase(text != null ? text.toString() : "")){
            this.setBorderColor(color_neutral);
        }
    }
    private void setBorderColor(int color) {
        GradientDrawable border = new GradientDrawable();
        border.setColor(Color.BLACK);
        border.setStroke(1, color);
        this.setBackground(border);
    }

}
