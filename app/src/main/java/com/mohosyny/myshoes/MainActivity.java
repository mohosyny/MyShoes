package com.mohosyny.myshoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHost_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
        Navigation.findNavController(this, R.id.navHost_fragment);
    }


    @Override
    public void onBackPressed() {

        if (Objects.requireNonNull(navController.getCurrentDestination()).getId() == navController.getGraph().getStartDestination())
            super.onBackPressed();
        else navController.navigateUp();
    }
}
