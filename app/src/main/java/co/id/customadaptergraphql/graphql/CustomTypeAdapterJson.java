package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class  CustomTypeAdapterJson implements CustomTypeAdapter<JSONObject> {
    @Override
    public JSONObject decode(@NotNull CustomTypeValue value) {
        JSONObject object;
//        Timber.tag("AdapterJsonObj").d(value.value.getClass().toString());
        try {
//            Timber.tag("AdapterJsonVal").d(value.value.toString());
            if(value.value instanceof String) {
                object = new JSONObject(value.value.toString());
            } else if (value.value instanceof ArrayList){
                JSONArray jsonArray = new JSONArray(((ArrayList) value.value).toArray());
                object = jsonArray.toJSONObject(jsonArray);
            } else {
                object = new JSONObject(value.value.toString()).getJSONObject(value.value.toString());
            }
        } catch (JSONException e) {
            System.out.println("Eror "+e.getMessage());
            e.printStackTrace();
            return null;
        }
        return object;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull JSONObject value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
