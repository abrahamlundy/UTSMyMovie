package utsmobprog.lundy1407229.com.mymovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import utsmobprog.lundy1407229.com.mymovie.Adapter.CardViewDashboardAdapter;
import utsmobprog.lundy1407229.com.mymovie.Adapter.ListCinemaAdapter;
import utsmobprog.lundy1407229.com.mymovie.Data.DashboardData;
import utsmobprog.lundy1407229.com.mymovie.Data.ListCinemaData;
import utsmobprog.lundy1407229.com.mymovie.DataModel.CinemaModel;
import utsmobprog.lundy1407229.com.mymovie.DataModel.DashboardModel;

public class CinemaOption extends AppCompatActivity {


    RecyclerView rvCategory;
    private ArrayList<CinemaModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema_option);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        //data.sendPostMethod("https://api.themoviedb.org/3/discover/movie?api_key=ca90f1d4d320c8fa1c5a0efd7054f02f&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1",null);
        rvCategory.setHasFixedSize(true);
        list = new ArrayList<>();
        list.addAll(ListCinemaData.getListData());
        showRecyclerRowView();
    }

    private void showRecyclerRowView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListCinemaAdapter listCinemaAdapter = new ListCinemaAdapter(this);
        listCinemaAdapter.setListPresident(list);
        rvCategory.setAdapter(listCinemaAdapter);
    }


}
