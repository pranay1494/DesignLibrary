package com.customview.pranay.designlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Collections;
import java.util.List;

import Model.RecyclerModel;
import adapter.RecyclerviewAdapter;
import dummyData.DummyData;

/**
 * Created by Pranay on 14-01-2017.
 */
public class AdvancedRecyclerview extends AppCompatActivity{
    private RecyclerView recyclerView;
    private List<RecyclerModel> list;
    private RecyclerviewAdapter adapter;
    private RelativeLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.advanced_recyclerview);
        layout = (RelativeLayout) findViewById(R.id.rlTop);

        DummyData data = new DummyData();
        list = data.getImages();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerviewAdapter(this,list);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN
                ,ItemTouchHelper.START | ItemTouchHelper.END) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                updateList(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                boolean[] proceed = dispalySnackBar(viewHolder.getAdapterPosition());
                if(proceed[0]) {
                    list.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private boolean[] dispalySnackBar(final int position) {
        final boolean[] remove = {true};
        Snackbar snackbar = Snackbar.make(layout,"Undo Remove",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove[0] = false;
                adapter.notifyItemInserted(position);
            }
        });
        snackbar.show();
        return remove;
    }

    private void updateList(int initialPosition, int finalPosition) {
        if (initialPosition < finalPosition) {
            for (int i = initialPosition; i < finalPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else {
            for (int i = initialPosition; i > finalPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }
    }
}
