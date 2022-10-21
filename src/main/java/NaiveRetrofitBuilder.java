
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 18/04/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class NaiveRetrofitBuilder {
    public static volatile JPlaceHolder api=(NaiveRetrofitBuilder.buildRetrofit("http://192.168.2.21:5010")).create(JPlaceHolder.class);;

    static {
        renewApi();

    }
    public static void renewApi(){

            System.out.println("-------------Naive retrofit builder  "+1+ "   "+"is returned value from file repo");

            api=(NaiveRetrofitBuilder.buildRetrofit("http://192.168.2.21:5010")).create(JPlaceHolder.class);

    }

    public static Retrofit buildRetrofit(String addr) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        TrustManager TRUST_ALL_CERTS = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { TRUST_ALL_CERTS }, new java.security.SecureRandom());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            //NLog.log("ive retrofit builder ",1,e.toString());
        }
        builder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) TRUST_ALL_CERTS);

        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
               return true;
            }
        });
        builder.readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build();
        OkHttpClient client =builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(addr+"/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;

    }


    public static JPlaceHolder getApi(){
        return api;
    }




}
