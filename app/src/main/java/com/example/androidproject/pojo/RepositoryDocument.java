
package com.example.androidproject.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepositoryDocument {

    @SerializedName("pdfStatus")
    @Expose
    private int pdfStatus;
    @SerializedName("textStatus")
    @Expose
    private int textStatus;
    @SerializedName("metadataAdded")
    @Expose
    private long metadataAdded;
    @SerializedName("metadataUpdated")
    @Expose
    private long metadataUpdated;
    @SerializedName("timestamp")
    @Expose
    private long timestamp;
    @SerializedName("depositedDate")
    @Expose
    private long depositedDate;
    @SerializedName("indexed")
    @Expose
    private int indexed;
    @SerializedName("deletedStatus")
    @Expose
    private String deletedStatus;
    @SerializedName("pdfSize")
    @Expose
    private int pdfSize;
    @SerializedName("tdmOnly")
    @Expose
    private boolean tdmOnly;
    @SerializedName("pdfOrigin")
    @Expose
    private Object pdfOrigin;

    public int getPdfStatus() {
        return pdfStatus;
    }

    public void setPdfStatus(int pdfStatus) {
        this.pdfStatus = pdfStatus;
    }

    public int getTextStatus() {
        return textStatus;
    }

    public void setTextStatus(int textStatus) {
        this.textStatus = textStatus;
    }

    public long getMetadataAdded() {
        return metadataAdded;
    }

    public void setMetadataAdded(long metadataAdded) {
        this.metadataAdded = metadataAdded;
    }

    public long getMetadataUpdated() {
        return metadataUpdated;
    }

    public void setMetadataUpdated(long metadataUpdated) {
        this.metadataUpdated = metadataUpdated;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getDepositedDate() {
        return depositedDate;
    }

    public void setDepositedDate(long depositedDate) {
        this.depositedDate = depositedDate;
    }

    public int getIndexed() {
        return indexed;
    }

    public void setIndexed(int indexed) {
        this.indexed = indexed;
    }

    public String getDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(String deletedStatus) {
        this.deletedStatus = deletedStatus;
    }

    public int getPdfSize() {
        return pdfSize;
    }

    public void setPdfSize(int pdfSize) {
        this.pdfSize = pdfSize;
    }

    public boolean isTdmOnly() {
        return tdmOnly;
    }

    public void setTdmOnly(boolean tdmOnly) {
        this.tdmOnly = tdmOnly;
    }

    public Object getPdfOrigin() {
        return pdfOrigin;
    }

    public void setPdfOrigin(Object pdfOrigin) {
        this.pdfOrigin = pdfOrigin;
    }

}
