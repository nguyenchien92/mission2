package com.example.nguyen.mission2.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission2.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentDetailFour extends Fragment {

    private View rootView;
    private TextView tvTitle,tvLeaveFragment;
    private LinearLayout lnParent;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_child, container, false);

        tvTitle = rootView.findViewById(R.id.tv_title);
        tvLeaveFragment = rootView.findViewById(R.id.tv_leave_fragment);

        tvTitle.setText(FragmentDetailFour.class.getSimpleName());
        tvLeaveFragment.setVisibility(View.GONE);



        TabLayout tabLayout = getActivity().findViewById(R.id.tab);
        tabLayout.setVisibility(View.GONE);

        lnParent = rootView.findViewById(R.id.ln_parent);
        lnParent.setBackground(getResources().getDrawable(R.color.colorBlue));
        lnParent.setGravity(Gravity.CENTER);

        return rootView;
    }
}
