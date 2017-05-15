package headfirst.singleton.chocolatethreadsafe;

public class ChocolateController {
    public static void main(String[] args) {
        ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        boiler1.fill();
        boiler1.boil();
        boiler1.drain();
        
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
        ChocolateBoiler boiler3 = ChocolateBoiler.getInstance();
    }
}