#Author: your.email@your.domain.com
@casos
Feature: Casos de prueba para aplciacion de Abdominales en 30 dias

  @caso1
  Scenario: iniciar una rutina en la aplicacion
    Given ingreso a la aplicacion
    When selecciono la rutina a iniciar
    Then valido el ingreso a la rutina

	@caso2
  Scenario: iniciar una rutina en la aplicacion
    Given ingreso a la aplicacion
    When ingreso a opciones de Lenguaje
    And cambio el lenguaje seleccionado
    Then valido el cambio de lenguaje