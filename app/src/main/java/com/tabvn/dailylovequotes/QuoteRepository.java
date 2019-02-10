package com.tabvn.dailylovequotes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class QuoteRepository {

    private QuoteDao quoteDao;


    public QuoteRepository(Application application) {

        QuoteDatabase quoteDatabase = QuoteDatabase.getInstance(application);
        quoteDao = quoteDatabase.quoteDao();

    }

    public void insert(Quote... quotes) {
        new InsertQuoteAsyncTask(quoteDao).execute(quotes);
    }

    public void deleteAll() {

        new DeleteAllQuoteAsyncTask(quoteDao).execute();
    }


    public LiveData<List<Quote>> getQuotesByCategory(String category) {
        return quoteDao.getAllByCategory(category);
    }

    public LiveData<List<Quote>> getQuotesByColor(String color) {
        return quoteDao.getAllByColor(color);
    }

    private static class InsertQuoteAsyncTask extends AsyncTask<Quote, Void, Void> {

        private QuoteDao quoteDao;

        private InsertQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Quote... quotes) {
            quoteDao.insert(quotes);
            return null;
        }
    }

    private static class DeleteAllQuoteAsyncTask extends AsyncTask<Void, Void, Void> {

        private QuoteDao quoteDao;

        private DeleteAllQuoteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            quoteDao.deleteAll();
            return null;
        }
    }
}
