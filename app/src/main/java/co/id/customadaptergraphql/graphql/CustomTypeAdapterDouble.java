package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

public class CustomTypeAdapterDouble implements CustomTypeAdapter<Double> {
    @Override
    public Double decode(@NotNull CustomTypeValue value) {
        return Double.valueOf(value.value.toString());
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Double value) {
        return new CustomTypeValue.GraphQLNumber(value);
    }
}
