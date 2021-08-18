package br.com.cadastro.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Screenshot {

    private static WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public static void takeSnapShot(String nomeDoArquivoImagem) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        final String directory = LocalDate.now().toString();
        String imageFileDir = System.getProperty("user.dir")+"/src/test/resources/evidences/"+directory;
        try {
            FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
