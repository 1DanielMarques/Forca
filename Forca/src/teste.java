import java.util.Random;

public class teste {
    public static void main(String[] args) {

        String texto = "banana,maçã,laranja";

        String frutas[] = texto.split("");
        System.out.println(frutas[0]); //imprime banana
        System.out.println(frutas[1]); //imprime maçã
        System.out.println(frutas[2]); //imprime laranja[/code]

        String banana = "b,a,n,a,n,a";
        String letras[] = banana.split(",");
        for(int i =0; i<letras.length;i++){
            System.out.println(letras[i]);
        }


    }
}
