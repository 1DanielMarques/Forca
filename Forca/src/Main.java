import java.util.*;

public class Main {

    public static String letraUsuario = "";
    public static String palavra="";
    public static List<String> natureza = new ArrayList<String>(Arrays.asList("f,a,u,n,a", "a,r,v,o,r,e", "a,n,i,m,a,l", "r,o,c,h,a", "o,c,e,a,n,o", "p,e,i,x,e", "a,v,e", "o,x,i,g,e,n,i,o", "f,o,t,o,s,s,i,n,t,e,s,e", "b,i,o,d,i,v,e,r,s,i,d,a,d,e"));
    public static List<String> educacao = new ArrayList<String>(Arrays.asList("p,r,o,f,e,s,s,o,r", "a,l,u,n,o", "m,a,t,e,r,i,a,s", "p,r,o,v,a", "t,r,a,b,a,l,h,o", "n,o,t,a", "r,e,c,u,p,e,r,a,c,a,o", "b,o,l,e,t,i,m", "d,i,r,e,t,o,r", "f,a,c,u,l,d,a,d,e"));
    public static List<String> esportes = new ArrayList<String>(Arrays.asList("b,o,l,a", "f,u,t,e,b,o,l", "e,q,u,i,p,e", "b,a,s,q,u,e,t,e", "v,o,l,e,i", "o,l,i,m,p,i,a,d,a", "t,r,e,i,n,a,d,o,r", "t,o,r,c,i,d,a", "c,o,m,p,e,t,i,c,a,o", "n,a,t,a,c,a,o"));
    public static List<String> tecnologia = new ArrayList<String>(Arrays.asList("m,o,u,s,e", "t,e,c,l,a,d,o", "c,o,m,p,u,t,a,d,o,r", "n,o,t,e,b,o,o,k", "c,e,l,u,l,a,r", "p,r,o,g,r,a,m,a,c,a,o", "j,o,g,o,s", "r,o,b,o", "i,n,t,e,r,n,e,t", "i,n,s,t,a,g,r,a,m"));
    public static List<String> cinema = new ArrayList<String>(Arrays.asList("f,i,l,m,e", "o,s,c,a,r", "s,e,r,i,e,s", "e,l,e,n,c,o", "c,o,m,e,d,i,a", "t,e,r,r,o,r", "s,u,s,p,e,n,s,e", "f,o,t,o,g,r,a,f,i,a", "m,u,s,i,c,a,l", "d,r,a,m,a"));
    public static int tamanhoPalavra = 0;

    public static String letras[];

    public static void main(String[] args) {

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
                    int contador = 0;
                    boolean verifica = false;

                    sorteiaPalavra(natureza, sorteia());
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    do {
                        System.out.print("Informe uma letra");
                        letraUsuario = sc.next();
                        verifica = false;
                        for (int i = 0; i < letras.length; i++) {
                            if (letraUsuario.equals(letras[i])) {
                                verifica = true;
                                break;
                            }
                        }
                        if (verifica) {
                            System.out.println("LETRA CERTA");
                        } else {
                            System.out.println("LETRA ERRADA");
                            contador++;
                        }

                        desenhaMatriz();
                    } while (contador <= 4);
                    break;
                case 2:
                    System.out.println(sorteiaPalavra(educacao, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    desenhaMatriz();
                    break;
                case 3:
                    System.out.println(sorteiaPalavra(esportes, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    desenhaMatriz();
                    break;
                case 4:
                    System.out.println(sorteiaPalavra(tecnologia, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    desenhaMatriz();
                    break;
                case 5:
                    System.out.println(sorteiaPalavra(cinema, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                    desenhaMatriz();
                    break;
            }
        } while (opcao != 9);
    }

    public static Integer sorteia() {
        Random gerador = new Random();
        int index = gerador.nextInt(10);
        System.out.println("Index Sorteado: " + index);
        return index;
    }

    public static String sorteiaPalavra(List tema, int index) {
        palavra = tema.get(index).toString();
        letras = palavra.split(",");
        for(int i=0;i<letras.length;i++){
            System.out.print(letras[i]);
        }
        System.out.println();
        tamanhoPalavra = letras.length;
        return tema.get(index).toString();
    }

    public static void desenhaMatriz() {
        int colunas = 16;
        System.out.println(colunas);
        String matriz[][] = new String[7][16];
        for (int linha = 0; linha < 1; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                matriz[linha][coluna] = "—";
            }
        }
        for (int linha = 5; linha < 6; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                matriz[linha][coluna] = "—";
            }
        }

        for (int linha = 1; linha < 5; linha++) {
            matriz[linha][0] = "|";
        }

        for (int linha = 1; linha < 5; linha++) {
            matriz[linha][15] = "|";
        }

        for (int linha = 1; linha < 5; linha++) {
            matriz[linha][1] = "|";
        }
        matriz[4][2] = "—";
        matriz[4][3] = "—";
        matriz[3][2] = "";
        matriz[2][2] = "";
        matriz[2][2] = "Letra:" + String.valueOf(tamanhoPalavra);
        matriz[1][2] = "";
        matriz[3][3] = " |";
        matriz[2][3] = "  ";
        matriz[1][3] = "  ";
        matriz[2][3] = "  ";
        matriz[4][4] = "";
        matriz[3][4] = "";
        matriz[2][4] = "";
        matriz[1][4] = "";

        for (int linha = 1; linha < 5; linha++) {
            for (int coluna = 4; coluna < 16; coluna++) {
                matriz[linha][coluna] = "";
            }
        }
        for (int linha = 5; linha > -1; linha--) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                System.out.print(" " + matriz[linha][coluna]);
            }
            System.out.println();
        }
    }
}