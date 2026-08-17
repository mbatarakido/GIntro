package com.example.mysqltest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class About extends AppCompatActivity {

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
        setContentView(R.layout.activity_about);


        ListView itemsListView = (ListView) findViewById(R.id.itemsListView);


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

        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Save");
        menu.add(0, v.getId(), 0, "Download");
        menu.add(0, v.getId(), 0, "Upload");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Delete");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        return true;
    }
}
