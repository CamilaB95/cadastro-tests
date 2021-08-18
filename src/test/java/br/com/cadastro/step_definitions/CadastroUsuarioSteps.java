package br.com.cadastro.step_definitions;

import br.com.cadastro.pages.CadastroUsuarioPage;
import br.com.cadastro.pages.TelaInicialPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class CadastroUsuarioSteps {

    private DriverFactory driverFactory = new DriverFactory();
    private TelaInicialPage telaInicialPage;
    private CadastroUsuarioPage cadastroUsuarioPage;
    private String cpfCadastrado = "62098280009";
    private String senhaCadastrada = "iPhone#08";

    @Before
    public void setUp() throws Exception {
    }

    @Dado("que estou na tela inicial da pagina")
    public void que_estou_na_tela_inicial_da_pagina() {
        telaInicialPage = new TelaInicialPage(driverFactory.driver);
        telaInicialPage.acessarTelaInicial();
    }

    @Quando("acesso a tela de cadastro do usuário")
    public void acesso_a_tela_de_cadastro_do_usuário() {
        cadastroUsuarioPage = new CadastroUsuarioPage(driverFactory.driver);
        cadastroUsuarioPage.acessaTelaCadastro();
    }

    @Quando("realizo o cadastro do usuário")
    public void realizo_o_cadastro_do_usuário() {
        cpfCadastrado = cadastroUsuarioPage.cadastraUsuario(cpfCadastrado,senhaCadastrada);
    }

    @Então("devo conseguir logar com usuário cadastrado")
    public void devo_conseguir_logar_com_usuário_cadastrado() {
        telaInicialPage.acessarTelaInicial();
        Assert.assertTrue("Erro ao logar!",
                telaInicialPage.LogarUsuario(cpfCadastrado, senhaCadastrada));
    }

    @After
    public void afterClass() throws Exception {
    }
}
