public class Campeao {
    protected String nome;
    protected String rota;
    protected int nivel;

    // Construtor padrão (nível 1)
    public Campeao(String nome, String rota) {
        this.nome = nome;
        this.rota = rota;
        this.nivel = 1;
    }

    // Novo construtor com nível inicial
    public Campeao(String nome, String rota, int nivel) {
        this.nome = nome;
        this.rota = rota;
        this.nivel = nivel;
    }

    public void upar() {
        nivel++;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
    }

    public void atacar() {
        System.out.println(nome + " atacou de forma genérica!");
    }

    public void mostrarInfo() {
        System.out.println("Campeão: " + nome + " | Rota: " + rota + " | Nível: " + nivel);
    }
}
