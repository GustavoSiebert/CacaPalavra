import java.util.Scanner;

public class Main {
    public Main() {

        Scanner sc = new Scanner(System.in);

        String[][] palavras = new String[5][2];
        char[][] mapa = new char[10][5];

        Boolean continuar = true;

        PalavrasEncontradas(palavras);
        MapaEntrada(mapa);

        do{
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            int opt = sc.nextInt();
            switch(opt)
            {
                case 1: 
                PalavrasImprimir(palavras);
                break;
                case 2: 
                MapaImprimir(mapa);
                break;
                case 3: 
                MapaPesquisa(palavras,mapa);
                break;
                case 4:
                continuar = false;
                break;
                default:
                System.out.println("Pfv digita algo valido ;-;");
                break;
            }
        }while(continuar);

        

    }
    public void PalavrasEncontradas(String[][] palavras)
    {
        palavras[0][0] = "IFELSE";  
        palavras[1][0] = "FORA";  
        palavras[2][0] = "WHILE";  
        palavras[3][0] = "OBJETO";  
        palavras[4][0] = "VETOR";  
    }
    public void PalavrasImprimir(String[][] palavras)
    {
        for(int i = 0; i < palavras.length; i++)
        {
            System.out.println(palavras[i][0]);
        }
        
    }
    public void MapaImprimir(char[][] mapa)
    { 
        System.out.println("---------------------");
        for(int i = 0; i < 10; i++)
        {
            
            for(int ii = 0; ii < 5; ii++)
            {
                if(ii == 0)
                {
                    System.out.print("| ");
                    System.out.print(mapa[i][ii]);
                    System.out.print(" | ");
                }
                else
                {
                    System.out.print(mapa[i][ii]);
                    System.out.print(" | ");
                }      
            }
            System.out.println("\n---------------------");
        }        
    }
    public void MapaEntrada(char[][]mapa)
    {
        mapa[ 0][ 0]='D';  mapa[ 0][ 1]='C';  mapa[ 0][ 2]='Q';  mapa[ 0][ 3]='W';  mapa[ 0][ 4]='E';
        mapa[ 1][ 0]='I';  mapa[ 1][ 1]='X';  mapa[ 1][ 2]='F';  mapa[ 1][ 3]='O';  mapa[ 1][ 4]='R';
        mapa[ 2][ 0]='F';  mapa[ 2][ 1]='F';  mapa[ 2][ 2]='R';  mapa[ 2][ 3]='G';  mapa[ 2][ 4]='F';
        mapa[ 3][ 0]='E';  mapa[ 3][ 1]='L';  mapa[ 3][ 2]='I';  mapa[ 3][ 3]='H';  mapa[ 3][ 4]='W';
        mapa[ 4][ 0]='L';  mapa[ 4][ 1]='S';  mapa[ 4][ 2]='F';  mapa[ 4][ 3]='O';  mapa[ 4][ 4]='U';
        mapa[ 5][ 0]='S';  mapa[ 5][ 1]='D';  mapa[ 5][ 2]='G';  mapa[ 5][ 3]='T';  mapa[ 5][ 4]='S';
        mapa[ 6][ 0]='E';  mapa[ 6][ 1]='J';  mapa[ 6][ 2]='H';  mapa[ 6][ 3]='E';  mapa[ 6][ 4]='T';
        mapa[ 7][ 0]='I';  mapa[ 7][ 1]='I';  mapa[ 7][ 2]='I';  mapa[ 7][ 3]='J';  mapa[ 7][ 4]='M';
        mapa[ 8][ 0]='X';  mapa[ 8][ 1]='C';  mapa[ 8][ 2]='K';  mapa[ 8][ 3]='B';  mapa[ 8][ 4]='G';
        mapa[ 9][ 0]='V';  mapa[ 9][ 1]='E';  mapa[ 9][ 2]='T';  mapa[ 9][ 3]='O';  mapa[ 9][ 4]='R';
    }
    public void MapaPesquisa(String [][]palavras,char[][]mapa) 
    {
        for(int indicePalavra = 0; indicePalavra < 5; indicePalavra++)
        {
            int resposta = 1;
            char[] palavraSerDescoberta = palavras[indicePalavra][0].toCharArray();
            for(int vert = 0; vert<10; vert++)
            {
                char[] linhaHorizontal = new char[5];
                for(int hori = 0; hori < 5; hori++)
                {
                    linhaHorizontal[hori] = mapa[vert][hori];
                }
                
                int result = Comparar(palavraSerDescoberta, linhaHorizontal);
                if(result != 1000)
                {
                    palavras[indicePalavra][resposta] = "["+result+"]"+"["+vert+"]"+" - " + palavras[indicePalavra][0];
                    break;
                }
            }
        }
        Printar(palavras);
    }
    private void Printar(String[][]palavras)
    {
        for (int i = 0; i < palavras.length; i++) {
            if(palavras[i][1] != null)
            System.out.println(palavras[i][1]);
        }
    }
    private int Comparar(char[] palavraSerDescoberta, char[]linha)
    {
        int indice = 0;
        int valorInicial = 0;
        for(int i = 0; i < linha.length; i++)
        {
            if(palavraSerDescoberta[indice] == linha[i])
            {
                valorInicial = i;
                indice++;
            }
            else
            {
                valorInicial = 1000;
                indice = 0;
            }
         
        }
        if(valorInicial == 5)
        {
            return valorInicial;
        }
        else
        {
            return valorInicial;
        }
    }
    public static void main(String[] args) throws Exception {
        new Main();
    }
}
