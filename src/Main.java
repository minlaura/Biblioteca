import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    static void main(String[] args) {

        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o ano do livro: ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine();
        System.out.print("Digite o preço do livro: ");
        double preco = sc.nextDouble();
        System.out.println("Escolha o gênero: " +
                "\n 1 - ROMANCE \n 2 - TERROR \n 3 - POESIA \n 4 - DRAMA \n 5 - AVENTURA \n 6 - FANTASIA \n 7 - INFANTIL");

        int opcaoGenero = sc.nextInt();
        sc.nextLine();
        Genero genero = null;

        switch (opcaoGenero) {
            case 1:
                genero = Genero.ROMANCE;
                break;
            case 2:
                genero = Genero.TERROR;
                break;

            case 3:
                genero = Genero.POESIA;
                break;

            case 4:
                genero = Genero.DRAMA;
                break;

            case 5:
                genero = Genero.AVENTURA;
                break;

            case 6:
                genero = Genero.FANTASIA;
                break;

            case 7:
                genero = Genero.INFANTIL;
                break;



        }

        sistemaBiblioteca.cadastrarLivro(titulo, ano, autor, preco, genero);
        System.out.println("Livro cadastrado com sucesso!");
        System.out.println(sistemaBiblioteca.buscarLivro(titulo).toString());


        System.out.print("Digite o nome do cliente: ");
        String nomeDoCliente = sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        int cpfDoCliente = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o Email do cliente: ");
        String emailDoCliente = sc.nextLine();

        sistemaBiblioteca.cadastrarCliente(nomeDoCliente,cpfDoCliente,emailDoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println(sistemaBiblioteca.buscarCliente(cpfDoCliente).toString());


        System.out.print("Título do livro à alugar: ");
        String livroAAlugar = sc.nextLine();
        System.out.print("CPF do cliente: ");
        int cpfDoClienteAluguel = sc.nextInt();
        sc.nextLine();

        sistemaBiblioteca.alugarLivro(livroAAlugar,cpfDoClienteAluguel);

        System.out.println(sistemaBiblioteca.buscarLivro(livroAAlugar).toString());
        System.out.println(sistemaBiblioteca.buscarCliente(cpfDoClienteAluguel).toString());


        System.out.println("CPF do cliente para devolução: ");
        int cpfClienteDevolucao = sc.nextInt();
        sc.nextLine();
        System.out.println("Título do livro a ser devolvido: ");
        String tituloLivroDevolucao = sc.nextLine();
        sistemaBiblioteca.devolverLivro(cpfClienteDevolucao, tituloLivroDevolucao);
        System.out.println(sistemaBiblioteca.buscarLivro(tituloLivroDevolucao).toString());
        System.out.println(sistemaBiblioteca.buscarCliente(cpfClienteDevolucao).toString());


        sistemaBiblioteca.removerCliente(cpfDoCliente);
        sistemaBiblioteca.removerLivro(titulo);
        if (sistemaBiblioteca.buscarLivro(titulo) == null){
            System.out.println("Livro removido com sucesso! =)");
        } else{
            System.out.println(sistemaBiblioteca.buscarLivro(titulo).toString());
        }
        if (sistemaBiblioteca.buscarCliente(cpfDoCliente) == null){
            System.out.println("Cliente removido com sucesso!");
        }
        else {
            System.out.println(sistemaBiblioteca.buscarCliente(cpfDoCliente).toString());
        }

        sistemaBiblioteca.cadastrarLivro(titulo, ano, autor, preco, genero);
        sistemaBiblioteca.cadastrarCliente(nomeDoCliente, cpfDoCliente, emailDoCliente);

        System.out.println("Digite o ano do título do Livro que deseja procurar: ");
        int anoDoTituloLivro = sc.nextInt();
        List<Livro> listaDeLivrosPorAno = sistemaBiblioteca.buscarLivroPorAno(anoDoTituloLivro);
        System.out.println(listaDeLivrosPorAno.toString());
        sc.nextLine();


        System.out.println("Procure o título de acordo com o gênero: " +
                "\n 1 - ROMANCE \n 2 - TERROR \n 3 - POESIA \n 4 - DRAMA \n 5 - AVENTURA \n 6 - FANTASIA \n 7 - INFANTIL");

        int opcaoTituloPorGenero = sc.nextInt();
        Genero livroPorGenero = null;

        switch (opcaoTituloPorGenero){
            case 1:
                livroPorGenero = Genero.ROMANCE;
                break;

            case 2:
                livroPorGenero = Genero.TERROR;
                break;
            case 3:
                livroPorGenero = Genero.POESIA;
                break;
            case 4:
                livroPorGenero = Genero.DRAMA;
                break;
            case 5:
                livroPorGenero = Genero.AVENTURA;
                break;

            case 6:
                livroPorGenero = Genero.FANTASIA;
                break;

            case 7:
                livroPorGenero = Genero.INFANTIL;

        }
        List <Livro> listaTitulosPorGenero = sistemaBiblioteca.buscarLivrosPorGenero(livroPorGenero);
        System.out.println(listaTitulosPorGenero.toString());

    }


}
