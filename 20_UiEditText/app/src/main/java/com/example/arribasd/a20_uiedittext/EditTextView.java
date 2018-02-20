package com.example.arribasd.a20_uiedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

/**
 * Created by ArribasD on 2/13/2018.
 */

public class EditTextView extends android.support.v7.widget.AppCompatEditText{
    public EditTextView(Context context) {
        super(context);
    }

    public EditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        desing(context, attrs);
    }

    private void desing(Context context, AttributeSet attrs) {
        context.setTheme(R.style.RepsolEditText);
        this.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }


}
