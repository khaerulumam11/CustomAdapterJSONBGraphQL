package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.response.CustomTypeAdapter;
import com.apollographql.apollo.response.CustomTypeValue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSONBTypeAdapterObject implements CustomTypeAdapter<Map> {

    @Override
    public Map decode(@NotNull CustomTypeValue value) {
        if(value.value instanceof Map){
            return ((Map) value.value);
        }else if(value.value instanceof ArrayList){
            Map<Integer, String> result = new LinkedHashMap<>();
            ArrayList strings = (ArrayList)value.value;
            for(int i = 0 ; i < strings.size() ; i++){
                result.put(i, (String)strings.get(i));
            }
            return result;

        }else{
            return new LinkedHashMap<>();
        }
    }

    @Override
    public @NotNull CustomTypeValue encode(@NotNull Map value) {

        return new CustomTypeValue.GraphQLJsonObject(value);
    }
}
