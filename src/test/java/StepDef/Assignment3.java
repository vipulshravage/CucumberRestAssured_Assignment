package StepDef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Assignment3
{
    Response response;
    String response1;
    RestAssured restAssured;
    RequestSpecification requestSpecification;

    @Given("User launch the url {string}")
    public void user_launch_the_url(String url)
    {
        restAssured.baseURI =url;
    }

    @Then("User hit the url")
    public void user_hit_the_url()
    {
        response = RestAssured.get();
        response1 = response.getBody().asString();
        System.out.println("Response: "+response1);
    }

    @Then("User check the status code {string}")
    public void user_check_the_status_code(String status_code)
    {
        int stutuscode = response.statusCode();
        Assert.assertEquals(String.valueOf(stutuscode),status_code);
    }

    @Then("User validate the id {string} and verify {string}")
    public void user_validate_the_id_and_verify(String id, String name)
    {
        int id_value =response.getBody().jsonPath().getList("id").size();
        System.out.println("Total number of ID: " + id_value);
        for (int a=1;a<id_value;a++) {
            String id1 = response.getBody().jsonPath().getString("id[" + a + "]");

            if (id1.equals(id)) {
                System.out.println("ID is showing as " + id);
                String name1 = response.getBody().jsonPath().getString("name[" + a + "]");
                System.out.println("Name is "+ name1);
                Assert.assertEquals(name1,name);
                break;
            }
        }
    }
}
