package assignment.hibernate.enteties;

public class Institute {
	private int instId;
	private String title;
	private String description;
	private String location;
	private String branches;
	private String image;
	private String courses;

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public Institute() {
	}

	public Institute(String title, String description, String location,
			String branches, String image,String courses) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.branches = branches;
		this.image = image;
		this.courses=courses;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int id) {
		this.instId = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;

	}
}
