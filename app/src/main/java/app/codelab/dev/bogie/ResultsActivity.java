package app.codelab.dev.bogie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 27/06/2017.
 */

public class ResultsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<Result> mResults = new ArrayList<>();


    private RecyclerView mResultsView;
    private ResultAdapter mResultsAdapter;

    private DatabaseReference mDatabase;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        final Intent intent = getIntent();
        final String bogieCategory = intent.getStringExtra("category");

        Log.i("ResultActivity", bogieCategory);

        final Query query = mDatabase.orderByChild("bogie").equalTo(bogieCategory);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Result result = postSnapshot.getValue(Result.class);
                    mResults.add(result);
                }
                Log.i("Resultats", mResults.toString());
                setupResultsList(mResults);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void setupResultsList(final List<Result> results) {
        mResultsView = (RecyclerView) findViewById(R.id.rv_bogie);
        mResultsAdapter = new ResultAdapter(results);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mResultsView.setLayoutManager(mLayoutManager);
        mResultsView.setAdapter(mResultsAdapter);
    }
}
