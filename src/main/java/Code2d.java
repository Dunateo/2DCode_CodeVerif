public class Code2d {
   private String MI;
   private int Version;
   private String IAC;
   private String IC;
   private String DateEm;
   private String DateCrea;
   private String CodeIden;
   private String IdentifPerim;
   private String PaysEm;
   private String zoneMessage;

    //V01-02
    public Code2d(String MI, int version, String IAC, String IC, String dateEm, String dateCrea, String codeIden) {
        this.MI = MI;
        Version = version;
        this.IAC = IAC;
        this.IC = IC;
        DateEm = dateEm;
        DateCrea = dateCrea;
        CodeIden = codeIden;
    }
    //V03
    public Code2d(String MI, int version, String IAC, String IC, String dateEm, String dateCrea, String codeIden, String identifPerim) {
        this.MI = MI;
        Version = version;
        this.IAC = IAC;
        this.IC = IC;
        DateEm = dateEm;
        DateCrea = dateCrea;
        CodeIden = codeIden;
        IdentifPerim = identifPerim;
    }
    //V04
    public Code2d(String MI, int version, String IAC, String IC, String dateEm, String dateCrea, String codeIden, String identifPerim, String paysEm) {
        this.MI = MI;
        Version = version;
        this.IAC = IAC;
        this.IC = IC;
        DateEm = dateEm;
        DateCrea = dateCrea;
        CodeIden = codeIden;
        IdentifPerim = identifPerim;
        PaysEm = paysEm;
    }

    public String getMI() {
        return MI;
    }

    public int getVersion() {
        return Version;
    }

    public String getIAC() {
        return IAC;
    }

    public String getIC() {
        return IC;
    }

    public String getDateEm() {
        return DateEm;
    }

    public String getDateCrea() {
        return DateCrea;
    }

    public String getCodeIden() {
        return CodeIden;
    }

    public String getIdentifPerim() {
        return IdentifPerim;
    }

    public String getPaysEm() {
        return PaysEm;
    }

    public String getZoneMessage() {
        return zoneMessage;
    }

    public void setZoneMessage(String zoneMessage) {
        this.zoneMessage = zoneMessage;
    }
}
