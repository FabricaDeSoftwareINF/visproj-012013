package br.ufg.inf.visproj.repositorio;


/**
 * Created by IntelliJ IDEA.
 * Package: es.inf.ufg.br
 * Class: pack_exp
 * User: ArthurNote
 * Date: 15/05/13
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */

public abstract class X_Pack_Exp implements I_Pack_Exp {

    private Object ctx;
    private static final long serialVersionUID = 20100614L;

    private Object trxName;


    /**
     * Standard Constructor
     */
    protected X_Pack_Exp(Object trxName, Object ctx) {
        this.trxName = trxName;
        this.ctx = ctx;
    }

    /**
     * AccessLevel
     *
     * @return 4 - System
     */
    protected int get_AccessLevel() {
        return accessLevel.intValue();
    }

    /**
     * AD_Package_Type AD_Reference_ID=50001
     */
    public static final int AD_PACKAGE_TYPE_AD_Reference_ID = 50001;
    /**
     * Local Transfer = L
     */
    public static final String AD_PACKAGE_TYPE_LocalTransfer = "L";
    /**
     * Remote Transfer = R
     */
    public static final String AD_PACKAGE_TYPE_RemoteTransfer = "R";
    /**
     * XML File = X
     */
    public static final String AD_PACKAGE_TYPE_XMLFile = "X";


    /**
     * ReleaseNo AD_Reference_ID=50002
     */
    public static final int RELEASENO_AD_Reference_ID = 50002;
    /**
     * Release 2.5.2a = Release 2.5.2a
     */
    public static final String RELEASENO_Release252a = "Release 2.5.2a";
    /**
     * Release 2.5.2b = Release 2.5.2b
     */
    public static final String RELEASENO_Release252b = "Release 2.5.2b";
    /**
     * Release 2.5.2c = Release 2.5.2c
     */
    public static final String RELEASENO_Release252c = "Release 2.5.2c";
    /**
     * Release 2.5.2d = Release 2.5.2d
     */
    public static final String RELEASENO_Release252d = "Release 2.5.2d";
    /**
     * Release 2.5.2e = Release 2.5.2e
     */
    public static final String RELEASENO_Release252e = "Release 2.5.2e";
    /**
     * Release 2.5.3a = Release 2.5.3a
     */
    public static final String RELEASENO_Release253a = "Release 2.5.3a";
    /**
     * Release 2.5.3b = Release 2.5.3b
     */
    public static final String RELEASENO_Release253b = "Release 2.5.3b";
    /**
     * No specific release = all
     */
    public static final String RELEASENO_NoSpecificRelease = "all";
    /**
     * Release 3.1.0 = Release 3.1.0
     */
    public static final String RELEASENO_Release310 = "Release 3.1.0";
    /**
     * Release 3.2.0 = Release 3.2.0
     */
    public static final String RELEASENO_Release320 = "Release 3.2.0";
    /**
     * Release 3.3.0 = Release 3.3.0
     */
    public static final String RELEASENO_Release330 = "Release 3.3.0";

    /**
     * Set Release No.
     *
     * @param ReleaseNo Internal Release Number
     */
    public void setReleaseNo(String ReleaseNo) {


    }

    /**
     * Get Release No.
     *
     * @return Internal Release Number
     */
    public String getReleaseNo() {
        return null;
    }

    /**
     * Set Registered EMail.
     *
     * @param UserName Email of the responsible for the System
     */
    public void setUserName(String UserName) {

    }

    /**
     * Get Registered EMail.
     *
     * @return Email of the responsible for the System
     */
    public String getUserName() {
        return null;
    }

    /**
     * Set Version.
     *
     * @param Version Version of the table definition
     */
    public void setVersion(String Version) {
    }

    /**
     * Get Version.
     *
     * @return Version of the table definition
     */
    public String getVersion() {
        return null;
    }
}