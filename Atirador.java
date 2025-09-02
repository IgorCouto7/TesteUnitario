public class Atirador extends Campeao {
    public Atirador(String nome, String rota) {
        super(nome, rota);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " disparou vários tiros com sua arma!");
    }
}
