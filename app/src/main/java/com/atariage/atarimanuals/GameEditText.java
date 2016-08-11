package com.atariage.atarimanuals;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by tschak on 8/10/2016.
 */
public class GameEditText extends EditText {
    public GameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"HAMMRF.TTF"));
    }
}
