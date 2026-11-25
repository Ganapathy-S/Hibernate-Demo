package annotation.com.demo.collections.Set;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="FOLDERS")
public class Folder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FOLDER_ID")
	private long id;
	
	@Column(name="FOLDER_NAME")
	private String folderName;
	
	@org.hibernate.annotations.CollectionOfElements(
	targetElement=java.lang.String.class,fetch=FetchType.EAGER		
	)
	@JoinTable(name="FILES", joinColumns=@JoinColumn(name="FOLDER_ID"))
	@Column(name="FILENAME", nullable=false)
	private Set<String> files = new HashSet<String>();
	
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
