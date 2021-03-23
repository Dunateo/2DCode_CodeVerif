public class Parsedoc {

    public Code2d parseDdoc(String docres) {


        String version = docres.substring(3, 4);
        System.out.println(version);
        switch (Integer.parseInt(version)) {
            case 01:
                String MI = docres.substring(0, 1);
                System.out.println(MI);
                String version1 = docres.substring(2, 3);
                System.out.println(version1);
                String IAC = docres.substring(4,7);
                System.out.println(IAC);
                String IC = docres.substring(8,11);
                System.out.println(IC);
                String DateEm = docres.substring(12,15);
                System.out.println(DateEm);
                String DateCrea = docres.substring(16,19);
                System.out.println(DateCrea);
                String CodeIden = docres.substring(20,21);
                System.out.println(CodeIden);
                new Code2d(MI ,Integer.parseInt(version1) ,IAC ,IC ,DateEm ,DateCrea ,CodeIden);
            case 02:
                String MI2 = docres.substring(0, 1);
                System.out.println(MI2);
                String version2 = docres.substring(2, 3);
                System.out.println(version2);
                String IAC2 = docres.substring(4,7);
                System.out.println(IAC2);
                String IC2 = docres.substring(8,11);
                System.out.println(IC2);
                String DateEm2 = docres.substring(12,15);
                System.out.println(DateEm2);
                String DateCrea2 = docres.substring(16,19);
                System.out.println(DateCrea2);
                String CodeIden2 = docres.substring(20,21);
                System.out.println(CodeIden2);
                new Code2d(MI2 ,Integer.parseInt(version2) ,IAC2 ,IC2 ,DateEm2 ,DateCrea2 ,CodeIden2);
                break;
            case 03:
                String MI3 = docres.substring(0, 1);
                System.out.println(MI3);
                String version3 = docres.substring(2, 3);
                System.out.println(version3);
                String IAC3 = docres.substring(4,7);
                System.out.println(IAC3);
                String IC3 = docres.substring(8,11);
                System.out.println(IC3);
                String DateEm3 = docres.substring(12,15);
                System.out.println(DateEm3);
                String DateCrea3 = docres.substring(16,19);
                System.out.println(DateCrea3);
                String CodeIden3 = docres.substring(20,21);
                System.out.println(CodeIden3);
                String identifPerim3 = docres.substring(22,23);
                System.out.println(identifPerim3);
                new Code2d(MI3 ,Integer.parseInt(version3) ,IAC3 ,IC3 ,DateEm3 ,DateCrea3 ,CodeIden3,identifPerim3);
                break;
            case 04:
                String MI4 = docres.substring(0, 1);
                System.out.println(MI4);
                String version4 = docres.substring(2, 3);
                System.out.println(version4);
                String IAC4 = docres.substring(4,7);
                System.out.println(IAC4);
                String IC4 = docres.substring(8,11);
                System.out.println(IC4);
                String DateEm4 = docres.substring(12,15);
                System.out.println(DateEm4);
                String DateCrea4 = docres.substring(16,19);
                System.out.println(DateCrea4);
                String CodeIden4 = docres.substring(20,21);
                System.out.println(CodeIden4);
                String IdentifPerim4 = docres.substring(22,23);
                System.out.println(IdentifPerim4);
                String PaysEm4 = docres.substring(24,25);
                System.out.println(PaysEm4);
                new Code2d(MI4 ,Integer.parseInt(version4) ,IAC4 ,IC4 ,DateEm4 ,DateCrea4 ,CodeIden4 ,IdentifPerim4 ,PaysEm4 );
                break;
        }


    }
}