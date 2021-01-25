package co.id.customadaptergraphql.graphql;


import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomTypeAdapterArrayList implements CustomTypeAdapter<ArrayList<HashMap<String, Object>>> {
    @Override
    public ArrayList<HashMap<String, Object>> decode(@NotNull CustomTypeValue value) {
        ArrayList<HashMap<String,Object>> list =  (ArrayList<HashMap<String, Object>>) value.value;
     return list;

    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull ArrayList<HashMap<String, Object>> value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
