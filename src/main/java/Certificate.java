import com.nimbusds.jose.util.X509CertUtils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

public class Certificate {

    /**
     * Verification d'un certificat
     * @param sign
     * @param cert
     * @return
     * @throws CertificateException
     * @throws IOException
     */
    public static Boolean verification(X509Certificate sign, X509Certificate cert) throws CertificateException, IOException {

        if (!cert.getIssuerDN().equals(sign.getSubjectDN())) return false;
        try {
            cert.verify(sign.getPublicKey());
            return true;
        } catch (GeneralSecurityException verifyFailed) {
            return false;
        }
    }

    /**
     * Conversion d'un string en certficat
     * @param certEntry
     * @return
     * @throws IOException
     */
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

    /**
     * convert .der to X509
     * @param encodedCert
     * @return
     */
    public static X509Certificate generateX509withBinary(URL url) throws CertificateException, IOException {
        CertificateFactory fact = CertificateFactory.getInstance("X509");
        HttpURLConnection con =  (HttpURLConnection) url.openConnection();
        X509Certificate resul = null;

        try(DataInputStream resStream = new DataInputStream(con.getInputStream())) {
            resul = (X509Certificate) fact.generateCertificate(resStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resul;
    }

    public static X509Certificate convertStringToX509Cert(String certificate) throws Exception{
        //conversion
        //String cert = "-----BEGIN CERTIFICATE-----" + Base64.getDecoder().decode(certificate) + "-----END CERTIFICATE-----";

        InputStream targetStream = new ByteArrayInputStream(Base64.getDecoder().decode(certificate));
        return (X509Certificate) CertificateFactory
                .getInstance("X509")
                .generateCertificate(targetStream);
    }

    public static boolean decipherSignP256(PublicKey pubKey, String cipher, byte[] data) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        //byte[] dataConvert = data.getBytes(StandardCharsets.UTF_8);
        byte[] sign = cipher.getBytes();
        Signature sg = Signature.getInstance("SHA256withECDSA", "SunEC");
        sg.initVerify(pubKey);
        sg.update(data);
        return sg.verify(sign);
    }


}
