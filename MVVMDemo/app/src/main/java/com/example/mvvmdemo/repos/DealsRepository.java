package com.example.mvvmdemo.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvmdemo.dao.DealsDao;
import com.example.mvvmdemo.database.DealsDatabase;
import com.example.mvvmdemo.models.Deal;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DealsRepository {

    private DealsDao dealsDao;

    public DealsRepository(Application application) {
        this.dealsDao = DealsDatabase.getInstance(application).getDealsDao();
    }

    public void addDeal(Deal deal) {
        new InsertAsyncTask(this.dealsDao).execute(deal);
    }

    public void updateDeal(Deal deal) {
        new UpdateAsyncTask(this.dealsDao).execute(deal);
    }

    public LiveData<List<Deal>> getDeals() {
        try {
            return new GetDealsAsyncTask(this.dealsDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteDeal(Deal deal) {
        new DeleteAsyncTask(this.dealsDao).execute(deal);
    }

    private static class InsertAsyncTask extends AsyncTask<Deal, Void, Void> {

        private DealsDao dealsDao;

        public InsertAsyncTask(DealsDao dealsDao) {
            this.dealsDao = dealsDao;
        }

        @Override
        protected Void doInBackground(Deal... deals) {
            this.dealsDao.insertDeal(deals[0]);

            return null;
        }

    }


    private static class UpdateAsyncTask extends AsyncTask<Deal, Void, Void> {

        private DealsDao dealsDao;

        public UpdateAsyncTask(DealsDao dealsDao) {
            this.dealsDao = dealsDao;
        }

        @Override
        protected Void doInBackground(Deal... deals) {
            this.dealsDao.updateDeal(deals[0]);

            return null;
        }
    }


    private static class GetDealsAsyncTask extends AsyncTask<Void, Void, LiveData<List<Deal>>> {

        private DealsDao dealsDao;

        public GetDealsAsyncTask(DealsDao dealsDao) {
            this.dealsDao = dealsDao;
        }

        @Override
        protected LiveData<List<Deal>> doInBackground(Void... voids) {
            return this.dealsDao.getDeals();
        }
    }


    private static class DeleteAsyncTask extends AsyncTask<Deal, Void, Void> {

        private DealsDao dealsDao;

        public DeleteAsyncTask(DealsDao dealsDao) {
            this.dealsDao = dealsDao;
        }

        @Override
        protected Void doInBackground(Deal... deals) {
            this.dealsDao.deleteDeal(deals[0]);

            return null;
        }
    }

}
