package com.hzn.emptyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by hzn on 1/10/15.
 */
public class EmptyView extends FrameLayout {
    /**
     * The empty status
     */
    public final static int STATUS_EMPTY = 0;
    /**
     * The loading status
     */
    public final static int STATUS_LOADING = 1;
    /**
     * The error status
     */
    public final static int STATUS_ERROR = 2;

    private View mStatusEmptyView;
    private View mStatusLoadingView;
    private View mStatusErrorView;
    private int mStatus;

    private OnClickListener mTryAgainListener;

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EmptyView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mStatusEmptyView = inflate(context, R.layout.view_empty, null);
        mStatusLoadingView = inflate(context, R.layout.view_loading, null);
        mStatusErrorView = inflate(context, R.layout.view_error, null);

        LinearLayout errorLayout = (LinearLayout) mStatusErrorView.findViewById(R.id.ll_error_panel);
        errorLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTryAgainListener != null) {
                    mTryAgainListener.onClick(v);
                } else {
                    Toast.makeText(getContext(), "You need to set a callback for 'try again'!!!"
                            , Toast.LENGTH_LONG).show();
                }
            }
        });

        mStatus = STATUS_EMPTY;
        initWithStatus(context, mStatus);
    }

    private void initWithStatus(Context context, int status) {
        switch (status) {
            case STATUS_EMPTY:
                removeAllViews();
                addView(mStatusEmptyView);
                break;
            case STATUS_LOADING:
                removeAllViews();
                addView(mStatusLoadingView);
                break;
            case STATUS_ERROR:
                removeAllViews();
                addView(mStatusErrorView);
                break;
            default:
                throw new UnsupportedOperationException("no this status");
        }
    }

    /**
     * Sets the empty view's status. with different status, display different view.
     *
     * @param status use EmptyView.STATUS_EMPTY EmptyView.STATUS_LOADING EmptyView.mStatusErrorView
     */
    public void setStatus(int status) {
        mStatus = status;
        initWithStatus(getContext(), mStatus);
    }

    /**
     * set Press to try again callback
     *
     * @param tryAgainListener
     */
    public void setTryAgainListener(OnClickListener tryAgainListener) {
        mTryAgainListener = tryAgainListener;
    }

    /**
     * Shows the empty layout.
     */
    public void showEmpty() {
        setStatus(STATUS_EMPTY);
    }

    /**
     * Shows the loading layout.
     */
    public void showLoading() {
        setStatus(STATUS_LOADING);
    }

    /**
     * Shows the error layout.
     */
    public void showError() {
        setStatus(STATUS_ERROR);
    }
}
