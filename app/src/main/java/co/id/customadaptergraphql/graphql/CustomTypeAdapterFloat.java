package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

public class CustomTypeAdapterFloat implements CustomTypeAdapter<Float> {
    @Override
    public Float decode(@NotNull CustomTypeValue value) {
        return Float.valueOf(value.value.toString());
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Float value) {
        return new CustomTypeValue.GraphQLNumber(value);
    }
}
