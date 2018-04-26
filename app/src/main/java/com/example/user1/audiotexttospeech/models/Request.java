package com.example.user1.audiotexttospeech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Request {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("headers")
    @Expose
    private String headers;
    @SerializedName("headerData")
    @Expose
    private List<Object> headerData = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("queryParams")
    @Expose
    private List<Object> queryParams = null;
    @SerializedName("pathVariables")
    @Expose
    private PathVariables pathVariables;
    @SerializedName("pathVariableData")
    @Expose
    private List<Object> pathVariableData = null;
    @SerializedName("preRequestScript")
    @Expose
    private Object preRequestScript;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("collectionId")
    @Expose
    private String collectionId;
    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("dataMode")
    @Expose
    private String dataMode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("descriptionFormat")
    @Expose
    private String descriptionFormat;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("responses")
    @Expose
    private List<Object> responses = null;
    @SerializedName("tests")
    @Expose
    private Object tests;
    @SerializedName("currentHelper")
    @Expose
    private String currentHelper;
    @SerializedName("helperAttributes")
    @Expose
    private HelperAttributes helperAttributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public List<Object> getHeaderData() {
        return headerData;
    }

    public void setHeaderData(List<Object> headerData) {
        this.headerData = headerData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(List<Object> queryParams) {
        this.queryParams = queryParams;
    }

    public PathVariables getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(PathVariables pathVariables) {
        this.pathVariables = pathVariables;
    }

    public List<Object> getPathVariableData() {
        return pathVariableData;
    }

    public void setPathVariableData(List<Object> pathVariableData) {
        this.pathVariableData = pathVariableData;
    }

    public Object getPreRequestScript() {
        return preRequestScript;
    }

    public void setPreRequestScript(Object preRequestScript) {
        this.preRequestScript = preRequestScript;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionFormat() {
        return descriptionFormat;
    }

    public void setDescriptionFormat(String descriptionFormat) {
        this.descriptionFormat = descriptionFormat;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Object> getResponses() {
        return responses;
    }

    public void setResponses(List<Object> responses) {
        this.responses = responses;
    }

    public Object getTests() {
        return tests;
    }

    public void setTests(Object tests) {
        this.tests = tests;
    }

    public String getCurrentHelper() {
        return currentHelper;
    }

    public void setCurrentHelper(String currentHelper) {
        this.currentHelper = currentHelper;
    }

    public HelperAttributes getHelperAttributes() {
        return helperAttributes;
    }

    public void setHelperAttributes(HelperAttributes helperAttributes) {
        this.helperAttributes = helperAttributes;
    }
}
