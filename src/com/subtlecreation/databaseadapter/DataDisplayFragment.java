package com.subtlecreation.databaseadapter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.subtlecreation.databasecore.DatabaseSqliteHelper;
import com.subtlecreation.databasecore.TaskDbManager;
import com.subtlecreation.general.Task;

public class DataDisplayFragment extends Fragment {
	ListView listView;
	SimpleCursorAdapter simpleCursorAdapter;
	String[] toBeUsedColumns;
	int[] toBePopulatedViews;
	TaskDbManager taskDatabaseManager ;
	public DataDisplayFragment() {
		toBeUsedColumns = new String[]{
				DatabaseSqliteHelper.TASK_DESCRIPTION,
				DatabaseSqliteHelper.TASK_IMPLEMENTOR,
				DatabaseSqliteHelper.TASK_DATE
		};
		toBePopulatedViews = new int[]{
			R.id.taskDescription,
			R.id.taskImplementor,
			R.id.taskDate
		};
	}
			 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		return rootView;
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		taskDatabaseManager = new TaskDbManager(getActivity().getApplicationContext());
		listView = (ListView)getActivity().findViewById(R.id.datalistview);
		taskDatabaseManager.open();
		Cursor allTasks = taskDatabaseManager.getAllTasks();		
		simpleCursorAdapter = new SimpleCursorAdapter(	getActivity().getApplicationContext(),
														R.layout.task,
														allTasks,
														toBeUsedColumns,
														toBePopulatedViews);
		listView.setAdapter(simpleCursorAdapter);
		taskDatabaseManager.close();
	}
	public void addTask(Task task){
		taskDatabaseManager.open();
		taskDatabaseManager.storeTask(task);
		Cursor freshData = taskDatabaseManager.getAllTasks();
		simpleCursorAdapter.changeCursor(freshData);
		taskDatabaseManager.close();
	}
}
