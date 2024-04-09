package StepDef;

import io.cucumber.java.en.*;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.Assert;


public class Assignment2
{
    public String name1,data_year1,data_price1;
    public XmlPath xml_path_obj;
    public String request_body;
    Response response;

    @Given("User provide the name {string} and {string} and {string}")
    public void user_provide_the_name_and_and(String name, String year, String price)
    {
        name1 = name;
        data_year1 = year;
        data_price1 = price;
    }

    @Then("User create a conversion")
    public void user_create_a_conversion()
    {
        request_body ="{\"name\":\""+name1+"\",\n" +
                "\"data\":{\"year\":"+data_year1+",\n" +
                "\"price\":"+data_price1+",\n" +
                "\"CPU model\":\"Intel Core i9\",\n" +
                "\"Hard disk size\":\"1 TB\"\n" +
                "}\n" +
                "}";
    }

    @When("User send a post call {string}")
    public void user_send_a_post_call(String url)
    {
        response = given().contentType(ContentType.JSON).body(request_body).when().post(url);
        System.out.println("Response: "+response.getBody().asString());
    }

    @When("User see the status code as {string}")
    public void user_see_the_status_code_as(String status_code)
    {
        int stauscodenew = response.statusCode();
        Assert.assertEquals(String.valueOf(stauscodenew),status_code);
    }

    @When("User validate the year {string}")
    public void user_validate_the_year(String responseyear)
    {
        String year1 = response.getBody().jsonPath().getString("data.year");
        System.out.println(year1);
        Assert.assertEquals(String.valueOf(year1),responseyear);
    }

    @When("User validate the price  {string}")
    public void user_validate_the_price(String price)
    {
        String price1 = response.getBody().jsonPath().getString("data.price");
        System.out.println(price1);
        Assert.assertEquals(String.valueOf(price1),price);
    }

    @When("User validate the created date should not null")
    public void user_validate_the_created_date_should_not_null()
    {
        String create_date_new = response.getBody().jsonPath().getString("createdAt");
        System.out.println(create_date_new);
    }

}
