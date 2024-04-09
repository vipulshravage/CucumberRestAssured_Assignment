package StepDef;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class Assignment1
{
    public String celsius_value;
    public XmlPath xml_path_obj;
    public String request_body;
    Response response;

    @Given("user provide the Celsius value {string}")
    public void user_provide_the_celsius_value(String celsius)
    {
        celsius_value=celsius;
    }

    @Then("user create a conversion")
    public void user_create_a_conversion()
    {
        request_body ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "      <Celsius>"+celsius_value+"</Celsius>\n" +
                "    </CelsiusToFahrenheit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    @When("user send a post call {string}")
    public void user_send_a_post_call(String expectedurl)
    {
        response =given().contentType(ContentType.XML).header("Content-Type","text/xml; charset=utf-8")
                .body(request_body).when().post(expectedurl);
        System.out.println("Response: "+response.getBody().asString());

    }

    @When("user see the status code as {string}")
    public void user_see_the_status_code_as(String status_code)
    {
        int stauscode = response.statusCode();
        Assert.assertEquals(String.valueOf(stauscode),status_code);
    }

    @When("user see the result as CelsiustoFerhenheit {string}")
    public void user_see_the_result_as_celsiusto_ferhenheit(String result)
    {
        xml_path_obj =new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String data = xml_path_obj.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult").trim();
        System.out.println(data);
        Assert.assertEquals(String.valueOf(data),result);
    }
}
