package com.example.attendance;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class StuProfileFragment extends Fragment {

    View myView;
    TextView stuNum;
    TextView stuFirstname;
    TextView stuLastname;
    TextView stuDob;
    TextView stuSex;
    TextView stuEmail;
    TextView stuPhoneNum;
    TextView stuFullName;
    Button editBtn;
    Button logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView= getLayoutInflater().inflate(R.layout.stu_profile_fragment, container, false);

        stuNum=myView.findViewById(R.id.sid);
        stuFirstname=myView.findViewById(R.id.sfname);
        stuLastname=myView.findViewById(R.id.slname);
        stuDob=myView.findViewById(R.id.sdob);
        stuSex=myView.findViewById(R.id.sex);
        stuEmail=myView.findViewById(R.id.semail);
        stuPhoneNum=myView.findViewById(R.id.sphone);
        editBtn=myView.findViewById(R.id.editBtn);
        logoutBtn=myView.findViewById(R.id.logoutBtn);
        stuFullName=myView.findViewById(R.id.sfullname);

        initializer();

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), EditProfile.class);
                startActivity(intent);
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomething();
            }
        });
        return myView;
    }

    public void initializer(){
        stuNum.setText(MyProfile.getmUserId());
        stuFirstname.setText(MyProfile.getmFirstName());
        stuLastname.setText(MyProfile.getmLastName());
        stuFullName.setText(MyProfile.getmFirstName()+" "+MyProfile.getmLastName());
        stuDob.setText(MyProfile.getmDob());
        stuSex.setText(MyProfile.getmSex());
        stuEmail.setText(MyProfile.getmEmail());
        stuPhoneNum.setText(MyProfile.getmPhoneNum());
    }
    public void doSomething(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Intent intent=new Intent(getContext(), Logout.class);
                        startActivity(intent);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Do you want to Exit?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    //Updating my profile, add code for updating user profile as required
    public void updateStudentProfile(){
        //MyProfileFragment.update();
        //MyProfileFragmentAdditional.updateAdditionalFields();
        //Toast.makeText(this, "Update Successful!", Toast.LENGTH_SHORT).show();
    }

}
