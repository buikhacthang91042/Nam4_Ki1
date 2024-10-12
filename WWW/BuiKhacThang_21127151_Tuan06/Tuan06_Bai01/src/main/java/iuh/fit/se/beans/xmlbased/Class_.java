package iuh.fit.se.beans.xmlbased;

public class Class_ {
	private String classId;
	private String className;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String id) {
		this.classId = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String name) {
		this.className = name;
	}
	@Override
	public String toString() {
		return "Class_ [id=" + classId + ", name=" + className + "]";
	}
	public Class_() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class_(String id, String name) {
		super();
		this.classId = id;
		this.className = name;
	}
	
	
}
