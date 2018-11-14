package utsmobprog.lundy1407229.com.mymovie.Data;

import java.util.ArrayList;

import utsmobprog.lundy1407229.com.mymovie.DataModel.CinemaModel;

public class ListCinemaData {
 //   public static String[][] data = new String[][]{};
    public static String[][] data = new String[][]{
                {"CIWALK XXI", "https://upload.wikimedia.org/wikipedia/id/8/87/XXI.png"},
                {"BTC XXI", "https://upload.wikimedia.org/wikipedia/id/8/87/XXI.png"},
                {"BRAGA XXI", "https://upload.wikimedia.org/wikipedia/id/8/87/XXI.png"},
                {"BEC CGV", "https://upload.wikimedia.org/wikipedia/id/1/10/Cgv_blitz.png"},
                {"PVJ CGV", "https://upload.wikimedia.org/wikipedia/id/1/10/Cgv_blitz.png"},
                {"PASKAL CGV", "https://upload.wikimedia.org/wikipedia/id/1/10/Cgv_blitz.png"}
                };




   public static ArrayList<CinemaModel> getListData(){
            CinemaModel cinemaModel = null;
            ArrayList<CinemaModel> list = new ArrayList<>();
            for (int i = 0; i <data.length; i++) {
                cinemaModel = new CinemaModel();
                cinemaModel.setName(data[i][0]);
                cinemaModel.setPhoto(data[i][1]);
                list.add(cinemaModel);}
            return list;
        }
}

