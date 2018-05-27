
package TestNG.WS_RestTestFiles.JSONSchemas.TimeSlotSessionInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Session {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("timeslotId")
    @Expose
    private Integer timeslotId;
    @SerializedName("sessionId")
    @Expose
    private Integer sessionId;
    @SerializedName("sessionTypeId")
    @Expose
    private Integer sessionTypeId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("speakers")
    @Expose
    private List<Speaker> speakers = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Integer timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSessionTypeId() {
        return sessionTypeId;
    }

    public void setSessionTypeId(Integer sessionTypeId) {
        this.sessionTypeId = sessionTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

}
