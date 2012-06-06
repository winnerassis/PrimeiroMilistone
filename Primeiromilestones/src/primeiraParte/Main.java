package primeiraParte;

import java.util.Random;
import java.util.Scanner;
//esta e a classe onde o programa comeca. aqui se cria o primeiro cliente e chama menu.
public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String op = "s";
		int j= 0;
		Menu menu = new Menu();
		do
		{
			System.out.println("-------Bem Vindo a nosso Banco------\n\n");
			System.out.println("Ja Sou cliente - Digite 1 \nNao sou Cliente - digite 2");
			j = s.nextInt();
		switch (j) {
		case 1: 
				System.out.println("Digite sua senha: ");
				String senha = s.next();
				menu.Bank.SenhaCadastrada(senha);
				menu.Bank.isPermissao();
				if(menu.Bank.isPermissao()==true){
					System.out.println("Seja bem Vindo Cliente\n\n");
					j=8;
					break;
				}
				else {
					System.out.println("Senha Errada! Faca seu Cadastro");
					j=2;
					break;
				}
		case 2: 
				int conta = 0,agencia=0;
				double saldo=0;
				String a="s",b, tipodeConta="";
				Random r = new Random();
				
				System.out.println("\nNome do Cliente: ");
				String client = s.next();
				System.out.println("Endereco: ");
				String endereco = s.next();
				System.out.println("Nascimento: ");
				String nascimento = s.next();
				System.out.println("CPF: ");
				int cPF = s.nextInt();
				System.out.println("Digite sua Senha: ");
				String senh = s.next();
				while(a.equalsIgnoreCase("s")){
					System.out.println("Que tipo de Conta voce deseja? \n1 - Conta Corrente\n2 - Conta Poupanca \n");
					b  = s.next();
					if(b.equals("1")){
						tipodeConta = "Conta Corrente";
						conta = 100000 + r.nextInt(90000);
						agencia= 1000 + r.nextInt(900);
						menu.Bank.cadastraAgencia(agencia);
						menu.Bank.cadastraCCorrente(conta);
						a="n";
					}	
					else if(b.equals("2")){
						tipodeConta = "Conta Poupanca";
						conta = 200000 + r.nextInt(90000);
						agencia= 2000 + r.nextInt(900);
						menu.Bank.cadastraAgencia(agencia);
						menu.Bank.cadastraCPoupanca(conta);
						a="n";
					}	
				}						
				menu.Bank.cadastraCliente(client, endereco, nascimento, cPF, agencia, conta, saldo, senh, tipodeConta);
				System.out.println("\nCliente Cadastrado");
				j=8;
				break;
			}	
	}while (j>=1 && j<=2);
		while (op.equalsIgnoreCase("s")){
		
		menu.menuPrincipal();
		
		System.out.println("\nDeseja realizar outra operacao? (s/n)");
		op = s.next();
		}		
		System.exit(0);
					
	}
	
}
