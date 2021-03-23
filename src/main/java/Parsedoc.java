public class Parsedoc {

    public static Code2d parseDdoc(String docres) {
        Code2d res = null;
        String version = docres.substring(3, 4);

        switch (Integer.parseInt(version)) {
            case 1:
                for (int i = 4; i < 8; i++)
                    System.out.println();
                break;
            case 2:
                // code block
                //res = new Code2d();
                break;
            case 3:
                // code block
                break;
            case 4:
                // code block
                break;
        }

        return res;
    }
}