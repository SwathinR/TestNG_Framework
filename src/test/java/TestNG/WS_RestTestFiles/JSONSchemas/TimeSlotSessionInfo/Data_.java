
package TestNG.WS_RestTestFiles.JSONSchemas.TimeSlotSessionInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_ {

    @SerializedName("colorCode")
    @Expose
    private String colorCode;
    @SerializedName("webHookTrigger")
    @Expose
    private Boolean webHookTrigger;

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Boolean getWebHookTrigger() {
        return webHookTrigger;
    }

    public void setWebHookTrigger(Boolean webHookTrigger) {
        this.webHookTrigger = webHookTrigger;
    }

}
