package com.example.attendance;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StudentProfile extends AppCompatActivity {

    View myView;
    TextView stuNum;
    TextView stuFirstname;
    TextView stuLastname;
    TextView stuDob;
    TextView stuSex;
    TextView stuEmail;
    TextView stuPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stu_profile_fragment);

        //myView= getLayoutInflater().inflate(R.layout.student_profile, container, false);
    }
    public void initializer(){
        stuNum=(TextView)findViewById(R.id.sid);
        stuFirstname=(TextView)findViewById(R.id.sfname);
        stuLastname=(TextView)findViewById(R.id.slname);
        stuDob=(TextView)findViewById(R.id.sdob);
        stuSex=(TextView)findViewById(R.id.sex);
        stuEmail=(TextView)findViewById(R.id.semail);
        stuPhoneNum=(TextView)findViewById(R.id.sphone);

        stuNum.setText(MyProfile.getmUserId());
        stuFirstname.setText(MyProfile.getmFirstName());
        stuLastname.setText(MyProfile.getmLastName());
        stuDob.setText(MyProfile.getmDob());
        stuSex.setText(MyProfile.getmSex());
        stuEmail.setText(MyProfile.getmEmail());
        stuPhoneNum.setText(MyProfile.getmPhoneNum());
    }
    //Updating my profile
    public void updateStudentProfile(){
        //MyProfileFragment.update();
        //MyProfileFragmentAdditional.updateAdditionalFields();
        Toast.makeText(this, "Update Successful!", Toast.LENGTH_SHORT).show();
    }
}