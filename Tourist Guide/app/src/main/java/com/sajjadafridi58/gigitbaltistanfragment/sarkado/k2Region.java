package com.sajjadafridi58.gigitbaltistanfragment.sarkado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sajjadafridi58.navigationappca.GetSpecificePlace;
import com.sajjadafridi58.navigationappca.GoogleActivity;
import com.sajjadafridi58.navigationappca.R;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class k2Region extends Fragment {

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.k_2, container, false);
        textView= (TextView) rootView.findViewById(R.id.main_heading);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), GetSpecificePlace.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
