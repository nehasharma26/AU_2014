package assignment.hibernate.enteties;

public class Course {
	private int courseId;
	private String name;
	private String description;
	private int durationInMonths;
	private String admissionProcess;
	private String eligibilityCriteria;
	public String getAdmissionProcess() {
		return admissionProcess;
	}
	public void setAdmissionProcess(String admissionProcess) {
		this.admissionProcess = admissionProcess;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public Course(String name,String description,int durationInMonths,String admissionProcess,String eligibilityCriteria){
		this.name=name;
		this.description=description;
		this.durationInMonths=durationInMonths;
		this.admissionProcess=admissionProcess;
		this.eligibilityCriteria=eligibilityCriteria;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
}
