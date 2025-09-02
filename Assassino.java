public class Assassino extends Campeao {
    public Assassino(String nome, String rota) {
        super(nome, rota);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " deu um dash e explodiu o inimigo!");
    }
}
