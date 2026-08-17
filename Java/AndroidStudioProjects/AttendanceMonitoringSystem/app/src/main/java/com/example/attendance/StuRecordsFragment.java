package com.example.attendance;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StuRecordsFragment extends Fragment {

    View view;
    String uid;
    TextView absentTextView;
    TableLayout stk;
    int count;
    List<Records> records=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.table_main, viewGroup, false);

        MyProfile profile=new MyProfile();
        uid=profile.getmUserId();
        new GetStudentRecords(uid).execute();
        return view;
    }

    public void init() {
        absentTextView = view.findViewById(R.id.absentTextView);
        Log.i("TABLE DATA : ", records.toString());
        stk = view.findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(getContext());
        TextView tv0 = new TextView(getContext());
        tv0.setText("Class ID   ");
        tv0.setTextSize(18);
        tv0.setTextColor(Color.CYAN);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(getContext());
        tv1.setText("  Class Name    ");
        tv1.setTextSize(18);
        tv1.setTextColor(Color.CYAN);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(getContext());
        tv2.setText("    Date&Time ");
        tv2.setTextSize(18);
        tv2.setTextColor(Color.CYAN);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(getContext());
        tv3.setText(" Status ");
        tv3.setTextSize(18);
        tv3.setTextColor(Color.CYAN);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        for (Records record : records) {
            TableRow tbrow = new TableRow(getContext());
            TextView t1v = new TextView(getContext());
            tbrow.setPadding(0,10,0,0);
            t1v.setText(record.getClassId());
            t1v.setTextSize(18);
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(getContext());
            t2v.setText(record.getClassName());
            t2v.setTextSize(18);
            t2v.setTextColor(Color.WHITE);
            tbrow.addView(t2v);
            TextView t3v = new TextView(getContext());
            t3v.setText(record.getMarkedTime());
            t3v.setTextColor(Color.WHITE);
            t3v.setTextSize(18);
            t3v.setPadding(20,0,0,0);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(getContext());
            t4v.setText(record.getStatus());
            t4v.setTextSize(18);
            t4v.setTextColor(Color.WHITE);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            if(record.getStatus().equals("N")){
                count++;
            }
            stk.addView(tbrow);
        }
        absentTextView.setText(count+"");
    }
    //Implementing the AsyncTask for url connection to get Records
    class GetStudentRecords extends AsyncTask<String, Void, String> {

        private String uid;
        GetStudentRecords(String uid){
            this.uid=uid;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {

            String urlString="http://"+getString(R.string.ip)+":8080/attendance/webapi/login/records/"+uid+"/";

            try{
                URL url=new URL(urlString);
                HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                try{
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuffer.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuffer.toString();
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
            String classId;
            String className;
            String markedTime;
            String status;

            Log.i("INFO", response);
            try{
                JSONArray students=new JSONArray(response);

                //Records record=new Records();
                for(int i=0; i<students.length(); i++){

                    JSONObject object=students.getJSONObject(i);
                    classId=object.getInt("classId")+"";
                    markedTime=object.getString("markedTime");
                    status=object.getString("status");
                    className=object.getString("className");

                    Records record=new Records();

                    record.setClassId(classId);
                    record.setMarkedTime(markedTime);
                    record.setStatus(status);
                    record.setClassName(className);
                    records.add(record);
                }
                init();
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
