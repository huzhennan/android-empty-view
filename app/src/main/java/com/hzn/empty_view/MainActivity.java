package com.hzn.empty_view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hzn.emptyview.EmptyView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button mEmptyButton;
    private Button mLoadingButton;
    private Button mErrorButton;
    private EmptyView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmptyView = (EmptyView) findViewById(R.id.empty_test);

        mEmptyButton = (Button) findViewById(R.id.bt_status_empty);
        mLoadingButton = (Button) findViewById(R.id.bt_status_loading);
        mErrorButton = (Button) findViewById(R.id.bt_status_error);

        mEmptyButton.setOnClickListener(this);
        mLoadingButton.setOnClickListener(this);
        mErrorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_status_empty:
                mEmptyView.setStatus(this, EmptyView.STATUS_EMPTY);
                break;
            case R.id.bt_status_loading:
                mEmptyView.setStatus(this, EmptyView.STATUS_LOADING);
                break;
            case R.id.bt_status_error:
                mEmptyView.setStatus(this, EmptyView.STATUS_ERROR);
                break;
        }
    }
}
