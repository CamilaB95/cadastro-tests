package br.com.cadastro.pages;

import br.com.cadastro.step_definitions.DriverFactory;
import br.com.cadastro.util.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaInicialPage {

    private WebDriver driver;
    Screenshot screenshot = new Screenshot(DriverFactory.driver);

    private By btnEntre = By.xpath("//div[@class='login']//a[@href='/central-do-cliente']");
    private By btnLogin = By.xpath("//button[@class='botao-commerce botao-efetuar-login']");
    private By inputEmail = By.xpath("//input[@id='input-email']");
    private By btnContinuar = By.xpath("//button[@id='tray-login-identify']");
    private By inputSenha = By.xpath("//input[@id='input-password']");
    private By btnContinuarLogin = By.xpath("//button[@id='password-submit']");
    private By btnMinhaConta = By.xpath("//a[@href='/my-account/']");


    public TelaInicialPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarTelaInicial() {
        DriverFactory.driver.manage().deleteAllCookies();
        DriverFactory.driver.get("https://www.amoberloque.com.br/");
        DriverFactory.driver.manage().window().maximize();
        screenshot.takeSnapShot("TelaInicial");
    }

    public Boolean LogarUsuario(String cpf, String senha) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        screenshot.takeSnapShot("Login");
        driver.findElement(btnEntre).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        driver.findElement(btnLogin).click();
        driver.findElement(inputEmail).sendKeys(cpf);
        driver.findElement(btnContinuar).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnContinuarLogin));
        driver.findElement(inputSenha).sendKeys(senha);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(btnContinuarLogin).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnMinhaConta));
        if (driver.findElement(btnMinhaConta).isDisplayed()) {
            screenshot.takeSnapShot("LoginSucesso");
            return true;
        } else {
            return false;
        }
    }

}
