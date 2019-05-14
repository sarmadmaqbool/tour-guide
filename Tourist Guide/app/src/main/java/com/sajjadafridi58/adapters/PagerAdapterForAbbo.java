package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage1;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage2;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage3;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage4;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage1;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage2;
import com.sajjadafridi58.kpkfragment.abbottabad.AbPage3;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForAbbo extends FragmentStatePagerAdapter {
    public PagerAdapterForAbbo(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AbPage1();
                break;
            case 1:
                fragment = new AbPage2();
                break;
            case 2:
                fragment = new AbPage3();
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
