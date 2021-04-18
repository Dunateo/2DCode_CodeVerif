import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Parsedoc {

    public static Code2d parseDdoc(String docres) {
        Code2d res = null;
        String version = docres.substring(3, 4);
        //System.out.println(version);
        switch (Integer.parseInt(version)) {
            case 01:
                String MI = docres.substring(0, 2);
                //System.out.println(MI);
                String version1 = docres.substring(2, 4);
                //System.out.println(version1);
                String IAC = docres.substring(4, 8);
                //System.out.println(IAC);
                String IC = docres.substring(8, 12);
                //System.out.println(IC);
                String DateEm = docres.substring(12, 16);
                //System.out.println(DateEm);
                String DateCrea = docres.substring(16, 20);
                //System.out.println(DateCrea);
                String CodeIden = docres.substring(20, 22);
                //System.out.println(CodeIden);
                res = new Code2d(MI, Integer.parseInt(version1), IAC, IC, DateEm, DateCrea, CodeIden);
            case 02:
                String MI2 = docres.substring(0, 2);
                //System.out.println(MI2);
                String version2 = docres.substring(2, 4);
                //System.out.println(version2);
                String IAC2 = docres.substring(4, 8);
                //System.out.println(IAC2);
                String IC2 = docres.substring(8, 12);
                //System.out.println(IC2);
                String DateEm2 = docres.substring(12, 16);
                //System.out.println(DateEm2);
                String DateCrea2 = docres.substring(16, 20);
                //System.out.println(DateCrea2);
                String CodeIden2 = docres.substring(20, 22);
                //System.out.println(CodeIden2);
                res = new Code2d(MI2, Integer.parseInt(version2), IAC2, IC2, DateEm2, DateCrea2, CodeIden2);
                break;
            case 03:
                String MI3 = docres.substring(0, 2);
                //System.out.println(MI3);
                String version3 = docres.substring(2, 4);
                //System.out.println(version3);
                String IAC3 = docres.substring(4, 8);
                //System.out.println(IAC3);
                String IC3 = docres.substring(8, 12);
                //System.out.println(IC3);
                String DateEm3 = docres.substring(12, 16);
                //System.out.println(DateEm3);
                String DateCrea3 = docres.substring(16, 20);
                //System.out.println(DateCrea3);
                String CodeIden3 = docres.substring(20, 22);
                //System.out.println(CodeIden3);
                String identifPerim3 = docres.substring(22, 24);
                //System.out.println(identifPerim3);
                res = new Code2d(MI3, Integer.parseInt(version3), IAC3, IC3, DateEm3, DateCrea3, CodeIden3, identifPerim3);
                break;
            case 04:
                String MI4 = docres.substring(0, 2);
                //System.out.println(MI4);
                String version4 = docres.substring(2, 4);
                //System.out.println(version4);
                String IAC4 = docres.substring(4, 8);
                //System.out.println(IAC4);
                String IC4 = docres.substring(8, 12);
                //System.out.println(IC4);
                String DateEm4 = docres.substring(12, 16);
                //System.out.println(DateEm4);
                String DateCrea4 = docres.substring(16, 20);
                //System.out.println(DateCrea4);
                String CodeIden4 = docres.substring(20, 22);
                //System.out.println(CodeIden4);
                String IdentifPerim4 = docres.substring(22, 24);
                //System.out.println(IdentifPerim4);
                String PaysEm4 = docres.substring(24, 26);
                //System.out.println(PaysEm4);
                res = new Code2d(MI4, Integer.parseInt(version4), IAC4, IC4, DateEm4, DateCrea4, CodeIden4, IdentifPerim4, PaysEm4);
                break;
        }



        int debut = docres.indexOf("/");
        int fin = docres.lastIndexOf("/");
        res.setUsername(docres.substring(debut+1,fin));

        int debut1 = docres.lastIndexOf("/");
        int fin1 = docres.indexOf("\u001D");
        res.setUserfirstname(docres.substring(debut1+1,fin1));


        String result[] = docres.split("\u001D");


        res.setAddress(result[result.length - 4]);
        res.setTown(result[result.length - 3]);


        char US = (char) 31;
        res.setSign(docres.substring(docres.lastIndexOf(US) + 1));

        System.out.println(docres.substring(docres.lastIndexOf(US) + 1));

        return res;
    }


    /**
     * Parse Tsl Thing
     * @param File
     * @param IAC
     * @param IC
     * @return
     */
    public static String[] parseTSL(String File, String IAC, String IC) {
        String[] res = {null,null};
        int ca_number = Integer.parseInt(IAC.substring(2,4));
        try {
            java.io.File file = new File(File);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            doc.getDocumentElement().normalize();
            NodeList CAList = doc.getElementsByTagName("tsl:TrustServiceProvider");
            String addrs = "";
            for (int i = 0; i < CAList.getLength(); ++i) {
                Node ca_xml = CAList.item(i);

                if (ca_xml.getNodeType() == Node.ELEMENT_NODE && ca_number - 1 == i) {
                    Element tElement = (Element) ca_xml;
                    Node addrs_node = tElement.getElementsByTagName("tsl:TSPInformationURI").item(0);
                    Element addr_element = (Element) addrs_node;
                    addrs = addr_element.getElementsByTagName("tsl:URI").item(0).getTextContent();
                    String cert_ca_brut = tElement.getElementsByTagName("tsl:X509Certificate").item(0).getTextContent();
                    res[0] = cert_ca_brut;
                }
            }


            if(ca_number==3) {    //CA FR03
                addrs=addrs.substring(0,43);
                addrs = addrs +"name="+IC;
            }
            else if(ca_number==2) { // CA FR02
                System.out.println("La CA n'existe pas");
            }else if(ca_number==1) { // CA FRO1
                addrs = addrs +"?name="+IC;

            }
            res[1] = addrs;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return res;
    }
}
