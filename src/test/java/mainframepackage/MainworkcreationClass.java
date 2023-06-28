package mainframepackage;

import java.awt.AWTException;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreportpackage.ExtentReportClass;

public class MainworkcreationClass {
 
    public ExtentReports extent;			
	public ExtentTest test;			
	public WebDriver driver;
	
	   
    @BeforeTest			
	public void Extentreport() {			
	extent = new ExtentReports(System.getProperty("D:\\Eclipseworkspace 1\\HrmsDemoProgram") + "HrmsDemoReport.html",true);		
	}	
		
	@Test(priority=1, enabled=true)			
	public void BrowserLaunch()				
	{	
	test = extent.startTest("HRMS Demo Project");
	System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\DRIVERS\\chromedriver.exe");		
	driver=new ChromeDriver();		
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
	driver.manage().window().maximize();		
	driver.navigate().to("https://hrmsdemo.tdesk.io/");		
	test.log(LogStatus.PASS, " Browser launching Successfully ");
	test.log(LogStatus.INFO," Browser Method Running Successsfully");

	}

	@Test(priority=2, enabled=true)
	public void Login() {
		
		test = extent.startTest("Login Functionality");
		WebElement Email=driver.findElement(By.id("email"));
		Email.click();
		Email.sendKeys("bjohnpaul0609@gmail.com");
		
		WebElement Password=driver.findElement(By.id("password"));
		Password.click();
		Password.sendKeys("bjohnpaul@0609");
		
		
		WebElement signup=driver.findElement(By.xpath("//button[@type='submit']"));
		signup.click();	
		
		test.log(LogStatus.PASS, " Login Successfully ");
		test.log(LogStatus.INFO," User Logging into the portal Successsfully");
}
	  @Test(priority=3, enabled=true)
	  public void CandidateRegistration() throws InterruptedException, AWTException {
		test = extent.startTest("Candidate Registration Form Functionality");
		WebElement HRProcess=driver.findElement(By.xpath("//div[@class='widget-user-header bg-info']"));
		HRProcess.click();
		
		WebElement Candidate=driver.findElement(By.xpath("//a[@title='Candidates']"));
		Candidate.click();
		
		WebElement AddCandidate=driver.findElement(By.xpath("//a[@data-content='Add Candidate']"));
		AddCandidate.click();
		
		WebElement CandidateName=driver.findElement(By.id("form_element.candidate_name"));
		CandidateName.click();
		CandidateName.sendKeys("Johnpaul");
		
		WebElement CandidateSource=driver.findElement(By.xpath("//select[@id='form_element.candidate_source_id']"));
		Actions obj1= new Actions(driver);	
	    obj1.doubleClick(CandidateSource).build().perform();
	    Thread.sleep(1000);    
	    Select select= new Select(CandidateSource);
	    select.selectByIndex(3);	    

	    WebElement CandidateReference=driver.findElement(By.xpath("//select[@id='form_element.referal_employee_id']"));	
	    obj1.doubleClick(CandidateReference).build().perform();
	    Thread.sleep(1000);    
	    Select select1= new Select(CandidateReference);
	    select1.selectByIndex(4);
	    	    
		WebElement CandidateMobile=driver.findElement(By.id("form_element.mobile_1"));
		CandidateMobile.click();
		CandidateMobile.sendKeys("9080068247");
			
		WebElement CandidateExperience=driver.findElement(By.id("form_element.experience_in_years"));
		CandidateExperience.click();
		CandidateExperience.sendKeys("6");
		
		WebElement CandidateExperienceMonth=driver.findElement(By.id("form_element.experience_in_months"));
		CandidateExperienceMonth.click();
		CandidateExperienceMonth.sendKeys("3");
			
		WebElement CandidateEmail=driver.findElement(By.id("form_element.email"));
		CandidateEmail.click();
		CandidateEmail.sendKeys("bjohnpaul060902@gmail.com");
			
		WebElement CandidateTitle=driver.findElement(By.id("form_element.current_job_title"));
		CandidateTitle.click();
		CandidateTitle.sendKeys("Quality Engineer");
				
		WebElement CandidateOrganiz=driver.findElement(By.id("form_element.current_organization"));
		CandidateOrganiz.click();
		CandidateOrganiz.sendKeys("Texila Inc");
			
		WebElement CandidateNoticePeriod=driver.findElement(By.id("form_element.currently_in_notice"));
		CandidateNoticePeriod.click();
			
		WebElement CandidateLastNoticePeriod=driver.findElement(By.id("form_element.notice_period"));
		CandidateLastNoticePeriod.click();
		CandidateLastNoticePeriod.sendKeys("5/07/2023");
			
		WebElement CandidateReleventExp=driver.findElement(By.id("form_element.relevant_experience"));
		CandidateReleventExp.click();
		CandidateReleventExp.sendKeys("6");
			
		WebElement CandidateCTC=driver.findElement(By.id("form_element.current_ctcmonth"));
		CandidateCTC.click();
		CandidateCTC.sendKeys("500000");
			
		WebElement CandidateECTC=driver.findElement(By.id("form_element.expected_ctcmonth"));
		CandidateECTC.click();
		CandidateECTC.sendKeys("700000");
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS, " Candidate Field Entered Successfully ");
		test.log(LogStatus.INFO," Candidate log into the portal Successsfully");
		
	}
	
	@Test(priority=4, enabled=true)
	public void ResumeUpload() throws InterruptedException, AWTException {

		    test = extent.startTest("Candidate Resume Uploaded Form Functionality");
		    String filePath = "C:\\Users\\Admin\\Test Data.pdf"; // Replace with your desired file path

	        // Copy the file path to the clipboard
	        StringSelection stringSelection = new StringSelection(filePath);
	        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	        clipboard.setContents(stringSelection, null);

	        // Locate the input field where you want to paste the file path
	         WebElement resume=driver.findElement(By.xpath("//input[@name='form_element_resume_filename531']"));
			 Thread.sleep(3000); 
			 Actions obj = new Actions(driver);				 
			 //obj.click(resume).perform();

	        // Simulate the Ctrl+V keyboard shortcut to paste the file path
			  resume.sendKeys(filePath);			  
			  Thread.sleep(4000);
			  
			  WebElement Summit=driver.findElement(By.xpath("//button[@class='btn btn-success form_action_ele']"));
			  obj.click(Summit).build().perform();  
			  
			  test.log(LogStatus.PASS, " Candidate Resume Uploaded Successfully ");
			  test.log(LogStatus.INFO," Candidate Resume Uploaded Successfully");
	}

	@Test(priority=5, enabled=false)
	public void CandidateSource() throws InterruptedException, AWTException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		Thread.sleep(1000);
	
	WebElement CandidateSource=driver.findElement(By.xpath("//select[@id='form_element.candidate_source_id']"));
	Actions obj1= new Actions(driver);	
    obj1.doubleClick(CandidateSource).build().perform();
    Thread.sleep(2000);    
    Select select= new Select(CandidateSource);
    select.selectByIndex(3);
    

    WebElement CandidateReference=driver.findElement(By.xpath("//select[@id='form_element.referal_employee_id']"));	
    obj1.doubleClick(CandidateReference).build().perform();
    Thread.sleep(2000);    
    Select select1= new Select(CandidateReference);
    select1.selectByIndex(4);
    
	}
	
	@AfterMethod			
	public void getResult(ITestResult result) throws IOException {			
		if (result.getStatus() == ITestResult.SUCCESS) {		
			//String screenShotPath = ExtentReportClass.capture(driver, "screenShotName");	
			test.log(LogStatus.PASS, "Test case is passed " + result.getStatus());	
				
				
		} else {		
			if (result.getStatus() == ITestResult.FAILURE) {	
				String screenShotPath = ExtentReportClass.capture(driver, "screenShotName");
				test.log(LogStatus.FAIL, "Test case is failed at below location " + result.getThrowable());
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
			}	
		}}
	
	@AfterTest	
	public void endreport() {	
		extent.flush();
		extent.endTest(test);
	}	

	
	
}

	
		
	
				




