package com.example.nguyen.mission2.models;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission2.network.BackStack;

public class MoveTo {

    public static void nextFragment(FragmentManager mn, Fragment fragment, int resId, BackStack backStack) {

        if (backStack.equals(BackStack.GO_BACK_STACK)) {
            FragmentTransaction transaction = mn.beginTransaction();
            transaction.replace(resId, fragment, fragment.getTag());
            transaction.addToBackStack(fragment.getTag());
            transaction.commit();
        } else if (backStack.equals(BackStack.WITHOUT_BACK_STACK)) {
            FragmentTransaction transaction = mn.beginTransaction();
            transaction.replace(resId, fragment, fragment.getTag());
            transaction.commit();
        }
    }
}
