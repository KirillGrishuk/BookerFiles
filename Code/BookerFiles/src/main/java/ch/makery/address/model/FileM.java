package ch.makery.address.model;

import ch.makery.address.view.MysqlConnect;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileM {

	private final StringProperty date;
	private final StringProperty name;
	private final StringProperty organization;
	private final SimpleStringProperty Tapping;
	private final StringProperty path;

	String query = "select  * from mainwin";
	MysqlConnect mysqlConnect = new MysqlConnect();
	PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
	ResultSet resultSet = statement.executeQuery(query);

	public FileM() throws SQLException {
		this(null, null);
	}

	public FileM(String firstName, String lastName) throws SQLException {
		this.date = new SimpleStringProperty(firstName);
		this.name = new SimpleStringProperty(lastName);

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
		return date;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return name;
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