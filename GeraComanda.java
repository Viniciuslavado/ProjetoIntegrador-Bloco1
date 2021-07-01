package Turma24;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GeraComanda {

	public void geraComanda() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Cardapio> list = new ArrayList<>();

		System.out.println("Quantas comandas serão registradas? ");
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			System.out.println();
			System.out.println("comanda # " + (i + 1) + ":");
			System.out.println("Digite a identificaçao da comanda: ");
			Integer id = sc.nextInt();
			System.out.println("Prato: ");
			sc.nextLine();
			String prato = sc.nextLine();
			// System.out.println();
			System.out.println("Bebida: ");
			String bebida = sc.nextLine();
			System.out.println("Valor: ");
			Double valor = sc.nextDouble();
			System.out.println("-------------------------------");
			Cardapio cardapio = new Cardapio(id, prato, bebida, valor);
			list.add(cardapio);
		}
	
			for (int i = 0; i < N; i++) {
			for (Cardapio car : list) {
				System.out.println(car);
			}

			System.out.println("Qual a identificação da comanda que você deseja aplicar o desconto? ");
			int ident = sc.nextInt();
			Integer pos = listaCardapio(list, ident);
			
			if (pos == null) {
				System.out.println("Esta identificação nao existe!");
				
			
			} else {
				System.out.println("\n--------Tabela de desconto--------");
				System.out.println("\nDe: até 30R$ aplicar 10% de Desconto, valor acima disso 20%.");
				System.out.println("\nDigite a % de desconto");
				double percentage = sc.nextDouble();
				list.get(pos).valorFinal(percentage);
			}
		}
	}

	public static Integer listaCardapio(List<Cardapio> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
