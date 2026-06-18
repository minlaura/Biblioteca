public class Livro {
    private String titulo;
    private int ano;
    private String autor;
    private double preco;
    private boolean status;
    private Genero genero;

    private Cliente clienteQueAlugou;

    public Livro (String titulo, int ano, String autor, double preco, Genero genero){
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.preco = preco;
        this.status = true;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cliente getClienteQueAlugou() {
        return clienteQueAlugou;
    }

    public void setClienteQueAlugou(Cliente clienteQueAlugou) {
        this.clienteQueAlugou = clienteQueAlugou;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", status=" + status +
                ", genero=" + genero+"}";
//                ", clienteQueAlugou=" + clienteQueAlugou +

    }
}
