package co.id.customadaptergraphql.graphql;


import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomTypeAdapterArrayObject implements CustomTypeAdapter<ArrayList<HashMap<String, Object>>> {
    @Override
    public ArrayList<HashMap<String, Object>> decode(@NotNull CustomTypeValue value) {

        return null;

    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull ArrayList<HashMap<String, Object>> value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
