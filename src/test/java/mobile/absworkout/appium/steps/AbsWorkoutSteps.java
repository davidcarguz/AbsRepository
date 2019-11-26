package mobile.absworkout.appium.steps;

import mobile.absworkout.appium.pageObjects.AbsWorkoutPageObjects;
import net.thucydides.core.annotations.Step;

public class AbsWorkoutSteps {
	
	AbsWorkoutPageObjects absWorkoutPageObjects;
	
	@Step
	public void iniciarAplicacion() {
		absWorkoutPageObjects.iniciarApp();
	}
	
	@Step
	public void seleccionarRutina() {
		absWorkoutPageObjects.darClicBotonDificultad();
		absWorkoutPageObjects.darClicEnBotonListo();
		absWorkoutPageObjects.darClicenBotonIniciar();
		
	}
	
	@Step
	public void validoPresenciaDeBotonPausar() {
		absWorkoutPageObjects.validoBotonPausa();
		
	}

	public void ingresarASeleccionarLenguaje() {
		absWorkoutPageObjects.darClicBotonDificultad();
		absWorkoutPageObjects.darClicBotonPerfil();
		absWorkoutPageObjects.seleccionarBotonCambioLenguaje();
		
		
		
	}
	@Step
	public void cambioDeIdioma() {
		absWorkoutPageObjects.seleccionarIdiomaEspanol();
		
	}

	public void validarCambioIdioma() {
		absWorkoutPageObjects.validarBotonPreparados();
		
	}

}
