package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class CustomTypeAdapterHashMap implements CustomTypeAdapter<List<HashMap>> {
    @Override
    public List<HashMap> decode(@NotNull CustomTypeValue value) {
       return null;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull List<HashMap> value) {
        return CustomTypeValue.fromRawValue(value);
    }
}
