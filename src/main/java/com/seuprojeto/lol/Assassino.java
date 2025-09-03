public class Assassino extends Campeao {
    public Assassino(String nome, String rota) {
        super(nome, rota);
    }

    
    public Assassino(String nome, String rota, int nivel) {
        super(nome, rota, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(nome + " deu um dash e explodiu o inimigo!");
    }
}
