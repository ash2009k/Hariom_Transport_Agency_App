package com.hot.ashwini.hariomtransport;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FrameLayout mainframe;
    private home_frag home_frag;
    private about about;
    private our_team our_team;
    private service service;
    private share share;
    private  contact contact;
    private show_info show_info;

    //info pass variable to show_info fragment based on button click
    private static String head = "";
    private static String address = "";
    private static String mob = "";
    private static LatLng latLng = new LatLng(0,0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainframe=(FrameLayout)findViewById(R.id.main_frame);

        home_frag=new home_frag();
        about=new about();
        our_team=new our_team();
        service=new service();
        share=new share();
        contact=new contact();
        show_info=new show_info();
        setFragment(home_frag);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hariomtrtansportagency@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Any subject if you want");
                intent.setPackage("com.google.android.gm");
                if (intent.resolveActivity(getPackageManager())!=null)
                    startActivity(intent);
                else {
                    Snackbar.make(view, "Gmail App is not installed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            setFragment(home_frag);

            // Handle the camera action
        } else if (id == R.id.nav_services) {
            setFragment(service);

        } else if (id == R.id.nav_our_team) {
            setFragment(our_team);

        } else if (id == R.id.nav_about) {
            setFragment(about);

        } else if (id == R.id.nav_share) {
            setFragment(share);

        } else if (id == R.id.nav_contact) {
            setFragment(contact);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(android.support.v4.app.Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }

    public void email(View view) {
        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hariomtrtansportagency@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Any subject if you want");
        intent.setPackage("com.google.android.gm");
        if (intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
        else
            Toast.makeText(this,"Gmail App is not installed",Toast.LENGTH_SHORT).show();


    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9835050613"));
        startActivity(intent);
    }
    public void call1(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:09835892439"));
        startActivity(intent);
    }


    //call redirector for show info fragment:

    public void call_info(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+mob));
        startActivity(intent);
    }


    public void share(View view) {
        String url = "http://www.example.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void like(View view) {
        String url = "https://www.facebook.com/HARIOMTRANSPORTAGENCY/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    //getter methods for show info fragment

    public static String getHead() {
        return head;
    }
    public static String getAddress() {
        return address;
    }
    public static String getMob() {
        return mob;
    }
    public static LatLng getLatLng() {
        return latLng;
    }


    ///info methods

    public void info_1(View view) {
        head="Bihar Sharif";
        address="Nh 31, Bypass Road, Near Mangla Asthan, Bihar Sharif, Bihar 803101";
        mob="9835892439";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }

    public void info_2(View view) {
        head="Pahari Par";
        address="Gaya - Masaurhi Road, Mear Janta Transport, Bihar Sharif, Bihar 803101";
        mob="9608241192";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }

    public void info_3(View view) {
        head="Patna Junction";
        address="Kadam Kuan, Janak Kishore Road, Beside Old Post Office, Bihar Sharif, Bihar 803101";
        mob="9304369986";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }

    public void info_4(View view) {
        head="Warisaliganj";
        address="Main Road, Near St. Johns Public School, Warisaliganj, Bihar 805130";
        mob="9835892439";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }
    public void info_5(View view) {
        head="Nawada";
        address="Garh Par, Naradiganj Road, Near Marble Godam, Nawada, Bihar 805110";
        mob="9835892439";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }

    public void info_6(View view) {
        head="Bhawani Pollution Centre";
        address="Nh 31, Bypass Road, Near Mangla Asthan, Bihar Sharif, Bihar 803101";
        mob="9835892439";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }

    public void info_7(View view) {
        head="Anil Motors";
        address="Nh 31, Bypass Road, Near Mangla Asthan, Bihar Sharif, Bihar 803101";
        mob="7654619498";
        latLng=new LatLng(25.1931,85.5054);
        setFragment(show_info);
    }


    public void get_back_to_service(View view) {
        setFragment(service);
    }
}
