/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.KCommonWebElementsPage;
import co.com.avvillaspasivos.util.KConstantes;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class KEsperas {

  private KEsperas() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable loader() {
    return Task.where(
        "{0} espera elemento de carga",
        WaitUntil.the(KCommonWebElementsPage.LOADER, isVisible()),
        WaitUntil.the(KCommonWebElementsPage.LOADER, isNotVisible()).forNoMoreThan(KConstantes.MAX_WAIT).seconds());
  }
  public static Performable loader(int time) {
    return Task.where(
        "{0} espera elemento de carga",
        WaitUntil.the(KCommonWebElementsPage.LOADER, isVisible()),
        WaitUntil.the(KCommonWebElementsPage.LOADER, isNotVisible()).forNoMoreThan(time).seconds());
  }

  public static Performable captchaReady() {
    return Task.where(
        "{0} espera que el captcha este listo en el formulario de identificacion",
        WaitUntil.angularRequestsHaveFinished());
  }
}
