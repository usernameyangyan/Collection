package com.youngmanster.collectionlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.youngmanster.collectionlibrary.mvp.BasePresenter;
import com.youngmanster.collectionlibrary.mvp.ClassGetUtil;

/**
 * Created by yangyan
 * on 2018/3/18.
 */

public abstract class IBaseActivity<T extends BasePresenter> extends AppCompatActivity {
	public T mPresenter;

	private boolean isFirst = false;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getLayoutId() != 0) {
			setContentView(getLayoutId());
		}

		mPresenter = ClassGetUtil.getClass(this, 0);

		if (mPresenter != null) {
			mPresenter.setV(this);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (!isFirst) {
			init();
			requestData();
			isFirst = true;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (mPresenter != null) {
			mPresenter.onDestroy();
		}
	}

	/**
	 * 布局文件加载
	 */
	public abstract int getLayoutId();

	/**
	 * 初始化参数
	 */
	public abstract void init();

	/**
	 * 请求数据
	 */
	public abstract void requestData();
}
