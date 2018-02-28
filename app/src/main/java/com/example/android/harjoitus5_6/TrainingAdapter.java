package com.example.android.harjoitus5_6;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.harjoitus5_6.data.DatabaseContract;

/**
 * Created by Roope on 28-Feb-18.
 */

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingAdapterViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    public TrainingAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    public class TrainingAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mDateTextView;
        public final TextView mSportTextView;
        public final TextView mDurationTextView;
        public final TextView mRpeTextView;
        public final TextView mSharpnessTextView;

        public TrainingAdapterViewHolder(View view) {
            super(view);
            mDateTextView = (TextView) view.findViewById(R.id.tv_training_date);
            mSportTextView = (TextView) view.findViewById(R.id.tv_training_sport);
            mDurationTextView = (TextView) view.findViewById(R.id.tv_training_duration);
            mRpeTextView = (TextView) view.findViewById(R.id.tv_training_rpe);
            mSharpnessTextView = (TextView) view.findViewById(R.id.tv_training_sharpness);
        }
    }

    @Override
    public TrainingAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.training_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        TrainingAdapterViewHolder viewHolder = new TrainingAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrainingAdapterViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String date = mCursor.getString(mCursor.getColumnIndex(DatabaseContract.TrainingEntry.COLUMN_DATE));
        long id = mCursor.getLong(mCursor.getColumnIndex(DatabaseContract.TrainingEntry._ID));
        String sport = mCursor.getString(mCursor.getColumnIndex(DatabaseContract.TrainingEntry.COLUMN_SPORT));
        int duration = mCursor.getInt(mCursor.getColumnIndex(DatabaseContract.TrainingEntry.COLUMN_DURATION));
        int rpe = mCursor.getInt(mCursor.getColumnIndex(DatabaseContract.TrainingEntry.COLUMN_RPE));
        int sharpness = mCursor.getInt(mCursor.getColumnIndex(DatabaseContract.TrainingEntry.COLUMN_SHARPNESS));

        holder.mDateTextView.setText(date);
        holder.mSportTextView.setText(sport);
        holder.mDurationTextView.setText(String.valueOf(duration) + " min");
        holder.mSharpnessTextView.setText(String.valueOf(sharpness));
        holder.mRpeTextView.setText(String.valueOf(rpe));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() { return mCursor.getCount(); }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }
}
