package com.ronisserles.noahsapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tardis on 6/10/16.
 */
public class ManageSpeakers extends android.support.v4.app.Fragment {

    private EditText name;
    //EditText age;
    private Button add_dob;
    private Button add_btn;
    private String dob;

    public ManageSpeakers(){}//empty constructor


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.manage_speakers,container, false);
        name = (EditText) view.findViewById(R.id.s_name);
        //age = (EditText) view.findViewById(R.id.s_age);

        add_dob = (Button) view.findViewById(R.id.ms_dob_btn);
        add_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDobPicker();
            }
        });

        add_btn = (Button) view.findViewById(R.id.ms_add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSpeaker();
            }
        });
        return view;
    }

    public void addSpeaker(){
        if(StringUtils.isEmpty(name)){
            Toast.makeText(getActivity(),R.string.error_001,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getActivity(),name.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(getActivity(),"name: " + name.getText(), Toast.LENGTH_SHORT).show();
        //String _name = String.valueOf(name.getText());
        //String _age = String.valueOf(age.getText());

//        if(_name != "" && _age != ""){
//            Toast.makeText(getActivity(),"name: " + _name + "age: "+_age, Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(getActivity(),R.string.error_001, Toast.LENGTH_SHORT).show();
//        }
    }

    public void openDobPicker (){
        DialogFragment dobPick = new DobPicker();
        dobPick.show(getFragmentManager(),"dobPicker");
    }

    public void setDob(String _dob){
        dob = _dob;
        Toast.makeText(getActivity(),dob,Toast.LENGTH_SHORT).show();
    }
}
