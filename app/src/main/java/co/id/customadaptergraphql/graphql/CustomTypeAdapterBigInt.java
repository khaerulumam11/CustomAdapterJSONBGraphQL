package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class CustomTypeAdapterBigInt implements CustomTypeAdapter<BigInteger> {

    @Override
    public BigInteger decode(@NotNull CustomTypeValue value) {
        return new BigInteger(value.value.toString());
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull BigInteger value) {
        return CustomTypeValue.fromRawValue(value);
    }
}

