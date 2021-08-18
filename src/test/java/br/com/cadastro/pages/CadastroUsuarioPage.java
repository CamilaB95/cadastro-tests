package br.com.cadastro.pages;

import br.com.cadastro.step_definitions.DriverFactory;
import br.com.cadastro.util.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CadastroUsuarioPage {

    private WebDriver driver;
    Screenshot screenshot = new Screenshot(DriverFactory.driver);
    private By btnCadastreSe = By.xpath("//div[@class='login']//a[@href='/cadastro']");
    private By lblCadastro = By.xpath("//span[@id='tit_cadastro_pf']");
    // Objetos cadastro
    private By inputNome = By.xpath("//input[@id='pf_nome_cliente']");
    private By inputDataNasc = By.xpath("//input[@id='pf_data_nascimento']");
    private By inputCPF = By.xpath("//input[@id='pf_cpf_cliente']");
    private By inputCel = By.xpath("//input[@id='telefone_cliente_2']");
    private By inputEmail = By.xpath("//input[@id='email_cliente']");
    private By inputEmailConf = By.xpath("//input[@id='email_cliente2']");
    private By inputSenha = By.xpath("//input[@id='senha_cliente']");
    private By inputSenhaConf = By.xpath("//input[@id='senha_cliente2']");
    private By btnAvancar = By.xpath("//button[@class='botao-commerce botao-prosseguir-cadastro right']");

    public CadastroUsuarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessaTelaCadastro () {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(btnCadastreSe).click();
        screenshot.takeSnapShot("CadastroUsuario");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblCadastro));
        driver.findElement(lblCadastro).isDisplayed();
    }

    public void acessaTelaInicial() {
        driver.findElement(btnCadastreSe).click();
        driver.findElement(lblCadastro).isDisplayed();
    }

    public String cadastraUsuario(String cpfCadastrado, String senhaCadastrada) {
        Random random = new Random();
        int randomico = random.nextInt(1000);
        driver.findElement(inputNome).sendKeys("Camila Barbosa Nascimento");
        driver.findElement(inputDataNasc).sendKeys("03/10/1995");
        driver.findElement(inputCPF).sendKeys(cpfCadastrado);
        driver.findElement(inputCel).sendKeys("11923423432");
        driver.findElement(inputEmail).sendKeys("testeCam"+randomico+"@teste.com");
        driver.findElement(inputEmailConf).sendKeys("testeCam"+randomico+"@teste.com");
        driver.findElement(inputSenha).sendKeys(senhaCadastrada);
        driver.findElement(inputSenhaConf).sendKeys(senhaCadastrada);
        driver.findElement(btnAvancar).click();
        screenshot.takeSnapShot("CadastroRealizado");
        return cpfCadastrado;
    }


}
