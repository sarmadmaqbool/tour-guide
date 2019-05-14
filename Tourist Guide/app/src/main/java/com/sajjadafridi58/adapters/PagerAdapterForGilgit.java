package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage1;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page1;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page2;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page3;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page4;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page5;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page6;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page7;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForGilgit extends FragmentStatePagerAdapter {
    public PagerAdapterForGilgit(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Page1();
                break;
            case 1:
                fragment = new Page2();
                break;
            case 2:
                fragment = new Page3();
                break;
            case 3:
                fragment = new Page4();
                break;
            case 4:
                fragment = new Page5();
                break;
            case 5:
                fragment = new Page6();
                break;
            case 6:
                fragment = new Page7();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 7;
    }
}
