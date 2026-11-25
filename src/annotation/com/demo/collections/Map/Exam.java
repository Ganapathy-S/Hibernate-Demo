package annotation.com.demo.collections.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

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
@Table(name="EXAMS")
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXAM_ID")
	private long id;

	@Column(name="EXAM_NAME")
	private String examName;

	@org.hibernate.annotations.CollectionOfElements(targetElement=java.util.Date.class,fetch=FetchType.EAGER)
	@JoinTable(name="TIME_TABLE", joinColumns=@JoinColumn(name="EXAM_ID"))
	@org.hibernate.annotations.MapKey(columns=@Column(name="SUBJECT"))
	@Column(name="EXAM_DATE")
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
