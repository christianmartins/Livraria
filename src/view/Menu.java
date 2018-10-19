package view;

import dao.DAOLivro;
import java.util.Scanner;
import model.Livro;

public class Menu {
    
    private static Scanner leitor;
        
    public static void main(String[] args) {
        leitor = new Scanner(System.in);     
        iniciarMenu();
        
    }
    
    public static void mostrarOpcoes(){
        System.out.println("----- Menu -----");
        System.out.println("1 - Inserir");
        System.out.println("2 - Consultar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Deletar");
    }
    
    public static int pegarOpcoes(){
        mostrarOpcoes();
        
        int opcao;
        do{  
            System.out.print("\nEscolha uma opção: ");
            opcao = leitor.nextInt();
            
            if(opcao > 4 || opcao < 1){
                System.out.println("Insira uma posição valida");
            }
        }while(opcao > 4 || opcao < 1);
        
        return opcao;
    }
    
    public static void iniciarMenu(){
        DAOLivro dao = new DAOLivro();
        switch(pegarOpcoes()){
            case 1: 
//                Livro livro = new Livro();
//                livro.setNome("Pudim Landy");
//                livro.setAutor("Leonardo");
//                livro.setEdicao("Piorou");
//                livro.setEditora("Não sei");
//                livro.setAnoPublicacao(2000);
//                
//               
//                dao.inserir(livro);
                
                
                
                
                break;
            case 2:
                System.out.println("Consulta");
                System.out.println("Codigo\tNome\t\tAutor\t\t");
                for(Livro l : DAOLivro.listar()){
                    System.out.print(l.getCodigo() + "\t");
                    System.out.print(l.getNome() + "\t");
                    System.out.println(l.getAutor() + "\t");
                }
                
                break;
            case 3: 
                System.out.println("Altera");
                break;
            case 4: 
                System.out.println("Deleta");
                break;
        }
    }
    
    
    
    
}
