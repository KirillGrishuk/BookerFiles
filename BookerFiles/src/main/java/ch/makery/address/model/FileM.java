package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class FileM {

	private final StringProperty date;
	private final StringProperty name;
	private final StringProperty organization;
	private final SimpleStringProperty Tapping;
	private final StringProperty path;

	public FileM() throws SQLException {
		this(null, null);
	}

	public FileM(String date, String name) throws SQLException {
		this.date = new SimpleStringProperty(date);
		this.name = new SimpleStringProperty(name);
		this.organization = new SimpleStringProperty();
		this.Tapping = new SimpleStringProperty();
		this.path = new SimpleStringProperty();
	}
	
	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}
	
	public StringProperty dateProperty() {
		return name;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return date;
	}

	public String getOrganization() {
		return organization.get();
	}

	public void setOrganization(String organization) {
		this.organization.set(organization);
	}
	
	public StringProperty organizationProperty() {
		return organization;
	}

	public String getTapping() {
		return Tapping.get();
	}

	public void setTapping(String tapping) {
		this.Tapping.set(tapping);
	}
	
	public SimpleStringProperty tappingProperty() {
		return Tapping;
	}

	public String getPath() {
		return path.get();
	}

	public void setPath(String path) {
		this.path.set(path);
	}
	
	public StringProperty pathProperty() {
		return path;
	}

}