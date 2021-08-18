package br.com.cadastro.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/"
        ,glue={"br.com.webmotors.step_definitions"}
)

public class Runner {
    public static void main(String[] args){
        {io.cucumber.core.cli.Main.main(args);}
    }
}
