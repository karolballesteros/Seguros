/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.data.KGlobalData;
import co.com.avvillaspasivos.model.KActorData;
import co.com.avvillaspasivos.ui.KIdentificacionPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;

import static co.com.avvillaspasivos.util.KConstantes.TEXTO_SUPERIOR_LIMITE_TAMANIO;

public class KFormIdentificacion {

    private KFormIdentificacion() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable diligenciar() {
      KActorData actorData = KGlobalData.getInstance().getActorData();
      return Task.where(
        "{0} diligencia formulario",
        Enter.theValue(actorData.getDocumentNumber()).into(KIdentificacionPage.DNI_INPUT),
        Enter.theValue(actorData.getPhone()).into(KIdentificacionPage.CELULAR_INPUT).thenHit(Keys.TAB),
        Enter.theValue(actorData.getPhone()).into(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue(actorData.getFirstName()).into(KIdentificacionPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(actorData.getLastName()).into(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue(actorData.getSalary()).into(KIdentificacionPage.INGRESOS_INPUT),
        Click.on(KIdentificacionPage.HABEAS_DATA_CHECKBOX));
  }


  public static Performable digitarCelularErrado() {
    return Task.where(
        "{0} diligencia formulario",
        Enter.theValue("31601234567").into(KIdentificacionPage.CELULAR_INPUT).thenHit(Keys.TAB));
  }

  public static Performable noDiligenciar() {
    return Task.where(
        "{0}  no diligencia formulario",
        Click.on(KIdentificacionPage.DNI_INPUT),
        Click.on(KIdentificacionPage.CELULAR_INPUT),
        Click.on(KIdentificacionPage.PRIMER_NOMBRE_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.DNI_INPUT));
  }

  public static Performable simularRobot() {
    return Task.where(
        "{0} simulña comportamiento sospechoso tipo robot ",
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.PRIMER_APELLIDO_INPUT),
        Click.on(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT),
        Click.on(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT));
  }

  public static Performable validarCargaInicial() {
    return Task.where(
        "{0} valida carga de pagina identificacion",
        Ensure.that(KIdentificacionPage.CONTINUAR_BUTTON).isDisabled(),
        Ensure.that(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT).isDisabled());
  }

  public static Performable ingresarTextoFueraDelLimite() {
    return Task.where(
        "{0} diligencia campos de texto con mas de 20 caracteres",
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO).into(KIdentificacionPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO)
            .into(KIdentificacionPage.PRIMER_APELLIDO_INPUT));
  }

  public static Performable copiarPegarTelefono() {
    return Task.where(
        "{0} diligencia campo de telefono , se copia y se pega en confirmacion de telefono",
        Enter.theValue("3167998941").into(KIdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "a").into(KIdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "c").into(KIdentificacionPage.DNI_INPUT),
        Enter.keyValues(Keys.COMMAND + "v").into(KIdentificacionPage.CELULAR_INPUT),
        Enter.keyValues(Keys.COMMAND + "v").into(KIdentificacionPage.CELULAR_CONFIRMACION_INPUT));
  }
}
