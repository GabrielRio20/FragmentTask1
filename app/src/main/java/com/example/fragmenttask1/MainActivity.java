package com.example.fragmenttask1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button specButton;
    private boolean isFragmentDisplayed = true;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        specButton = findViewById(R.id.spec_button);
        getSupportActionBar().hide();

        specButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isFragmentDisplayed){
                    specButton.setText("See Specifications");
                    fragment = SimpleFragment.newInstance();
                }
                else{
                    specButton.setText("Nice Information!");
                    fragment = DetailFragment.newInstance();
                }
                displayFragment(fragment);
                isFragmentDisplayed = !isFragmentDisplayed;
            }
        });

        displayFragment(SimpleFragment.newInstance());
    }

    private void displayFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }
}