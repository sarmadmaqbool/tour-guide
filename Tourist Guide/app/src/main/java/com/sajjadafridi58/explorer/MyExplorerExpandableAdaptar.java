package com.sajjadafridi58.explorer;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sajjadafridi58.navigationappca.R;

import java.util.ArrayList;

/**
 * Created by Sajjad on 5/17/2016.
 */
public class MyExplorerExpandableAdaptar extends BaseExpandableListAdapter {
    Context ctx;
    private Activity activity;
    private ArrayList<Object> childtems;
    private LayoutInflater inflater;
    private ArrayList<String> parentItems, child;
    private ArrayList<Integer> imageList;

    public MyExplorerExpandableAdaptar(Context ctx, ArrayList<String> parentItems, ArrayList<Object> childtems,ArrayList<Integer> imageList) {
        this.parentItems = parentItems;
        this.childtems = childtems;
        this.ctx = ctx;
        this.imageList=imageList;
    }

    public void setInflater(LayoutInflater inflater, Activity activity) {
        this.inflater = inflater;
        this.activity = activity;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.explorer_parent, null);
        }

        ((CheckedTextView) convertView).setText(parentItems.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        child = (ArrayList<String>) childtems.get(groupPosition);
        TextView textView = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.explorer_child, null);
        }

        // get the textView reference and set the value
        ImageView img= (ImageView) convertView.findViewById(R.id.image_view);
        textView = (TextView) convertView.findViewById(R.id.child_layout);
        textView.setText(child.get(childPosition));
        img.setImageResource(imageList.get(childPosition));

        // set the ClickListener to handle the click event on child item
        /*convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent=null;
                String selected=child.get(childPosition).toUpperCase();
                Toast.makeText(ctx, "You select "+selected, Toast.LENGTH_SHORT).show();
                switch (child.get(childPosition).toLowerCase()) {
                    case "skardo-region":
                        myIntent = new Intent(activity.getApplicationContext(), SkardoActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(myIntent);
                        break;
                    case "gilgit-region":
                        myIntent = new Intent(activity.getApplicationContext(), GilgitActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(myIntent);
                        break;
                    case "astroi-region":
                        myIntent = new Intent(activity.getApplicationContext(), AstoreActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(myIntent);
                        break;
                    case "abbottabad":
                        myIntent = new Intent(activity.getApplicationContext(), AbbottabadActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        ctx.startActivity(myIntent);
                        break;
                    case "chitral":
                        myIntent = new Intent(activity.getApplicationContext(), ChitralActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    case "galyat":
                        myIntent = new Intent(activity.getApplicationContext(), GalyatActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    case "mansehra":
                        myIntent = new Intent(activity.getApplicationContext(), MansehraActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    case "peshawar":
                        myIntent = new Intent(activity.getApplicationContext(), PeshawarActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    case "shangla":
                        myIntent = new Intent(activity.getApplicationContext(), ShanglaActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                       break;
                    case "swat":
                        myIntent = new Intent(activity.getApplicationContext(), SwatActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    case "harripurr":
                        myIntent = new Intent(activity.getApplicationContext(), HarripurActivity.class);
                        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// activity outof bound called
                        ctx.startActivity(myIntent);
                        break;
                    default:
                        break;
                }*/
    /*}
        });
    */
        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((ArrayList<String>) childtems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.parentItems.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
