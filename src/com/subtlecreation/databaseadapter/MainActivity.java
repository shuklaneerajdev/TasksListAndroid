package com.subtlecreation.databaseadapter;

import java.util.Date;

import com.subtlecreation.general.Task;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	EditText taskDescription;
	EditText taskImplementor;
	Button createTaskButton;
	DataDisplayFragment displayFragment;
	DatePicker taskDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragmentContainer, new DataDisplayFragment(), "TASKSFRAGMENT").commit();
		}
		getSupportFragmentManager().executePendingTransactions();
		displayFragment = (DataDisplayFragment)getSupportFragmentManager().findFragmentByTag("TASKSFRAGMENT");
		taskDescription = (EditText)findViewById(R.id.taskDescription);
		taskImplementor = (EditText)findViewById(R.id.taskImplementor);
		createTaskButton = (Button)findViewById(R.id.createTask);
		taskDate = (DatePicker)findViewById(R.id.taskDate);
		createTaskButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View view) {
				Task newTask = new Task();				
				newTask.setTaskDescription(taskDescription.getText().toString());
				newTask.setTaskImplementor(taskImplementor.getText().toString());
				Date taskDateValue = new Date(taskDate.getYear(), taskDate.getMonth(), taskDate.getDayOfMonth());
				newTask.setTaskDate(taskDateValue.toLocaleString());
				displayFragment.addTask(newTask);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
