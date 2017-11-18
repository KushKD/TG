package kushkumardhawan.com.tg;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kushkumardhawan.com.tg.Abstracts.AsyncTaskListener;
import kushkumardhawan.com.tg.Enums.TaskType;
import kushkumardhawan.com.tg.Generic.Custom_Dialog;
import kushkumardhawan.com.tg.Generic.Generic_Async_Get;
import kushkumardhawan.com.tg.Utilities.AppStatus;
import kushkumardhawan.com.tg.Utilities.Econstants;

public class Home extends AppCompatActivity  implements AsyncTaskListener {

    Custom_Dialog CD = new Custom_Dialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (AppStatus.getInstance(Home.this).isOnline()) {
            GetDaTaAsync();
        } else {
            CD.showDialog(Home.this, "Internet not available.");
        }
    }

    @Override
    public void onTaskCompleted(String result, TaskType taskType) {

        if (taskType == TaskType.GET_COUNTRIES_SERVICE) {

            Log.e("Data", result);
            CD.showDialog(Home.this, result);
          //  Districts_Server = AddParkingData.parseFeedNotifications(result);
          //  Log.e("Length", Integer.toString(Districts_Server.size()));
          //  adapter = new SpinAdapter_District(Add_Parking_Here.this, android.R.layout.simple_spinner_item, Districts_Server);
          //  district_sp.setAdapter(adapter);

        }
    }

    @Override
    public void onTaskCompleted(Activity activity, String result, TaskType taskType) {

    }

    private void GetDaTaAsync() {
        new Generic_Async_Get(Home.this, Home.this, TaskType.GET_COUNTRIES_SERVICE).execute(Econstants.URL_MAIN);
    }
}
