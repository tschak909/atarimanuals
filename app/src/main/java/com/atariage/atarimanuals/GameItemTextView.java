package com.atariage.atarimanuals;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by tschak on 7/31/2016.
 */

public class GameItemTextView extends TextView {
    public GameItemTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"HAMMRF.TTF"));
    }
}
