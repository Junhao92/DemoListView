package com.example.a14049472.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects) {
        super(context, resource, objects);
        // store the food that is passed to this adapter

        food = objects;
        // store Context object as we would need to use it later
        this.context = context;

    }

    // getView() is the method listview will call to get the
    // view object everytime listview need a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // the usual way to get the LayoutInflater object to
        // "inflate" the XML file into a View object_

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for View object

        View rowView = inflater.inflate(R.layout.row, parent, false);

        // get the TextView object
        tvFoodName = (TextView) rowView.findViewById(R.id.FoodName);

        // get the ImageView object
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);

        // The parameter "position" is the index of the
        // row ListView is requesting
        // we get back the food at the same index

        Food currentFood = food.get(position);
        //set the TextView to show the food

        tvFoodName.setText(currentFood.getName());
        // set the image to star or no star accordingly

        if (currentFood.isStar()) {
            ivStar.setImageResource(R.drawable.star);
        } else {
            ivStar.setImageResource(R.drawable.nostar);
        }
        // return the nicely done up View to the listview
        return rowView;
    }
}
