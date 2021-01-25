package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CustomTypeAdapterObjectArray implements CustomTypeAdapter<ArrayList<Object>> {
    @Override
    public ArrayList<Object> decode(@NotNull CustomTypeValue value) {
     return null;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull ArrayList<Object> value) {
        return new CustomTypeValue.GraphQLJsonList(value);
    }
}
