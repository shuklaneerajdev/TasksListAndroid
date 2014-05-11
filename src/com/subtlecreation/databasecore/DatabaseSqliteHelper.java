package com.subtlecreation.databasecore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseSqliteHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "BASE_DATABASE";
	public static final int DATABASE_VERSION = 1;
	public static String TASKS_TABLE = "AllTasks";
	public static String TASKS_ID = "_id";
	public static String TASK_DESCRIPTION = "taskDescription";
	public static String TASK_IMPLEMENTOR = "taskImplementor";
	public static String TASK_DATE = "taskDate";
	
	public static String CREATE_TASKS_TABLE = 	"create table "+
												TASKS_TABLE + " ( "
												+TASKS_ID + " integer primary key autoincrement, "
												+TASK_DESCRIPTION+ " text not null , "
												+TASK_IMPLEMENTOR+" text not null , "
												+ TASK_DATE + " text not null "
												+ ");";
	
	public DatabaseSqliteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_TASKS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.d("DATABASEUPGRADE", "The database has been upgraded.");
	}

}
