package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

public class CustomTypeAdapterInteger implements CustomTypeAdapter<Integer> {
    @Override
    public Integer decode(@NotNull CustomTypeValue value) {
        return Integer.valueOf(value.value.toString());
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Integer value) {
        return new CustomTypeValue.GraphQLNumber(value);
    }
}
