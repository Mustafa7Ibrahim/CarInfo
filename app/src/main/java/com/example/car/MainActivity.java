package com.example.car;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked
{

    Button btnCarInfo ,btnOwnerInfo ;
    TextView Name , Tel , Model;
    ImageView Make ;
    FragmentManager fragmentManager ;
    Fragment buttonFrag , listFrag , carInfoFrag , OwnerInfoFrag ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarInfo = findViewById(R.id.car);
        btnOwnerInfo = findViewById(R.id.owner);
        Name = findViewById(R.id.tvName);
        Tel = findViewById(R.id.tvTel);
        Model = findViewById(R.id.tvModel);
        Make = findViewById(R.id.ivMake);

        fragmentManager = getSupportFragmentManager();

        buttonFrag = fragmentManager.findFragmentById(R.id.ButtonFrag);
        listFrag = fragmentManager.findFragmentById(R.id.ListFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.CarInfoFrag);
        OwnerInfoFrag = fragmentManager.findFragmentById(R.id.OwnerFrag);

        fragmentManager.beginTransaction()
                .show(buttonFrag)
                .show(listFrag)
                .show(carInfoFrag)
                .hide(OwnerInfoFrag)
                .commit();


        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .show(carInfoFrag)
                        .hide(OwnerInfoFrag)
                        .commit();


            }
        });

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .hide(carInfoFrag)
                        .show(OwnerInfoFrag)
                        .commit();


            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {

        Name.setText(ApplicationClass.cars.get(index).getOwnerName());
        Model.setText(ApplicationClass.cars.get(index).getModel());
        Tel.setText(ApplicationClass.cars.get(index).getOwnerTel());

        switch (ApplicationClass.cars.get(index).getMake()) {
            case "Mercedes":
                Make.setImageResource(R.drawable.mercedes);
                break;
            case "Nissan":
                Make.setImageResource(R.drawable.nissan);
                break;
            default:
                Make.setImageResource(R.drawable.volkswagen);
                break;
        }

    }
}
