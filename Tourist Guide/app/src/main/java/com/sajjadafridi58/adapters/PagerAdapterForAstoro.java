package com.sajjadafridi58.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage1;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage2;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage3;
import com.sajjadafridi58.gigitbaltistanfragment.astoreregion.AsPage4;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page2;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page3;
import com.sajjadafridi58.gigitbaltistanfragment.gilgitregion.Page4;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class PagerAdapterForAstoro extends FragmentStatePagerAdapter {
    public PagerAdapterForAstoro(FragmentManager fm) {
        super(fm);
    }

    /*change here*/
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AsPage1();
                break;
            case 1:
                fragment = new AsPage2();
                break;
            case 2:
                fragment = new AsPage3();
                break;
            case 3:
                fragment = new AsPage4();
                break;
            default:
                break;

        }
        return fragment;
    }

        @Override
    public int getCount() {
        return 4;
    }
}
