package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.galyatfragment.GlytPage1;
import com.sajjadafridi58.galyatfragment.GlytPage2;
import com.sajjadafridi58.galyatfragment.GlytPage3;
import com.sajjadafridi58.galyatfragment.GlytPage4;
import com.sajjadafridi58.galyatfragment.GlytPage5;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForGalyat extends FragmentStatePagerAdapter {
    public PagerAdapterForGalyat(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new GlytPage1();
                break;
            case 1:
                fragment = new GlytPage2();
                break;
            case 2:
                fragment = new GlytPage3();
                break;
            case 3:
                fragment = new GlytPage4();
                break;
            case 4:
                fragment = new GlytPage5();
                break;
            default:
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
