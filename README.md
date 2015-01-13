Android Empty View
==================
用来显示列表(ListView)为空的视图(View).有以下三种状态：
* 列表正在加载中
* 列表没有任务项
* 加载错误

**这个库资源接口等参考[Android Empty Layout](https://github.com/alamkanak/android-empty-layout).**

截图
---
![alt text](https://github.com/huzhennan/android-empty-view/blob/master/Screenshots/Screenshot_empty.png "empty")

使用
---
1. 在layout XML文件里定义EmptyView
```java
    <com.hzn.emptyview.EmptyView
        android:id="@+id/empty_test"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone"
        />
```
2.设置EmptyView为ListView的空视图
```java
    mEmptyView = (EmptyView) findViewById(R.id.empty_test);
    mSampleListView.setEmptyView(mEmptyView);
```
3.当数据还在加载中,
```java
    mAdapter.clear();
    mEmptyView.showLoading();
```
4.当数据项为空时
```java
    mAdapter.clear();
    mEmptyView.showEmpty();
```
5.当数据加载出错时
```java
    mAdapter.clear();
    mEmptyView.showError();
```
6.数据加载出错时，设置回调重试
```java
    mEmptyView.setTryAgainListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Try again button clicked", Toast.LENGTH_LONG).show();
        }
    });
```

