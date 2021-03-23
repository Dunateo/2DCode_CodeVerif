public class Parse {

        public Code2d parseDdoc(String docres){



            int version = (int)docres[3];
            switch(version) {
                case '1':
                    for (int i = 4; i < 8; i++)
                        System.out.println();
                    break;
                case '2':
                    // code block
                    break;
                case '3':
                    // code block
                    break;
                case '4':
                    // code block
                    break;
            }


}
