package net.example.springbootexp;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name="id")
	private int id;
	

	@Column(name="mark")
	private int mark;
	
	
	
	public Student() {
		super();
	}

	public Student(int id, int mark, String name) {
		super();
		this.id = id;
		this.mark = mark;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="name")
	private String name;
	
	

}
