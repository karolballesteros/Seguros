/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.KIdentificacionPage;
import co.com.avvillaspasivos.util.KConstantes;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class KAsercionesUi {

  private KAsercionesUi() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validarBotonContinuarLanding() {
    return Task.where(
        "{0} valida boton continuar landing",
        WaitUntil.the(KIdentificacionPage.CONTINUAR_BUTTON, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(KConstantes.PATH_FORM_IDENTIFICACION));
  }

  public static Performable botonContinuarFormIdentificacionEnabled() {
    return Task.where(
        "{0} valida boton continuar landing habilitado",
        Ensure.that(KIdentificacionPage.CONTINUAR_BUTTON).isEnabled());
  }

  public static Performable botonContinuarFormIdentificacionDisabled() {
    return Task.where(
        "{0} valida boton continuar landing deshabilitado",
        Ensure.that(KIdentificacionPage.CONTINUAR_BUTTON).isDisabled());
  }

  public static Performable cantidadMsjObligatoriosFormIdentificacion() {
    return Task.where(
        "{0} valida mensajes de error en formulario identificacion",
        Ensure.that(KIdentificacionPage.MSJ_CAMPOS_OBLIG).values().hasSize(4));
  }

  public static Performable validarMensajeCelularErrado(String mensaje) {
    return Task.where(
        "{0} valida mensajes de error por celular errado",
        Ensure.that(KIdentificacionPage.MSJ_CAMPOS_OBLIG).text().contains(mensaje));
  }

  public static Performable validatePopUpHabeasData() {
    return Task.where(
        "{0} valida presencia de popup habeas data",
        Ensure.that(KIdentificacionPage.VER_MAS_HABEAS_DATA_POPUP).isDisplayed());
  }

  public static Performable validaFormularioIdentificacionHabilitado() {
    return Task.where(
        "{0} valida que no este presente el popup de habeas data",
        Ensure.that(KIdentificacionPage.VER_MAS_HABEAS_DATA_POPUP).isNotDisplayed());
  }

  public static Performable validarCantidadLimiteTexto() {
    return Task.where(
        "{0} valida que no se supere el limite de texto en campos de texto",
        Ensure.that(KIdentificacionPage.PRIMER_NOMBRE_INPUT).value().hasSize(20),
        Ensure.that(KIdentificacionPage.PRIMER_APELLIDO_INPUT).value().hasSize(20));
  }

  public static Performable validarCantidadTextoConfirmacionCel() {
    return Task.where(
        "{0} valida que no exista informacion despues de pegar sobre el campo confirmacion celular",
        Ensure.that(KIdentificacionPage.PRIMER_NOMBRE_INPUT).value().hasSize(0));
  }
}
