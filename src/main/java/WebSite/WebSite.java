package WebSite;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void scrollByPixels(int amount) throws InterruptedException {
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
    //Parrilla
    public void validarParrilla(String urlEsperada, String nombreSeccion) throws InterruptedException {
        String handlePaginaActual = driver.getWindowHandle();
        driver.findElement(Locators.SubmitButton).click();

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
