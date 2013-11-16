package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by lndsharkfury on 11/11/13.
 */

// NOTE: Could add "extends ActionBarActivity".  But need new import.
public class Base_Activity extends Activity {

    String TAG;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch(id) {
            case R.id.twitter:
                Log.i(TAG, "Twitter item clicked");
                return true;

            case R.id.facebook:
                Log.i(TAG, "Facebook item clicked");
                return true;

            case R.id.refresh:
                Log.i(TAG, "Refresh item clicked");
                return true;

            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
