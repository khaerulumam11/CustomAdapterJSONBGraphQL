package co.id.customadaptergraphql.graphql;
import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomTypeAdapterTimestampz implements CustomTypeAdapter<Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    @Override
    public Date decode(@NotNull CustomTypeValue value) {
        try {
            return dateFormat.parse(value.value.toString());
        } catch (ParseException e) {
            throw new IllegalArgumentException(value+" is not a valid ISO 8601 date", e);
        }
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Date value) {
        return CustomTypeValue.fromRawValue((dateFormat.format(value)));
    }
}
