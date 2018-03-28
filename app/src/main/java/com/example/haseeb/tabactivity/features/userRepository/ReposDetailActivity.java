package com.example.haseeb.tabactivity.features.userRepository;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haseeb.tabactivity.data.Models.RepositoryModels;
import com.example.haseeb.tabactivity.features.commits.CommentFragment;
import com.example.haseeb.tabactivity.features.repositoryConttributors.ContributorsFragment;
import com.example.haseeb.tabactivity.R;
import com.squareup.picasso.Picasso;

public class ReposDetailActivity extends AppCompatActivity {

    TextView username, fork, watchers, date, size, lang;
    ImageView profileImage;
    RepositoryModels repoList;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_repos_detail);
        username = findViewById(R.id.activity_detail_repo_fullName);
        profileImage = findViewById(R.id.repo_detail_owner_Profile_img);
        fork = findViewById(R.id.fork_value);
        watchers = findViewById(R.id.watchers_value);
        date = findViewById(R.id.date);
        size = findViewById(R.id.size);
        lang = findViewById(R.id.lang);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Contributers"));
        tabLayout.addTab(tabLayout.newTab().setText("Commits"));

        repoList = getIntent().getParcelableExtra("repo");
        username.setText(repoList.getFullName().toString());
        Picasso.get().load(repoList.getOwner().getAvatarUrl()).into(profileImage);


        fork.setText(repoList.getForks() + "");
        watchers.setText(String.valueOf(repoList.getWatchers()));
        try {
            // dateSizelang.setText(repoList.getCreatedAt() + ",");
            size.setText(repoList.getSize() + "MB");
            lang.setText(repoList.getLanguage().toString());


        } catch (NullPointerException ex) {
            Toast.makeText(getApplicationContext(), "null date", Toast.LENGTH_SHORT).show();
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        PagerAdapter1 pagerAdapter1 = new PagerAdapter1(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter1);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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

    @RequiresApi(api = Build.VERSION_CODES.N)


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

    class PagerAdapter1 extends FragmentStatePagerAdapter {
        int number;


        public PagerAdapter1(FragmentManager fm, int tabCount) {
            super(fm);
            this.number = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ContributorsFragment.newInstance(repoList.getFullName(), repoList.getName());
                case 1:
                    CommentFragment commentFragment = new CommentFragment();
                    return commentFragment;
                default:
                    return null;

            }
        }


        @Override
        public int getCount() {
            return number;
        }
    }
}
