package com.hzn.emptyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

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

        mStatus = STATUS_EMPTY;
        initWithStatus(context, mStatus);
    }

    public void setStatus(Context context, int status) {
        mStatus = status;
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
}
