import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Certificate {

    public static Boolean verification(X509Certificate sign, String cert) throws CertificateException, IOException {

        X509Certificate certf = generateX509Certificate(cert);

        return Boolean.FALSE;
    }


    public static X509Certificate generateX509Certificate(String certEntry) throws IOException {

        InputStream in = null;
        X509Certificate cert = null;
        try {
            byte[] certEntryBytes = certEntry.getBytes();
            in = new ByteArrayInputStream(certEntryBytes);
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            cert = (X509Certificate) certFactory.generateCertificate(in);
        } catch (CertificateException ex) {

        } finally {
            if (in != null) {
                in.close();
            }
        }
        return cert;
    }
}
