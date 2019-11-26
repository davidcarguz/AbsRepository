package mobile.absworkout.appium.pageObjects;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;

public class AbsWorkoutPageObjects extends PageObject {

	public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities dc = new DesiredCapabilities();
	public WebDriverWait wait;
	public static String context = "";
	
	String btnStart = "//android.widget.ListView/android.view.ViewGroup[1]/android.widget.TextView[@text = \"Start\"]";
	String btnComenzar = "//android.view.ViewGroup/android.widget.TextView[@text = \"Ready to go\"]";
	String btnComenzarRutina = "sixpack.sixpackabs.absworkout:id/ly_start";
	String btnPausa = "sixpack.sixpackabs.absworkout:id/action_progress_pause_btn";
	String btnPerfil = "sixpack.sixpackabs.absworkout:id/view_setting_click";
	String btnLenguaje = "//android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@text = \"Language options\"]";
	String chkEspanol = "//android.widget.ListView/android.widget.CheckedTextView[@text = \"Español\"]";
	String btnComenzarSpn = "//android.view.ViewGroup/android.widget.TextView[@text = \"Ready to go\"]";
	
	public void iniciarApp() {
		dc.setCapability("deviceName", "Xiaomi Mi5");
        dc.setCapability("udid", "d728d2a97cf5");
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "8.1.0");
        dc.setCapability("app", "C:\\Users\\DAVID\\Desktop\\Six Pack in 30 Days Abs Workout_v1.0.14.apk");
        dc.setCapability("skipUnlock","true");
        dc.setCapability("appPackage", "sixpack.sixpackabs.absworkout");
        dc.setCapability("appActivity","sixpack.sixpackabs.absworkout.activity.StartActivity");
        dc.setCapability("noReset","false");
		try {
			driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		wait = new WebDriverWait(this.driver, 15);
	}

	public void darClicBotonDificultad() {
		MobileElement btnComenzarDificultad =(MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnStart)));
		btnComenzarDificultad.click();
		
	}

	public void darClicEnBotonListo() {
		MobileElement btnListo = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnComenzar)));
		btnListo.click();
		
	}

	public void darClicenBotonIniciar() {
		MobileElement btnIniciar = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnComenzarRutina)));
		btnIniciar.click();
		
	}

	public void validoBotonPausa() {
		boolean presente = false;
		MobileElement btnPausa = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnPausa)));
		presente = btnPausa.isDisplayed();
		assertTrue(presente);
		driver.quit(); 
		
	}

	public void darClicBotonPerfil() {
		context = driver.getContext();
		System.out.println("contexto: "+context);
		MobileElement btnPerfil = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPerfil)));
		btnPerfil.click();
		
	}
	@SuppressWarnings("rawtypes")
	public void seleccionarBotonCambioLenguaje() {
		waitFor(4).seconds();
		boolean presente;
		TouchAction ta = new TouchAction((PerformsTouchActions)driver);
		Dimension size = driver.manage().window().getSize();
		int pointX = ((size.width)/2);
		int startY = (int) ((size.height)*0.5);
		int endY = (int) ((size.height)*0.2);
		System.out.println("x: "+pointX+" y1: "+startY+" y2: "+endY);
		presente = driver.findElements(By.xpath(this.btnLenguaje)).size() > 0;
		while(presente == false){
		presente = driver.findElements(By.xpath(this.btnLenguaje)).size() > 0;	
		ta.press(PointOption.point(pointX,startY)).waitAction().moveTo(PointOption.point(pointX,endY)).release().perform();
		}
		driver.findElement(By.xpath(this.btnLenguaje)).click();
	}

	public void seleccionarIdiomaEspanol() {
		MobileElement btnEspanol = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.chkEspanol)));
		btnEspanol.click();
		
	}

	public void validarBotonPreparados() {
		waitFor(12).seconds();
		System.out.println("contexto global: "+context);
		System.out.println("contexto local: "+driver.getContext());
		driver.context(context);
		boolean presente = false;
		MobileElement btnPreparados = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnComenzarSpn)));
		presente = btnPreparados.isDisplayed();
		assertTrue(presente);
		driver.quit(); 
		
	}

	
	
}
