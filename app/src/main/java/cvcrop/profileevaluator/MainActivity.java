package cvcrop.profileevaluator;


import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,EvaluateFragment.OnFragmentInteractionListener,
        AboutUsFragment.OnFragmentInteractionListener,ContactUsFragment.OnFragmentInteractionListener,
        BlogsFragment.OnFragmentInteractionListener,OverviewFragment.OnFragmentInteractionListener,
        EvaluateResultFragment.OnFragmentInteractionListener,UniversitiesFragment.OnFragmentInteractionListener,
        UniversitiesResultFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,
        EvaluateFragment2.OnFragmentInteractionListener
         {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");



        // Code for Email
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment=HomeFragment.newInstance("","");
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,homeFragment,homeFragment.getTag()).commit();

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
        System.out.println("@@@@@@@@@@@@@@@");
        int id = item.getItemId();

        if (id == R.id.nav_evaluate) {

            EvaluateFragment evaluateFragment=EvaluateFragment.newInstance("msg1","msg2");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,evaluateFragment,evaluateFragment.getTag()).commit();


        } else if (id == R.id.nav_universities) {

            UniversitiesFragment universitiesFragment=UniversitiesFragment.newInstance("msg1","msg2");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,universitiesFragment,universitiesFragment.getTag()).commit();
        } else if (id == R.id.nav_overview) {

            OverviewFragment overviewFragment=OverviewFragment.newInstance("msg1","msg2");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,overviewFragment,overviewFragment.getTag()).commit();

        } else if (id == R.id.nav_blogs) {

              BlogsFragment blogsFragment=BlogsFragment.newInstance("msg1","");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,blogsFragment,blogsFragment.getTag()).commit();


        } else if (id == R.id.nav_contact_us) {

            ContactUsFragment contactUsFragment=ContactUsFragment.newInstance("","");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,contactUsFragment,contactUsFragment.getTag()).commit();

        } else if (id == R.id.nav_about_us) {

            AboutUsFragment aboutUsFragment=AboutUsFragment.newInstance("","");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,aboutUsFragment,aboutUsFragment.getTag()).commit();
        }
        else if (id == R.id.nav_home) {

            HomeFragment homeFragment=HomeFragment.newInstance("","");
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,homeFragment,homeFragment.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

        System.out.println("Interactionnnnnnnnnnnnnnnnnnnnnnn");
    }

    public void goEvaluateFragment(View v)
    {
        EvaluateFragment evaluateFragment=EvaluateFragment.newInstance("msg1","msg2");
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layout_for_fragment,evaluateFragment,evaluateFragment.getTag()).commit();

    }
}
