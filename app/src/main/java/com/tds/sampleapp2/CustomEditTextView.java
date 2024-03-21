package com.tds.sampleapp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomEditTextView extends androidx.appcompat.widget.AppCompatEditText {
    public String expectedAnswer = "Marega";
    private boolean isWrong = false;
    private int color_wrong = Color.RED;
    private int color_neutral = Color.BLACK;


    public CustomEditTextView(@NonNull Context context) {
        super(context);
    }

    public CustomEditTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean isWrong() {
        return isWrong;
    }

    public void setWrong(boolean wrong) {
        isWrong = wrong;
        if (isWrong){
            GradientDrawable border = new GradientDrawable();
            border.setColor(Color.BLACK);  // Background color
            border.setStroke(1, Color.RED);  // Border color and width
            // Set corner radius if needed
            // border.setCornerRadius(8);

            // Set the custom background drawable to the EditText
            this.setBackground(border);
        }
        else{
            GradientDrawable border = new GradientDrawable();
            border.setColor(Color.BLACK);  // Background color
            border.setStroke(1, Color.GREEN);  // Border color and width
            // Set corner radius if needed
            // border.setCornerRadius(8);
            expectedAnswer = this.getText() != null? this.getText().toString() : "";
            System.out.println("batatinha");
            // Set the custom background drawable to the EditText
            this.setBackground(border);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (expectedAnswer == null){
            return;
        }
        if (!expectedAnswer.equalsIgnoreCase(text != null ? text.toString() : "")){
            this.setBorderColor(this.color_neutral);
        }
    }
    private void setBorderColor(int color) {
        GradientDrawable border = new GradientDrawable();
        border.setColor(Color.BLACK);
        border.setStroke(1, color);
        this.setBackground(border);
    }

}
