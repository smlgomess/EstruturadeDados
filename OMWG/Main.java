package omwg;

/**
 *
 * @author Samuel
 */
import java.io.IOException;
import java.util.Scanner;


class Main {
     
    public static void main(String[] args) throws IOException {
        
        try {            
            Scanner scanner = new Scanner(System.in);
            
            int linha, coluna;
            
            int tentativas = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < tentativas; i++) {
                String[] linha_coluna = scanner.nextLine().split(" ");
                linha = Integer.parseInt(linha_coluna[0]);
                coluna = Integer.parseInt(linha_coluna[1]);
                System.out.println(contador_Pontos(linha, coluna));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    static int contador_Pontos(int linhas, int colunas) {
        
        int[][] M = new int[linhas + 2][colunas + 2];
        int pontos = 0;
        
        for (int i = 1; i < linhas + 1; i++) {
            for (int j = 1; j < colunas + 1; j++) {
                int esquerda = M[i][j - 1];
                int direita = M[i][j + 1];
                int cima = M[i + 1][j];
                int baixo = M[i - 1][j];
                M[i][j] = 1;
                pontos += esquerda + direita + cima + baixo;
            }
        }
        return pontos;
    }
}
