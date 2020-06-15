package febb.renwa_client.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RenwaVoice implements Serializable {
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("confirm_mail")
    @Expose
    private String confirmMail;
    @SerializedName("user_agent")
    @Expose
    private String userAgent;
    @SerializedName("app_ver")
    @Expose
    private String appVer;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getConfirmMail() {
        return confirmMail;
    }

    public void setConfirmMail(String confirmMail) {
        this.confirmMail = confirmMail;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }
}
