import java.util.*;

public class Main {
    public static String natureza[] = {"f,a,u,n,a", "a,r,v,o,r,e", "a,n,i,m,a,l", "r,o,c,h,a", "o,c,e,a,n,o", "p,e,i,x,e", "a,v,e", "o,x,i,g,e,n,i,o", "f,o,t,o,s,s,i,n,t,e,s,e", "b,i,o,d,i,v,e,r,s,i,d,a,d,e"};
    public static String educacao[] = {"p,r,o,f,e,s,s,o,r", "a,l,u,n,o", "m,a,t,e,r,i,a,s", "p,r,o,v,a", "t,r,a,b,a,l,h,o", "n,o,t,a", "r,e,c,u,p,e,r,a,c,a,o", "b,o,l,e,t,i,m", "d,i,r,e,t,o,r", "f,a,c,u,l,d,a,d,e"};
    public static String esportes[] = {"b,o,l,a", "f,u,t,e,b,o,l", "e,q,u,i,p,e", "b,a,s,q,u,e,t,e", "v,o,l,e,i", "o,l,i,m,p,i,a,d,a", "t,r,e,i,n,a,d,o,r", "t,o,r,c,i,d,a", "c,o,m,p,e,t,i,c,a,o", "n,a,t,a,c,a,o"};
    public static String tecnologia[] = {"m,o,u,s,e", "t,e,c,l,a,d,o", "c,o,m,p,u,t,a,d,o,r", "n,o,t,e,b,o,o,k", "c,e,l,u,l,a,r", "p,r,o,g,r,a,m,a,c,a,o", "j,o,g,o,s", "r,o,b,o", "i,n,t,e,r,n,e,t", "i,n,s,t,a,g,r,a,m"};
    public static String cinema[] = {"f,i,l,m,e", "o,s,c,a,r", "s,e,r,i,e,s", "e,l,e,n,c,o", "c,o,m,e,d,i,a", "t,e,r,r,o,r", "s,u,s,p,e,n,s,e", "f,o,t,o,g,r,a,f,i,a", "m,u,s,i,c,a,l", "d,r,a,m,a"};

    public static String letraUsuario = "";
    public static String letrasErradas[] = new String[10];
    public static String palavra = "";
    public static int tamanhoPalavra = 0;
    public static String letras[];
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        int opcao = 0;
        do {
            for (int i = 0; i < letrasErradas.length; i++) {
                letrasErradas[i] = "";
            }
            System.out.println("Escolha o tema: ");
            System.out.println("1 - Natureza");
            System.out.println("2 - Educação");
            System.out.println("3 - Esportes");
            System.out.println("4 - Tecnologia");
            System.out.println("5 - Cinema");
            System.out.println("9 - Finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    forca(natureza,"NATUREZA");
                    break;
                case 2:
                    forca(educacao,"EDUCAÇÃO");
                    break;
                case 3:
                    forca(esportes,"ESPORTES");
                    break;
                case 4:
                    forca(tecnologia,"TECNOLOGIA");
                    break;
                case 5:
                    forca(cinema,"CINEMA");
                    break;
            }
        } while (opcao != 9);
    }

    // Método que faz toda a lógica do jogo
    public static void forca(String[] tema,String nomeTema) throws InterruptedException {
        int contador = 10;
        boolean verifica;
        int indice = 0;

        sorteiaPalavra(tema, sorteia());
        boolean criada = true;
        int linhaAux = 7;
        int colunaAux = tamanhoPalavra + 5;
        String matriz[][] = new String[linhaAux][colunaAux];
        do {
            if (criada) {
                System.out.println("    --"+nomeTema+"--");
                desenhaMatriz(matriz, linhaAux, colunaAux);
                criada = false;
            }
            System.out.println("Tentativas: " + contador);
            if (contador < 10) {
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < letrasErradas.length; i++) {
                    if (letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(letrasErradas[i] + " | ");
                }
                System.out.println();
            }
            System.out.print("Informe uma letra: ");
            letraUsuario = sc.next();
            verifica = false;
            for (int i = 0; i < letras.length; i++) {
                if (letraUsuario.equals(letras[i])) {
                    int aux = 4 + i;
                    matriz[2][aux] = letraUsuario;
                    verifica = true;
                }
            }
            if (verifica == false) {
                contador--;
                letrasErradas[indice] = letraUsuario;
                indice++;
                //System.out.println("Tentativas: " + contador);
            }
            System.out.println("\n\n");
            System.out.println("    --"+nomeTema+"--");
            matrizAtual(matriz, linhaAux, colunaAux);
            if (verificaPalavra(matriz, colunaAux)) {
                System.out.println("--PARABÉNS!--");
                System.out.println("Erros: " + (10 - contador));
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < letrasErradas.length; i++) {
                    if (letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(letrasErradas[i] + " | ");
                }
                System.out.println();

                Thread.sleep(4500);
                break;
            }
            if (contador == 0) {
                System.out.println("OPS! Não foi dessa vez :(");
                System.out.print("A palavra era: ");
                for (int i = 0; i < letras.length; i++) {
                    System.out.print(letras[i]);
                }
                System.out.println("\nErros: " + (10 - contador));
                System.out.print("Letras erradas: | ");
                for (int i = 0; i < letrasErradas.length; i++) {
                    if (letrasErradas[i].equals("")) {
                        break;
                    }
                    System.out.print(letrasErradas[i] + " | ");
                }
                System.out.println();

                Thread.sleep(4500);
            }
        } while (contador > 0);
    }
    public static boolean verificaPalavra(String matriz[][], int colunaAux) {
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
    public static void matrizAtual(String matriz[][], int linhaAux, int colunaAux) {
        for (int linha = linhaAux - 1; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunaAux; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }
    // Sorteia index
    public static Integer sorteia() {
        Random gerador = new Random();
        int index = gerador.nextInt(10);
        return index;
    }
    // Sorteia palavra de acordo com o index e o tema
    public static void sorteiaPalavra(String[] tema, int index) {
        palavra = tema[index];
        letras = palavra.split(",");
       /* Mostra a palavra sorteada
       System.out.print("Palavra: ");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
        }
        System.out.println();*/
        tamanhoPalavra = letras.length;
    }
    public static void desenhaMatriz(String matriz[][], int linhaAux, int colunaAux) {

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