import io.testproject.sdk.drivers.GenericDriver;
import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import io.testproject.sdk.internal.rest.AgentClient;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DemoAPITest {

    //@Test
    public void demoApiTest() throws IOException, InvalidTokenException, AgentConnectException, ObsoleteVersionException {
        String projectName = "APIFirstProject";
        String projectJob = "APIFrstJob";
        //GenericDriver genericDriver = new GenericDriver(new URL("http://localhost:8585"), "j-cMljjJIjQ6zoXzyYIjhpz0PDyseiIyRXYKsqYzu_41", projectName, projectJob, false);
        GenericDriver genericDriver = new GenericDriver(new URL("https://api.testproject.io/v2/agents?_start=0&_limit=10"), "iVDNC-jeL8mhP4lh3F1CjVYSQVPRk_sgGpT5cFAtbhI1", projectName, projectJob, false);
        //genericDriver.getReportingCommandExecutor().getAgentClient().getVersion()

        //HttpHost httpHost = new HttpHost("localhost", 8585);
        HttpGet httpGet = new HttpGet("https://api.testproject.io/v2/agents?_start=0&_limit=10");

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();
        httpGet.setConfig(config);
        HttpClientBuilder httpClientBuilder = HttpClients.custom()
                .addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
                    request.setHeader(HttpHeaders.AUTHORIZATION, "iVDNC-jeL8mhP4lh3F1CjVYSQVPRk_sgGpT5cFAtbhI1");
                    request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.toString());
                    request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
                });

        // Send Get request
        CloseableHttpResponse response;
        try {
            response = httpClientBuilder.build().execute(httpGet);
        } catch (IOException e) {
            //LOG.error("Failed to get Agent status", e);
            throw new AgentConnectException("Failed to get Agent status", e);
        }

        // Read Response
        String responseBody;
        try {
            responseBody = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.name());
            JSONParser jsonParser = new JSONParser();

            JSONArray jsonArray = (JSONArray) jsonParser.parse(responseBody);
            Object aliasName = ((JSONObject) jsonArray.get(0)).get("alias");
            if(aliasName.equals("Pulkit's") || aliasName.equals("TX windows"))
                Assert.assertTrue(true);
            else {
                Assert.assertTrue(false);
            }
        } catch (IOException | ParseException e) {
            //LOG.error("Failed reading Agent status response", e);
            throw new AgentConnectException("Failed to get Agent status", e);
        }
    }
}
