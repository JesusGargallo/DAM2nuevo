package exercicio6;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "row")

// Clase per element fitxa
public class Fitxa {

	private String url;

	@XmlAttribute(name="url")      
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
