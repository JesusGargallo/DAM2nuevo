package exercicio6;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement(name = "rows")

//@XmlAccessorType(XmlAccessType.FIELD) // This line was added
class Row {

	private String _id;
	private String _uuid;
	private int _position;
	private String _address;
	
	private int id;	
	private String clau;
	private String titol;
	private double x;
	private double y;
	private String desapareguda;
	private String bandol;
	private String notes;
	private String numRestes;
	private String municipi;
	private String comarca;
	private String idCategoria;
	private String estudi_ebre;
	private Fitxa fitxa;
	private String excavades;
	private Geocoded_column geocoded_column;

	@XmlAttribute(name="_id")        
	public String getIdAtribute() {
		return this._id;
	}        

	public void setIdAtribute(String id) {
		this._id = id;
	}

	@XmlAttribute(name="_uuid")        
	public String getUuid() {
		return this._uuid;
	}        

	public void setUuid(String s) {
		this._uuid = s;
	}
	
	@XmlAttribute(name="_position")        
	public int getPosition() {
		return this._position;
	}        

	public void setPosition(int n) {
		this._position = n;
	}
	
	@XmlAttribute(name="_address")        
	public String getAddress() {
		return this._address;
	}        

	public void setAdress(String s) {
		this._address = s;
	}
	
	//@XmlAttribute(name="Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//@XmlAttribute(name="Clau")
	public String getClau() {
		return clau;
	}

	public void setClau(String clau) {
		this.clau = clau;
	}

	//@XmlAttribute(name="Titol")
	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	//@XmlAttribute(name="X")
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	//@XmlAttribute(name="Y")
	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	//@XmlAttribute(name="Desapareguda")
	public String getDesapareguda() {
		return desapareguda;
	}

	public void setDesapareguda(String desapareguda) {
		this.desapareguda = desapareguda;
	}

	//@XmlAttribute(name="Bandol")
	public String getBandol() {
		return bandol;
	}

	public void setBandol(String bandol) {
		this.bandol = bandol;
	}

	//@XmlAttribute(name="Notes")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	//@XmlAttribute(name="Restes")
	public String getNumRestes() {
		return numRestes;
	}

	public void setNumRestes(String numRestes) {
		this.numRestes = numRestes;
	}

	//@XmlAttribute(name="Municipi")
	public String getMunicipi() {
		return municipi;
	}

	public void setMunicipi(String municipi) {
		this.municipi = municipi;
	}

	//@XmlAttribute(name="Comarca")
	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	//@XmlAttribute(name="Categoria")
	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	//@XmlAttribute(name="Estudi_ebre")
	public String getEstudi_ebre() {
		return estudi_ebre;
	}

	public void setEstudi_ebre(String estudi_ebre) {
		this.estudi_ebre = estudi_ebre;
	}

	//@XmlAttribute(name="Fitxa")
	public Fitxa getFitxa() {
		return fitxa;
	}

	public void setFitxa(Fitxa fitxa) {
		this.fitxa = fitxa;
	}

	//@XmlAttribute(name="Excavades")
	public String getExcavades() {
		return excavades;
	}

	public void setExcavades(String excavades) {
		this.excavades = excavades;
	}

	//@XmlAttribute(name="Geocoded_column")
	public Geocoded_column getGeocoded_column() {
		return geocoded_column;
	}

	public void setGeocoded_column(Geocoded_column geocoded_column) {
		this.geocoded_column = geocoded_column;
	}
}

