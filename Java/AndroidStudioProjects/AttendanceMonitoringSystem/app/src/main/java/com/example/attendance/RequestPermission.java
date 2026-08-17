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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestPermission extends AppCompatActivity {

    Button requestBtn;
    EditText requestText;
    String request;
    String stuid, perm, tchrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_permission);

        requestBtn=(Button)findViewById(R.id.sendRequestBtn);
        requestText=(EditText)findViewById(R.id.requestEditText);

        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request=requestText.getText()+"";

                Requests.setsId(MyProfile.getmUserId());
                Requests.settId(MyProfile.getmTeacherId());
                Requests.setRequest(request);

                JSONObject attendance = new JSONObject();
                try {
                    attendance.put("stuId", Requests.getsId());
                    attendance.put("request", Requests.getRequest());
                    attendance.put("tchrId", Requests.gettId());

                    new SendPermission().execute(attendance.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new SendPermission().execute(stuid, perm, tchrid);
            }
        });
    }
    class SendPermission extends AsyncTask<String, Void, String> {
        ProgressDialog mProgressDialog;
        private String res;

        @Override
        protected void onPreExecute() {
            //mProgressDialog = ProgressDialog.show(StuGetLocation.this,
            // "", "Please wait...");
        }

        @Override
        protected String doInBackground(String... params) {

            String url="http://"+getString(R.string.ip)+":8080/attendance/webapi/login/request";
            String data = "";

            HttpURLConnection httpURLConnection = null;
            try{
                httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setRequestMethod("POST");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(params[0]);
                wr.flush();
                wr.close();

                //int status = httpURLConnection.getResponseCode();
                //if(status < 400) {
                   // InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream());
                   //Log.i("InputStreamReader", isr.toString());
                //} else{
                    //InputStreamReader esr = new InputStreamReader(httpURLConnection.getErrorStream());
                    //Log.i("InputStreamReaderError", esr.toString());

                //}

                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(in);

                int inputStreamData = inputStreamReader.read();
                while (inputStreamData != -1) {
                    char current = (char) inputStreamData;
                    inputStreamData = inputStreamReader.read();
                    data += current;

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            Log.i("ATTENDANCE", data);
            Log.e("TAGDATA", data);
            return data;
        }

        protected void onPostExecute(String res) {
            //"Here you get response from server in res"
            Toast.makeText(RequestPermission.this, "Request Sent", Toast.LENGTH_SHORT).show();
        }
    }
}