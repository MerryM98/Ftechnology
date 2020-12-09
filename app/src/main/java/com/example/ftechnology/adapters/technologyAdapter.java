package com.example.ftechnology.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ftechnology.R;
import com.example.ftechnology.models.TechnologyModel;

import java.util.ArrayList;

public class technologyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TechnologyModel> modelArrayList;

    public technologyAdapter(Context context, ArrayList<TechnologyModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public TechnologyModel getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.tehnology_list, viewGroup, false);
        }
        TextView tv_techology_type = view.findViewById(R.id.tv_techology_type);
        TextView tv_techology_description = view.findViewById(R.id.tv_techology_description);

        tv_techology_type.setText(getItem(position).getType());
        tv_techology_description.setText(getItem(position).getDescription());

        return view;
    }
}
