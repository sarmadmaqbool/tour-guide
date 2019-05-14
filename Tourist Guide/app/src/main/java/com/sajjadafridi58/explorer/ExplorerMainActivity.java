package com.sajjadafridi58.explorer;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sajjadafridi58.activities.AbbottabadActivity;
import com.sajjadafridi58.activities.AstoreActivity;
import com.sajjadafridi58.activities.BahawalpurActivity;
import com.sajjadafridi58.activities.ChitralActivity;
import com.sajjadafridi58.activities.FaisalabadActivity;
import com.sajjadafridi58.activities.GalyatActivity;
import com.sajjadafridi58.activities.GilgitActivity;
import com.sajjadafridi58.activities.HarripurActivity;
import com.sajjadafridi58.activities.IslamabadActivity;
import com.sajjadafridi58.activities.LahoreActivity;
import com.sajjadafridi58.activities.MansehraActivity;
import com.sajjadafridi58.activities.PeshawarActivity;
import com.sajjadafridi58.activities.ShanglaActivity;
import com.sajjadafridi58.activities.SkardoActivity;
import com.sajjadafridi58.activities.SwatActivity;
import com.sajjadafridi58.navigationappca.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class ExplorerMainActivity extends Fragment {

    View rootView;
    //private List<String> parentHeaderInformation;
    //private HashMap<String, List<String>> allChildItems;
    private ExpandableListView expandableListView;
    private ArrayList<String> parentHeaderInformation = new ArrayList<String>();
    private ArrayList<Object> allChildItems = new ArrayList<Object>();
    private ArrayList<Integer> imageList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.explorer_fragment, container, false);
        //expandableListView.setOnChildClickListener(this);
        loadImage();
        return rootView;
    }

    public void parentHeaderInformationAdded() {
        parentHeaderInformation.add("Gilgit Baltistan");
        parentHeaderInformation.add("Khyber Pakhtonkha");
        parentHeaderInformation.add("Murree and Galyat");
        parentHeaderInformation.add("Punjab");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        expandableListView.setDividerHeight(2);
        expandableListView.setGroupIndicator(null);
        expandableListView.setClickable(true);
        parentHeaderInformationAdded();
        returnGroupedChildItems();

        final MyExplorerExpandableAdaptar adapter = new MyExplorerExpandableAdaptar(getActivity().getApplicationContext(),parentHeaderInformation, allChildItems,imageList);
        adapter.setInflater((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE), getActivity());

        // Set the Adapter to expandableList
        expandableListView.setAdapter(adapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                callSelectedFragment(groupPosition,childPosition);

                return false;
            }
        });

        //allChildItems = returnGroupedChildItems();
        //ExplorerExpandableAdapter expandableListViewAdapter = new ExplorerExpandableAdapter(getActivity().getApplication(), allChildItems, parentHeaderInformation);
        //expandableListView.setAdapter(expandableListViewAdapter);
        //expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
    }

    private void loadImage()
    {
        imageList.add(R.drawable.sakardu_icon);
        imageList.add(R.drawable.gilgiy_icon);
        imageList.add(R.drawable.astroi_icon);
        imageList.add(R.drawable.abbotabbad_icon);
        imageList.add(R.drawable.chitral_icon);
        imageList.add(R.drawable.mansehra_icon);
        imageList.add(R.drawable.peshawar_icon);
        imageList.add(R.drawable.shangla_icon);
        imageList.add(R.drawable.swat_icon);
        imageList.add(R.drawable.harripur_icon);
        imageList.add(R.drawable.isb_icon);
        imageList.add(R.drawable.fiasalabad_icon);
        imageList.add(R.drawable.galyat_icon);
        imageList.add(R.drawable.lahore_icon);
        imageList.add(R.drawable.bwp_icon);



    }
    private void returnGroupedChildItems() {

        //HashMap<String, List<String>> childContent = new HashMap<String, List<String>>();

        ArrayList<String> gilgit = new ArrayList<String>();
        gilgit.add("Skardo-Region");
        gilgit.add("Gilgit-Region");
        gilgit.add("Astroi-Region");

        allChildItems.add(gilgit);

        ArrayList<String> khyber = new ArrayList<String>();

        khyber.add("Abbottabad");
        khyber.add("Chitral");
        khyber.add("Mansehra");
        khyber.add("Peshawar");
        khyber.add("Shangla");
        khyber.add("Swat");
        khyber.add("Harripurr");

        allChildItems.add(khyber);


        ArrayList<String> murree = new ArrayList<String>();
        murree.add("Galyat");
        allChildItems.add(murree);


        ArrayList<String> punjab = new ArrayList<String>();

        punjab.add("Islamabad");
        punjab.add("FaisalAbad");
        //punjab.add("Dera Ghazi Khan");
        punjab.add("Lahore");
        //punjab.add("SahiWal");
        //punjab.add("Multan");
        punjab.add("BahawalPur");
        //punjab.add("Rahim Yar Khan");

        allChildItems.add(punjab);
// add to hashmap with specified values
        /*childContent.put(parentHeaderInformation.get(0), gilgit);
        childContent.put(parentHeaderInformation.get(1), khyber);
        childContent.put(parentHeaderInformation.get(2), murree);
        childContent.put(parentHeaderInformation.get(3), punjab);*/
// return the hashmap
//        return childContent;

    }

    void callSelectedFragment(int groupPostion,int childPosition)
    {
        Intent myIntent=null;
        switch (groupPostion)
        {
            case 0:
                switch (childPosition)
                {
                    case 0:
                        myIntent = new Intent(getActivity().getApplicationContext(), SkardoActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 1:
                        myIntent = new Intent(getActivity().getApplicationContext(), GilgitActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 2:
                        myIntent = new Intent(getActivity().getApplicationContext(), AstoreActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                switch (childPosition)
                {
                    case 0:
                        myIntent = new Intent(getActivity().getApplicationContext(), AbbottabadActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 1:
                        myIntent = new Intent(getActivity().getApplicationContext(), ChitralActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 2:
                        myIntent = new Intent(getActivity().getApplicationContext(), MansehraActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 3:
                        myIntent = new Intent(getActivity().getApplicationContext(), PeshawarActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 4:
                        myIntent = new Intent(getActivity().getApplicationContext(), ShanglaActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 5:
                        myIntent = new Intent(getActivity().getApplicationContext(), SwatActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 6:
                        myIntent = new Intent(getActivity().getApplicationContext(), HarripurActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (childPosition)
                {
                    case 0:
                        myIntent = new Intent(getActivity().getApplicationContext(), GalyatActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        getActivity().startActivity(myIntent);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                switch (childPosition)
                {
                    case 0:
                        myIntent = new Intent(getActivity().getApplicationContext(), IslamabadActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 1:
                        myIntent = new Intent(getActivity().getApplicationContext(), FaisalabadActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 2:
                        myIntent = new Intent(getActivity().getApplicationContext(), LahoreActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    case 5:
                        myIntent = new Intent(getActivity().getApplicationContext(), BahawalpurActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getActivity().startActivity(myIntent);
                        break;
                    default:
                        break;

                }
                break;
            default:
                break;

        }
    }

}
