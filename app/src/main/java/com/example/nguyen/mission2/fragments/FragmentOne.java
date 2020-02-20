package com.example.nguyen.mission2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission2.R;

public class FragmentOne extends Fragment {

    private View rootView;
    private TextView tvTitle,tvLeaveFragment;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_child, container, false);

        tvTitle = rootView.findViewById(R.id.tv_title);
        tvLeaveFragment = rootView.findViewById(R.id.tv_leave_fragment);

        tvTitle.setText(FragmentOne.class.getSimpleName());
        tvLeaveFragment.setText("Next Fragment");

        tvLeaveFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_main
                ,new FragmentDetailOne(),FragmentDetailOne.class.getSimpleName());
                transaction.addToBackStack(FragmentDetailOne.class.getSimpleName());
                transaction.commit();
            }
        });

        return rootView;
    }
}
