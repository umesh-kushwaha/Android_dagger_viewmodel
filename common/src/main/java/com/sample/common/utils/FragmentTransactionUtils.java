package com.sample.common.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Umesh on 12-02-2018.
 */

public class FragmentTransactionUtils {

    private FragmentTransactionUtils(){

    }

    public static void addFragment(Fragment fragment, FragmentManager fragmentManager, int resId, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(resId, fragment, fragment.getClass().getSimpleName());
        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();
    }

    public static void replaceFragment(Fragment fragment, FragmentManager fragmentManager, int resId, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(resId, fragment, fragment.getClass().getSimpleName());
        if(addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();
    }
}
