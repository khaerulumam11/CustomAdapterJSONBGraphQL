package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CustomTypeAdapterJsonArray implements CustomTypeAdapter<JSONArray> {
    @Override
    public JSONArray decode(@NotNull CustomTypeValue value) {
        JSONArray object;
        //8String os = value.value.toString();
        try {
//            object = new JSONArray(((ArrayList)value.value).toArray());
            if(value.value instanceof String) {
                object = new JSONArray((value.value).toString());
            } else if(value.value instanceof ArrayList) {
                object = new JSONArray(((ArrayList)value.value).toArray());
            } else if(value.value instanceof JSONObject) {
                object = new JSONArray(JSONObject.wrap(value.value));
            } else if(value.value instanceof LinkedHashMap) {
                JSONObject obj = new JSONObject((LinkedHashMap)value.value);
                object = new JSONArray("["+obj.toString()+"]");
            } else {
                object = new JSONArray(value.value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull JSONArray value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
