package com.example.nguyen.mission2.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission2.R;

public class FragmentDetailOne extends Fragment {

    private View rootView;
    private TextView tvTitle, tvLeaveFragment;
    private LinearLayout lnParent;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_child, container, false);

        tvTitle = rootView.findViewById(R.id.tv_title);
        tvLeaveFragment = rootView.findViewById(R.id.tv_leave_fragment);
        lnParent = rootView.findViewById(R.id.ln_parent);
        lnParent.setBackground(getResources().getDrawable(R.color.colorBlue));

//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
//                , LinearLayout.LayoutParams.MATCH_PARENT);
//
//        lnParent.setLayoutParams(params);
        lnParent.setGravity(Gravity.CENTER);

        tvTitle.setText(FragmentDetailOne.class.getSimpleName());
        tvLeaveFragment.setText("Go to Detail One 2");

        tvLeaveFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_main
                        , new FragmentDetailOne2()
                        , FragmentDetailOne2.class.getSimpleName());
                transaction.addToBackStack(FragmentDetailOne2.class.getSimpleName());
                transaction.commit();
            }
        });

        return rootView;
    }
}
