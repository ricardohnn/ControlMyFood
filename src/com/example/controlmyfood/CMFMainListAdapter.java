package com.example.controlmyfood;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CMFMainListAdapter extends ArrayAdapter<String>{

	private ArrayList<String> items;
	
	public CMFMainListAdapter(Context context, int textViewResourceId, ArrayList<String> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            //inflate a new view for your list item
            LayoutInflater vi = (LayoutInflater)convertView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_row_layout, null);
        }
        String o = items.get(position);
        if (o != null) {
            //set text to view
            TextView tt = (TextView) v.findViewById(R.id.headerText);
            TextView bt = (TextView) v.findViewById(R.id.nameText);
            if (tt != null) {
                  tt.setText("Name: "+o);
            }
            if(bt != null){
                  bt.setText("Status: "+ o);
            }
        }
        return v;
    }
	
}
