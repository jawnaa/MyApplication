package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

        private List<Product> mData;
        private LayoutInflater mInflater;
        private com.example.myapplication.AdapterProduct.ItemClickListener mClickListener;

        // data is passed into the constructor
        AdapterProduct(Context context, List<Product> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public com.example.myapplication.AdapterProduct.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.rowproduct12, parent, false);
            return new AdapterProduct.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(AdapterProduct.ViewHolder holder, int position) {
            Product product = mData.get(position);
            holder.tvName.setText(product.getColor());
            //holder.ivPhoto.setImageDrawable(rest.getPhoto());
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tvName;
            ImageView ivPhoto;

            ViewHolder(View itemView) {
                super(itemView);
                tvName = itemView.findViewById(R.id.tvNameProductRow);
                ivPhoto = itemView.findViewById(R.id.ivPhotoProductRow);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        // convenience method for getting data at click position
        Product getItem(int id) {
            return mData.get(id);
        }

        // allows clicks events to be caught
        void setClickListener(AdapterProduct.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }

