package WebSite;

import org.openqa.selenium.By;

public class Locators {
    //Definiendo Scroll
    public static final double scrollAmoun = -530;
    public static final int scrollAmount = 530; // Cantidad de píxeles a desplazar
    public static final int scroll1Amount = 220; // Cantidad de píxeles a desplazar
    public static final int scroll2Amount = 1000; // Cantidad de píxeles a desplazar

    //Banner principal
    public static final By bannerButton = By.xpath("/html/body/div[3]/section/swiper-container/swiper-slide/div/div/div[1]/div/div[1]/a");

    //Acordeon Planes
    public static final By IntVerBenef1 = By.xpath("/html/body/div[3]/section/section/div[2]/swiper-container/swiper-slide[1]/div/div[6]/div");
    public static final By IntVerBenef2 = By.xpath("/html/body/div[3]/section/section/div[2]/swiper-container/swiper-slide[2]/div/div[6]/div");
    public static final By IntVerBenef3 = By.xpath("/html/body/div[3]/section/section/div[2]/swiper-container/swiper-slide[3]/div/div[6]/div");


    //Planes De Internet
    //public static final By SubmitButton = By.xpath("/html/body/div[3]/section/section/div[2]/swiper-container/swiper-slide[1]/div/div[4]/div[4]/a");
    //Crear una variable por el índice de cada locador
    public static By SubmitButton (int i){
        return By.xpath("/html/body/div[3]/section/section/div[2]/swiper-container/swiper-slide["+ i +"]/div/div[4]/div[4]/a");
    }

    //Mini banner Exclusivos
    public static final By CanalesButton = By.xpath("/html/body/div[3]/section/div[5]/div[2]/div/button");
    public static final By inputCelular = By.xpath("/html/body/div[3]/section/div[5]/div[2]/div/form/div[2]/label/div[1]/input");
    public static final By registrarButton = By.xpath("/html/body/div[3]/section/div[5]/div[2]/div/form/div[2]/label/div[2]/div/button"); // Identificador del botón

    //Ver Politicas
    public static final By terminosCheck = By.xpath("/html/body/div[3]/section/div[5]/div[2]/div/form/div[3]/div/div[1]/input");
    public static final By terminosLink = By.xpath("/html/body/div[3]/section/div[5]/div[2]/div/form/div[3]/div/div[1]/label/span");
    public static final By terminosLink1 = By.xpath("/html/body/div[5]/div[2]/div/div/div[2]/a");

    //cerrar
    public static final By cerrarNodal = By.xpath("/html/body/div[5]/div[2]/span");
    //mensaje
    public static final By confirmationMessage = By.xpath("/html/body/div[5]/div[2]/div/div/div/h3");

    //Legales
    public static final By verTerminos = By.xpath("/html/body/div[3]/section/div/div[1]");
}
