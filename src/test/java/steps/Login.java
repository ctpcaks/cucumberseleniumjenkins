package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	// Atributos
	String url = "https://goo.gl/TbDtU7";
	WebDriver driver;

	@Given("^que o Ususario acessa o site TestLink$")
	public void que_o_Ususario_acessa_o_site_TestLink() throws Throwable {
	    System.out.println("Passo 1 - Abrir o TestLink");
	    // Inicializar
	    System.setProperty("webdriver.chrome.driver", "C:\\Iterasys\\Sabado\\chromedriver.exe");
	    driver = new ChromeDriver ();
	    
	    // Abrir o TestLink
	    driver.get(url);
	}

	@And("^preenche seu login e senha e aperta o Enter$")
	public void preenche_seu_login_e_senha_e_aperta_o_Enter() throws Throwable {
		System.out.println("Passo 2 - Fazer login");
		driver.findElement(By.id("login")).sendKeys("correia");
		driver.findElement(By.name("tl_password")).sendKeys("iterasys" + Keys.ENTER);
	}

	@Then("^exibe a pagina principal com o usuario e perfil logado$")
	public void exibe_a_pagina_principal_com_o_usuario_e_perfil_logado() throws Throwable {
		System.out.println("Passo 3 - Validar usuario e perfil");
		driver.switchTo().frame("titlebar");
		String resultadoEsperado = "correia [admin]";
		String resultadoAtual = driver.findElement(By.cssSelector("span.bold")).getText();
		assertEquals(resultadoEsperado, resultadoAtual);
		
		// Finalizar
		driver.quit();
	}

}
