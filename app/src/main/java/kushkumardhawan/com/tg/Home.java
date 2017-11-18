package kushkumardhawan.com.tg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import kushkumardhawan.com.tg.Abstracts.AsyncTaskListener;
import kushkumardhawan.com.tg.Adapters.CountryAdapter;
import kushkumardhawan.com.tg.Enums.TaskType;
import kushkumardhawan.com.tg.Generic.Custom_Dialog;
import kushkumardhawan.com.tg.Generic.Generic_Async_Get;
import kushkumardhawan.com.tg.Json.CountryJson;
import kushkumardhawan.com.tg.Model.Countries;
import kushkumardhawan.com.tg.Utilities.AppStatus;
import kushkumardhawan.com.tg.Utilities.Econstants;

public class Home extends AppCompatActivity  implements AsyncTaskListener {

    Custom_Dialog CD = new Custom_Dialog();
    ListView listv;
    Context context;
    ProgressBar pb;
    LinearLayout LGone;
    Button refresh;
    EditText Search_EditText;
    List<Countries> countryServer;
    CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listv = (ListView) findViewById(R.id.list);
        Search_EditText = (EditText)findViewById(R.id.edit_text_search);
        refresh = (Button)findViewById(R.id.refresh);
        LGone = (LinearLayout)findViewById(R.id.lgone);
        context = this;
        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        if (AppStatus.getInstance(Home.this).isOnline()) {
            GetDaTaAsync();
        } else {
            CD.showDialog(Home.this, "Internet not available.");
        }

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppStatus.getInstance(Home.this).isOnline()) {
                    Search_EditText.setText("");
                    new Generic_Async_Get(Home.this, Home.this, TaskType.GET_COUNTRIES_SERVICE).execute(Econstants.URL_MAIN);
                } else {
                    CD.showDialog(Home.this,"Oops ... This was not susspose to happen!!");
                }
            }
        });

        Search_EditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                //MainActivity.this.adapt.getFilter().filter(s);
                //  String searchString=Search_EditText.getText().toString();
                //  adapter.getFilter().filter(searchString);
                // System.out.println("Text ["+s+"] - Start ["+start+"] - Before ["+before+"] - Count ["+count+"]");
               /* if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    adapter.resetData();
                }*/

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                Home.this.adapter.getFilter().filter(s);


            }
        });
    }

    protected void updateDisplay() {

        LGone.setVisibility(View.VISIBLE);
        adapter = new CountryAdapter(this, R.layout.item_country, countryServer);
        listv.setAdapter(adapter);
        listv.setTextFilterEnabled(true);

    }

    public  Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void onTaskCompleted(String result, TaskType taskType) {

        if (taskType == TaskType.GET_COUNTRIES_SERVICE) {

            countryServer = CountryJson.parseFeed(result);
            if(!countryServer.isEmpty()){
                updateDisplay();

            }else
            {
                CD.showDialog(Home.this,"Nothing To Display");
            }

        }else{
            CD.showDialog(Home.this,"Somethings Not Right");
        }
    }

    @Override
    public void onTaskCompleted(Activity activity, String result, TaskType taskType) {

    }

    private void GetDaTaAsync() {
        new Generic_Async_Get(Home.this, Home.this, TaskType.GET_COUNTRIES_SERVICE).execute(Econstants.URL_MAIN);
    }
}
