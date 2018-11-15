package vision4.com.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import de.hdodenhof.circleimageview.CircleImageView;
import vision4.com.Fragments.BuyProductsFragment;
import vision4.com.Fragments.CategoriesFragment;
import vision4.com.Fragments.FeedsFragment;
import vision4.com.Fragments.HireFragment;
import vision4.com.Fragments.JobOffersFragment;
import vision4.com.Fragments.NotificationFragment;
import vision4.com.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //variables
    GoogleSignInAccount account;
    FragmentTransaction ft;

    //widgets
    TextView nav_name;
    NavigationView navigationView;
    DrawerLayout drawer;
    FrameLayout fl;
    CircleImageView nav_img;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //initialize_variables
        init();

        //toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        //set drawer
        setDrawer();

        //set default fragment
        setDefaultFragment();

    }

    private void init() {
        toolbar =  findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        nav_img = header.findViewById(R.id.nav_image);
        nav_name = header.findViewById(R.id.nav_user_name);
        account = GoogleSignIn.getLastSignedInAccount(this);
        fl = findViewById(R.id.home_container);
    }

    private void setDrawer() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setDefaultFragment(){
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.home_container,new FeedsFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_feeds);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);

        int id = item.getItemId();
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.home_container);
        switch (id){
            case R.id.nav_feeds:
                if(!(f instanceof FeedsFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new FeedsFragment()).commit();
                }
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_categories:
                if(!(f instanceof CategoriesFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new CategoriesFragment()).commit();
                }
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_notification:
                if(!(f instanceof NotificationFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new NotificationFragment()).commit();
                }
                break;
            case R.id.nav_buy_products:
                if(!(f instanceof BuyProductsFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new BuyProductsFragment()).commit();
                }
                break;
            case R.id.nav_job_offers:
                if(!(f instanceof JobOffersFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new JobOffersFragment()).commit();
                }
                break;
            case R.id.nav_hire:
                if(!(f instanceof HireFragment)) {
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.home_container, new HireFragment()).commit();
                }
                break;
        }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
