package com.example.esoftwaricareplica.ui.students;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.esoftwaricareplica.R;
import com.example.esoftwaricareplica.models.Students;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    EditText fullname, age, address;
    RadioGroup radioGroup;
    Button btnsave;
    String nametxt, agetxt, addresstxt, gender;
    View root;
    int img;

    public StudentFragment() {
        // Required empty public constructor
    }

    public static List<Students> studentsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_student, container, false);

        fullname = root.findViewById(R.id.fullname);
        age = root.findViewById(R.id.age);
        radioGroup = root.findViewById(R.id.rggender);
        address = root.findViewById(R.id.address);
        btnsave = root.findViewById(R.id.btnsave);

        radioGroup.setOnCheckedChangeListener(this);
        btnsave.setOnClickListener(this);

        return root;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rbmale) {
            img = R.drawable.male;
            gender = "Male";
        }

        if (i == R.id.rbfemale) {
            img = R.drawable.female;
            gender = "Female";
        }
        if (i == R.id.others) {
            img = R.drawable.other;
            gender = "Others";
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnsave) {
            addStudent();
        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(nametxt)) {
            fullname.setError("Please enter your name!");
            fullname.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(agetxt)) {
            age.setError("Please enter your age!");
            age.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(root.getContext(), "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(addresstxt)) {
            address.setError("Please enter your address!");
            address.requestFocus();
            return false;
        }

        return true;
    }

    private void addStudent() {
        nametxt = fullname.getText().toString();
        agetxt = age.getText().toString();
        addresstxt = address.getText().toString();
        if (validate()) {
            studentsList.add(new Students(nametxt, agetxt, gender, addresstxt, img));
            Toast.makeText(root.getContext(), "Student Added!", Toast.LENGTH_SHORT).show();
        }
    }

}
