package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.Map;

public class CustomTypeAdapterObject implements CustomTypeAdapter<Map<String, Object>> {

    @Override
    public Map<String, Object> decode(@NotNull CustomTypeValue value) {
        Map<String, Object> objectMap;
        JSONArray object;
//        //8String os = value.value.toString();
        try {
            object = new JSONArray(value.value);
            if (value.value instanceof String) {
                object = new JSONArray((value.value).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Map<String, Object> value) {
        return new CustomTypeValue.GraphQLJsonObject(value);
    }
}
