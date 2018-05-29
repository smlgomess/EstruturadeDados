package hashit;

import java.util.Scanner;

/**
 *
 * @author Samuel
 */
public class Main {

    static class  Hash_List{
        private String[] key;
        private int tam = 0;
        
        public Hash_List(){
            key = new String[101];
            
            for(int m=0; m<101; m++){
                key[m] = "";                
            }
        }
        
        public int get_tamanho (){
            return tam;
        }
        
        public String get_key(int pos){
            return key[pos];
        }
                
        public int insert(String chave){
            int pos = Hash(chave); 
            int aux = pos;
            int j=0;            
            
            for(j=0; j<20;){                
               
               if(key[aux].equals(chave)){
                   return 0;
               }               
             
               else{
                   j++;
                   aux = (Hash(chave)+(j*j)+(23*j))%101;                   
               }
            } 
            
            
            for(j=0; j<20;){              
               if(key[pos].equals("") || key[pos].equals("empty")){
                   key[pos] = chave;
                   tam++;
                   return 1;               
               }
               else{
                   j++;
                   pos = (Hash(chave)+(j*j)+(23*j))%101;                   
               }
            } 
            
            return 0;
        }
        
        public void remove(String chave){
            int pos = search(chave);
            
            if(pos!= -1){
                key[pos] = "empty";
                tam --;
            }  
        }
        
        public int search(String chave){
            int pos = Hash(chave); 
            int j=0;
            
            for(j=0; j<20;){
               if(key[pos].equals(chave)){
                   return pos;
               }               
               else{
                   j++;
                   pos = (Hash(chave)+(j*j)+(23*j))%101;                   
               }
            }
            
            return -1;
        }
        
        public int Hash(String chave){
            char array[] = chave.toCharArray();
            int h_key=0;
            int soma=0;
                        
            for(int i=0; i < chave.length(); i++){
                soma = soma + (((int)array[i]) * (i+1));
            }
            h_key = 19*soma;
            
            return h_key%101;
        }
    }
    
        
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        int t = 0, n1=0;
        int l=0,k=0;
        String opt;
        
        t = scanner.nextInt();
        
        Hash_List casos[] = new Hash_List[t];
        
        while(l<t){
            casos[l] = new Hash_List();
            
            n1 = scanner.nextInt();
        
            scanner.nextLine();
            for(k=0;k<n1;k++){
                opt = scanner.nextLine();
                
                if(opt.startsWith("ADD")){
                    casos[l].insert(opt.substring(4));
                }
                
                if(opt.startsWith("DEL")){
                    casos[l].remove(opt.substring(4));
                }               
            }
            
            System.out.println(casos[l].get_tamanho());
            
            for(k=0; k<101; k++){
                if(!(casos[l].get_key(k).equals("")) && !(casos[l].get_key(k).equals("empty")) ){
                    System.out.println(k + ":" + casos[l].get_key(k));
                }
            }
           
            l++;
        }       
       
    }
    
}
