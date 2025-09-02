import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Campeao> campeoes = new ArrayList<>();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU LoL ===");
            System.out.println("1 - Adicionar campeão");
            System.out.println("2 - Listar campeões");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do campeão: ");
                    String nome = sc.nextLine();
                    System.out.print("Rota do campeão: ");
                    String rota = sc.nextLine();
                    System.out.print("Tipo (1-Assassino, 2-Mago, 3-Atirador): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Campeao novo;
                    if (tipo == 1) novo = new Assassino(nome, rota);
                    else if (tipo == 2) novo = new Mago(nome, rota);
                    else novo = new Atirador(nome, rota);

                    campeoes.add(novo);
                    System.out.println("Campeão adicionado com sucesso!");
                    break;

                case 2:
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão adicionado ainda.");
                    } else {
                        for (Campeao c : campeoes) {
                            c.mostrarInfo();
                            c.atacar();
                        }
                    }
                    break;

                case 3:
                    rodando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
