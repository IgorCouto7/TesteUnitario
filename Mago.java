public class Mago extends Campeao {
    public Mago(String nome, String rota) {
        super(nome, rota);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " lançou uma skill!");
    }
}
