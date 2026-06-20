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
        Genero genero = sistemaBiblioteca.escolherGeneroLivro(opcaoGenero);

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


        System.out.print("CPF do cliente para devolução do livro: ");
        int cpfClienteDevolucao = sc.nextInt();
        sc.nextLine();
        System.out.print("Título do livro a ser devolvido: ");
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
        sc.nextLine();
        Genero livroPorGenero = sistemaBiblioteca.escolherGeneroLivro(opcaoTituloPorGenero);

        List <Livro> listaTitulosPorGenero = sistemaBiblioteca.buscarLivrosPorGenero(livroPorGenero);

        System.out.println(listaTitulosPorGenero.toString());


        System.out.print("Digite o título para a modificação de preço: ");
        String tituloPrecoAtualizado = sc.nextLine();
        System.out.print("Qual será o novo preço do Livro?");
        double precoAtualizadoLivro = sc.nextDouble();
        sistemaBiblioteca.atualizarPrecoDoLivro(tituloPrecoAtualizado, precoAtualizadoLivro);
        System.out.println(sistemaBiblioteca.buscarLivro(tituloPrecoAtualizado).toString());


        System.out.print("Cpf do cliente para a atualização do e-mail: ");
        int cpfParaAlteracaoEmail = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o novo E-mail: ");
        String emailAlteracao = sc.nextLine();
        sistemaBiblioteca.atualizarDadosCliente(cpfParaAlteracaoEmail, emailAlteracao);

        System.out.println(sistemaBiblioteca.buscarCliente(cpfParaAlteracaoEmail).toString());


        System.out.println();


        System.out.print("Digite o título para modificar o gênero: ");
        String tituloGeneroParaModificar = sc.nextLine();
        System.out.println("Atualize o gênero do Livro: " +
                "\n 1 - ROMANCE \n 2 - TERROR \n 3 - POESIA \n 4 - DRAMA \n 5 - AVENTURA \n 6 - FANTASIA \n 7 - INFANTIL");

        int opcaoGeneroModificar = sc.nextInt();
        sc.nextLine();
        Genero generoModificado = sistemaBiblioteca.escolherGeneroLivro(opcaoGeneroModificar);
        sistemaBiblioteca.mudarGeneroDeLivro(generoModificado, tituloGeneroParaModificar);



        System.out.println(sistemaBiblioteca.buscarLivro(tituloGeneroParaModificar).toString());



        System.out.print("Digite o cpf para consultar fatura: ");
        int cpfParaConsultar = sc.nextInt();
        double faturaConsultaCliente = sistemaBiblioteca.verificarDividas(cpfParaConsultar);

        System.out.println("O valor pendente para pagamento é: " + faturaConsultaCliente);



    }


}
