package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;

    Button loginBtn;
    private String username, password;
    MyProfile profile=new MyProfile();

    private String TAG = Login.class.getSimpleName(); //need more information on the function of this TAG

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        //When the button is clicked go to main page
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=usernameEditText.getText().toString();
                password=passwordEditText.getText().toString();

                new StuLoginTask(username, password).execute();
            }
        });
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    //Implementing the AsyncTask for Student Login url connection
    class StuLoginTask extends AsyncTask<String, Void, String>{

        ProgressDialog mProgressDialog;
        private String username;
        private String password;

        StuLoginTask(String uname, String pass){
            username=uname;
            password=pass;
        }

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Login.this,
                    "", "Please wait...");
        }

        @Override
        protected String doInBackground(String... strings) {

            String urlString="http://"+getString(R.string.ip)+":8080/attendance/webapi/login/stulogin/"+username+"/"+password+"/";

            try{
                URL url=new URL(urlString);
                HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                try{
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }finally {
                    urlConnection.disconnect();
                }
            }catch (Exception e){
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String response) {
            String userID;
            String pass;
            String stuFirstname;
            String stuLastname;
            String stuDob;
            String stuSex;
            String stuEmail;
            String tchrId;

            Log.i("INFO", response);
            try {
                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
                userID = object.getInt("id")+"";
                pass=object.getString("stu_password");
                stuFirstname=object.getString("firstname");
                stuLastname=object.getString("lastname");
                stuDob=object.getString("dob");
                stuSex=object.getString("sex");
                stuEmail=object.getString("email");
                tchrId=object.getString("teacher_id");

                if((userID.equals(username)) && (pass.equals(password))){
                    profile.setmUserId(userID);
                    profile.setmFirstName(stuFirstname);
                    profile.setmLastName(stuLastname);
                    profile.setmDob(stuDob);
                    profile.setmSex(stuSex);
                    profile.setmEmail(stuEmail);
                    profile.setmTeacherId(tchrId);

                    Intent intent = new Intent(getApplicationContext(), StuBottomMenu.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                }
            } catch (JSONException e) {
                e.printStackTrace();
           }
        }
    }
}
