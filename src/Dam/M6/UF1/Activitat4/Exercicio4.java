package exercicio4;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Exercicio4 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        File file = new File("E:\\Segundo Superior\\M6\\exercicio4\\exercicio4\\rows.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        Element nodeArrel = doc.getDocumentElement();
        NodeList list = nodeArrel.getChildNodes();
        
        for(int i = 0; i < list.getLength(); i++){
            Node nodeRows = list.item(i);
            System.out.println("Nombre del nodo: " + nodeRows.getNodeName());
            
            
            
            System.out.println("Nombres de los nodos hijos y contenidos");
            for(int j = 0; j < nodeRows.getChildNodes().getLength(); j++){
                Node nodeRowChild = nodeRows.getChildNodes().item(j);
                System.out.println("Nombre del nodo hijo: " +
                        nodeRowChild.getNodeName() + "   Contenido: " +
                        nodeRowChild.getTextContent());
            }
            
            
            
            System.out.println("Nombres de los atributos y sus contenidos");
            for(int k = 0; k < nodeRows.getAttributes().getLength();k++){
                Node nodeRowAtt = nodeRows.getAttributes().item(k);
                System.out.println("Nombre de 1 atributo: " +
                        nodeRowAtt.getNodeName() + "   Contenido: " +
                        nodeRowAtt.getTextContent());
            }
            System.out.println("\n");
        }
        
    }
    
}



