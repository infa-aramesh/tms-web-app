package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.time.Instant;

@Controller
public class TMSController {
  final long processing_duration_minutes = 3;
  final long processing_duration_msecs = processing_duration_minutes * 60 * 1000;

  @Autowired
  private AppConfig config;


  @RequestMapping(method = RequestMethod.PUT, value = "/dataDestruction/orgdelete/request/{migrationId}")
  @ResponseBody
  public OrgDeleteInitiateResponse orgDeleteInitiate(@PathVariable String migrationId, @RequestBody OrgDeleteInitiateRequest request) {
    System.out.println("Received data destruction initiation request from P2PMS service for migration Id: " + migrationId);
    System.out.println("Request payload ...");
    System.out.println("***** Migration Id:" + request.getMigrationId());
    System.out.println("***** Service Name:" + request.getServiceName());
    System.out.println("***** Org Id:" + request.getOrgId());
    System.out.println("***** Request Sequence:" + request.getRequestSqn());
    System.out.println("***** Request Id:" + request.getRequestId());

    OrgDeleteInitiateResponse response = new OrgDeleteInitiateResponse();
    response.setMigrationId(request.getMigrationId());
    response.setRequestId(request.getRequestId());
    response.setServiceName(request.getServiceName());
    response.setOrgId(request.getOrgId());
    response.setStatus("INITIAL");

    System.out.println("Response payload:");
    System.out.println("***** Migration Id:" + response.getMigrationId());
    System.out.println("***** Request Id:" + response.getRequestId());
    System.out.println("***** Service Name:" + response.getServiceName());
    System.out.println("***** Org Id:" + response.getOrgId());
    System.out.println("***** Status:" + response.getStatus());
    System.out.println("****************************************************************************************************");

    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/dataDestruction/orgdelete/status/{migrationId}")
  @ResponseBody
  public OrgDeleteStatusResponse orgDeleteStatus(@PathVariable String migrationId) {
    System.out.println("Received data destruction status request from P2PMS service for migration Id: " + migrationId);

    OrgDeleteStatusResponse response = new OrgDeleteStatusResponse();
    response.setMigrationId(migrationId);
    response.setRequestId("<RequestId>");
    response.setServiceName("<ServiceName>");
    response.setOrgId("<OrgId>");

    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    long uptimeInMilliseconds = runtimeMXBean.getStartTime();
    long currentTimeinMilliseconds = Instant.now().getEpochSecond() * 1000;

    if (currentTimeinMilliseconds - uptimeInMilliseconds >= processing_duration_msecs)
    {
      response.setStatus("COMPLETED_OK");
    }
    else
    {
      response.setStatus("IN_PROGRESS");
    }

    System.out.println("Response payload:");
    System.out.println("***** Migration Id:" + response.getMigrationId());
    System.out.println("***** Request Id:" + response.getRequestId());
    System.out.println("***** Service Name:" + response.getServiceName());
    System.out.println("***** Org Id:" + response.getOrgId());
    System.out.println("***** Status:" + response.getStatus());

    System.out.println("****************************************************************************************************");

    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/dataDestruction/orgdelete/result/{migrationId}")
  @ResponseBody
  public OrgDeleteResultResponse orgDeleteResult(@PathVariable String migrationId) {
    System.out.println("Received data destruction result request from P2PMS service for migration Id: " + migrationId);

    OrgDeleteResultResponse response = new OrgDeleteResultResponse();
    response.setMigrationId(migrationId);
    response.setRequestId("<RequestId>");
    response.setErrorMessage("");
    response.setErrorCode("");
    response.setServiceName("<ServiceName>");
    response.setOrgId("org");
    response.setTest_Val(config.getValue());
    response.setMessage(config.getMessage());

    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    long uptimeInMilliseconds = runtimeMXBean.getStartTime();
    long currentTimeinMilliseconds = Instant.now().getEpochSecond() * 1000;

    if (currentTimeinMilliseconds - uptimeInMilliseconds >= processing_duration_msecs)
    {
      response.setResult("COMPLETED_OK");
    }
    else
    {
      response.setResult("IN_PROGRESS");
    }

    System.out.println("Response payload:");
    System.out.println("***** Result: " + response.getResult());
    System.out.println("***** Migration Id: " + response.getMigrationId());
    System.out.println("***** Request Id: " + response.getRequestId());
    System.out.println("***** Error Message: " + response.getErrorMessage());
    System.out.println("***** Error Code: " + response.getErrorCode());
    System.out.println("***** Service Name: " + response.getServiceName());
    System.out.println("***** Org Id: " + response.getOrgId());

    System.out.println("****************************************************************************************************");

    return response;
  }

}
