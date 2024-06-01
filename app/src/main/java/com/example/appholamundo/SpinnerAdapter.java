package com.example.appholamundo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.view.menu.MenuView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerData> {
    int groupID;
    Activity Context;
    ArrayList<SpinnerData> lst;
    LayoutInflater inflater;

    public SpinnerAdapter(Activity Context, int groupID, int id, ArrayList<SpinnerData> lst) {
        super(Context, id, lst);
        this.lst = lst;
        inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupID = groupID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupID, parent, false);

        ImageView img = (ImageView) itemView.findViewById(R.id.imgCategoria);
        img.setImageResource(lst.get(position).getImageID());

        TextView textCategoria = (TextView) itemView.findViewById(R.id.lblCategorias);
        textCategoria.setText(lst.get(position).getTextCategoria());

        TextView textDescription = (TextView) itemView.findViewById(R.id.lblDescripcion);
        textCategoria.setText(lst.get(position).getTextDescripcion());

        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

}
