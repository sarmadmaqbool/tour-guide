package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.mansehra.MansPage1;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage2;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage3;
import com.sajjadafridi58.kpkfragment.mansehra.MansPage4;
import com.sajjadafridi58.punjab.lahore.faisalabad.Faisal1;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForFaisalAbad extends FragmentStatePagerAdapter {
    public PagerAdapterForFaisalAbad(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Faisal1();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 1;
    }
}
