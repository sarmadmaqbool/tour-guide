package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;
import com.sajjadafridi58.kpkfragment.harripur.Harripur1;
import com.sajjadafridi58.kpkfragment.harripur.Harripur2;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForHarripur extends FragmentStatePagerAdapter {
    public PagerAdapterForHarripur(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Harripur1();
                break;
            case 1:
                fragment = new Harripur2();
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 2;
    }
}
