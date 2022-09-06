package br.com.forca.logica;

import java.util.Random;

public class Metodos {
    Variaveis var = new Variaveis();

    // Método que faz toda a lógica do jogo
    public void forca(String[] tema, String nomeTema) throws InterruptedException {
        for (int i = 0; i < var.letrasErradas.length; i++) {
            var.letrasErradas[i] = "";
        }
        int contador = 10;
        boolean verifica;
        int indice = 0;

        sorteiaPalavra(tema, sorteia());
        boolean criada = true;
        int linhaAux = 7;
        int colunaAux = var.tamanhoPalavra + 5;
        String matriz[][] = new String[linhaAux][colunaAux];
        do {
            if (criada) {
                System.out.println("    --" + nomeTema + "--");
                desenhaMatriz(matriz, linhaAux, colunaAux);
                criada = false;
            }
            System.out.println("Tentativas: " + contador);
            if (contador < 10) {
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < var.letrasErradas.length; i++) {
                    if (var.letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(var.letrasErradas[i] + " | ");
                }
                System.out.println();
            }
            System.out.print("Informe uma letra: ");
            var.letraUsuario = var.sc.next();
            verifica = false;
            for (int i = 0; i < var.letras.length; i++) {
                if (var.letraUsuario.equals(var.letras[i])) {
                    int aux = 4 + i;
                    matriz[2][aux] = var.letraUsuario;
                    verifica = true;
                }
            }
            if (verifica == false) {
                contador--;
                var.letrasErradas[indice] = var.letraUsuario;
                indice++;
                //System.out.println("Tentativas: " + contador);
            }
            System.out.println("\n\n");
            System.out.println("    --" + nomeTema + "--");
            matrizAtual(matriz, linhaAux, colunaAux);
            if (verificaPalavra(matriz, colunaAux)) {
                System.out.println("--PARABÉNS!--");
                System.out.println("Erros: " + (10 - contador));
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < var.letrasErradas.length; i++) {
                    if (var.letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(var.letrasErradas[i] + " | ");
                }
                System.out.println();

                Thread.sleep(4500);
                break;
            }
            if (contador == 0) {
                System.out.println("OPS! Não foi dessa vez :(");
                System.out.print("A palavra era: ");
                for (int i = 0; i < var.letras.length; i++) {
                    System.out.print(var.letras[i]);
                }
                System.out.println("\nErros: " + (10 - contador));
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < var.letrasErradas.length; i++) {
                    if (var.letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(var.letrasErradas[i] + " | ");
                }
                System.out.println();

                Thread.sleep(4500);
            }
        } while (contador > 0);
    }

    public boolean verificaPalavra(String matriz[][], int colunaAux) {
        boolean verificaPalavra = false;
        for (int coluna = 4; coluna < colunaAux; coluna++) {
            if (!matriz[2][coluna].equals(" ")) {
                verificaPalavra = true;
            } else {
                verificaPalavra = false;
                break;
            }
        }
        return verificaPalavra;
    }

    // Imprime a matriz atualizada
    public void matrizAtual(String matriz[][], int linhaAux, int colunaAux) {
        for (int linha = linhaAux - 1; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunaAux; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }

    // Sorteia index
    public Integer sorteia() {
        Random gerador = new Random();
        int index = gerador.nextInt(10);
        return index;
    }

    // Sorteia palavra de acordo com o index e o tema
    public void sorteiaPalavra(String[] tema, int index) {
        var.palavra = tema[index];
        var.letras = var.palavra.split(",");
       /* Mostra a palavra sorteada
       System.out.print("Palavra: ");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
        }
        System.out.println();*/
        var.tamanhoPalavra = var.letras.length;
    }

    public void desenhaMatriz(String matriz[][], int linhaAux, int colunaAux) {

        // Desenha "_" borda superior
        for (int linha = linhaAux - 1; linha < 7; linha++) {
            for (int coluna = 1; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = "=";
            }
        }
        // Desenha "_" borda inferior
        for (int linha = 0; linha < 1; linha++) {
            for (int coluna = 1; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = "=";
            }
        }
        // Desenha "|" borda esquerda
        for (int linha = 0; linha < linhaAux; linha++) {
            matriz[linha][0] = "│";
        }
        // Desenha "|" borda direita
        for (int linha = 6; linha > -1; linha--) {
            matriz[linha][colunaAux - 1] = "│";
        }
        // Desenha vertical forca
        for (int linha = 1; linha < linhaAux - 1; linha++) {
            matriz[linha][1] = "|";
        }
        // Desenha resto da forca
        for (int linha = 1; linha <= 5; linha++) {
            for (int coluna = 2; coluna <= 3; coluna++) {
                // Desenha ultimo X vertical forca
                if (linha == 4 && coluna == 3) {
                    matriz[linha][coluna] = "§";
                } else if (linha == 5) {
                    // Desenha 2 X horizontais forca
                    matriz[linha][coluna] = "—";
                } else {
                    // Desenha " " embaixo da forca/antes da palavra
                    matriz[linha][coluna] = " ";
                }
            }
        }
        matriz[3][3] = "O";
        // Desenha "_" das letras
        for (int i = 4; i < colunaAux - 1; i++) {
            matriz[1][i] = "_";
        }
        // Desenha " " do lugar das letras e para cima
        for (int linha = 2; linha <= 5; linha++) {
            for (int coluna = 4; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = " ";
            }
        }
        // Imprime a matriz
        for (int linha = linhaAux - 1; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunaAux; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }
}
