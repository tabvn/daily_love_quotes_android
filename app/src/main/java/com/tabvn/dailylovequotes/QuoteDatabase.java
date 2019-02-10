package com.tabvn.dailylovequotes;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {Quote.class}, version = 1)
public abstract class QuoteDatabase extends RoomDatabase {

    private static QuoteDatabase instance;

    public abstract QuoteDao quoteDao();

    public static synchronized QuoteDatabase getInstance(Context context) {


        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), QuoteDatabase.class, "quote_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };



    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private QuoteDao quoteDao;

        private PopulateDbAsyncTask(QuoteDatabase db) {
            quoteDao = db.quoteDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.i("toan", "how are you??!!!!!!!");
            quoteDao.insert(new Quote(1, "Title 1", "Description", "http://tabvn.com/image.png", "http://tabvn.com", "new", "blue", 0));
            quoteDao.insert(new Quote(2, "Title 2", "Description", "http://tabvn.com/image.png", "http://tabvn.com", "new", "blue", 0));
            quoteDao.insert(new Quote(3, "Title 2", "Description", "http://tabvn.com/image.png", "http://tabvn.com", "new", "blue", 0));


            return null;
        }
    }


}
