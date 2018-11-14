package utsmobprog.lundy1407229.com.mymovie.Data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utsmobprog.lundy1407229.com.mymovie.DataModel.DashboardModel;
import utsmobprog.lundy1407229.com.mymovie.Network.NetworkRequest;

public class DashboardData extends NetworkRequest {
    public static String[][] sample = new String[][]{
                {"Venom", "15 Oktober 2018",
                        "https://image.tmdb.org/t/p/original/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg"}
                };




    public DashboardData(Context context) {
        super(context);
    }


    public void  sendPostMethod(String url, String param[]) {

       StringRequest postRequest = new StringRequest(Request.Method.POST, url,
               new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       // menampilkan respone
                       Log.d("Response", response);
                       try {
                           JSONObject obj= new JSONObject(response);
                           JSONArray jsonArray = new JSONArray(response);
                           Log.d ("Array", jsonArray.toString());
                           JSONObject obj1 = jsonArray.getJSONObject(3);
                           Log.d("Objek", obj1.getString("id"));
                           // menampilkan response pada logcat

                           Log.d("Response", obj1.getString("id"));
                           // Toast.makeText(this, jsonArray.toString(), Toast.LENGTH_SHORT).show();
                       }catch (JSONException e){
                           e.printStackTrace();
                       }
                   }
               },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       // error
                       error.printStackTrace();
                   }
               }
       ) {
           @Override
           protected Map<String, String> getParams() {         // Menambahkan parameters post
               Map<String, String> params = new HashMap<String, String>();
               // params.put("parameter1", "value1");
               //params.put("parameter2", "value2");

               return params;
           }
       };

   }

    public void  sendGetMethod(String url, String param[]) {
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response.getJSONArray("results"));
                            // menampilkan response pada logcat

                            Log.d("Response", jsonArray.getJSONObject(0).toString());
                           // Toast.makeText(this, jsonArray.toString(), Toast.LENGTH_SHORT).show();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }


                    }
                },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {         // Menambahkan parameters post
                    Map<String, String> params = new HashMap<String, String>();
                    // params.put("parameter1", "value1");
                    //params.put("parameter2", "value2");

                    return params;
                }
            };
    }

   public static ArrayList<DashboardModel> getListData(){
            DashboardModel dashboardModel = null;
            ArrayList<DashboardModel> list = new ArrayList<>();
            for (int i = 0; i <sample.length; i++) {
                dashboardModel = new DashboardModel();
                dashboardModel.setName(sample[i][0]);
                dashboardModel.setRemarks(sample[i][1]);
                dashboardModel.setPhoto(sample[i][2]);
                list.add(dashboardModel);}
            return list;
        }
    }

