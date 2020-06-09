/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.KAsercionesUi;
import co.com.avvillaspasivos.tasks.KFormIdentificacion;
import co.com.avvillaspasivos.tasks.KNavegarA;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class KFormIdentificationSteps {
  @Dado(
      "que el {string} es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos")
  public void
      queElEsClienteActualizadoDelBancoEstaInteresadoEnAdquirirElProductoYEnPantallaSeMuestraElFormularioDeDatos(
          String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(
            KNavegarA.homePage(),
            KNavegarA.comenzarSolicitud(),
            KFormIdentificacion.validarCargaInicial());
  }

  @Cuando("ingresa los datos correctamente")
  public void ingresaLosDatosCorrectamente() {
    OnStage.theActorInTheSpotlight().attemptsTo(KFormIdentificacion.diligenciar());
  }

  @Cuando("ingresa los datos incompletos")
  public void ingresaLosDatosIncompletos() {
    OnStage.theActorInTheSpotlight().attemptsTo(KFormIdentificacion.noDiligenciar());
  }

  @Entonces("se activara el boton de continuar")
  public void seActivaraElBotonDeContinuar() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(KAsercionesUi.botonContinuarFormIdentificacionEnabled());
  }

  @Entonces("no se activara el boton de continuar y muestra mensaje de error")
  public void noSeActivaraElBotonDeContinuarYMuestraMensajeDeError() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            KAsercionesUi.botonContinuarFormIdentificacionDisabled(),
            KAsercionesUi.cantidadMsjObligatoriosFormIdentificacion());
  }

  @Dado("que el {string} esta en la pantalla del formulario de identificacion de usuario")
  public void queElEstaEnLaPantallaDelFormularioDeIdentificacionDeUsuario(String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(
            KNavegarA.homePage(),
            KNavegarA.comenzarSolicitud(),
            KFormIdentificacion.validarCargaInicial());
  }

  @Cuando("ingresa celular con cuarto numero igual a 1 o 0")
  public void ingresaCelularConCuartoNumeroIgualAO() {
    OnStage.theActorInTheSpotlight().attemptsTo(KFormIdentificacion.digitarCelularErrado());
  }

  @Entonces("genera mensaje {string}")
  public void generaMensaje(String mensaje) {
    OnStage.theActorInTheSpotlight().attemptsTo(KAsercionesUi.validarMensajeCelularErrado(mensaje));
  }

  @Dado("que los campos donde digito mi informacion son tipo texto")
  public void queLosCamposDondeDigitoMiInformacionSonTipoTexto() {
    OnStage.theActorCalled("Usuario")
        .attemptsTo(
            KNavegarA.homePage(),
            KNavegarA.comenzarSolicitud(),
            KFormIdentificacion.validarCargaInicial());
  }

  @Cuando("ingrese mas de 20 caracteres")
  public void ingreseMasDeCaracteres() {
    OnStage.theActorInTheSpotlight().attemptsTo(KFormIdentificacion.ingresarTextoFueraDelLimite());
  }

  @Entonces("no me permite ingresar mas datos")
  public void noMePermiteIngresarMasDatos() {
    OnStage.theActorInTheSpotlight().attemptsTo(KAsercionesUi.validarCantidadLimiteTexto());
  }

  @Dado("que el {string} esta digitando informacion en el campo confirmacion de telefono")
  public void queElEstaDigitandoInformacionEnElCampoConfirmacionDeTelefono(String actor) {
    OnStage.theActorCalled(actor)
        .attemptsTo(
            KNavegarA.homePage(),
            KNavegarA.comenzarSolicitud(),
            KFormIdentificacion.validarCargaInicial());
  }

  @Cuando("intente pegar la informacion \\(control V)")
  public void intentePegarLaInformacionControlV() {
    OnStage.theActorInTheSpotlight().attemptsTo(KFormIdentificacion.copiarPegarTelefono());
  }

  @Entonces("no me permitira pegar los datos")
  public void noMePermitiraPegarLosDatos() {
    OnStage.theActorInTheSpotlight().attemptsTo(KAsercionesUi.validarCantidadTextoConfirmacionCel());
  }
}
