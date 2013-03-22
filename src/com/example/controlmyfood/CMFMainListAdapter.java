package com.example.controlmyfood;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.controlmyfood.vo.FoodBean;

public class CMFMainListAdapter extends ArrayAdapter<FoodBean>{

	private ArrayList<FoodBean> items;
	
	public CMFMainListAdapter(Context context, int textViewResourceId, ArrayList<FoodBean> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            //inflate a new view for your list item
            LayoutInflater vi = (LayoutInflater)parent.findViewById(R.id.listView).getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_row_layout, null);
        }
        FoodBean fb = items.get(position);
        if (fb != null) {
            //set text to view
            TextView tt = (TextView) v.findViewById(R.id.headerText);
            TextView bt = (TextView) v.findViewById(R.id.nameText);
            if (tt != null) {
                  tt.setText(fb.getFoodName());
            }
            if(bt != null){
                  bt.setText(fb.getFoodLocation());
            }
            GridView gv = (GridView) v.findViewById(R.id.datesGrid);
        }
        return v;
    }
	
}
