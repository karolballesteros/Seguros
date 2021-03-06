/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.KDataProvider;
import co.com.avvillaspasivos.data.KGlobalData;
import co.com.avvillaspasivos.tasks.KEsperas;
import co.com.avvillaspasivos.tasks.KFormIdentificacion;
import co.com.avvillaspasivos.ui.*;
import co.com.avvillaspasivos.util.KConstantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;

public class Ke2eStepsDefinitions {
  @Cuando("el {string} diligencia el formulario de identificacion de usuario")
  public void elDiligenciaElFormularioDeIdentificacionDeUsuario(String actor) {
    KGlobalData.getInstance().setActorData(KDataProvider.getActorData(actor));

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            KFormIdentificacion.diligenciar(),
            Click.on(KIdentificacionPage.CONTINUAR_BUTTON),
            KEsperas.loader());
  }

  @Y("selecciona el producto {string}")
  public void seleccionaElProducto(String tipoCuenta) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            SeleccionCuenta.tipo(tipoCuenta)
            );
  }

  @Y("{string} el seguro")
  public void elSeguro(String arg0) {
    OnStage.theActorInTheSpotlight().attemptsTo(SeleccionSeguros.acepta());
  }

  @Y("se autentica mediante otp")
  public void seAutenticaMedianteOtp() {
    OnStage.theActorInTheSpotlight().attemptsTo(KEsperas.loader());
    String otp = KGlobalData.getInstance().getOtp();
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Enter.theValue(otp).into(AutenticacionPage.LIST_OTP_INPUT),
            Click.on(AutenticacionPage.CONTINUAR_BUTTON));
  }

  @Y("Selecciona el paquete con {string} retiros en cajero y {string} retiros en oficina")
  public void seleccionaElPaqueteConRetirosEnCajeroYRetirosEnOficina(
      String retiroCajero, String retiroOficina) {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              Click.on(PaqueteProPage.LISTA_CAJERO),
              Click.on(PaqueteProPage.LISTA_OPCIONES)
          );
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              Click.on(PaqueteProPage.LISTA_OFICINA),
              Click.on(PaqueteProPage.LISTA_OPCIONES)
          );

      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              Click.on(PaqueteProPage.BOTON_CONTINUAR)
          );

  }

  @Y("{string} la direccion de envio")
  public void laDireccionDeEnvio(String arg0) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(KEsperas.loader(), Click.on(DireccionPage.BOTON_CONTINUAR));
  }

  @Y("{string} que es declarante")
  public void queEsDeclarante(String arg0) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Click.on(DeclarantePage.RADIO_SI),
            Click.on(DeclarantePage.BOTON_CONTINUAR)
        );
  }


    @Y("realiza la firma electronica de documentos")
    public void realizaLaFirmaElectronicaDeDocumentos() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                KEsperas.loader(KConstantes.MAX_WAIT_GET_PDF),
                Click.on(FirmaElectronicaPage.CHECK_AUTORIZACION),
                Click.on(FirmaElectronicaPage.BOTON_CONTINUAR),
                KEsperas.loader());
    }

  @Entonces("se muestra el resumen de la creacion de la cuenta")
  public void seMuestraElResumenDeLaCreacionDeLaCuenta() {
    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(ResumenPage.BOTON_ENTENDIDO));
    OnStage.theActorInTheSpotlight().attemptsTo(Switch.toWindow("Banco AV Villas"));
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Click.on(ResumenPage.BOTON_ENTENDIDO), Switch.toWindow("Banco AV Villas"));
  }

    @Y("Selecciono que {string} es PEP")
    public void seleccionoQueEsPEP(String opcion) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                Click.on(PepPage.RADIO_NO_PEP),
                Click.on(PepPage.BOTON_CONTINUAR)
            );
    }


}

