package com.example.restservice;

// Source class: com.informatica.cloud.service.p2pms.client.messages.impl.OrgDeleteResultImpl
public class OrgDeleteResultResponse {

  String result;

  String migrationId;

  String requestId;

  String errorMessage;

  String errorCode;

  String serviceName;

  String orgId;

  Integer test_Val;

  String message;


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getMigrationId() {
    return migrationId;
  }

  public void setMigrationId(String migrationId) {
    this.migrationId = migrationId;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
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
  };

  public void setTest_Val(Integer test_Val) {
    this.test_Val = test_Val;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getTest_Val() {
    return test_Val;
  }

  public String getMessage() {
    return message;
  }
}
