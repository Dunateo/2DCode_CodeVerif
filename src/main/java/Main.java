import com.google.zxing.common.StringUtils;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.security.cert.X509Certificate;


public class Main {
    public static void main(String[] args) throws Exception {
        //Decode the 2D Doc
        String url = "./res/sfr2d.png";
        String Qrstring = ReadQR.decodeQRCode(url);

        //Get the entete
        Code2d entete = Parsedoc.parseDdoc(Qrstring);

        //get the certificate online
        String fileTsl = "./res/ANTS_2D-DOc_TSL_230713_v3_signed.xml";
        String[] resFileTsl = Parsedoc.parseTSL(fileTsl, entete.getIAC(), entete.getIC());

        //static
        //String xmlCert = "MIIFnzCCA4egAwIBAgIIWGqMmtUG62gwDQYJKoZIhvcNAQENBQAwTjENMAsGA1UEAwwERlIwMTEcMBoGA1UECwwTMDAwMiA1MjA3NjkyMjUwMDAyNzESMBAGA1UECgwJQXJpYWRORVhUMQswCQYDVQQGEwJGUjAeFw0xMjA2MjYxNTIyMzRaFw0yMjA2MjYxNTIyMzRaME4xDTALBgNVBAMMBEZSMDExHDAaBgNVBAsMEzAwMDIgNTIwNzY5MjI1MDAwMjcxEjAQBgNVBAoMCUFyaWFkTkVYVDELMAkGA1UEBhMCRlIwggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAwggIKAoICAQCqKLgVoE+hgLBeJ7t6kf2QFslItd6bkRolj3iZlvtVuYV//WOicYKuGWkjW/K2Zv2PySieo676qAsrEbchxwBMPpx12yCQoBckHxCB9mwiG+uyBiN3bukuPKlRxb7i+yNARt3hT+DDUuYqcwat2G4mP8MbHnCsbS2S1jikwWJeCPCa2vhNXSXVr2hNSFlQQEvfQzaaE4hDmwfrFqbyTMUAsTxSV3G6l513KWSY6ZAgMA9lB3KxMcpqvY7mHTClvAUMQYUKa4199NTJIvS6pNF0eLZ+JCAbMoQgMxAKS8VLRW6ovqgtdExD9fr664lAPAMpXFnb7mcLz9ovIhrOM33BZaJ+3zUwqMn5WYOxAPdbPqaf/ap2E3E07v5CeUgFpy4UdkHarUS6MYlbXY14dITwGpxBWyEB3LVpQE9GP1ZAKf4f+tBstS5m08G3xum6wMdpBVDJ3w8ao7KR+jUJcvzk4av4ZphI8Z5AyeTtLdAXFhffX8B12PmeLLPQmF2VK8zSC4MnkKAwU5D6leASDmgHIdN/mpRwWGEQSZqlKa3LQBXWIauNIHqlK777jgNe+EdifLcXIpoiQCVZCU3k+b9WAio0uWywdIZca8aHpKliGLgbOsyXUWIeskc6Gk/JopisdJwE3osGpU+CNU8Jipq4FMvnq4CL7y9FbEWXGDIEQwIDAQABo4GAMH4wHQYDVR0OBBYEFBGxw8fKDCm4PX28b3V6u3DuL9hJMBIGA1UdEwEB/wQIMAYBAf8CAQAwHwYDVR0jBBgwFoAUEbHDx8oMKbg9fbxvdXq7cO4v2EkwGAYDVR0gBBEwDzANBgsrBgEEAYKqUgoCAjAOBgNVHQ8BAf8EBAMCAUYwDQYJKoZIhvcNAQENBQADggIBAE+yUWliolk2HDG2/Iq2rOprnLqe50ixhvA2f5LB4vzcJSwZal9UxWe8TXgydSb693k+Uw+f+jpWj4j9UQmILNkfOzWNNQbm2GWCCTxsgzdAQRsvV7JesueL4JjnX59bqt45YPOcoKo184x5Bc0eb83drrQaJzRA18WKvpDLiHwUIs7rhX799CPG5BQoLRKQpE3hgGjSswPV6+xZ4HHh3+IUjohxZGZTN+r+mIqKIKBqJVHjy4C+x5X+yvmKpT0SUzaZ+rxcDEEyvLbvxFR2j3gtQx7ytmn3aCfY1pzdixmkqx473r6Kinz9NhoZ9RsnxpDOpnLaB2by0mVWPb6z56ki6GkziO2QbllXqW4UmTWymLAd8zt1nhGq/TUcQJBZIt1S1v9IgwGItfvKuMtFprwhba1YVErBKQU/Zb7WJrhzji3JZVWJZelEbp8iBTOZdAqicvVYTUsDql7G8lgQ4szNugeWryeEtSdG4ZGN7nfrrVsb0C0fNswutS7EeFy/ly4L7dDdA8Y/qKhjK1zbLKBimihbPEJqc4up8tF2tjMtJkqY2Oej4FyxS+TOXZjWJ9FWhnly4yxK0MYW82kw3HB5fsBPvEEnbSCZj70TCcvLRdoM48+r7wZvdZVGYxKQ0vr/T/sRICKboFzysRvhflOREXvnHZUL9UVeV8HqTOgo";
        //URL url2 = new URL("http://cert.pki-2ddoc.ariadnext.fr/pki-2ddoc.der?name=SFR2");

        //convert to certificate
        String xmlCert = resFileTsl[0];
        URL url2 = new URL(resFileTsl[1]);


        X509Certificate cert = Certificate.convertStringToX509Cert(xmlCert);
        X509Certificate cert2 = Certificate.generateX509withBinary(url2);

        //Signature Verfication Invalid encoding ?
        PublicKey pubKey = cert2.getPublicKey();
        System.out.println(pubKey);
        char US = (char) 31;
        String truc = Qrstring.substring(Qrstring.lastIndexOf(US) + 1);
        String data = Qrstring.substring(0,Qrstring.lastIndexOf(US)-1);
        //System.out.println(truc.length());
        System.out.println(data);
        switch (truc.length()){
            case 103:
                //Base32 base32 = new Base32();
                //byte[] mes = base32.encode(data.getBytes(StandardCharsets.UTF_8));
                //System.out.println(Certificate.decipherSignP256(pubKey,truc,mes));
                break;
            case 154:
                break;
            case 212:
                break;
        }






        System.out.println(Qrstring);
        entete.affichage();
        System.out.println(Certificate.verification(cert,cert2));
    }
}
