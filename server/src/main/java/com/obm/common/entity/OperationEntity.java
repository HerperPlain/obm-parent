package com.obm.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_operation")
public class OperationEntity {
    @Id
    @Column(name = "operation_id")
    private String operationId;
    @Column(name = "operation_name")
    private String operationName;
    @Column(name = "operation_url")
    private String operationUrl;
    @Column(name = "operation_time")
    private String operationTime;
    @Column(name = "operation_username")
    private String operationUsername;
    @Column(name = "operation_rolename")
    private String operationRolename;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationUrl() {
        return operationUrl;
    }

    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationUsername() {
        return operationUsername;
    }

    public void setOperationUsername(String operationUsername) {
        this.operationUsername = operationUsername;
    }

    public String getOperationRolename() {
        return operationRolename;
    }

    public void setOperationRolename(String operationRolename) {
        this.operationRolename = operationRolename;
    }

    @Override
    public String toString() {
        return "OperationEntity{" +
                "operationId='" + operationId + '\'' +
                ", operationName='" + operationName + '\'' +
                ", operationUrl='" + operationUrl + '\'' +
                ", operationTime='" + operationTime + '\'' +
                ", operationUsername='" + operationUsername + '\'' +
                ", operationRolename='" + operationRolename + '\'' +
                '}';
    }
}
