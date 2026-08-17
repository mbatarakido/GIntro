package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UselessCode extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int countTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useless_code);


        Info.setText("Incorrect Attempts: ");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.home_grid);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void verify(String userName, String userPassword){
        if(userName.equals("MisterPotato") && userPassword.equals("123456")){
            Intent intent = new Intent(getApplicationContext(), StuBottomMenu.class);

            startActivity(intent);
        }else{
            countTimes++;
            Info.setText("Incorrect Attempts: " + countTimes);

            if(countTimes == 0){
                login.setEnabled(false);
            }
        }
    }
}