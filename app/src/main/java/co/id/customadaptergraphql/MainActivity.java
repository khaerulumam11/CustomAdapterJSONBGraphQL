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
import co.id.customadaptergraphql.testing.MyQuery;

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

    }

    private void convertJSONObject() {
        for (int x=0; x < jsonObject.length(); x++){
            try {
                System.out.println("List JSON Object Name "+jsonObject.getString("name"));
                System.out.println("List JSON Object isObject "+jsonObject.getBoolean("isObject"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private void convertJSONArray(String raw) {
        String[] output=null;
        output = raw.split(",");
        output[0] = output[0].replace("[","");
        output[output.length-1] = output[output.length-1].replace("]","");

        for (int a =0; a < output.length; a++){
            System.out.println("Isi JSON Array "+output[a]);
        }
    }

    private void fetchData() {
        final MyQuery query = MyQuery
                .builder()
                .build();
        GraphQLServerGet.getApolloClient().query(query).responseFetcher(ApolloResponseFetchers.NETWORK_FIRST).enqueue(dataCallback);
    }

    ApolloCall.Callback<MyQuery.Data> dataCallback = new ApolloCall.Callback<MyQuery.Data>() {
        @Override
        public void onResponse(@NotNull Response<MyQuery.Data> response) {
            runOnUiThread(() -> {
                if (response.data() != null){
                    for (int a =0; a < response.data().test().size(); a++){
                        System.out.println("JSON Array "+response.data().test().get(a).obj1());
                        System.out.println("JSON Object "+response.data().test().get(a).obj2());
                        //convert to JSON Array
                        convertJSONArray(response.data().test().get(a).obj1().toString());
                        //convert to JSON Object
                        try {
                            jsonObject = new JSONObject(response.data().test().get(a).obj2().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }


                    convertJSONObject();
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