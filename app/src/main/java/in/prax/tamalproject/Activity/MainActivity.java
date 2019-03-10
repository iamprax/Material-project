package in.prax.tamalproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import in.prax.tamalproject.Apppref;
import in.prax.tamalproject.Fragment.AboutUsFragment;
import in.prax.tamalproject.Fragment.ComparisionFragment;
import in.prax.tamalproject.Fragment.ContactUsFragment;
import in.prax.tamalproject.Fragment.EnquiryGenerationFragment;
import in.prax.tamalproject.Fragment.FairPricingFragment;
import in.prax.tamalproject.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
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

            if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
                toggle.setDrawerIndicatorEnabled(true);
                toggle.syncState();
            }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Products) {
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
//            assert getSupportFragmentManager() != null;
            Apppref.getInstance(this).setVideo(false);
//            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (id == R.id.nav_Enquiry_generation) {

            EnquiryGenerationFragment productsfragment = new EnquiryGenerationFragment();
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Enquiry generation").addToBackStack("").commit();
        }
        if (id == R.id.ic_nav_aboutus) {

            AboutUsFragment productsfragment = new AboutUsFragment();
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "about us").addToBackStack("").commit();
        }
        if (id == R.id.action_contact) {

            ContactUsFragment productsfragment = new ContactUsFragment();
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Contact us").addToBackStack("").commit();
        }
        if (id == R.id.nav_Place_your_order_Buy_here) {

            FairPricingFragment productsfragment = new FairPricingFragment();
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "FairPricingFragment").addToBackStack("").commit();
        }
        if (id == R.id.nav_Product_videos) {

//            Productsfragment productsfragment = new Productsfragment();
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
            Apppref.getInstance(this).setVideo(true);
//            assert getSupportFragmentManager() != null;
//            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (id == R.id.ic_baseline_theaters_24px) {

            ComparisionFragment productsfragment = new ComparisionFragment();
            assert getSupportFragmentManager() != null;
            getSupportFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (id == R.id.Services_and_repair) {

            Intent intent = new Intent(this, ServiceActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
