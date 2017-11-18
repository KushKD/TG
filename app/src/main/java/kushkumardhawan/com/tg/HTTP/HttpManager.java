package kushkumardhawan.com.tg.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by KU854963 on 11/18/2017.
 */

public class HttpManager {

    public static String get_Data(String uri) {

        BufferedReader reader = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }

    public String GetData(String url) {
        System.out.print(url);
        BufferedReader reader = null;

        try {
            URL url_ = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url_.openConnection();

            if (con.getResponseCode() != 200) {
                throw new IOException(con.getResponseMessage());
            }


            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            con.disconnect();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Timeout";
        } finally {
            if (reader != null) {
                try {
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    return "Error";
                }
            }
        }
    }


}
