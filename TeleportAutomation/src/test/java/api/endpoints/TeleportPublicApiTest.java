package api.endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
/*
 * Feature1: Retrieve Miami City Details
 * 
  Scenario: Verify the retrieval of alternate city names for Miami
    Given the Teleport API endpoint to retrieve alternate city names is "https://api.teleport.org/api/cities/geonameid:5368361"
    When a GET request is sent to the API endpoint
    Then the response status code should be 200
    And the response should contain "Miami" 
    And the response should contain "alternate_names" */
public class TeleportPublicApiTest {

    @Test
    public void testGetAlternateNamesForMiamiCity() {
        String cityId = "5368361"; // 
        Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .when()
            .get("https://api.teleport.org/api/cities/geonameid:" + cityId)
            .then()
            .statusCode(200)
            .extract()
            .response();

        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
    }
    /* Feature2: Get Africa Continent Information

  Scenario:  Verify the retrieval of Africa Continent Details
     Given the Teleport API endpoint to retrieve Africa Continent Details is "https://api.teleport.org/api/continents/geonames:AF/"
    When I send a GET request to retrieve information about the Africa continent
    Then the response status code should be 200
    And the response should be in JSON format
    And the response body should contain continent information */
    @Test
    public void testGetAfricaContinent() {
        Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .when()
            .get("https://api.teleport.org/api/continents/geonames:AF/")
            .then()
            .statusCode(200)
            .extract()
            .response();

        String responseBody = response.getBody().asString();
        System.out.println("Response body for Africa continent: " + responseBody);
    }
}
  
