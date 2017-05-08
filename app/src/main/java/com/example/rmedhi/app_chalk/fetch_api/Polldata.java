package com.example.rmedhi.app_chalk.fetch_api;

/**
 * Created by R Medhi on 09-05-2017.
 */

public class Polldata {
    private int poll_id;
    private String poll_ques;
    private String poll_desc;
    private String status;
    private int creator_uid;
    private int topic;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPoll_id() {
        return poll_id;
    }

    public void setPoll_id(int poll_id) {
        this.poll_id = poll_id;
    }

    public String getPoll_ques() {
        return poll_ques;
    }

    public void setPoll_ques(String poll_ques) {
        this.poll_ques = poll_ques;
    }

    public String getPoll_desc() {
        return poll_desc;
    }

    public void setPoll_desc(String poll_desc) {
        this.poll_desc = poll_desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreator_uid() {
        return creator_uid;
    }

    public void setCreator_uid(int creator_uid) {
        this.creator_uid = creator_uid;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }
}
