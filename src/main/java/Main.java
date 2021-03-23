import com.google.zxing.NotFoundException;
import java.io.IOException;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException, NotFoundException {
        //Decode the 2D Doc
        String url = "./res/test.jpg";
        String Qrstring = ReadQR.decodeQRCode(url);

        Code2d entete = Parsedoc.parseDdoc(Qrstring);

        System.out.println(Qrstring);
    }
}
