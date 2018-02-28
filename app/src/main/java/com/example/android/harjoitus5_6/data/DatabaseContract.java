package com.example.android.harjoitus5_6.data;

import android.provider.BaseColumns;

/**
 * Created by Roope on 28-Feb-18.
 */

public class DatabaseContract {

    public static final class TrainingEntry implements BaseColumns {
        public static final String TABLE_NAME = "training";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_RPE = "rpe";
        public static final String COLUMN_SHARPNESS = "sharpness";
        public static final String COLUMN_SPORT = "sport";
    }
}
