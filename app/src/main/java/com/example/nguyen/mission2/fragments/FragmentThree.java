package com.example.nguyen.mission2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nguyen.mission2.R;

public class FragmentThree extends Fragment {
    private View rootView;
    private TextView tvTitle,tvLeaveFragment;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_child, container, false);

        tvTitle = rootView.findViewById(R.id.tv_title);
        tvLeaveFragment = rootView.findViewById(R.id.tv_leave_fragment);

        tvTitle.setText(FragmentThree.class.getSimpleName());

        tvLeaveFragment.setVisibility(View.GONE);

        return rootView;
    }
}
