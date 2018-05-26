package bdd;

import cofre.ValidacaoHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidacaoHelperTestSteps {

    @When("^eu precionei destravar$")
    public void eu_precionei_destravar() throws Exception {
    }

    @Then("^eh numero$")
    public void eh_numero() throws Exception {
        assertTrue(ValidacaoHelper.ehNumero("123"));
        assertTrue(ValidacaoHelper.ehNumero("1234444"));
    }

    @Given("^entrei com o numero \"([^\"]*)\"$")
    public void entrei_com_o_numero(String arg1) throws Exception {
        eh_numero();
        nao_e_numero();
    }

    @Then("^nao e numero$")
    public void nao_e_numero() throws Exception {
        assertFalse(ValidacaoHelper.ehNumero(""));
        assertFalse(ValidacaoHelper.ehNumero("123aaaa"));
    }

    @Given("^entrei com o numero (\\d+)aaaa$")
    public void entrei_com_o_numero_aaaa(String senha) throws Exception {
        senha_valida();
    }

    @Then("^senha invalida$")
    public void senha_invalida() throws Exception {
        assertFalse(ValidacaoHelper.ehSenhaValida("123"));
        assertFalse(ValidacaoHelper.ehSenhaValida("1"));
        assertFalse(ValidacaoHelper.ehSenhaValida("12345"));
        assertFalse(ValidacaoHelper.ehSenhaValida("12345a"));
    }

    @Given("^entrei com o numero (\\d+)a$")
    public void entrei_com_o_numero_a(String senha) throws Exception {
        senha_invalida();
    }

    @Then("^senha valida$")
    public void senha_valida() throws Exception {
        assertTrue(ValidacaoHelper.ehSenhaValida("123999"));
    }
}
