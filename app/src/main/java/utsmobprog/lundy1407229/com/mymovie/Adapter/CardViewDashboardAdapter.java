package utsmobprog.lundy1407229.com.mymovie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import utsmobprog.lundy1407229.com.mymovie.CustomOnItemClickListener;
import utsmobprog.lundy1407229.com.mymovie.DataModel.DashboardModel;
import utsmobprog.lundy1407229.com.mymovie.MapCinema;
import utsmobprog.lundy1407229.com.mymovie.R;
import utsmobprog.lundy1407229.com.mymovie.ViewMovie;

public class CardViewDashboardAdapter extends RecyclerView.Adapter<CardViewDashboardAdapter.CardViewViewHolder>{
        private ArrayList<DashboardModel> listPresident;
        private Context context;
        public CardViewDashboardAdapter(Context context) {
            this.context = context;
        }
        private ArrayList<DashboardModel> getListPresident() {
            return listPresident;
        }
        public void setListPresident(ArrayList<DashboardModel> listPresident) {
            this.listPresident = listPresident;
        }
        @Override
        public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
            return new CardViewViewHolder(view);
        }
        @Override
        public void onBindViewHolder(CardViewViewHolder holder, int position) {
            DashboardModel p = getListPresident().get(position);
            Glide.with(context)
                    .load(p.getPhoto())
                    .override(350, 550)
                    .into(holder.imgPhoto);
            holder.tvName.setText(p.getName());
            holder.tvRemarks.setText(p.getRemarks());
            holder.btnFavorite.setOnClickListener(new
                    CustomOnItemClickListener(position, new
                    CustomOnItemClickListener.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(View view, int position) {
                            Intent maps = new Intent(context,ViewMovie.class);
                            view.getContext().startActivity(maps);
                            //Toast.makeText(context, "Favorite "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    }));
            holder.btnShare.setOnClickListener(new
                    CustomOnItemClickListener(position, new
                    CustomOnItemClickListener.OnItemClickCallback() {
                        @Override
                        public void onItemClicked(View view, int position) {
                            Toast.makeText(context, "Share"+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    }));
        }
        @Override
        public int getItemCount() {
            return getListPresident().size();
        }
        class CardViewViewHolder extends RecyclerView.ViewHolder{
            ImageView imgPhoto;
            TextView tvName, tvRemarks;
            Button btnFavorite, btnShare;
            CardViewViewHolder(View itemView) {
                super(itemView);
                imgPhoto =
                        (ImageView)itemView.findViewById(R.id.img_item_photo);
                tvName = (TextView)itemView.findViewById(R.id.tv_item_name);tvRemarks =
                        (TextView)itemView.findViewById(R.id.tv_item_remarks);
                btnFavorite =
                        (Button)itemView.findViewById(R.id.btn_set_favorite);
                btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
            }
        }
    }
