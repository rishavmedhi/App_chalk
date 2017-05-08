package com.example.rmedhi.app_chalk.fetch_api;

import java.util.ArrayList;

/**
 * Created by R Medhi on 09-05-2017.
 */

public class Fetch_all_polls {
    private int status;
    private int msg;
    private ArrayList<Polldata> polls;
    private ArrayList<Option_data> options;
    private ArrayList<Topic_data> topics;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public ArrayList<Polldata> getPolls() {
        return polls;
    }

    public void setPolls(ArrayList<Polldata> polls) {
        this.polls = polls;
    }

    public ArrayList<Option_data> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option_data> options) {
        this.options = options;
    }

    public ArrayList<Topic_data> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Topic_data> topics) {
        this.topics = topics;
    }
}
