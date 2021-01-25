package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

public class CustomTypeAdapterBChar implements CustomTypeAdapter<Character> {

    @Override
    public Character decode(@NotNull CustomTypeValue value) {
        return null;
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Character value) {
        return  new CustomTypeValue.GraphQLString(value.toString());
    }
}
