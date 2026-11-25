package com.demo.collections.Set;

import java.util.HashSet;
import java.util.Set;

public class Folder {
	
	private long id;
	
	private String folderName;
	
	private Set files = new HashSet();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public Set getFiles() {
		return files;
	}

	public void setFiles(Set files) {
		this.files = files;
	}
}
