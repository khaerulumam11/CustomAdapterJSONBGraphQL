package co.id.customadaptergraphql.graphql;


import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public class CustomTypeAdapterLinkedHashmap implements CustomTypeAdapter<LinkedHashMap<String,Object>> {
    @Override
    public LinkedHashMap<String,Object> decode(@NotNull CustomTypeValue value) {
        LinkedHashMap<String, Object> l = (LinkedHashMap<String, Object>) value.value;
       return l;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull LinkedHashMap<String,Object> value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
