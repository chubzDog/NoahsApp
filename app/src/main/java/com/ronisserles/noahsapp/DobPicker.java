package com.ronisserles.noahsapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Tardis on 6/30/16.
 */
public class DobPicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private OnUserAction action;
    public DobPicker(){//empty constructor

    }

    public interface OnUserAction{
        void onClosedDialog(String result);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH);
        int y = c.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(), this,y,m,d);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            action = (OnUserAction) activity;
        } catch (ClassCastException e) {
            e.getMessage();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //Toast.makeText(getActivity(),String.valueOf(year),Toast.LENGTH_SHORT).show();
        //OnUserAction action = (OnUserAction) getActivity();
        //action.onClosedDialog("result");
        String date = String.valueOf(dayOfMonth)+ "/" + String.valueOf(monthOfYear) + "/" + String.valueOf(year);
        action.onClosedDialog(date);
    }


}
