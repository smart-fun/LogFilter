# Log Filter #

Log Filter is a helper to set the **Log Level** of your App, for example setting **VERBOSE in Debug** mode and **ERROR in Release** mode. This way you see all the logs when debugging, but only the errors in release.

## Usage ##

You need to initialize and keep a reference to the logger in your Application class

```java
public class MainApplication extends Application {

    private Log mLog;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            mLog = new Log(Log.Priority.VERBOSE);
        } else {
            mLog = new Log(Log.Priority.ERROR);
        }

    }
}
```

Just as a reminder, to add an Application class to your app, you need to update the manifest with a android:name attribut in the application tag:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.mycompany.myapp">

    <application
        android:name=".MainApplication"
        ...
```

Then the usage is exactly the same as for the android Log class. You just need to replace the android.util.Log import with fr.arnaudguyon.logfilter.Log:

```java
//import android.util.Log
import fr.arnaudguyon.logfilter.Log

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.v(TAG, "VERBOSE TEST");
        Log.d(TAG, "DEBUG TEST");
        Log.i(TAG, "INFO TEST");
        Log.w(TAG, "WARNING TEST");
        Log.e(TAG, "ERROR TEST");

    }
}

```

That's it.

