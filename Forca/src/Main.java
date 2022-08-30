import java.util.*;

public class Main {

    public static String letraUsuario = "";
    public static String letrasErradas[] = new String[10];
    public static String palavra = "";
    public static List<String> natureza = new ArrayList<String>(Arrays.asList("f,a,u,n,a", "a,r,v,o,r,e", "a,n,i,m,a,l", "r,o,c,h,a", "o,c,e,a,n,o", "p,e,i,x,e", "a,v,e", "o,x,i,g,e,n,i,o", "f,o,t,o,s,s,i,n,t,e,s,e", "b,i,o,d,i,v,e,r,s,i,d,a,d,e"));
    public static List<String> educacao = new ArrayList<String>(Arrays.asList("p,r,o,f,e,s,s,o,r", "a,l,u,n,o", "m,a,t,e,r,i,a,s", "p,r,o,v,a", "t,r,a,b,a,l,h,o", "n,o,t,a", "r,e,c,u,p,e,r,a,c,a,o", "b,o,l,e,t,i,m", "d,i,r,e,t,o,r", "f,a,c,u,l,d,a,d,e"));
    public static List<String> esportes = new ArrayList<String>(Arrays.asList("b,o,l,a", "f,u,t,e,b,o,l", "e,q,u,i,p,e", "b,a,s,q,u,e,t,e", "v,o,l,e,i", "o,l,i,m,p,i,a,d,a", "t,r,e,i,n,a,d,o,r", "t,o,r,c,i,d,a", "c,o,m,p,e,t,i,c,a,o", "n,a,t,a,c,a,o"));
    public static List<String> tecnologia = new ArrayList<String>(Arrays.asList("m,o,u,s,e", "t,e,c,l,a,d,o", "c,o,m,p,u,t,a,d,o,r", "n,o,t,e,b,o,o,k", "c,e,l,u,l,a,r", "p,r,o,g,r,a,m,a,c,a,o", "j,o,g,o,s", "r,o,b,o", "i,n,t,e,r,n,e,t", "i,n,s,t,a,g,r,a,m"));
    public static List<String> cinema = new ArrayList<String>(Arrays.asList("f,i,l,m,e", "o,s,c,a,r", "s,e,r,i,e,s", "e,l,e,n,c,o", "c,o,m,e,d,i,a", "t,e,r,r,o,r", "s,u,s,p,e,n,s,e", "f,o,t,o,g,r,a,f,i,a", "m,u,s,i,c,a,l", "d,r,a,m,a"));
    public static int tamanhoPalavra = 0;

    public static String letras[];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < letrasErradas.length; i++) {
            letrasErradas[i] = "";
        }
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        do {
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
                    int contador = 10;
                    boolean verifica;
                    int indice = 0;

                    sorteiaPalavra(natureza, sorteia());
                    boolean criada = true;
                    int linhaAux = 7;
                    int colunaAux = tamanhoPalavra + 5;
                    String matriz[][] = new String[linhaAux][colunaAux];
                    do {
                        if (criada) {
                            desenhaMatriz(matriz, linhaAux, colunaAux);
                            criada = false;
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
                            System.out.println("Tentativas: " + contador);
                        }
                        matrizAtual(matriz, linhaAux, colunaAux);
                        if (verificaPalavra(matriz, colunaAux)) {
                            System.out.println("--PARABÉNS!--");
                            System.out.println("Erros: " + (10 - contador));
                            System.out.print("Letras erradas: ");
                            for (int i = 0; i < letrasErradas.length; i++) {
                                if (letrasErradas[i].equals("")) {
                                    break;
                                }
                                System.out.print(letrasErradas[i] + " | ");

                            }
                            System.out.println();

                            Thread.sleep(4000);
                            break;
                        } //IMPLEMENTAR LOGICA SE NAO COMPLETOU A PALAVRA
                    } while (contador > 0);


                    break;
                case 2:
                    System.out.println(sorteiaPalavra(educacao, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    //desenhaMatriz();
                    break;
                case 3:
                    System.out.println(sorteiaPalavra(esportes, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    //desenhaMatriz();
                    break;
                case 4:
                    System.out.println(sorteiaPalavra(tecnologia, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    //desenhaMatriz();
                    break;
                case 5:
                    System.out.println(sorteiaPalavra(cinema, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    //desenhaMatriz();
                    break;
            }
        } while (opcao != 9);
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

    public static void matrizAtual(String matriz[][], int linhaAux, int colunaAux) {
        for (int linha = linhaAux - 1; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunaAux; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }

    public static Integer sorteia() {
        Random gerador = new Random();
        int index = gerador.nextInt(10);
        return index;
    }

    public static String sorteiaPalavra(List tema, int index) {
        palavra = tema.get(index).toString();
        letras = palavra.split(",");
        System.out.print("Palavra: ");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
        }
        System.out.println();
        tamanhoPalavra = letras.length;
        return tema.get(index).toString();
    }

    public static void desenhaMatriz(String matriz[][], int linhaAux, int colunaAux) {
        for (int linha = 0; linha < 1; linha++) {
            for (int coluna = 1; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = "-";
            }
        }
        for (int linha = linhaAux - 1; linha < 7; linha++) {
            for (int coluna = 1; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = "_";
            }
        }

        for (int linha = 0; linha < linhaAux; linha++) {
            matriz[linha][0] = "|";
        }
        for (int linha = 1; linha < linhaAux - 1; linha++) {
            matriz[linha][1] = "X";
        }
        for (int coluna = 4; coluna < colunaAux - 1; coluna++) {
            matriz[5][coluna] = " ";
        }

        matriz[5][2] = "X";
        matriz[5][3] = "X";
        matriz[3][2] = " ";
        matriz[3][3] = " ";
        matriz[1][2] = " ";
        matriz[1][3] = " ";
        matriz[2][2] = " ";
        matriz[2][3] = " ";
        matriz[4][2] = " ";
        matriz[4][3] = "X";
        for (int i = 4; i < colunaAux - 1; i++) {
            matriz[1][i] = "_";
        }
        for (int linha = 2; linha < 5; linha++) {
            for (int coluna = 4; coluna < colunaAux - 1; coluna++) {
                matriz[linha][coluna] = " ";
            }
        }
        for (int linha = 6; linha > -1; linha--) {
            matriz[linha][colunaAux - 1] = "|";
        }
        // DESENHA A MATRIZ
        for (int linha = linhaAux - 1; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunaAux; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }
}