package kushkumardhawan.com.tg.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

import kushkumardhawan.com.tg.Model.Countries;

/**
 * Created by KU854963 on 11/18/2017.
 */

public class CountryJson {

    public static List<Countries> parseFeed(String content) {

        try {
            String g_Table = null;
            Object json = new JSONTokener(content).nextValue();
          /*  if (json instanceof JSONObject){
                JSONObject obj = new JSONObject(content);
                g_Table = obj.optString(EConstants.Vacancies_Result);
            }
            else if (json instanceof JSONArray){
            }*/
            JSONArray ar = new JSONArray(content);
            List<Countries>CountryList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject obj = ar.getJSONObject(i);
                Countries pojo_country = new Countries();
                pojo_country.setName(obj.getString("name"));
                pojo_country.setAlpha2Code(obj.getString("alpha2Code"));
                pojo_country.setAlpha3Code(obj.getString("alpha3Code"));
                pojo_country.setCapital(obj.getString("capital"));
                pojo_country.setRegion(obj.getString("region"));
                pojo_country.setSubregion(obj.getString("subregion"));
                pojo_country.setPopulation(obj.getString("population"));
                pojo_country.setDemonym(obj.getString("demonym"));
                pojo_country.setArea(obj.getString("area"));
                pojo_country.setGini(obj.getString("gini"));
                pojo_country.setNativeName(obj.getString("nativeName"));
                pojo_country.setNumericCode(obj.getString("numericCode"));
                pojo_country.setCioc(obj.getString("cioc"));
                pojo_country.setFlag(obj.getString("flag"));
                CountryList.add(pojo_country);
            }
            return CountryList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


}
