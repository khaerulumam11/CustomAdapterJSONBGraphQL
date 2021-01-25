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
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Authorization", "Bearer "+"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImFmOGQ4YjFiLWJjNjktNDliYi1iODc1LTdkZGIwMGE3MzAzMiIsIm9yZyI6ImZkYjMyZmU4LWZjOGMtNDNiZC04NjE2LTIzOTIyMzYxYjVjOCIsIm9mZmljZSI6IkpCUjAxIiwidXNlcm5hbWUiOiJoYWxpbUB3bGIuY28uaWQiLCJlbWFpbCI6ImhhbGltQHdsYi5jby5pZCIsImh0dHBzOi8vaGFzdXJhLmlvL2p3dC9jbGFpbXMiOnsieC1oYXN1cmEtZGVmYXVsdC1yb2xlIjoidXNlciIsIngtaGFzdXJhLWFsbG93ZWQtcm9sZXMiOlsidXNlciIsInB1YmxpYyIsInN0dWRlbnQiLCJvcmdhbml6YXRpb24tc3RhZmYiLCJvcmdhbml6YXRpb24tYWRtaW5pc3RyYXRvciIsIm9yZ2FuaXphdGlvbi1kZXBhcnRtZW50LWhlYWQiLCJvcmdhbml6YXRpb24tZmluYW5jZS1hZG1pbiIsIm9yZ2FuaXphdGlvbi1oci1hZG1pbiIsIm9yZ2FuaXphdGlvbi1oci1hc3Npc3RhbnQiLCJvcmdhbml6YXRpb24tcGF5cm9sbC1tYXN0ZXIiLCJvcmdhbml6YXRpb24tc3VwZXJ2aXNvciJdLCJ4LWhhc3VyYS11c2VyLWVtYWlsIjoiaGFsaW1Ad2xiLmNvLmlkIiwieC1oYXN1cmEtdXNlci1pZCI6ImFmOGQ4YjFiLWJjNjktNDliYi1iODc1LTdkZGIwMGE3MzAzMiIsIngtaGFzdXJhLW9yZy1pZCI6ImZkYjMyZmU4LWZjOGMtNDNiZC04NjE2LTIzOTIyMzYxYjVjOCIsIngtaGFzdXJhLW9mZmljZS1jb2RlIjoiSkJSMDEifSwiaWF0IjoxNjExMTIyNTk0LCJleHAiOjE2MTExNDc3OTR9.Y_U79vv2yy5waHUyr9iaGZbZW9HbbqsHTCsjn90-H5SYrJyhGA4ijxsgPqU3K2mueu81-XBk1yKuck_PZAvfSnt8rzd0MDiPqZCPmtjmtZ5xvfUos9G_RcOvZ1O62qEY-B4pm7Kqj_Opq3jLnsw7sVW8iKL4hdALWSOxmXyl930YYnLlMllB5_bTy3nLtJaBBlGi11crEZnU26klv43touM_7vSNf-xuHxi0_OCfYqg_w_Kb0vqEbQAC38-Enjsrt3NJHUfGM9UVF_mhjDFH3SvywrEJMBiwmV_5eDHVNu0-xVL808sMRbOFxoqS9LfK1g6vHIZL3-R_B7BWZCsUtCnFPbYsPNbglEPJ4SumfSVMNwvwSuscFcTizEN4nHvMO6c8CqtUqlWWmaG9knL3cHpUOfj7yklMMe0IgBfaokY_J4HZnH2f3rMlLXThLNivcfsyLV2HAuLJnZl3H01oNLn52ap7oIxb2nCQ90UfYE7MfX6cO76QFVzE8WOQY5JqaBqFAqiZc-bOekngRNGVnlKbpGGUfLJgt7wQTsxpw7ZkO0tPn3biQ4nJl10vNfTBMp8A8QQDVdWFNtNwHnf_vdWkBFCBiJiPV3oODe-ViJxb61K99Cb3TuQiVjM5gWOAISomnbuOqjf1u74IBkPsR7l9xH11RXVI3sw5Ydg1J_s")
                            .header("X-Hasura-Role", "user");

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                })
                .build();

        apolloClient = ApolloClient.builder()
                .serverUrl(AppConstants.BASE_URL_GRAPQL_EXCUTE)
                .okHttpClient(okHttpClient)
                .addCustomTypeAdapter(CustomType.UUID,new CustomTypeAdapterString())
//                .addCustomTypeAdapter(CustomType.DATE,new CustomTypeAdapterTimestampz() )
                .addCustomTypeAdapter(CustomType.JSONB,new CustomTypeAdapterString() )
                .build();
        return apolloClient;
    }
}
