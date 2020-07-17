package com.example.esoftwaricareplica.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwaricareplica.R;
import com.example.esoftwaricareplica.adapters.StudentAdapter;
import com.example.esoftwaricareplica.ui.students.StudentFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.rvstudentlist);

        StudentAdapter studentAdapter = new StudentAdapter(root.getContext(), StudentFragment.studentsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(studentAdapter);

        return root;
    }
}