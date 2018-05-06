import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TREEORD {

    static class No {

        int valor;
        No esquerda;
        No direita;

        public No(int valor) {
            this.valor = valor;
            esquerda = null;
            direita = null;
        }
    }

    static class Arvore {

        protected String posStr = "";
        protected static int preIndex = 0;
       
        private No contruir_Arvore(String in[], String pre[], int in_Inicio, int in_Final) {
            if (in_Inicio > in_Final) {
                return null;
            }

            int value = Integer.parseInt(pre[preIndex++]);
            No no = new No(value);

            if (in_Inicio == in_Final) {
                return no;
            }

            int inIndex = pesquisar(in, in_Inicio, in_Final, no.valor);

            no.esquerda = contruir_Arvore(in, pre, in_Inicio, inIndex - 1);
            no.direita = contruir_Arvore(in, pre, inIndex + 1, in_Final);

            return no;
        }

        
        private int pesquisar(String vetor[], int inicio, int fim, int valor) {
            int i;
            for (i = inicio; i <= fim; i++) {
                int valor_Array = Integer.parseInt(vetor[i]);
                if (valor_Array == valor) {
                    return i;
                }
            }
            return i;
        }

        private void arvore_PosOrdem(No no) {
            if (no == null) {
                return;
            }            
            arvore_PosOrdem(no.esquerda);            
            arvore_PosOrdem(no.direita);            
            posStr += no.valor + " ";
        }

        private String equalsStr() {
            return posStr;
        }

    }

    public static void main(String[] args) throws IOException {
        try {            
            Arvore arvore = new Arvore();
          
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int tamanho = Integer.parseInt(in.readLine());
          
            String pre = in.readLine();
            String preOrder[] = pre.split(" ");
            
            String pos = in.readLine();
            
            String inOr = in.readLine();
            String inOrder[] = inOr.split(" ");
            
            No raiz = arvore.contruir_Arvore(inOrder, preOrder, 0, tamanho - 1);
           
            arvore.arvore_PosOrdem(raiz);

            String pos_Arvore = arvore.equalsStr();
            
            String posStr = pos_Arvore.substring(0, pos_Arvore.length() - 1);
                        
            if (pos.equals(posStr)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
