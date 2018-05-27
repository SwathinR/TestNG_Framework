
package TestNG.JSONSchemas.TimeSlotSessionInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Speaker {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("speakerId")
    @Expose
    private Integer speakerId;
    @SerializedName("eventSpeakerId")
    @Expose
    private Integer eventSpeakerId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("role")
    @Expose
    private Role role;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("sessionStatus")
    @Expose
    private Object sessionStatus;
    @SerializedName("order")
    @Expose
    private Integer order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }

    public Integer getEventSpeakerId() {
        return eventSpeakerId;
    }

    public void setEventSpeakerId(Integer eventSpeakerId) {
        this.eventSpeakerId = eventSpeakerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(Object sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}
