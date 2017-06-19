package xyz.bitnaesser.android_mvc_tutorial.screens.common.controllers;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import xyz.bitnaesser.android_mvc_tutorial.R;
import xyz.bitnaesser.android_mvc_tutorial.screens.smsall.controllers.SmsAllAllFragment;
import xyz.bitnaesser.android_mvc_tutorial.screens.common.mvcviews.RootViewMvcImpl;


public class MainActivity extends Activity implements BaseFragment.AbstractFragmentCallback {

    private static final int MY_PERMISSIONS_REQUEST_READ_SMS = 1;
    RootViewMvcImpl mViewMVC;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        The MVC view associated with this activity is very simple, therefore the below lines could
        be replaced with:
        setContentView(R.layout.mvc_view_frame_layout);
        and there would be no need for FrameLayoutViewMvc class.
        However, for the sake of consistency, we should try to stick to a single coding style,
        therefore we employ full MVC approach even in this simple case!
        */

        // Instantiate MVC view associated with this activity
        mViewMVC = new RootViewMvcImpl(this, null);

        // Set the root view of the associated MVC view as the content of this activity
        setContentView(mViewMVC.getRootView());

        // Show the default fragment if the application is not restored
        if (savedInstanceState == null) {
            replaceFragment(SmsAllAllFragment.class, false, null);
        }
/*
        if (checkSelfPermission(Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?

                // No explanation needed, we can request the permission.;
                requestPermissions(new String[]{Manifest.permission.READ_SMS},
                        MY_PERMISSIONS_REQUEST_READ_SMS);
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            */
    }




    // ---------------------------------------------------------------------------------------------
    //
    // Fragments management

    @Override
    public void replaceFragment(Class<? extends Fragment> claz, boolean addToBackStack,
                                Bundle args) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();


        Fragment newFragment;

        try {
            // Create new fragment
            newFragment = claz.newInstance();
            if (args != null) newFragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        if (addToBackStack) {
            // Add this transaction to the back stack
            ft.addToBackStack(null);
        }

        // Change to a new fragment
        ft.replace(R.id.frame_contents, newFragment, claz.getClass().getSimpleName());
        ft.commit();

    }
    // End of fragments management
    //
    // ---------------------------------------------------------------------------------------------
}
