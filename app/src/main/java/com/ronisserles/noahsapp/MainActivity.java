package com.ronisserles.noahsapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements DobPicker.OnUserAction{

    private String[] menuItems;
    private TypedArray menuIcons;
    private DrawerLayout drawer;
    private ListView menuContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItems = getResources().getStringArray(R.array.menu_items);
        menuIcons = getResources().obtainTypedArray(R.array.menu_icons);
        drawer = (DrawerLayout)findViewById(R.id.main_menu);
        menuContent = (ListView)findViewById(R.id.menu_content);

        //menuContent.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_line,menuItems));
        menuContent.setAdapter(new MenuAdapter(this, menuItems, menuIcons));
        menuContent.setOnItemClickListener(new MenuClickListener());
    }

    @Override
    public void onClosedDialog(String result) {
        //Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        ManageSpeakers ms = (ManageSpeakers)getSupportFragmentManager().findFragmentByTag(Const.TABLE_SPEAKERS);
        ms.setDob(result);
    }

    private class MenuClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position){
        Toast.makeText(MainActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                android.support.v4.app.Fragment ms = new ManageSpeakers();
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.content, ms,Const.TABLE_SPEAKERS).commit();
                drawer.closeDrawer(menuContent);
                break;
            default:
                break;
        }
    }


}
