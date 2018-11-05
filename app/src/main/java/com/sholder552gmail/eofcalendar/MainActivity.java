package com.sholder552gmail.eofcalendar;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
//TODO: Replace unnecessary if statements with same case/switch statements (if java has them)
//TODO: Replae Data.getInstance() with a persistant model variable

//TODO: (9/1/2018) Wrote some code today in the Data "model" that has yet to be tested. Test it and then commit code.
public class MainActivity extends AppCompatActivity {
    private boolean hasMonthCxt;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Capture current date and break it into month day and year variables
        String day = (String)android.text.format.DateFormat.format("dd", new Date());
        int dayNumber;
        if(Data.getInstance().hasMonthCxt){
            dayNumber = 1;
        }
        else{
            dayNumber = Integer.parseInt(day);
        }

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(dayNumber -  1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActionsDialog();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void openActionsDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.calendar_action_dialog, null);
        builder.setTitle("What would you like to do?");
        builder.setMessage("Please choose an action:");
        builder.setView(view)
                .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.actionsRadioGroup);
                        RadioButton currentDateButton = (RadioButton) view.findViewById(R.id.currentDate);
                        RadioButton monthsButton = (RadioButton) view.findViewById(R.id.viewMonths);
                        int selectedRadioButton = radioGroup.getCheckedRadioButtonId();
                        if (selectedRadioButton == monthsButton.getId()){
                            chooseMonth();
                        }
                        if (selectedRadioButton == currentDateButton.getId()){
                            backToToday();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void chooseMonth(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.calendar_title_pages_view, null);

        view.findViewById(R.id.janTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("jan");
            }
        });
        view.findViewById(R.id.febTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("feb");
            }
        });
        view.findViewById(R.id.marTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("mar");
            }
        });
        view.findViewById(R.id.aprTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("apr");
            }
        });
        view.findViewById(R.id.mayTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("may");
            }
        });
        view.findViewById(R.id.junTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("jun");
            }
        });
        view.findViewById(R.id.julTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("jul");
            }
        });
        view.findViewById(R.id.augTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("aug");
            }
        });
        view.findViewById(R.id.sepTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("sep");
            }
        });
        view.findViewById(R.id.octTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("oct");
            }
        });
        view.findViewById(R.id.novTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("nov");
            }
        });
        view.findViewById(R.id.decTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMonth("dec");
            }
        });
        builder.setTitle("Epitome of Faith");
        builder.setMessage("Please Choose a Month:");
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void setMonth(String month){
        Data.getInstance().month = month;
        Data.getInstance().hasMonthCxt = true;
        finish();
        startActivity(getIntent());
    }

    public void backToToday(){
        Data.getInstance().hasMonthCxt = false;
        finish();
        startActivity(getIntent());
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView calendarPage = (ImageView) rootView.findViewById(R.id.calendarImage);
            if (Data.getInstance().hasMonthCxt){
                calendarPage.setImageResource(getResources().getIdentifier(Data.getInstance().month + "_" + getArguments().getInt(ARG_SECTION_NUMBER), "drawable", "com.sholder552gmail.eofcalendar"));
            }
            else {
                String month = (String) android.text.format.DateFormat.format("MMM", new Date());
                calendarPage.setImageResource(getResources().getIdentifier(month.toLowerCase() + "_" + getArguments().getInt(ARG_SECTION_NUMBER), "drawable", "com.sholder552gmail.eofcalendar"));
            }
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.

            //Feed our data class into here, get a context for the amount of days we need based on the month.
            // Add a couple integers to this number for more placeholderfragments that we could fill with buttons.
            int days = Data.getInstance().getMonthInfo();
            return days;
        }
    }
}
