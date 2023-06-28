package mainframepackage;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreportpackage.ExtentReportClass;

public class ExcelDataProvider {
    public ExtentReports extent;
    public ExtentTest test;
    public WebDriver driver;

    @BeforeTest
    public void Extentreport() {
    	extent = new ExtentReports(System.getProperty("D:\\Eclipseworkspace 1\\HrmsDemoProgram") + "LoginReport.html",true);	
    }    
    
    @Test(priority = 1, enabled = true, dataProvider = "getData", dataProviderClass=DataDrivenClass.class)
       public void BrowserLaunch(String candidateName1, String password1) throws InterruptedException {
    	test = extent.startTest("HRMS Demo Project");
        System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\DRIVERS\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hrmsdemo.tdesk.io/");
           
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(candidateName1);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(password1);      

        WebElement signup = driver.findElement(By.xpath("//button[@type='submit']"));
        signup.click();
        Thread.sleep(3000);
        WebElement HRProcess = driver.findElement(By.xpath("//div[@class='widget-user-header bg-info']"));
        Assert.assertTrue(HRProcess.isDisplayed());
        driver.quit();
        
        test.log(LogStatus.PASS, "Login successfully");
        test.log(LogStatus.INFO, "User logged into the portal successfully");
        
    }   
    
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenShotPath = ExtentReportClass.capture(driver, "screenShotName");
            test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
            
        }
        extent.endTest(test);
    }
    
    @AfterTest
    public void teardown() {
        extent.flush();
        extent.close();
        driver.quit();
    }}





        
        
        
    	
    	/*
    	 
    @Test(priority = 3, enabled = false)
    public void candidate() throws InterruptedException {
    	
    test = extent.startTest("Candidate login Functionality");
    
    WebElement HRProcess = driver.findElement(By.xpath("//div[@class='widget-user-header bg-info']"));
    HRProcess.click();
   Thread.sleep(4000);

    WebElement Candidate = driver.findElement(By.xpath("//p[text()='Candidates']"));
    Candidate.click();

    WebElement AddCandidate = driver.findElement(By.xpath("//a[@data-content='Add Candidate']"));
    AddCandidate.click();
    
    test.log(LogStatus.PASS, "Candidate portal entered successfully");
    test.log(LogStatus.INFO, "Candidate logged into the portal successfully");
    }
    
    	Test(priority = 4, enabled = true, dataProvider = "login data", dataProviderClass=DataDrivenClass.class)
        public void CandidateRegistration(String candidateName, String candidateSource, String candidateReference,
             String candidateMobile, String candidateExperience, String candidateExperienceMonth, String candidateEmail,
             String candidateTitle, String candidateOrganization, String candidateNoticePeriod,
             String candidateLastNoticePeriod, String candidateRelevantExp, String candidateCTC, String candidateECTC)
             throws InterruptedException, AWTException {

        WebElement CandidateName = driver.findElement(By.id("form_element.candidate_name"));
        CandidateName.click();
        CandidateName.sendKeys(candidateName);

        WebElement CandidateSource = driver.findElement(By.xpath("//select[@id='form_element.candidate_source_id']"));
        Actions obj1 = new Actions(driver);
        obj1.doubleClick(CandidateSource).build().perform();
        Thread.sleep(1000);
        Select select = new Select(CandidateSource);
        select.selectByVisibleText(candidateSource);

        WebElement CandidateReference = driver.findElement(By.xpath("//select[@id='form_element.referal_employee_id']"));
        obj1.doubleClick(CandidateReference).build().perform();
        Thread.sleep(1000);
        Select select1 = new Select(CandidateReference);
        select1.selectByVisibleText(candidateReference);

        WebElement CandidateMobile = driver.findElement(By.id("form_element.mobile_1"));
        CandidateMobile.click();
        CandidateMobile.sendKeys(candidateMobile);

        WebElement CandidateExperience = driver.findElement(By.id("form_element.experience_in_years"));
        CandidateExperience.click();
        CandidateExperience.sendKeys(candidateExperience);

        WebElement CandidateExperienceMonth = driver.findElement(By.id("form_element.experience_in_months"));
        CandidateExperienceMonth.click();
        CandidateExperienceMonth.sendKeys(candidateExperienceMonth);

        WebElement CandidateEmail = driver.findElement(By.id("form_element.email"));
        CandidateEmail.click();
        CandidateEmail.sendKeys(candidateEmail);

        WebElement CandidateTitle = driver.findElement(By.id("form_element.current_job_title"));
        CandidateTitle.click();
        CandidateTitle.sendKeys(candidateTitle);

        WebElement CandidateOrganiz = driver.findElement(By.id("form_element.current_organization"));
        CandidateOrganiz.click();
        CandidateOrganiz.sendKeys(candidateOrganization);

        WebElement CandidateNoticePeriod = driver.findElement(By.id("form_element.currently_in_notice"));
        CandidateNoticePeriod.click();

        WebElement CandidateLastNoticePeriod = driver.findElement(By.id("form_element.notice_period"));
        CandidateLastNoticePeriod.click();
        CandidateLastNoticePeriod.sendKeys(candidateLastNoticePeriod);

        WebElement CandidateReleventExp = driver.findElement(By.id("form_element.relevant_experience"));
        CandidateReleventExp.click();
        CandidateReleventExp.sendKeys(candidateRelevantExp);

        WebElement CandidateCTC = driver.findElement(By.id("form_element.current_ctcmonth"));
        CandidateCTC.click();
        CandidateCTC.sendKeys(candidateCTC);

        WebElement CandidateECTC = driver.findElement(By.id("form_element.expected_ctcmonth"));
        CandidateECTC.click();
        CandidateECTC.sendKeys(candidateECTC);

        test.log(LogStatus.PASS, "Candidate field entered successfully");
        test.log(LogStatus.INFO, "Candidate logged into the portal successfully");
    }*/

    