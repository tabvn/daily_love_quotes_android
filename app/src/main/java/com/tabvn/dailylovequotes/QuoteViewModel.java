package com.tabvn.dailylovequotes;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

public class QuoteViewModel extends AndroidViewModel {

    private QuoteRepository quoteRepository;

    public QuoteViewModel(@NonNull Application application) {
        super(application);
        quoteRepository = new QuoteRepository(application);
    }

    public void insert(Quote... quotes) {
        quoteRepository.insert(quotes);
    }

    public void deleteAll() {
        quoteRepository.deleteAll();
    }

    public LiveData<List<Quote>> quotesByCategory(String category) {

        return quoteRepository.getQuotesByCategory(category);
    }

    public LiveData<List<Quote>> quotesByColor(String color) {
        return quoteRepository.getQuotesByColor(color);
    }


}
