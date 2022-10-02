package com.example.demo.dto;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-02 20:02
 **/
public class ProjectUrlDTO {
    private String projectNum;
    private String projectDashboardUrl;

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public String getProjectDashboardUrl() {
        return projectDashboardUrl;
    }

    public void setProjectDashboardUrl(String projectDashboardUrl) {
        this.projectDashboardUrl = projectDashboardUrl;
    }
}
