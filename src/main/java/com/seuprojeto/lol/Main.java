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
            System.out.println("3 - Upar campeão");
            System.out.println("4 - Remover campeão");
            System.out.println("5 - Mostrar campeão com nível mais alto");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do campeão: ");
                    String nome = sc.nextLine();
                    System.out.print("Rota do campeão: ");
                    String rota = sc.nextLine();
                    System.out.print("Nível inicial do campeão: ");
                    int nivel = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tipo (1-Assassino, 2-Mago, 3-Atirador): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    Campeao novo;
                    if (tipo == 1) novo = new Assassino(nome, rota, nivel);
                    else if (tipo == 2) novo = new Mago(nome, rota, nivel);
                    else novo = new Atirador(nome, rota, nivel);

                    campeoes.add(novo);
                    System.out.println("Campeão adicionado com sucesso!");
                    break;

                case 2:
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão adicionado ainda.");
                    } else {
                        for (int i = 0; i < campeoes.size(); i++) {
                            System.out.print((i + 1) + " - ");
                            campeoes.get(i).mostrarInfo();
                        }
                    }
                    break;

                case 3:
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão para upar.");
                        break;
                    }
                    System.out.println("Escolha o número do campeão para upar:");
                    for (int i = 0; i < campeoes.size(); i++) {
                        System.out.print((i + 1) + " - ");
                        campeoes.get(i).mostrarInfo();
                    }
                    int idxUpar = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxUpar >= 0 && idxUpar < campeoes.size()) {
                        campeoes.get(idxUpar).upar();
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 4:
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão para remover.");
                        break;
                    }
                    System.out.println("Escolha o número do campeão para remover:");
                    for (int i = 0; i < campeoes.size(); i++) {
                        System.out.print((i + 1) + " - ");
                        campeoes.get(i).mostrarInfo();
                    }
                    int idxRemover = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idxRemover >= 0 && idxRemover < campeoes.size()) {
                        System.out.println(campeoes.get(idxRemover).nome + " foi removido!");
                        campeoes.remove(idxRemover);
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;

                case 5:
                    if (campeoes.isEmpty()) {
                        System.out.println("Nenhum campeão adicionado ainda.");
                        break;
                    }
                    Campeao maisAlto = campeoes.get(0);
                    for (Campeao c : campeoes) {
                        if (c.nivel > maisAlto.nivel) {
                            maisAlto = c;
                        }
                    }
                    System.out.println("Campeão com nível mais alto:");
                    maisAlto.mostrarInfo();
                    break;

                case 6:
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
