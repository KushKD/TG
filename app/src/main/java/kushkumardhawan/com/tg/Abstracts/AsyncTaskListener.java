package kushkumardhawan.com.tg.Abstracts;

import android.app.Activity;

import kushkumardhawan.com.tg.Enums.TaskType;

/**
 * Created by KU854963 on 11/18/2017.
 */

public interface AsyncTaskListener {

    void onTaskCompleted(String result, TaskType taskType);

    void onTaskCompleted(Activity activity, String result, TaskType taskType);
}
