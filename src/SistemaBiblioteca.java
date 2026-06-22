import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {

    private List<Livro> listaDeLivros = new ArrayList<>();
    private List<Cliente> listaDeClientes = new ArrayList<>();

    private int ultimoId = 0;

    public int gerarId () {
        int novoId = ultimoId + 1;
        ultimoId = novoId;
        return novoId;
    }

    public void cadastrarLivro(String titulo, int ano, String autor, double preco, Genero genero) {

        int id = gerarId();
        Livro livroCadastrado = new Livro(titulo, ano, autor, preco, genero, id);

        listaDeLivros.add(livroCadastrado);
    }




    public Livro buscarLivro(String titulo){
        Livro livroEncontrado = null;
        for (Livro livro : listaDeLivros){
            if (titulo.equals(livro.getTitulo())){
                livroEncontrado = livro;
            }
        }
        return livroEncontrado;
    }
    public void atualizarPrecoDoLivro (String titulo, double preco){
      Livro livroAAtualizar = buscarLivro(titulo);
      livroAAtualizar.setPreco(preco);
    }

    public void removerLivro (String titulo){
        Livro livroARemover = buscarLivro(titulo);
        listaDeLivros.remove(livroARemover);
    }

    public void cadastrarCliente (String nome, int cpf, String email) {
        Cliente clienteCadastrado = new Cliente(nome, cpf, email);
        listaDeClientes.add(clienteCadastrado);

    }

    public Cliente buscarCliente (int cpf){

        Cliente clienteEncontrado = null;

        for (Cliente cliente : listaDeClientes){
            if (cpf == cliente.getCpf()) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    public void atualizarDadosCliente (int cpf, String email){
        Cliente atualizarCliente = buscarCliente(cpf);
        if (atualizarCliente != null) {
            atualizarCliente.setEmail(email);
        } else {
            System.out.println("CPF do cliente não encontrado no Sistema");
        }
    }

    public void removerCliente (int cpf){
        Cliente clienteARemover = buscarCliente(cpf);
        if (clienteARemover != null){
            listaDeClientes.remove(clienteARemover);
        }
        else {
            System.out.println("Cliente não encontrado no Sistema");
        }

    }
    public double verificarDividas(int cpf){
        Cliente cliente = buscarCliente(cpf);
        double valorAPagar = cliente.getValorAPagar();

        return valorAPagar;
    }


    public boolean alugarLivro (String titulo, int cpf){

        Livro livroAlugado = buscarLivro(titulo);
        Cliente  clienteAluguel = buscarCliente(cpf);

        if (livroAlugado != null && livroAlugado.isStatus()){

        livroAlugado.setStatus(false);
        livroAlugado.setClienteQueAlugou(clienteAluguel);

        clienteAluguel.getLivrosAlugados().add(livroAlugado);
        clienteAluguel.setValorAPagar(livroAlugado.getPreco() + clienteAluguel.getValorAPagar());

        return true;
     } else {
            System.out.println("Livro não encontrado ou não está disponível!");
            return false;
        }
    }

    public void devolverLivro (int cpf, String titulo){

        Cliente clienteAluguel = buscarCliente(cpf);
        Livro livroAlugado = buscarLivro(titulo);

        clienteAluguel.getLivrosAlugados().remove(livroAlugado);
        clienteAluguel.setValorAPagar(clienteAluguel.getValorAPagar() - livroAlugado.getPreco());

        livroAlugado.setStatus(true);
        livroAlugado.setClienteQueAlugou(null);

    }

    public List<Livro> buscarLivroPorAno (int ano) {
        List <Livro> listaLivrosPorAno = new ArrayList<>();
        for (Livro livro : listaDeLivros){
            if (ano == livro.getAno()) {
                listaLivrosPorAno.add(livro);
            }
        }
        if (listaLivrosPorAno.isEmpty()){
            System.out.println("Nenhum livro encontrado.");
            return listaLivrosPorAno;

        } else {
            return listaLivrosPorAno;
        }
    }
    public List<Livro> buscarLivrosPorGenero (Genero genero) {
        List <Livro> listaLivrosPorGenero = new ArrayList<>();
        for (Livro livro : listaDeLivros){
            if (genero.equals(livro.getGenero())){

                listaLivrosPorGenero.add(livro);
            }

        }
        return listaLivrosPorGenero;


    }
    public void mudarGeneroDeLivro (Genero genero, String titulo){
        Livro livro = buscarLivro(titulo);
        livro.setGenero(genero);




    }

    public Genero escolherGeneroLivro(int opcaoTituloPorGenero){

        Genero livroPorGenero = null;
            switch (opcaoTituloPorGenero) {
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
                    break;
            }
        return livroPorGenero;


    }
    public List<Livro> mostrarLivros() {
    return listaDeLivros;
    }



}
