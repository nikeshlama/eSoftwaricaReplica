package com.example.esoftwaricareplica.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwaricareplica.R;
import com.example.esoftwaricareplica.models.Students;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyHolder> {

    Context context;
    List<Students> studentsList;

    public StudentAdapter(Context context, List<Students> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_profile, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyHolder holder, final int position) {
        Students students = studentsList.get(position);
        holder.imgprofile.setImageResource(students.getImg());
        holder.name.setText(students.getFullname());
        holder.age.setText(students.getAge());
        holder.address.setText(students.getAddress());
        holder.gender.setText(students.getGender());
        holder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentsList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgprofile, imgdelete;
        TextView name, age, address, gender;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imgprofile = itemView.findViewById(R.id.profileimg);
            imgdelete = itemView.findViewById(R.id.delete);
            name = itemView.findViewById(R.id.stuname);
            age = itemView.findViewById(R.id.stuage);
            address = itemView.findViewById(R.id.stuaddress);
            gender = itemView.findViewById(R.id.stugender);

        }
    }
}
