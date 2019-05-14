package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.chitral.ChaPage1;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage2;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage3;
import com.sajjadafridi58.kpkfragment.chitral.ChaPage4;
import com.sajjadafridi58.punjab.lahore.Lahore1;
import com.sajjadafridi58.punjab.lahore.Lahore2;
import com.sajjadafridi58.punjab.lahore.Lahore3;
import com.sajjadafridi58.punjab.lahore.Lahore4;
import com.sajjadafridi58.punjab.lahore.Lahore5;
import com.sajjadafridi58.punjab.lahore.Lahore6;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForLahore extends FragmentStatePagerAdapter {
    public PagerAdapterForLahore(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Lahore1();
                break;
            case 1:
                fragment = new Lahore2();
                break;
            case 2:
                fragment =new Lahore3();
                break;
            case 3:
                fragment =new Lahore4();
                break;
            case 4:
                fragment =new Lahore5();
                break;
            case 5:
                fragment =new Lahore6();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 6;
    }
}
