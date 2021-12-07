package com.example.myapplication;

public class AdapterProduct {
    public class AdapterRestaurant extends RecyclerView.Adapter<AdapterRestaurant.ViewHolder> {

        private List<Restaurant> mData;
        private LayoutInflater mInflater;
        private AdapterRestaurant.ItemClickListener mClickListener;

        // data is passed into the constructor
        AdapterRestaurant(Context context, List<Restaurant> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public AdapterRestaurant.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.row, parent, false);
            return new AdapterRestaurant.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(AdapterRestaurant.ViewHolder holder, int position) {
            Restaurant rest = mData.get(position);
            holder.tvName.setText(rest.getName());
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
                tvName = itemView.findViewById(R.id.tvNameRestRow);
                ivPhoto = itemView.findViewById(R.id.ivPhotoRestRow);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        // convenience method for getting data at click position
        Restaurant getItem(int id) {
            return mData.get(id);
        }

        // allows clicks events to be caught
        void setClickListener(AdapterRestaurant.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }