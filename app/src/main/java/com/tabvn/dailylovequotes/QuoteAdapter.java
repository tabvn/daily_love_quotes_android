package com.tabvn.dailylovequotes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tabvn.dailylovequotes.Quote;
import com.tabvn.dailylovequotes.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {
    private List<Quote> Quotes = new ArrayList<>();

    @NonNull
    @Override
    public QuoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new QuoteHolder(itemView);
    }


    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage) {
            this.bmImage = (ImageView) bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.d("Error", e.getStackTrace().toString());

            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull QuoteHolder holder, int position) {
        Quote currentQuote = Quotes.get(position);

        Log.i("image", currentQuote.getImage() + holder.squareImageView.getWidth() + holder.squareImageView.getHeight());
        Picasso.get()
                .load(currentQuote.getImage())
                .resize(250, 250)
                .centerCrop()
                .into(holder.squareImageView);
    }

    @Override
    public int getItemCount() {
        return Quotes.size();
    }

    public void setQuotes(List<Quote> Quotes) {
        this.Quotes = Quotes;
        notifyDataSetChanged();
    }

    class QuoteHolder extends RecyclerView.ViewHolder {
        private SquareImageView squareImageView;

        public QuoteHolder(View itemView) {
            super(itemView);
            squareImageView = itemView.findViewById(R.id.squareImageView);


        }
    }
}