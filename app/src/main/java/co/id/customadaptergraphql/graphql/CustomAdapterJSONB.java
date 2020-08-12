package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

public class CustomAdapterJSONB implements CustomTypeAdapter<String> {
    @Override
    public String decode(@NotNull CustomTypeValue value) {
        return value.value.toString();
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull String value) {
        return null;
    }
}
