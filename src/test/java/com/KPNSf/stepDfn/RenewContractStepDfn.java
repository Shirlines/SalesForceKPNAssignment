package com.KPNSf.stepDfn;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.KPNSf.page.CreateNewContractPageClass;
import com.KPNSf.page.DocumentsPageClass;
import com.KPNSf.page.LoginPageClass;
import com.KPNSf.page.UserAccountPageClass;
import com.KPNSf.services.DriverServices;
import com.KPNSf.utils.IReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RenewContractStepDfn {

	private DriverServices Dservices;
	private WebDriver driver;
	private IReader readConfigFile;
	private LoginPageClass loginPage;
	private UserAccountPageClass usrAccPage;
	private CreateNewContractPageClass createNewContractPage;
	private DocumentsPageClass documentsPage;

	public RenewContractStepDfn(DriverServices services) {
		this.Dservices = services;
		this.driver = Dservices.getDriver();
		this.readConfigFile = services.getReader();
	}

	@Given("^A valid user is logged in$")
	public void a_valid_user_is_logged_in() {
		driver.get(readConfigFile.getApplicationUrl());
		loginPage = new LoginPageClass(driver);
		usrAccPage = (UserAccountPageClass) loginPage.loginAndNavigateToAccountPage(readConfigFile.getUsername(), readConfigFile.getPassword(),
				readConfigFile.getUserPageUrl());
		System.out.println("Given that the valid user should be logged in");
	}

	@When("^The Renew Contract link is clicked and the create new contract page is loaded$")
	public void The_Renew_Contract_link_is_clicked_and_the_create_new_contract_page_is_loaded() {
		createNewContractPage = (CreateNewContractPageClass) usrAccPage.navigateTocreateNewContractPage();
	}

	@When("^The fields are filled with contractName as \"([^\"]*)\", term as \"([^\"]*)\", status as Draft and clicked on Done$")
	public void The_fields_are_filled_with_contractName_as_something_term_as_something_status_as_Draft_and_clicked_on_Done(
			String contractname, String term) {
		createNewContractPage.fillDetails(contractname, term);
		documentsPage = (DocumentsPageClass) createNewContractPage.navigateToDocumentsPage();
	}

	@Then("^The contract is renewed successfully with correct details$")
	public void The_contract_is_renewed_successfully_with_correct_details() throws IOException {
		documentsPage.verifyDetails();
	}

	@When("^The fields are filled with contractName as \"([^\"]*)\", term as \"([^\"]*)\", status as Signed and clicked on Done$")
	public void The_fields_are_filled_with_contractName_as_something_term_as_something_status_as_signed_and_clicked_on_Done(
			String contractname, String term) {
		createNewContractPage.fillDetailsForErr(contractname, term);
	}

	@Then("^An error message pops up with a warning$")
	public void An_error_message_pops_up_with_a_warning() {
		createNewContractPage.errorPopUp();
	}

	@When("^OK is clicked by the user on the error pop up$")
	public void OK_is_clicked_by_the_user_on_the_error_pop_up() {
		createNewContractPage.clickOkOnErr();
	}

	@Then("^The user is taken back to the renew contract page with an error message displayed$")
	public void The_user_is_taken_back_to_the_renew_contract_page_with_an_error_message_displayed() {
		createNewContractPage.displayErrorOnPage();
	}
}
