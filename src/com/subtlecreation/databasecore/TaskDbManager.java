package com.subtlecreation.databasecore;

import com.subtlecreation.general.Task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TaskDbManager {
	Context localContext;
	DatabaseSqliteHelper databaseSqliteHelper;
	SQLiteDatabase database;
	String[] allColumns = {	
							DatabaseSqliteHelper.TASKS_ID,
							DatabaseSqliteHelper.TASK_DESCRIPTION,
							DatabaseSqliteHelper.TASK_IMPLEMENTOR,
							DatabaseSqliteHelper.TASK_DATE							
	};
	public TaskDbManager(Context context) {
		localContext = context;
		databaseSqliteHelper = new DatabaseSqliteHelper(localContext);
	}
	public void open(){
		Log.d("GettingDatabase", "Getting a database connection.");
		database = databaseSqliteHelper.getWritableDatabase();
	}
	public void close(){
		databaseSqliteHelper.close();
		Log.d("DatabaseClosed", "Closed the local connection to database.");
	}
	public long storeTask(Task task){
		long insertId = -1;
		ContentValues values = new ContentValues();
		values.put(DatabaseSqliteHelper.TASK_DESCRIPTION, task.getTaskDescription());
		values.put(DatabaseSqliteHelper.TASK_IMPLEMENTOR, task.getTaskImplementor());
		values.put(DatabaseSqliteHelper.TASK_DATE, task.getTaskDate());
		insertId = database.insert(DatabaseSqliteHelper.TASKS_TABLE, null, values);
		return insertId;
	}
	public Cursor getAllTasks(){
		Cursor data = database.query(	DatabaseSqliteHelper.TASKS_TABLE,
										allColumns,
										null,
										null,
										null,
										null,
										null);
		return data;
	}
}
