public class Atirador extends Campeao {
    public Atirador(String nome, String rota) {
        super(nome, rota);
    }

    // Novo construtor com nível
    public Atirador(String nome, String rota, int nivel) {
        super(nome, rota, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " disparou vários tiros com sua arma!");
    }
}
