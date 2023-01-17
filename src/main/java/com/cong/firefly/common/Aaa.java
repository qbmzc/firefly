package com.cong.firefly.common;

import java.util.List;

/**
 * @program: csp-parent
 * @description:
 * @author: sasa.zhang
 * @create: 2023-01-17 15:52
 */
public class Aaa {

    private List<String> file_upload;
    private List<String> ip_list_nprod;
    private List<String> ip_list_prod;
    private List<String> user_list;
    private String request_description;
    private String direct_leader;
    private String attachment;
    private String operator;
    private String title;
    private String env_type;
    private String permission;
    private Label labels;

    public Label getLabels() {
        return labels;
    }

    public void setLabels(Label labels) {
        this.labels = labels;
    }

    public List<String> getFile_upload() {
        return file_upload;
    }

    public void setFile_upload(List<String> file_upload) {
        this.file_upload = file_upload;
    }

    public List<String> getIp_list_nprod() {
        return ip_list_nprod;
    }

    public void setIp_list_nprod(List<String> ip_list_nprod) {
        this.ip_list_nprod = ip_list_nprod;
    }

    public List<String> getIp_list_prod() {
        return ip_list_prod;
    }

    public void setIp_list_prod(List<String> ip_list_prod) {
        this.ip_list_prod = ip_list_prod;
    }

    public List<String> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<String> user_list) {
        this.user_list = user_list;
    }

    public String getRequest_description() {
        return request_description;
    }

    public void setRequest_description(String request_description) {
        this.request_description = request_description;
    }

    public String getDirect_leader() {
        return direct_leader;
    }

    public void setDirect_leader(String direct_leader) {
        this.direct_leader = direct_leader;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnv_type() {
        return env_type;
    }

    public void setEnv_type(String env_type) {
        this.env_type = env_type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
