package edu.sabanciuniv.cs310.sumall;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.*;
import android.view.*;


public class cartitemadapter  extends RecyclerView.Adapter<cartitemadapter.ViewHolder>{


    private ArrayList<cartitem> list = new ArrayList<cartitem>();
    private Context context;

    public cartitemadapter(ArrayList<cartitem> list) {
        this.list = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, count;
        public ImageView image;
        public Button btn;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView9);
            price = view.findViewById(R.id.textView11);
            count = view.findViewById(R.id.textView12);
            image = view.findViewById(R.id.imageView4);
            btn = view.findViewById(R.id.button);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartitem, parent, false);

        return  new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        cartitem cartitem = list.get(position);
        holder.name.setText(cartitem.name);
        holder.price.setText(cartitem.price);
        holder.count.setText(cartitem.count);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }







}

