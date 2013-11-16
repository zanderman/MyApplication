package com.example.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class MainActivity extends Base_Activity {

    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        FragmentManager fragman = getFragmentManager();
        FragmentTransaction fragtrans = fragman.beginTransaction();
        Fragment frag = new Side_Fragment();
        fragtrans.replace(R.id.frag_frame, frag, "SIDE");
        fragtrans.commit();


    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


    // Inflates (i.e. draws) specific items on creation of the app.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // |
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    // ---------------------------------------------------------------------------------------------
    // If the button is pressed, then go to the login activity
    public void buttonClick(View view) {

        // Starts new intent.
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    // ---------------------------------------------------------------------------------------------


    // Test for checking orientation.
    public void showOrienLog(View view) {

        // Gets the current screen orientaiton.
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        int orientation = display.getRotation();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        int blah = getResources().getConfiguration().orientation;

        Log.i(TAG, "Orientation: " + orientation);
        Log.i(TAG, "Rotation: " + Configuration.ORIENTATION_LANDSCAPE);
        Log.i(TAG, "blah: " + blah);


        // NOTE: Orientation List.
        //      0 = front camera up
        //      1 = front camera left
        //      2 = front camera down
        //      3 = front camera right

    }

    public void  swapFrag(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment current = fragmentManager.findFragmentByTag("SIDE");

        Fragment picture = new Picture_Fragment();
        Fragment side = new Side_Fragment();

        if (current.isVisible()) {
            fragmentTransaction.replace(R.id.frag_frame, picture, "PIC");
        }
        else {
            fragmentTransaction.replace(R.id.frag_frame, side, "SIDE");
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }





}
