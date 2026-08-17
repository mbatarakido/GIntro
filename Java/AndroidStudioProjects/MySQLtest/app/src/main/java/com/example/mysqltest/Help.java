package com.example.mysqltest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Help extends AppCompatActivity {

    String myList[] = {
            "First Item",
            "Second Item",
            "Third Item",
            "Fourth Item",
            "Fifth Item"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ListView itemsListView = (ListView) findViewById(R.id.itemsListView);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("FFFF0004")));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.listview_item,
                R.id.itemTextView,
                myList);

        itemsListView.setAdapter(arrayAdapter);

        registerForContextMenu(itemsListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_resource, menu);

        menu.setHeaderTitle("Actions to be Performed");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            /*
            case R.id.about:
                Toast.makeText(this, "Red Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Green Selected", Toast.LENGTH_SHORT).show(); */
            default:
                return super.onContextItemSelected(item);
        }
    }
}
