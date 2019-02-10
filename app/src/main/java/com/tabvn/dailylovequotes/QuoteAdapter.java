package com.tabvn.dailylovequotes;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;


public class QuoteAdapter extends ListAdapter<Quote, QuoteAdapter.QuoteHolder> {

    public QuoteAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Quote> DIFF_CALLBACK = new DiffUtil.ItemCallback<Quote>() {
        @Override
        public boolean areItemsTheSame(@NonNull Quote oldQuote, @NonNull Quote newQuote) {
            return oldQuote.getId() == newQuote.getId();

        }

        @Override
        public boolean areContentsTheSame(@NonNull Quote oldQuote, @NonNull Quote newQuote) {
            return oldQuote.getTitle().equals(newQuote.getTitle()) && oldQuote.getDescription().equals(newQuote.getDescription()) && oldQuote.getUrl().equals(newQuote.getUrl())
                    && oldQuote.getImage().equals(newQuote.getImage());

        }
    };


    @NonNull
    @Override
    public QuoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new QuoteHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull QuoteHolder holder, int position) {
        Quote quote = getQuoteAt(position);

        Log.i("Image url", quote.getImage());

        Picasso.get()
                .load(quote.getImage())
                .resize(300, 300)
                .centerCrop()
                .into(holder.squareImageView);

    }

    public Quote getQuoteAt(int position) {
        return getItem(position);
    }


    class QuoteHolder extends RecyclerView.ViewHolder {
        private SquareImageView squareImageView;

        public QuoteHolder(View itemView) {
            super(itemView);
            squareImageView = itemView.findViewById(R.id.squareImageView);

        }
    }
}