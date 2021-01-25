package co.id.customadaptergraphql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.apollographql.apollo.fetcher.ApolloResponseFetchers;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import co.id.customadaptergraphql.graphql.GraphQLServerGet;
import co.id.customadaptergraphql.testing.GetPeopleProfileAboutQuery;
import co.id.customadaptergraphql.testing.GetPeopleProfileDetailQuery;

public class MainActivity extends AppCompatActivity {

    private TextView txtExample;
    JSONArray jsonArray=null;
    JSONObject jsonObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtExample = findViewById(R.id.textView);

        fetchData();
        fetchDataPeople();
    }

//    private void convertJSONObject() {
//        for (int x=0; x < jsonObject.length(); x++){
//            try {
//                System.out.println("List JSON Object Name "+jsonObject.getString("name"));
//                System.out.println("List JSON Object isObject "+jsonObject.getBoolean("isObject"));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    private void convertJSONArray(String raw) {
//        String[] output=null;
//        output = raw.split(",");
//        output[0] = output[0].replace("[","");
//        output[output.length-1] = output[output.length-1].replace("]","");
//
//        for (int a =0; a < output.length; a++){
//            System.out.println("Isi JSON Array "+output[a]);
//        }
//    }

    private void fetchData() {
        final GetPeopleProfileDetailQuery query = GetPeopleProfileDetailQuery
                .builder()
                .userId(String.valueOf("af8d8b1b-bc69-49bb-b875-7ddb00a73032"))
                .build();
        GraphQLServerGet.getApolloClient().query(query).responseFetcher(ApolloResponseFetchers.NETWORK_FIRST).enqueue(dataCallback);
    }
//
    ApolloCall.Callback<GetPeopleProfileDetailQuery.Data> dataCallback = new ApolloCall.Callback<GetPeopleProfileDetailQuery.Data>() {
        @Override
        public void onResponse(@NotNull Response<GetPeopleProfileDetailQuery.Data> response) {
            runOnUiThread(() -> {
                if (response.data() != null){
                    for (int a =0; a < response.data().global_users().get(0).people_addresses().size(); a++){
                        System.out.println("Data Province "+response.data().global_users().get(0).people_addresses().get(a).global_province().name());
                        System.out.println("Data City "+response.data().global_users().get(0).people_addresses().get(a).global_city().name());
                    }
                }
            });

        }

        @Override
        public void onFailure(@NotNull ApolloException e) {
            String eror = e.getMessage();
            Log.e("a", e.getMessage(), e);

        }
    };

    private void fetchDataPeople() {
        final GetPeopleProfileAboutQuery query = GetPeopleProfileAboutQuery
                .builder()
                .userId(String.valueOf("af8d8b1b-bc69-49bb-b875-7ddb00a73032"))
                .build();
        GraphQLServerGet.getApolloClient().query(query).responseFetcher(ApolloResponseFetchers.NETWORK_FIRST).enqueue(dataCallback1);
    }
    //
    ApolloCall.Callback<GetPeopleProfileAboutQuery.Data> dataCallback1 = new ApolloCall.Callback<GetPeopleProfileAboutQuery.Data>() {
        @Override
        public void onResponse(@NotNull Response<GetPeopleProfileAboutQuery.Data> response) {
            runOnUiThread(() -> {
                if (response.data() != null){
                    System.out.println("Data City People "+response.data().people_profile().get(0).global_city().name());
                    System.out.println("Data Province People "+response.data().people_profile().get(0).global_province().name());
                }
            });

        }

        @Override
        public void onFailure(@NotNull ApolloException e) {
            String eror = e.getMessage();
            Log.e("a", e.getMessage(), e);

        }
    };
}