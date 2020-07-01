package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmdemo.models.Deal;
import com.example.mvvmdemo.viewmodels.MainViewModel;
import com.example.mvvmdemo.viewmodels.ViewModelFactory;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModelFactory = new ViewModelFactory(getApplication());

        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
        viewModel.getDeals().observe(this, new Observer<List<Deal>>() {
            @Override
            public void onChanged(List<Deal> deals) {
                for (Deal deal: deals) {
                    Log.d("MainActivity", "Deal: " + deal.getAnimal());
                }
            }
        });

    }
}
