package StepDef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.ArrayList;

public class Assignment4
{
    Response response;
    RestAssured restAssured;
    RequestSpecification requestSpecification;
    public XmlPath xml_path_obj;

    @Given("User launch url {string}")
    public void user_launch_url(String url)
    {
        restAssured.baseURI = url;
    }

    @Then("User hit a url")
    public void user_hit_a_url()
    {
        response = RestAssured.get();
    }

    @Then("User check the status code as {string}")
    public void user_check_the_status_code_as(String statuscode)
    {
        int status_code1 = response.statusCode();
        Assert.assertEquals(String.valueOf(status_code1),statuscode);
    }

    @Then("User validate the currencies as {string}")
    public void user_validate_the_currencies_as(String string)
    {
        ArrayList<String> Titles = new ArrayList<>();
        int currencylist = xml_path_obj.get("definitions.types.schema.simpleType.name.size()");
        //System.out.println("Currencies "+currencylist);
        for (int i=0;i<currencylist;i++)
        {
            Titles.add(xml_path_obj.getString("definitions.types.s:schema.s:simpleType.name.s:restriction.s:enumeration["+i+"].value"));
        }
        System.out.println(Titles.toString());
    }

    @Then("User validate the forward types as {string}")
    public void user_validate_the_forward_types_as(String string) {

    }

    @Then("User validate outcome types as {string}")
    public void user_validate_outcome_types_as(String string) {

    }

}
