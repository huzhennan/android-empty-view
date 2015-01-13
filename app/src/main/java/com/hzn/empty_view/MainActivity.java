package com.hzn.empty_view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.hzn.emptyview.EmptyView;

import java.util.ArrayList;
import java.util.List;

/**
 * A sample use EmptyView
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button mEmptyButton;
    private Button mLoadingButton;
    private Button mErrorButton;
    private Button mResetButton;
    private EmptyView mEmptyView;
    private ListView mSampleListView;
    private ArrayAdapter<String> mAdapter;

    static List<String> DATA = new ArrayList<String>();

    // the list items
    static final String[] MOVIES = new String[]{
            "Forrest Gump",
            "Toy Story",
            "Saving Private Ryan",
            "Toy Story 2",
            "The Green Mile",
            "Cast Away",
            "Road to Perdition",
            "Catch Me If You Can",
            "The Terminal",
            "The Polar Express",
            "The Da Vinci Code",
            "Angels & Demons",
            "Toy Story 3",
            "Extremely Loud & Incredibly Close",
            "Cloud Atlas",
            "Captain Phillips",
            "Toy Story 4",
            "The Lost Symbol"
    };

    static {
        for (String movie : MOVIES) {
            DATA.add(movie);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmptyView = (EmptyView) findViewById(R.id.empty_test);
        mSampleListView = (ListView) findViewById(R.id.list_sample);
        mEmptyButton = (Button) findViewById(R.id.bt_status_empty);
        mLoadingButton = (Button) findViewById(R.id.bt_status_loading);
        mErrorButton = (Button) findViewById(R.id.bt_status_error);
        mResetButton = (Button) findViewById(R.id.bt_reset);

        mEmptyView.setTryAgainListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Try again button clicked", Toast.LENGTH_LONG).show();
            }
        });

        mAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, DATA);
        mSampleListView.setAdapter(mAdapter);
        mSampleListView.setEmptyView(mEmptyView);

        mEmptyButton.setOnClickListener(this);
        mLoadingButton.setOnClickListener(this);
        mErrorButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_status_empty:
                mAdapter.clear();
                // alse can directly use setStatus
                //mEmptyView.setStatus(EmptyView.STATUS_EMPTY);
                mEmptyView.showEmpty();
                break;
            case R.id.bt_status_loading:
                mAdapter.clear();
                // alse can directly use setStatus
                //mEmptyView.setStatus(EmptyView.STATUS_LOADING);
                mEmptyView.showLoading();
                break;
            case R.id.bt_status_error:
                mAdapter.clear();
                // alse can directly use setStatus
                //mEmptyView.setStatus(EmptyView.STATUS_ERROR);
                mEmptyView.showError();
                break;
            case R.id.bt_reset:
                mAdapter.clear();
                for (String movie : MOVIES) {
                    mAdapter.add(movie);
                }
                break;
        }
    }
}
