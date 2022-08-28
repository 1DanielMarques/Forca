import java.util.*;

/* Natureza:
        Fauna | Arvore | Animal | Rocha | Oceano | Peixe | Ave | Oxigenio | Fotossintese | Biodiversidade
       Educacao:
        Professor | Aluno | Materias | Prova | Trabalho | Nota | Recuperacao | Boletim | Diretor | Faculdade
       Esportes:
        Bola | Futebol | Equipe | Basquete | Volei | Olimpiada | Treinador | Torcida | Competicao | Natacao
       Tecnologia:
        Mouse | Teclado | Computador | Notebook | Celular | Programacao | Jogos | Robo | Internet | Instagram
       Cinema:
        Filme | Oscar | Series | Elenco | Comedia | Terror | Suspense | Fotografia | Musical | Drama
     */
public class Main {

    public static List<String> natureza = new ArrayList<String>(Arrays.asList("Fauna", "Arvore", "Animal", "Rocha", "Oceano", "Peixe", "Ave", "Oxigenio", "Fotossintese", "Biodiversidade"));
    public static List<String> educacao = new ArrayList<String>(Arrays.asList("Professor", "Aluno", "Materias", "Prova", "Trabalho", "Nota", "Recuperacao", "Boletim", "Diretor", "Faculdade"));
    public static List<String> esportes = new ArrayList<String>(Arrays.asList("Bola", "Futebol", "Equipe", "Basquete", "Volei", "Olimpiada", "Treinador", "Torcida", "Competicao", "Natacao"));
    public static List<String> tecnologia = new ArrayList<String>(Arrays.asList("Mouse", "Teclado", "Computador", "Notebook", "Celular", "Programacao", "Jogos", "Robo", "Internet", "Instagram"));
    public static List<String> cinema = new ArrayList<String>(Arrays.asList("Filme", "Oscar", "Series", "Elenco", "Comedia", "Terror", "Suspense", "Fotografia", "Musical", "Drama"));
    public static int tamanhoPalavra = 0;


    public static void main(String[] args) {
        //toLowCase natureza.get(0).toLowerCase();
        Scanner sc = new Scanner(System.in);
        String matriz[][] = new String[6][4];


        int opcao = 0;
        do {
            System.out.println("---FORCA---");
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
                    System.out.println(sorteiaPalavra(natureza, sorteia()));
                    System.out.println("Tamanho palavra: " + tamanhoPalavra);
                   // desenhaMatriz();

                    break;
                case 2:
                    sorteia();
                    break;
                case 3:
                    sorteia();
                    break;
                case 4:
                    sorteia();
                    break;
                case 5:
                    sorteia();
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
        tamanhoPalavra = tema.get(index).toString().length();
        return tema.get(index).toString();
    }

    public static void desenhaMatriz() {
        int colunas = 4 + tamanhoPalavra;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= colunas; j++) {
                // matriz[i][j];
                System.out.println("-");




            }

        }


    }


}
