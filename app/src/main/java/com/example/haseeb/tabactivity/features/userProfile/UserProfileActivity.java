package com.example.haseeb.tabactivity.features.userProfile;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haseeb.tabactivity.features.userFollowers.FollowerAdapter;
import com.example.haseeb.tabactivity.features.userFollowers.FollowersFragment;
import com.example.haseeb.tabactivity.features.userRepository.RepositoryFragment;
import com.example.haseeb.tabactivity.data.Repository;
import com.example.haseeb.tabactivity.R;
import com.squareup.picasso.Picasso;

public class UserProfileActivity extends AppCompatActivity implements UserProfileView {
    ImageView img;
    TextView username, etname, bio;
    String userName;
    ProgressBar progressBar;
    FollowerAdapter adapter;
    UserProfilePresenterImpl profilePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofileactivity);
        img = findViewById(R.id.imageView);
        username = findViewById(R.id.username);

        profilePresenter = new UserProfilePresenterImpl(this, new Repository());


        etname = findViewById(R.id.name);
        bio = findViewById(R.id.bio);
        Bundle extras = getIntent().getExtras();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        userName = extras.getString("username");
        // presenter.PresentUserName(userName);
//        profilePresenter.onSucess(userName);
        profilePresenter.GetSearchName(userName);


        //  GetUserProfile();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Repository"));
        tabLayout.addTab(tabLayout.newTab().setText("Followers"));
        //    tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        //   viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSucess(String LogName, String imagUrl, String name, String Bio) {
        username.setText(LogName);
        Picasso.get().load(imagUrl).into(img);
        etname.setText(name);
        bio.setText(Bio);
        progressBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void failed() {
        Toast.makeText(getApplicationContext(), "Error in responce", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.INVISIBLE);
    }


    class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return RepositoryFragment.newInstance("username", userName);
                case 1:
                    return FollowersFragment.newInstance("username", userName);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}

