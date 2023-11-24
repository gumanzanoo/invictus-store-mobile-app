package unipar.invictus.resources.helpers;

import android.content.Context;
import android.content.Intent;

public class Activity {
    public static void run(Context context, Class<?> activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
