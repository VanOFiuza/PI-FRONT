package pi.example.com.myapplication;


import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class WebClient {

    static java.net.CookieManager msCookieManager = new java.net.CookieManager();


    private HttpURLConnection connection ;

    public String post(String strUrl, String json, Context context, String method)  {

        if (!isConected(context)){
            return "NÃO CONECTADO";
        }
        try {

            URL url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (msCookieManager.getCookieStore().getCookies().size() > 0) {
                // While joining the Cookies, use ',' or ';' as needed. Most of the servers are using ';'
                connection.setRequestProperty("Cookie",
                        TextUtils.join(";", msCookieManager.getCookieStore().getCookies()));
            }

            connection.setRequestMethod(method);

            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-type", "application/json");

            connection.setDoInput(true);

            if (json != null) {
                connection.setDoOutput(true);
                PrintStream saida = new PrintStream(connection.getOutputStream());
                saida.println(json);
            }
            connection.connect();


            InputStream inputStream = connection.getInputStream();

            if (inputStream != null) {

                String resposta = "";

                String linha = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                while ((linha = br.readLine()) != null) {
                    resposta += linha;
                }


                Log.d("TESTE: ", resposta);

                Map<String, List<String>> headerFields = connection.getHeaderFields();
                List<String> cookiesHeader = headerFields.get("Set-Cookie");

                if (cookiesHeader != null) {
                    for (String cookie : cookiesHeader) {
                        msCookieManager.getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
                    }
                }
                return resposta;
            } else {
                return null;
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }
    public static boolean isConected(Context cont){
        ConnectivityManager conmag = (ConnectivityManager)cont.getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( conmag != null ) {
            conmag.getActiveNetworkInfo();

            //Verifica internet pela WIFI
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected()) {

                return true;
            }
            //Verifica se tem internet móvel
            if (conmag.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected()) {

                return true;
            }
        }

        return false;
    }

}