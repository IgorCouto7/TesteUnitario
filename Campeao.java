public class Campeao {
    protected String nome;
    protected String rota;
    protected int nivel;

    public Campeao(String nome, String rota) {
        this.nome = nome;
        this.rota = rota;
        this.nivel = 1;
    }

    public void atacar() {
        System.out.println(nome + " atacou de forma genérica!");
    }

    public void mostrarInfo() {
        System.out.println("Campeão: " + nome + " | Rota: " + rota + " | Nível: " + nivel);
    }
}
