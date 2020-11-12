package Exercicio5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Exercicio5 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// Declaramos el Scanner
		Scanner sc = new Scanner(System.in);

                
		try {
			// recorremos documento para hacer un setIdAttribute a true a todos los atributos
			File archivo = new File("E:\\Segundo Superior\\M6\\exercicio5\\exercicio5\\alumnes.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();

			int contadorId = 1;
			NodeList listaAlumnos = document.getDocumentElement().getChildNodes();

			for (int i = 0; i < listaAlumnos.getLength(); i++) {
				Node node = listaAlumnos.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;

					if (node.hasChildNodes()) {

						if (node.getAttributes().getNamedItem("id") != null){

							Element e = (Element) node;
							e.setIdAttribute("id", true);
							contadorId++;
						}
					}
				}
			}

			// Creamos un boolean para parar el while
			boolean parar = false;

			while (!parar) {

				System.out.println("<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>");
				System.out.println("0 Salir del programa");
				System.out.println("1 Mostrar XML:");
				System.out.println("2 Modificar XML:");
				System.out.println("3 Mostrar XML a partir de la id:");
				int seleccio = sc.nextInt();

				// Mostramos el documento entero
				if (seleccio == 1) {

					try {
						System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
						System.out.println();

						for (int i = 0; i < listaAlumnos.getLength(); i++) {
							Node node = listaAlumnos.item(i);

							if (node.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) node;

								if(eElement.hasChildNodes()) {
									NodeList nl = node.getChildNodes();
									System.out.print(eElement.getNodeName());
									NamedNodeMap atributeList = eElement.getAttributes();
									
									for (int j = 0; j < atributeList.getLength(); j++) {
										
										System.out.print(" " + atributeList.item(j).getNodeName() + ": " + atributeList.item(j).getTextContent());
									}
									System.out.println();
									

									recursiva(nl);
								}
								System.out.println();
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				// Si modificamos seleccionamos las dos posibles opciones
				} else if (seleccio == 2) {

					System.out.println("1 Editar Elements");
					System.out.println("2 Editar Atributs");
					int seleccioEdicio = sc.nextInt();

					// Seleccionamos una de las tres posibles opciones para los elementos
					if (seleccioEdicio == 1) {

						System.out.println("1 Crear Element");
						System.out.println("2 Modificar Element");
						System.out.println("3 Eliminar Element");
						seleccioEdicio = sc.nextInt();
						sc.nextLine();

						// Creamos un elemento nuevo
						if (seleccioEdicio == 1) {


							Element element0 = document.getDocumentElement();

							Element element1 = document.createElement("alumne");
							element1.setAttribute("id", String.valueOf(contadorId));

							element0.appendChild(element1);

							Element nom = document.createElement("nom");
							System.out.println("Introduce el nombre");
							nom.appendChild(document.createTextNode(sc.nextLine()));
							element1.appendChild(nom);

							Element cognom1 = document.createElement("cognom1");
							System.out.println("Introduce el cognom1");
							cognom1.appendChild(document.createTextNode(sc.nextLine()));
							element1.appendChild(cognom1);

							Element cognom2 = document.createElement("cognom2");
							System.out.println("Introduce el cognom2");
							cognom2.appendChild(document.createTextNode(sc.nextLine()));
							element1.appendChild(cognom2);

							Element notaFinal = document.createElement("notaFinal");
							System.out.println("Introduce la nota final");
							notaFinal.appendChild(document.createTextNode(sc.nextLine()));
							element1.appendChild(notaFinal);

							contadorId++;
	
						// Modificamos un elemento
						} else if (seleccioEdicio == 2) {

							System.out.println("Introdueix la ID del element que vols modificar");

							int seleccioId = sc.nextInt();
							sc.nextLine();

							Element idElement = document.getElementById(String.valueOf(seleccioId));

							System.out.println(idElement.getNodeName() + " id: " + idElement.getAttribute("id"));

							if (idElement.hasChildNodes()) {

								NodeList nl = idElement.getChildNodes();

								while (nl.getLength()!=0) {
									Node n = nl.item(0);
									idElement.removeChild(n);
								}

								Element nom = document.createElement("nom");
								System.out.println("Introduce el nombre");
								nom.appendChild(document.createTextNode(sc.nextLine()));
								idElement.appendChild(nom);

								Element cognom1 = document.createElement("cognom1");
								System.out.println("Introduce el cognom1");
								cognom1.appendChild(document.createTextNode(sc.nextLine()));
								idElement.appendChild(cognom1);

								Element cognom2 = document.createElement("cognom2");
								System.out.println("Introduce el cognom2");
								cognom2.appendChild(document.createTextNode(sc.nextLine()));
								idElement.appendChild(cognom2);

								Element notaFinal = document.createElement("notaFinal");
								System.out.println("Introduce la nota final");
								notaFinal.appendChild(document.createTextNode(sc.nextLine()));
								idElement.appendChild(notaFinal);

							}

						// Eliminamos un elemento
						} else if (seleccioEdicio == 3) {

							System.out.println("Introdueix la ID del element que vols eliminar");

							int seleccioId = sc.nextInt();

							Element idElement = document.getElementById(String.valueOf(seleccioId));

							if (idElement.hasChildNodes()) {

								NodeList nl = idElement.getChildNodes();

								while (nl.getLength()!=0) {
									Node n = nl.item(0);
									idElement.removeChild(n);
								}
							}

							idElement.getParentNode().removeChild(idElement);

						}

					// Seleccionamos una de las tres posibles opciones para los atributos
					} else if (seleccioEdicio == 2) {

						System.out.println("1 Crear Atribut");
						System.out.println("2 Modificar Atribut");
						System.out.println("3 Eliminar Atribut");
						seleccioEdicio = sc.nextInt();

						// Creamos un atributo a un elemento que no tenga
						if (seleccioEdicio == 1) {

							System.out.println("Introdueix la id del element al que vols crear l'atribut");

							int seleccioId = sc.nextInt();
							
							Element element = document.getElementById(String.valueOf(seleccioId));

							System.out.println("Introdueix el nom del atribut:");
							String nomAtribut = sc.next();
							System.out.println("Introdueix el valor del atribut");
							String valorAtribut = sc.next();
							element.setAttribute(nomAtribut, valorAtribut);

						// Modificamos un atributo id existente
						} else if (seleccioEdicio == 2) {

							System.out.println("Introdueix ID del element al que vols cambiar l'atribut");

							int seleccioId = sc.nextInt();

							Element element = document.getElementById(String.valueOf(seleccioId));

							System.out.println("Introdueix la nova id");
							element.setAttribute("id", String.valueOf(sc.nextInt()));

						// Eliminamos atributo
						} else if (seleccioEdicio == 3) {

							System.out.println("Introdueix ID del element al que vols eliminar l'atribut");

							int seleccioId = sc.nextInt();

							Element element = document.getElementById(String.valueOf(seleccioId));

							element.removeAttribute("id");

						}
					}

				// Al cerrar el programa guardamos el resultado en un nuevo xml
				} else if (seleccio == 0) {

					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					Result output = new StreamResult(new File("E:\\Segundo Superior\\M6\\exercicio5\\exercicio5\\alumnesResultat.xml"));
					Source input = new DOMSource(document);

					transformer.transform(input, output);

					parar = true;

				// Mostramos el elemento y sus hijos a partir de una id
				} else if (seleccio == 3) {

					System.out.println("Introdueix la ID:");
					int seleccioId = sc.nextInt();
					Element idElement = document.getElementById(String.valueOf(seleccioId));

					System.out.println(idElement.getNodeName() + " id: " + idElement.getAttribute("id"));

					if (idElement.hasChildNodes()) {

						Node node = idElement;
						NodeList nl = node.getChildNodes();
						recursiva(nl);
					}
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Funcio recursiva que mostra tot el xml restant
	public static void recursiva (NodeList nl){

		for(int j=0; j<nl.getLength(); j++) {
			Node nd = nl.item(j);
			
			if (nd.getNodeType() == Node.ELEMENT_NODE){
				
				Element element = (Element) nd;
				
				if (element.hasAttributes()) {
					mostrarAtributs(element);
				}
			}

			String nodeName = nd.getNodeName();
			if (!nodeName.equals("#text")){
				System.out.println(nodeName + ": " + nd.getTextContent());
			}
			if (nd.hasChildNodes()){
				NodeList nl2 = nd.getChildNodes();
				recursiva(nl2);
			}
		}
	}
	
	// Funcio que mostra els atributs
	public static void mostrarAtributs (Element element) {
		
		NamedNodeMap atributeList = element.getAttributes();
		
		for (int j = 0; j < atributeList.getLength(); j++) {
			
			System.out.print(" " + atributeList.item(j).getNodeName() + ": " + atributeList.item(j).getTextContent());
		}
		System.out.println();
	}
}