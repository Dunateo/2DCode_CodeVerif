public class Parsedoc {

    public Code2d parseDdoc(String docres) {


        String version = docres.substring(3, 4);
        switch (version) {
            case 01:
                for (int i = 4; i < 8; i++)
                    System.out.println();
                break;
            case 02:
                // code block
                break;
            case 3:
                // code block
                break;
            case 4:
                // code block
                break;
        }


    }
}