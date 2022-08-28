import java.util.Random;

public class teste {
    public static void main(String[] args) {
        Random gerador = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(gerador.nextInt(10));
        }
    }
}
