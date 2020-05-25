package com.youngmanster.collection.activity.base.dialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.youngmanster.collection.R;
import com.youngmanster.collection.activity.base.adapter.ItemRecycleAdapter;
import com.youngmanster.collectionlibrary.base.dialog.BaseDialogFragment;
import com.youngmanster.collectionlibrary.refreshrecyclerview.base.adapter.BaseRecyclerViewAdapter;
import com.youngmanster.collectionlibrary.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**自定义dialog样式
 * Created by yangyan
 * on 2018/5/14.
 */

public class CustomizeDialog extends BaseDialogFragment implements BaseRecyclerViewAdapter.OnItemClickListener{


	@BindView(R.id.rv_Item)
	protected RecyclerView rv_Item;

	private ItemRecycleAdapter itemRecycleAdapter;
	private List<String> itemStr=new ArrayList<>();


	@Override
	public int setContentView() {
		return R.layout.dialog_list;
	}


	@Override
	public void onViewCreated() {
		ButterKnife.bind(this,mainView);
		rv_Item.setLayoutManager(new LinearLayoutManager(getActivity()));
		for(int i=0;i<10;i++){
			itemStr.add("这是第"+(i+1)+"个item");
		}
		itemRecycleAdapter=new ItemRecycleAdapter(getActivity(),itemStr);
		rv_Item.setAdapter(itemRecycleAdapter);
		itemRecycleAdapter.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(View view, int position) {
		ToastUtils.showToast(getActivity(),itemStr.get(position));
	}
}
