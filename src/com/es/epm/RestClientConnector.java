package com.es.epm;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientConnector {
	
	//These will be read from application.properties file. Many other variables will be added (for Discrepancy and Teams connectors.
	public static final String SERVER_URI = "http://jarvissaibal:8080/ConnectorFramework/service";
	public static final String CHECK_QUERY_FILTER = "/rallyrestws/checkQueryFilter";
	public static final String QUERY_RALLY = "/rallyrestws/queryrally";
	
	Client client = Client.create();
	
	//Method will take JSONObject created in RestClientBL.java as parameter
	public void firePostRequest(){
		WebResource webResource = client.resource(SERVER_URI+QUERY_RALLY);
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,inputData);//inputData will change to JSONObject input created from RestClientBL.java
		if(response.getStatus()!=200){
			   throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}				         
		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);

	}
	
	//Add similar methods to fire get and delete operations
}
