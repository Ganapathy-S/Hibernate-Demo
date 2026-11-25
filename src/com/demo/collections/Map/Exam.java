package com.demo.collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class Exam {

	private long id;

	private String examName;

	private Map<String,Date> timeTable = new HashMap<String, Date>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Map<String, Date> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(Map<String, Date> timeTable) {
		this.timeTable = timeTable;
	}
}
