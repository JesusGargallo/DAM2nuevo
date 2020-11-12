package exercicio6;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Rows {
	
	private Row[] row;

	public Row[] getRow() {
		return row;
	}

	public void setRow(Row[] row) {
		this.row = row;
	}
}
