package edu.sabanciuniv.cs310.sumall;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Cemges on 5/6/2018.
 */

public class CartFragment extends Fragment implements View.OnClickListener{


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tt = (Button) getView().findViewById(R.id.buttoncheckout);
        tt.setOnClickListener(this);



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.cart, container, false);

        //now you must initialize your list view

        RecyclerView recyclerView = view.findViewById(R.id.recyclercart);


        //EDITED Code
        ArrayList<cartitem> items = new ArrayList<cartitem>();
        items.add(new cartitem(1,2,"stuff"));
        items.add(new cartitem( 2, 5, "something"));





        cartitemadapter mAdapter = new cartitemadapter(items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        return view;
    }



    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.buttoncheckout:
                fragment = new PaymentFragment();
                break;


        }
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }



}
