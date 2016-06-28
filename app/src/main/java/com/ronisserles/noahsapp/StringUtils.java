package com.ronisserles.noahsapp;

import android.widget.EditText;

/**
 * Created by Tardis on 6/14/16.
 */
public final class StringUtils {

    public static boolean isEmpty(EditText et){
        return et.getText().toString().trim().length() == 0;
    }
}
