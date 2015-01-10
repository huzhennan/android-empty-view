package com.hzn.empty_view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.hzn.emptyview.EmptyView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button mEmptyButton;
    private Button mLoadingButton;
    private Button mErrorButton;
    private Button mResetButton;

    private EmptyView mEmptyView;
    private ListView mTestListView;
    private ArrayAdapter<String> mAdapter;

    private List<String> DATA = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DATA.add("hello");
        DATA.add("foo");
        DATA.add("bar");

        mEmptyView = (EmptyView) findViewById(R.id.empty_test);

        mTestListView = (ListView) findViewById(R.id.list_for_test);
        mAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, DATA);
        mTestListView.setAdapter(mAdapter);

        mTestListView.setEmptyView(mEmptyView);


        mEmptyButton = (Button) findViewById(R.id.bt_status_empty);
        mLoadingButton = (Button) findViewById(R.id.bt_status_loading);
        mErrorButton = (Button) findViewById(R.id.bt_status_error);
        mResetButton = (Button) findViewById(R.id.bt_reset);

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
                mEmptyView.setStatus(this, EmptyView.STATUS_EMPTY);
                break;
            case R.id.bt_status_loading:
                mAdapter.clear();
                mEmptyView.setStatus(this, EmptyView.STATUS_LOADING);
                break;
            case R.id.bt_status_error:
                mAdapter.clear();
                mEmptyView.setStatus(this, EmptyView.STATUS_ERROR);
                break;
            case R.id.bt_reset:
                mAdapter.clear();
                mAdapter.add("hzn");
                break;
        }
    }
}
