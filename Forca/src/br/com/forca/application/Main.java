package br.com.forca.application;
/**
 * @author Daniel Marques
 */

import br.com.forca.logica.Metodos;
import br.com.forca.logica.Variaveis;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Variaveis var = new Variaveis();
        Metodos met = new Metodos();
        int opcao = 0;
        do {
            System.out.println("Escolha o tema: ");
            System.out.println("1 - Natureza");
            System.out.println("2 - Educação");
            System.out.println("3 - Esportes");
            System.out.println("4 - Tecnologia");
            System.out.println("5 - Cinema");
            System.out.println("9 - Finalizar");
            opcao = var.sc.nextInt();

            switch (opcao) {
                case 1:
                    met.forca(var.natureza, "NATUREZA");
                    break;
                case 2:
                    met.forca(var.educacao, "EDUCAÇÃO");
                    break;
                case 3:
                    met.forca(var.esportes, "ESPORTES");
                    break;
                case 4:
                    met.forca(var.tecnologia, "TECNOLOGIA");
                    break;
                case 5:
                    met.forca(var.cinema, "CINEMA");
                    break;
            }
        } while (opcao != 9);
    }

}
