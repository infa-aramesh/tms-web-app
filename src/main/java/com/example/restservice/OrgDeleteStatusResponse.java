package com.example.restservice;

// Source class: com.informatica.cloud.service.p2pms.client.messages.impl.OrgDeleteStatusImpl
public class OrgDeleteStatusResponse {

  String migrationId;

  String serviceName;

  String orgId;

  String status;

  String requestId;

  public String getMigrationId() {
    return migrationId;
  }

  public void setMigrationId(String migrationId) {
    this.migrationId = migrationId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
}
