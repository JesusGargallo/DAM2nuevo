/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Alumnes {
	
	private Alumne[] alumnes;
 
	
	public Alumne[] getAlumne() {
		return alumnes;
	}
	public void setAlumne(Alumne[] alumnes) {
		this.alumnes = alumnes;
	}
 
}
