package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.harripur.Harripur1;
import com.sajjadafridi58.kpkfragment.harripur.Harripur2;
import com.sajjadafridi58.punjab.lahore.bwp.bwp1;
import com.sajjadafridi58.punjab.lahore.bwp.bwp2;
import com.sajjadafridi58.punjab.lahore.bwp.bwp3;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForBwp extends FragmentStatePagerAdapter {
    public PagerAdapterForBwp(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new bwp1();
                break;
            case 1:
                fragment = new bwp2();
                break;
            case 2:
                fragment = new bwp3();
                break;
            default:
                break;
        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 3;
    }
}
