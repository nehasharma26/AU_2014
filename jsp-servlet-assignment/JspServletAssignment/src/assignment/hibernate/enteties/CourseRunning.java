package assignment.hibernate.enteties;

public class CourseRunning {
	private int courseId;
	private int instId;
	private String eligibilityCriteria;
	private String admissionProcedure;
	

	public CourseRunning(int courseId, int instId, String eligibilityCriteria,
			String admissionProcedure) {
		this.courseId = courseId;
		this.instId = instId;
		this.eligibilityCriteria = eligibilityCriteria;
		this.admissionProcedure = admissionProcedure;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public String getAdmissionProcedure() {
		return admissionProcedure;
	}

	public void setAdmissionProcedure(String admissionProcedure) {
		this.admissionProcedure = admissionProcedure;
	}

}
