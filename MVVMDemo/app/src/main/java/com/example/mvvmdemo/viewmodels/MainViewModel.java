package com.example.mvvmdemo.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.models.Deal;
import com.example.mvvmdemo.repos.DealsRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private DealsRepository dealsRepository;

    public MainViewModel(Application application) {
        super(application);
        this.dealsRepository = new DealsRepository(application);
    }

    public void addDeal(Deal deal) {
        dealsRepository.addDeal(deal);
    }

    public void updateDeal(Deal deal) {
        dealsRepository.updateDeal(deal);
    }

    public void deleteDeal(Deal deal) {
        dealsRepository.deleteDeal(deal);
    }

    public LiveData<List<Deal>> getDeals() {
        return dealsRepository.getDeals();
    }

    // TODO: explain the concept of a viewModel factory
    // TODO: add logic to display all deals
    // TODO: add logic and UI to add deals

}
