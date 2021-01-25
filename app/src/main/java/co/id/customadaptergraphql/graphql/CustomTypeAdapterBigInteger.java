package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class CustomTypeAdapterBigInteger implements CustomTypeAdapter<BigInteger> {
    @Override
    public BigInteger decode(@NotNull CustomTypeValue value) {
        return BigInteger.valueOf(Long.parseLong(value.value.toString()));
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull BigInteger value) {
        return new CustomTypeValue.GraphQLNumber(value);
    }
}
