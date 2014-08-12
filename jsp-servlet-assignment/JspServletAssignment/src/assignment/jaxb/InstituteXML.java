package assignment.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "Institute")
@XmlType(propOrder = {"title", "description", "location", "branches","courses"})
public class InstituteXML {
	private String title;
	private String description;
	private String location;
	private String branches;
	private String courses;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}

	 @Override
	    public String toString() {
	        return "Title = " + title + " Description=" + description + " Location=" + location + " Branches=" + branches + " Courses=" +
	                courses;
	    }

}
