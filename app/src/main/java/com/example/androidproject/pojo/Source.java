
package com.example.androidproject.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("citations")
    @Expose
    private List<Object> citations = null;
    @SerializedName("contributors")
    @Expose
    private List<Object> contributors = null;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;
    @SerializedName("deleted")
    @Expose
    private String deleted;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fullText")
    @Expose
    private Object fullText;
    @SerializedName("fullTextIdentifier")
    @Expose
    private Object fullTextIdentifier;
    @SerializedName("identifiers")
    @Expose
    private List<String> identifiers = null;
    @SerializedName("journals")
    @Expose
    private Object journals;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("duplicateId")
    @Expose
    private Object duplicateId;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("rawRecordXml")
    @Expose
    private String rawRecordXml;
    @SerializedName("relations")
    @Expose
    private List<String> relations = null;
    @SerializedName("repositories")
    @Expose
    private List<Repository> repositories = null;
    @SerializedName("repositoryDocument")
    @Expose
    private RepositoryDocument repositoryDocument;
    @SerializedName("similarities")
    @Expose
    private Object similarities;
    @SerializedName("subjects")
    @Expose
    private List<String> subjects = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("topics")
    @Expose
    private List<String> topics = null;
    @SerializedName("types")
    @Expose
    private List<Object> types = null;
    @SerializedName("urls")
    @Expose
    private List<String> urls = null;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("doi")
    @Expose
    private String doi;
    @SerializedName("oai")
    @Expose
    private String oai;
    @SerializedName("downloadUrl")
    @Expose
    private String downloadUrl;
    @SerializedName("pdfHashValue")
    @Expose
    private Object pdfHashValue;
    @SerializedName("documentType")
    @Expose
    private Object documentType;
    @SerializedName("documentTypeConfidence")
    @Expose
    private Object documentTypeConfidence;
    @SerializedName("citationCount")
    @Expose
    private Object citationCount;
    @SerializedName("estimatedCitationCount")
    @Expose
    private Object estimatedCitationCount;
    @SerializedName("acceptedDate")
    @Expose
    private Object acceptedDate;
    @SerializedName("depositedDate")
    @Expose
    private long depositedDate;
    @SerializedName("publishedDate")
    @Expose
    private long publishedDate;
    @SerializedName("issn")
    @Expose
    private Object issn;
    @SerializedName("crossrefDocument")
    @Expose
    private Object crossrefDocument;
    @SerializedName("magDocument")
    @Expose
    private Object magDocument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<Object> getCitations() {
        return citations;
    }

    public void setCitations(List<Object> citations) {
        this.citations = citations;
    }

    public List<Object> getContributors() {
        return contributors;
    }

    public void setContributors(List<Object> contributors) {
        this.contributors = contributors;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getFullText() {
        return fullText;
    }

    public void setFullText(Object fullText) {
        this.fullText = fullText;
    }

    public Object getFullTextIdentifier() {
        return fullTextIdentifier;
    }

    public void setFullTextIdentifier(Object fullTextIdentifier) {
        this.fullTextIdentifier = fullTextIdentifier;
    }

    public List<String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    public Object getJournals() {
        return journals;
    }

    public void setJournals(Object journals) {
        this.journals = journals;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public Object getDuplicateId() {
        return duplicateId;
    }

    public void setDuplicateId(Object duplicateId) {
        this.duplicateId = duplicateId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRawRecordXml() {
        return rawRecordXml;
    }

    public void setRawRecordXml(String rawRecordXml) {
        this.rawRecordXml = rawRecordXml;
    }

    public List<String> getRelations() {
        return relations;
    }

    public void setRelations(List<String> relations) {
        this.relations = relations;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public RepositoryDocument getRepositoryDocument() {
        return repositoryDocument;
    }

    public void setRepositoryDocument(RepositoryDocument repositoryDocument) {
        this.repositoryDocument = repositoryDocument;
    }

    public Object getSimilarities() {
        return similarities;
    }

    public void setSimilarities(Object similarities) {
        this.similarities = similarities;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<Object> getTypes() {
        return types;
    }

    public void setTypes(List<Object> types) {
        this.types = types;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getOai() {
        return oai;
    }

    public void setOai(String oai) {
        this.oai = oai;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Object getPdfHashValue() {
        return pdfHashValue;
    }

    public void setPdfHashValue(Object pdfHashValue) {
        this.pdfHashValue = pdfHashValue;
    }

    public Object getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Object documentType) {
        this.documentType = documentType;
    }

    public Object getDocumentTypeConfidence() {
        return documentTypeConfidence;
    }

    public void setDocumentTypeConfidence(Object documentTypeConfidence) {
        this.documentTypeConfidence = documentTypeConfidence;
    }

    public Object getCitationCount() {
        return citationCount;
    }

    public void setCitationCount(Object citationCount) {
        this.citationCount = citationCount;
    }

    public Object getEstimatedCitationCount() {
        return estimatedCitationCount;
    }

    public void setEstimatedCitationCount(Object estimatedCitationCount) {
        this.estimatedCitationCount = estimatedCitationCount;
    }

    public Object getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(Object acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public long getDepositedDate() {
        return depositedDate;
    }

    public void setDepositedDate(long depositedDate) {
        this.depositedDate = depositedDate;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Object getIssn() {
        return issn;
    }

    public void setIssn(Object issn) {
        this.issn = issn;
    }

    public Object getCrossrefDocument() {
        return crossrefDocument;
    }

    public void setCrossrefDocument(Object crossrefDocument) {
        this.crossrefDocument = crossrefDocument;
    }

    public Object getMagDocument() {
        return magDocument;
    }

    public void setMagDocument(Object magDocument) {
        this.magDocument = magDocument;
    }

}
