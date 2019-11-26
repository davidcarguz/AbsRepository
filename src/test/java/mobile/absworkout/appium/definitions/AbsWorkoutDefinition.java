package mobile.absworkout.appium.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mobile.absworkout.appium.steps.AbsWorkoutSteps;
import net.thucydides.core.annotations.Steps;

public class AbsWorkoutDefinition {

	@Steps
	AbsWorkoutSteps absWorksoutSteps;
	
	@Given("^ingreso a la aplicacion$")
	public void ingresoALaAplicacion() {
		absWorksoutSteps.iniciarAplicacion();
	}


	@When("^selecciono la rutina a iniciar$")
	public void seleccionoLaRutinaAIniciar() {
	    absWorksoutSteps.seleccionarRutina();
	}

	@Then("^valido el ingreso a la rutina$")
	public void validoElIngresoALaRutina() {
	    absWorksoutSteps.validoPresenciaDeBotonPausar();
	}
	
	@When("^ingreso a opciones de Lenguaje$")
	public void ingresoAOpcionesDeLenguaje() {
	    absWorksoutSteps.ingresarASeleccionarLenguaje();
	}


	@When("^cambio el lenguaje seleccionado$")
	public void cambioElLenguajeSeleccionado() {
	   absWorksoutSteps.cambioDeIdioma();
	}

	@Then("^valido el cambio de lenguaje$")
	public void validoElCambioDeLenguaje() {
	    absWorksoutSteps.validarCambioIdioma();
	}
}
