package com.example.user1.audiotexttospeech.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemberOrder {

@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("description")
@Expose
private String description;
@SerializedName("order")
@Expose
private List<String> order = null;
@SerializedName("folders")
@Expose
private List<Object> folders = null;
@SerializedName("folders_order")
@Expose
private List<Object> foldersOrder = null;
@SerializedName("timestamp")
@Expose
private Integer timestamp;
@SerializedName("owner")
@Expose
private Integer owner;
@SerializedName("public")
@Expose
private Boolean _public;
@SerializedName("requests")
@Expose
private List<Request> requests = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
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

public List<String> getOrder() {
return order;
}

public void setOrder(List<String> order) {
this.order = order;
}

public List<Object> getFolders() {
return folders;
}

public void setFolders(List<Object> folders) {
this.folders = folders;
}

public List<Object> getFoldersOrder() {
return foldersOrder;
}

public void setFoldersOrder(List<Object> foldersOrder) {
this.foldersOrder = foldersOrder;
}

public Integer getTimestamp() {
return timestamp;
}

public void setTimestamp(Integer timestamp) {
this.timestamp = timestamp;
}

public Integer getOwner() {
return owner;
}

public void setOwner(Integer owner) {
this.owner = owner;
}

public Boolean getPublic() {
return _public;
}

public void setPublic(Boolean _public) {
this._public = _public;
}

public List<Request> getRequests() {
return requests;
}

public void setRequests(List<Request> requests) {
this.requests = requests;
}

}