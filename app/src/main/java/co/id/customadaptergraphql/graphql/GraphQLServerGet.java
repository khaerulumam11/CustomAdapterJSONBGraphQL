package co.id.customadaptergraphql.graphql;

import com.apollographql.apollo.ApolloClient;

import java.util.concurrent.TimeUnit;

import co.id.customadaptergraphql.testing.type.CustomType;
import co.id.customadaptergraphql.util.AppConstants;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GraphQLServerGet {
    private static ApolloClient apolloClient;

    public static ApolloClient getApolloClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(AppConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.TIME_OUT_CONNECTION, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder();

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })
                .build();

        apolloClient = ApolloClient.builder()
                .serverUrl(AppConstants.BASE_URL_GRAPQL_EXCUTE)
                .okHttpClient(okHttpClient)
                .addCustomTypeAdapter(CustomType.JSONB,new CustomAdapterJSONB())
                .build();
        return apolloClient;
    }
}
