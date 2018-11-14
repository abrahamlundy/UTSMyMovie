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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import utsmobprog.lundy1407229.com.mymovie.CustomOnItemClickListener;
import utsmobprog.lundy1407229.com.mymovie.DataModel.CinemaModel;
import utsmobprog.lundy1407229.com.mymovie.MapCinema;
import utsmobprog.lundy1407229.com.mymovie.R;

public class ListCinemaAdapter extends RecyclerView.Adapter<ListCinemaAdapter.CategoryViewHolder>{
    private Context context;
    ArrayList<CinemaModel> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<CinemaModel> listPresident) {
        this.listPresident = listPresident;
    }
    private ArrayList<CinemaModel> listPresident;
    public ListCinemaAdapter(Context context) {
        this.context = context;
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View itemRow =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_cinema, parent, false);
        return new CategoryViewHolder(itemRow);
    }
    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresident().get(position).getName());
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
        holder.btnPilih.setOnClickListener(new
                CustomOnItemClickListener(position, new
                CustomOnItemClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        Intent maps = new Intent(context,MapCinema.class);
                        view.getContext().startActivity(maps);
                        //Toast.makeText(context, "Favorite "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                }));
    }
    @Override
    public int getItemCount() {
        return getListPresident().size();
    }
    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        Button btnPilih;
        ImageView imgPhoto;
        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            btnPilih =
                    (Button)itemView.findViewById(R.id.btn_item_name);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
    }
