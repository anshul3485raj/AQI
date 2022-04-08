package com.hoogle.aqi;


import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import com.github.clans.fab.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.github.clans.fab.FloatingActionMenu;
import com.github.javiersantos.appupdater.AppUpdater;
import com.google.android.gms.ads.MobileAds;
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    public WebView mWebView ;
    public FloatingActionMenu fab3;
    FloatingActionButton fabb1 ,fabb2,fabb3;

//app deeveloped by anshul raj

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AppUpdater(this)
                .setTitleOnUpdateAvailable("Update available")
                .setContentOnUpdateAvailable("Check out the latest version available of AQI")
                .setButtonDismiss("cancel")
                .setButtonDoNotShowAgain(null)
                .setButtonUpdate("Update now")
                .start();
        // Notification icon
        /*AppUpdateChecker appUpdateChecker=new AppUpdateChecker(this);  //pass the activity in constructure
        appUpdateChecker.checkForUpdate(false); //mannual check false here*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(this, "ca-app-pub-7479732637897937~3926309519");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BlankFragment3 blankFragment3 = new BlankFragment3();
        FragmentManager manager =   getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.oou, blankFragment3).commit();//app developed by anshul raj

        fab3 =(FloatingActionMenu) findViewById(R.id.fab32);
        fabb1=(FloatingActionButton) findViewById(R.id.item1);
        fabb2=(FloatingActionButton) findViewById(R.id.item2);
        fabb3=(FloatingActionButton) findViewById(R.id.item3);

        fabb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto: anshul348567890123@gmail.com"));
                startActivity(Intent.createChooser(emailIntent, "Report bug"));
                emailIntent.putExtra("android.intent.extra.TEXT", "Write your feedback");
                Snackbar.make(view, "Feedback ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        fabb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent text = new Intent();
                text.setAction("android.intent.action.SEND");
                text.setType("text/plain");
                text.putExtra("android.intent.extra.TEXT", " Hey guys I've using this AQI app lately developed by hoogle , it helps me to stay updated in terms of air quality around me and that too in real time. it including some of the latest features and user friendly layout for easy operation. It app is recommended to all by professionals . download link -->https://play.google.com/store/apps/details?id=com.hoogle.aqi");
                startActivity(Intent.createChooser(text, " share download link:"));
            }
        });

        fabb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlankFragment8 blankFragment8 = new BlankFragment8();
                FragmentManager manager =   getSupportFragmentManager();
                manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment8).commit();
            }
        });
    }
  //app developed by anshul raj








    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            BlankFragment5 blankFragment5 = new BlankFragment5();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment5).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


         if (id == R.id.nav_share) {

            Intent text = new Intent();
            text.setAction("android.intent.action.SEND");
            text.setType("text/plain");
            text.putExtra("android.intent.extra.TEXT", " Hey guys I've using this AQI app lately developed by hoogle , it helps me to stay updated in terms of air quality around me and that too in real time. it including some of the latest features and user friendly layout for easy operation. It app is recommended to all by professionals . download link -->https://play.google.com/store/apps/details?id=com.hoogle.aqi");
            startActivity(Intent.createChooser(text, " share download link:"));
        }
        else if (id == R.id.da) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=hoogle")));
        }
         else if (id == R.id.nav_send) {
             BlankFragment8 blankFragment8 = new BlankFragment8();
             FragmentManager manager =   getSupportFragmentManager();
             manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment8).commit();
         }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
