/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.runners;

import co.com.avvillaspasivos.util.KConstantes;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "classpath:features/landing/KformularioIdentificacion.feature",
    glue = KConstantes.RUTA_STEPS_DEFINITIONS,
    tags = KConstantes.EXECUTION_TAGS,
    snippets = SnippetType.CAMELCASE)
public class KFormIdentificacionTestRunner {}
