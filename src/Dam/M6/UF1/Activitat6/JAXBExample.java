package exercicio6;



import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.bind.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

	private static final String ROWS_XML_FILE = "resultat.xml";

	public static void main(String[] args) throws JAXBException, IOException {

            
                Alumnes alumnes = JAXB.unmarshal(new FileReader("alumnes.xml"), Alumnes.class);
                JAXB.marshal(alumnes, System.out);
                
		JAXBContext context = JAXBContext.newInstance(Rows.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Rows row = ompleAlumnes();

		//Mostrem el document XML generat por la sortida estandard
		marshaller.marshal(row, System.out);

		FileOutputStream fos = new FileOutputStream(ROWS_XML_FILE);
		//guardem l'objecte serializat en un document XML
		marshaller.marshal(row, fos);
		fos.close();

		Unmarshaller unmarshaller = context.createUnmarshaller();

                
		
		// FEM UN TRY CATCH PERQUE NO MOSTRI ERROR
		try {
			//Deserialitzem a partir de un document XML
			Rows alumnesAux = (Rows) unmarshaller.unmarshal(new File(ROWS_XML_FILE));
			System.out.println("********* Rows carregat desde fitxer XML***************");
			//Mostrem l'objeto Java obtingut
			marshaller.marshal(alumnesAux, System.out);	
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	private static Rows ompleAlumnes(){

		String[] _id = {"row-z6f2-hfpa_46ig","row-94y7.68qw~b3dz","row-9aee.gimq.en3a"};
		String[] _uuid = {"00000000-0000-0000-D92E-ADCE4962698B","00000000-0000-0000-CB3C-833A560B51BF","00000000-0000-0000-DDFB-AB8F59A6B806"};
		int[] _position = {0,0,0};
		String[] _adress = {"https://analisi.transparenciacatalunya.cat/resource/_6js6-vud6/row-z6f2-hfpa_46ig",
                                    "https://analisi.transparenciacatalunya.cat/resource/_6js6-vud6/row-94y7.68qw~b3dz",
                                    "https://analisi.transparenciacatalunya.cat/resource/_6js6-vud6/row-9aee.gimq.en3a"};
		int[] ids = {164459,125906,125910};
		String[] claus = {"Cementiri Sant Jaume Enveja_fossa","Cementiri de Masdenverge",
		"Cementiri de Santa Bárbara"};
		String[] titols = {"Cementiri de Sant Jaume d'Enveja","Cementiri de Masdenverge",
		"Cementiri de Santa Bárbara"};
		double[] x = {0.71728000,0.53620577,0.49530745};
		double[] y = {40.69924300,40.71169504,40.72543749};
		String[] desapareguda = {"Si","No","No"};
		String[] bandol = {"Republicà","Rebel","Rebel"};
		String[] notes = {"Fossa localitzada arran de l'estudi dut a terme per la Universitat Rovira i Virgili l'any 2016, per encàrrec de la Generalitat de Catalunya.Pròximament es completarà la informació d'aquesta fossa.",
				"Masdenverge, situat al costat d'Amposta, patí juntament amb aquesta darrera l'atac secundari per part de les tropes republicanes el 25 de juliol de 1938, que intentaven distreure les tropes franquistes de l'atac principal, que pretenia aprofundir en l'operació a partir de prendre Gandesa. A Masdenverge s'hi degueren enterrar els soldats franquistes morts els dies 26 i 27 de juliol, atès que les dades que es tenen de les dues fosses de les que es té coneixement, de 13 i 6 morts, identifiquen soldats franquistes.",
		"Santa Bàrbara, a pocs quilòmetres de Masdenverge, més allunyada del front, a la immediata reraguarda franquista, estigué molt propera a la línia de combat, sense que la població, però, hi estigués involucrada. És per aquest motiu que s'hi degué instal·lar un hospital militar i de fet la documentació així o indica. La data de les morts dels soldats van des del 29 de maig de 1938 fins el 13 de gener de 1939."};
		String[] numRestes = {"3","13 i 6", "114"};
		String[] municipi = {"Sant Jaume d'Enveja","Masdenverge","Santa Bàrbara"};
		String[] comarca = {"Montsià","Montsià","Montsià"};
		String[] idCategoria = {"Confirmada","Confirmada","Confirmada"};
		String[] estudi_ebre = {"Ebre","Antiga","Antiga"};
		String[] url = {"http://fossesirepressio.gencat.cat/ca/cementiri-sant-jaume-enveja",
				"http://fossesirepressio.gencat.cat/ca/masdenverge-possiblement-al-cementiri",
                                "http://fossesirepressio.gencat.cat/ca/santa-barbara-probablement-al-cementiri"};

		Fitxa[] fitxa = new Fitxa[3];
		for (int i = 0; i < fitxa.length; i++) {

			fitxa[i] = new Fitxa();
			fitxa[i].setUrl(url[i]);
		}

		double[] latitude = {40.699243,40.71169504,40.72543749};
		double[] longitude = {0.71728,0.53620577,0.49530745};
		Geocoded_column[] geocoded = new Geocoded_column[3];


		for (int i = 0; i < geocoded.length; i++) {

			geocoded[i] = new Geocoded_column();
			geocoded[i].setLatitude(latitude[i]);
			geocoded[i].setLongitude(longitude[i]);
		}     

		Row[] ArrayAlumnes = new Row[3];

		for(int i=0; i<3; i++){
			ArrayAlumnes[i] = new Row();
			ArrayAlumnes[i].setIdAtribute(_id[i]);
			ArrayAlumnes[i].setUuid(_uuid[i]);
			ArrayAlumnes[i].setPosition(_position[i]);
			ArrayAlumnes[i].setAdress(_adress[i]);
			ArrayAlumnes[i].setId(ids[i]);
			ArrayAlumnes[i].setClau(claus[i]);
			ArrayAlumnes[i].setTitol(titols[i]);
			ArrayAlumnes[i].setX(x[i]);
			ArrayAlumnes[i].setY(y[i]);
			ArrayAlumnes[i].setDesapareguda(desapareguda[i]);
			ArrayAlumnes[i].setBandol(bandol[i]);
			ArrayAlumnes[i].setNotes(notes[i]);
			ArrayAlumnes[i].setNumRestes(numRestes[i]);
			ArrayAlumnes[i].setMunicipi(municipi[i]);
			ArrayAlumnes[i].setComarca(comarca[i]);
			ArrayAlumnes[i].setIdCategoria(idCategoria[i]);
			ArrayAlumnes[i].setEstudi_ebre(estudi_ebre[i]);
			ArrayAlumnes[i].setFitxa(fitxa[i]);
			ArrayAlumnes[i].setGeocoded_column(geocoded[i]);
		}

		Rows alumnes = new Rows();
		alumnes.setRow(ArrayAlumnes);

		return alumnes;
	}

    private static void objectsToXML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void XMLToObjects() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
