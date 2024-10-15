import WebSite.Locators;
import SetUp.SetUp;
import WebSite.WebSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcuteTest {

    private static WebDriver driver;
    private static WebSite webSite;

    public static void main(String[] args) throws InterruptedException {
        driver = SetUp.getDriver();
        webSite = new WebSite(driver);

        // Variables Standaroup
        String url = "https://tiendaonline.movistar.com.pe/ofertas/servicioshogar/magento-duo2";
        String celular = "999999999";

        webSite.navigateToWebsite(url);
        webSite.scrollByPixels(Locators.scrollAmoun);
        //Banner Principal
        webSite.visitBanner("https://tienda.movistar.com.pe/solicitud/checkout/cobertura?service=93359103300FTTH&ref_origin=LC-LANDINGMAGENTO-DUO2_INTERNETTV_BANNER1_300MBPS_HOGAR", "TIENDA MOVISTAR DÚO TV 99.9");
        webSite.scrollByPixels(Locators.scrollAmount);
        webSite.scrollByPixels(Locators.scrollAmount);

        //Parrilla de Planes
        webSite.Acordeon();
        webSite.scrollByPixels(Locators.scrollAmoun);
        webSite.validarParrilla("TIENDA MOVISTAR DÚO");
        webSite.Acordeon();
        webSite.scrollByPixels(Locators.scroll2Amount);
        webSite.scrollByPixels(Locators.scrollAmount);

        //Canales Exclusivos - NO HABILITADO
//        webSite.CanalesExclusivos();
//        webSite.openTratamiento();
//        webSite.validarPoliticas("https://centrodetransparencia.movistar.com.pe/politica-local-privacidad", "CANALES EXCLUSIVOS");
//        webSite.closeModal();
//        webSite.inputFormulario(celular);
//        webSite.submitCanales();
//        String mensajeInternet = webSite.validarPedido();
//        if (mensajeInternet.equals("¡Gracias por contactarnos!")) {
//            System.out.println("Prueba exitosa: Se verificó el mensaje de confirmación INTERNET FIBRA");
//        } else {
//            System.out.println("Prueba fallida: El mensaje de confirmación no es el esperado");
//        }
//        webSite.closeModal();

        //Términos y condiciones
        webSite.verLegales();
        webSite.scrollByPixels(Locators.scroll1Amount);
        webSite.scrollByPixels(Locators.scrollAmoun);
        webSite.verLegales();

        SetUp.closeDriver();
    }
}
