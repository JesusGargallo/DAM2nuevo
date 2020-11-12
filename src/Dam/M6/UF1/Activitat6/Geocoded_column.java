package exercicio6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "row")

//Clase per element geocoded_column
public class Geocoded_column {

	private double latitude;
	private double longitude;
	
	@XmlAttribute(name="latitude")
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	@XmlAttribute(name="longitude")
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
