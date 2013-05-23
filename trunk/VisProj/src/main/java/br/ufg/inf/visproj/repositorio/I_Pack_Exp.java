package br.ufg.inf.visproj.repositorio;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * Package: es.inf.ufg.br
 * Class: I_Pack_Exp
 * User: ArthurNote
 * Date: 15/05/13
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */

public interface I_Pack_Exp {


    /**
     * AccessLevel = 4 - System
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /**
     * Load Meta Data
     * Column name Created
     */
    public static final String COLUMNNAME_Created = "Created";

    /**
     * Get Created.
     * Date this record was created
     */
    public Timestamp getCreated();

    /**
     * Column name CreatedBy
     */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

    /**
     * Get Created By.
     * User who created this records
     */
    public int getCreatedBy();

    /**
     * Column name Description
     */
    public static final String COLUMNNAME_Description = "Description";

    /**
     * Set Description.
     * Optional short description of the record
     */
    public void setDescription(String Description);

    /**
     * Get Description.
     * Optional short description of the record
     */
    public String getDescription();

    /**
     * Column name EMail
     */
    public static final String COLUMNNAME_EMail = "EMail";

    /**
     * Set EMail Address.
     * Electronic Mail Address
     */
    public void setEMail(String EMail);

    /**
     * Get EMail Address.
     * Electronic Mail Address
     */
    public String getEMail();

    /**
     * Column name File_Directory
     */
    public static final String COLUMNNAME_File_Directory = "File_Directory";

    /**
     * Set File_Directory
     */
    public void setFile_Directory(String File_Directory);

    /**
     * Get File_Directory
     */
    public String getFile_Directory();

    /**
     * Column name Instructions
     */
    public static final String COLUMNNAME_Instructions = "Instructions";

    /**
     * Set Instructions
     */
    public void setInstructions(String Instructions);

    /**
     * Get Instructions
     */
    public String getInstructions();

    /**
     * Column name IsActive
     */
    public static final String COLUMNNAME_IsActive = "IsActive";

    /**
     * Set Active.
     * The record is active in the system
     */
    public void setIsActive(boolean IsActive);

    /**
     * Get Active.
     * The record is active in the system
     */
    public boolean isActive();

    /**
     * Column name Name
     */
    public static final String COLUMNNAME_Name = "Name";

    /**
     * Set Name.
     * Alphanumeric identifier of the entity
     */
    public void setName(String Name);

    /**
     * Get Name.
     * Alphanumeric identifier of the entity
     */
    public String getName();

    /**
     * Column name PK_Version
     */
    public static final String COLUMNNAME_PK_Version = "PK_Version";

    /**
     * Set Package Version
     */
    public void setPK_Version(String PK_Version);

    /**
     * Get Package Version
     */
    public String getPK_Version();

    /**
     * Column name Processed
     */
    public static final String COLUMNNAME_Processed = "Processed";

    /**
     * Set Processed.
     * The document has been processed
     */
    public void setProcessed(boolean Processed);

    /**
     * Get Processed.
     * The document has been processed
     */
    public boolean isProcessed();

    /**
     * Column name Processing
     */
    public static final String COLUMNNAME_Processing = "Processing";

    /**
     * Set Process Now
     */
    public void setProcessing(boolean Processing);

    /**
     * Get Process Now
     */
    public boolean isProcessing();

    /**
     * Column name ReleaseNo
     */
    public static final String COLUMNNAME_ReleaseNo = "ReleaseNo";

    /**
     * Set Release No.
     * Internal Release Number
     */
    public void setReleaseNo(String ReleaseNo);

    /**
     * Get Release No.
     * Internal Release Number
     */
    public String getReleaseNo();

    /**
     * Column name Updated
     */
    public static final String COLUMNNAME_Updated = "Updated";

    /**
     * Get Updated.
     * Date this record was updated
     */
    public Timestamp getUpdated();

    /**
     * Column name UpdatedBy
     */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

    /**
     * Get Updated By.
     * User who updated this records
     */
    public int getUpdatedBy();

    /**
     * Column name UserName
     */
    public static final String COLUMNNAME_UserName = "UserName";

    /**
     * Set Registered EMail.
     * Email of the responsible for the System
     */
    public void setUserName(String UserName);

    /**
     * Get Registered EMail.
     * Email of the responsible for the System
     */
    public String getUserName();

    /**
     * Column name Version
     */
    public static final String COLUMNNAME_Version = "Version";

    /**
     * Set Version.
     * Version of the table definition
     */
    public void setVersion(String Version);

    /**
     * Get Version.
     * Version of the table definition
     */
    public String getVersion();
}

