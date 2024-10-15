package WebSite;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebSite {

    private static WebDriver driver;

    public WebSite(WebDriver driver) {
        WebSite.driver = driver;
    }

    public void navigateToWebsite(String url) throws InterruptedException {
        driver.get(url);
        // Use WebDriverWait para espera explícita (recomendado)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));  // Espere la carga básica de la página
    }
    // Scroll
    public void scrollByPixels(double amount) throws InterruptedException {
        // Desplazar la ventana verticalmente por la cantidad especificada
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + amount + ")");
        Thread.sleep(4000);
    }
    //cerrar nodales
    public void closeModal() throws InterruptedException {
        driver.findElement(Locators.cerrarNodal).click();
        Thread.sleep(4000);
    }
    //Banner Principal
    public void visitBanner(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.bannerButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    System.out.println("Acceso Correcto");
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }

    //Acordeon
    public void Acordeon() throws InterruptedException {
        driver.findElement(Locators.IntVerBenef1).click();
        Thread.sleep(1000);
        driver.findElement(Locators.IntVerBenef2).click();
        Thread.sleep(1000);
        driver.findElement(Locators.IntVerBenef3).click();
        Thread.sleep(1000);
    }

    //PARRILLA DUO
    public void validarParrilla(String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();

        //Estructura de datos HashMap
        Map<Integer, String> urlEsperada = new HashMap<>();
        urlEsperada.put(1, "https://tienda.movistar.com.pe/solicitud/checkout/cobertura?service=93359103300FTTH&ref_origin=LC-LANDINGMAGENTO-DUO2_INTERNETTV_PARRILLA_300MBPS_HOGAR");
        urlEsperada.put(2, "https://tienda.movistar.com.pe/solicitud/checkout/cobertura?service=93359103600FTTH&ref_origin=LC-LANDINGMAGENTO-DUO2_INTERNETTV_PARRILLA_600MBPS_HOGAR");
        urlEsperada.put(3, "https://tienda.movistar.com.pe/solicitud/checkout/cobertura?service=933591031000FTTH&ref_origin=LC-LANDINGMAGENTO-DUO2_INTERNETTV_PARRILLA_1000MBPS_HOGAR");

        //Buscando el indice
        for (int i = 1; i < 4; i++) {
            driver.findElement(Locators.SubmitButton(i)).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(handlePaginaActual)) {
                    driver.switchTo().window(handle);
                    String urlActual = driver.getCurrentUrl();
                    //Validar la URL esperada
                    String urlsEsperada = urlEsperada.get(i);

                    if (urlActual.equals(urlsEsperada)) {
                        System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                        System.out.println("Acceso Correcto");
                    } else {
                        System.err.println("¡Error! La URL no coincide: " + urlActual);
                    }
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                    break; //salir del bucle
                }
            }
        }
    }

    //Canales Exclusivos
    public void CanalesExclusivos() throws InterruptedException {
        driver.findElement(Locators.CanalesButton).click();
        Thread.sleep(500);
    }

    //Validar links
    public void openTratamiento() throws InterruptedException {
        driver.findElement(Locators.terminosCheck).click();
        Thread.sleep(2000);
        driver.findElement(Locators.terminosCheck).click();
        Thread.sleep(1000);
        driver.findElement(Locators.terminosLink).click();
        Thread.sleep(2000);
    }
    public void validarPoliticas(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.terminosLink1).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handlePaginaActual)) {
                driver.switchTo().window(handle);
                String urlActual = driver.getCurrentUrl();

                if (urlActual.equals(urlEsperada)) {
                    System.out.println("URL correcta: " + urlActual + " " + nombreSeccion);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                } else {
                    System.err.println("¡Error! La URL no coincide: " + urlActual);
                    driver.close(); // Cerrar la ventana actual
                    driver.switchTo().window(handlePaginaActual); // Volver a la ventana inicial
                }
            }
        }
    }
    public void inputFormulario(String celular) {
        driver.findElement(Locators.inputCelular).click();
        driver.findElement(Locators.inputCelular).sendKeys(celular);
    }
    public void submitCanales() throws InterruptedException {
        driver.findElement(Locators.registrarButton).click();
        Thread.sleep(6000);
    }
    //validar pedidos
    public String validarPedido () {
        return driver.findElement(Locators.confirmationMessage).getText();
    }

    public void verLegales() throws  InterruptedException {
        driver.findElement(Locators.verTerminos).click();
        Thread.sleep(3000);
    }



}
