package com.subtlecreation.general;

public class Task {
	String taskDescription;
	String taskImplementor;
	String taskDate;
	int taskIdOnDatabase;
	public Task() {
	}
	public int getTaskIdOnDatabase() {
		return taskIdOnDatabase;
	}
	public void setTaskIdOnDatabase(int taskIdOnDatabase) {
		this.taskIdOnDatabase = taskIdOnDatabase;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public String getTaskImplementor() {
		return taskImplementor;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public void setTaskImplementor(String taskImplementor) {
		this.taskImplementor = taskImplementor;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
}
