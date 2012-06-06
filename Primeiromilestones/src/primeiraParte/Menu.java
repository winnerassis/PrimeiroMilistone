package primeiraParte;

import java.util.Scanner;

public class Menu {

	public Menu(){ }
	
	Banco Bank = new Banco();
	
//menu que contem todas as opcoes para o cliente	
public void menuPrincipal(){
	    
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		Scanner s3 = new Scanner(System.in);
		Scanner s4 = new Scanner(System.in);
		Scanner s5 = new Scanner(System.in);
		Scanner s6 = new Scanner(System.in);
		s1.useDelimiter(System.getProperty("line.separator"));
		s2.useDelimiter(System.getProperty("line.separator"));
		s3.useDelimiter(System.getProperty("line.separator"));
		s4.useDelimiter(System.getProperty("line.separator"));
		s5.useDelimiter(System.getProperty("line.separator"));
		s6.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("------------MEU BANCO-------------");
		System.out.println("1. Cadastrar agencia");
		System.out.println("2. Cadastrar cliente na agencia");
		System.out.println("3. Pesquisar cliente na agencia");
		System.out.println("4. Excluir cliente da agencia");
		System.out.println("5. Cadastrar conta (associada a um cliente) na agencia");
		System.out.println("6. Excluir conta da agencia (corrente ou poupanca)");
		System.out.println("7. Pesquisar conta na agencia (corrente ou poupanca)");
		System.out.println("8. Saldo (geral) de uma conta (corrente ou poupanca)");
		System.out.println("9. Extrato (detalhado) de uma conta (corrente ou poupanca) ");
		System.out.println("10. Deposito em uma conta (corrente ou poupanca) ");
		System.out.println("11. Saque em uma conta (corrente ou poupanca) ");
		System.out.println("12. Alterar senha do cliente ");
		System.out.println("13. Salvar estado do sistema ");
		System.out.println("14. Cadastra novo Cliente ");
		System.out.println("15. Sair");
		System.out.println("---------------------------");
		System.out.printf("DIGITE UMA OPCAO:");
		int op = s1.nextInt();
		
		//cadastra uma agencia
		if (op==1){			
			System.out.println("Informe o tipo de conta que esta agencia vai se Cadastrar? \n1-Conta Corrente\n2-Conta Poupanca");
			String Tipo = s1.next();			
			String Tconta="", Tc="";
			if(Tipo.equals("1")){
				Tc="Conta Corrente";				
				Bank.procuraTipoConta(Tc);
				if(Bank.isTconta()==true){
					Tconta="Conta Corrente";
					Bank.cadastraAgencia(Tconta);
					System.out.println("Cadastro com Sucesso\n\n");
				}	
				else if (Bank.isTconta()==false){
					Bank.cadastraTipoConta(Tc);
					Tconta="Conta Corrente";
					Bank.cadastraAgencia(Tconta);
					System.out.println("Cadastro com Sucesso\n");
				}
			}
			else if(Tipo.equals("2")){
				Tc="Conta Poupanca";
				Bank.procuraTipoConta(Tc);
				if(Bank.isTconta()==true){
					Tconta="Conta Poupanca";
					Bank.cadastraAgencia(Tconta);
					System.out.println("Cadastro com Sucesso\n");
				}	
				else if (Bank.isTconta()==false){
					Bank.cadastraTipoConta(Tc);	
					Tconta="Conta Poupanca";
					Bank.cadastraAgencia(Tconta);
					System.out.println("Cadastro com Sucesso\n");
				}
			}	
			Bank.setTconta(false);
		}
		//associa o cliente a agencia
		if (op==2){
			String op1 = "s";
			System.out.println("Nome do Cliente: ");
			String cliente = s1.next();
			Bank.procuraCliente(cliente);
			if(Bank.isClien()==true){
				System.out.println("As Agencias Cadastradas sao:\n ");
				Bank.lerAgencias();
				while (op1.equalsIgnoreCase("s")){
					System.out.println("\nDeseja se Associar em qual agencia Cliente? : ");
					int agencia = s6.nextInt();
					Bank.procuraAgencia(agencia);
					if(Bank.isExisteAg()==true){					
						Bank.AssociarClienteAgencia(cliente, agencia);						
						Bank.lerCliente();
						op1="n";
					}
					else if(Bank.isExisteAg()==false){
						System.out.println("Desculpe esta agencia não esta cadastrada. Tente novamente.\n\n");
					}
				}
			}
			else if(Bank.isClien()==false){
				System.out.println("Tente Novamente. Cliente Nao Cadastrado.\n");
			}
			Bank.setExisteAg(false);
			Bank.setClien(false);
		}
		//pesquisa um cliente na agencia cadastrada
		if (op==3){
			System.out.println("\nDigite o nome do Cliente: ");
			String cliente = s1.next();
			Bank.procuraCliente(cliente);
			if(Bank.isClien()==true){
				System.out.println("Digite o numero da Agencia: ");
				int agencia = s2.nextInt();
				Bank.procuraAgencia(agencia);
				if(Bank.isExisteAg()==true){
					Bank.PesquisarClienteAgencia(cliente, agencia);
					if(Bank.isPCA()==true)
						System.out.println("Este Cliente esta Cadastrado nesta agencia.\n");
					else if(Bank.isPCA()==false)
						System.out.println("Este Cliente nao esta Cadastrado nesta agencia.\n");
				}
				else if(Bank.isExisteAg()==false)
					System.out.println("Tente novamente. Esta agencia nao esta cadastrada.\n");
			}
			else if(Bank.isClien()==false)
				System.out.println("Tente novamente. Este cliente nao esta cadastrado.\n");
			Bank.lerCliente();
			Bank.lerAgencias();
			Bank.setExisteAg(false);
			Bank.setClien(false);
			Bank.setPCA(false);
		}
		//exclui um cliente de sua agencia cadastrada
		if (op==4){
			System.out.println("Digite o Nome do Cliente: ");
			String nome = s1.next();
			Bank.ExcluirClienteAgencia(nome);
			if(Bank.isECA()==true)
				System.out.println("Exclusão feita com sucesso\n");
			else if(Bank.isECA()==false)
				System.out.println("Tente Novamente. Não foi possivel excluir.\n");
			Bank.setECA(false);
		}
		//cria uma conta para um cliente em uma dada agencia
		if (op==5){
			System.out.println("Nome do Cliente: ");
			String nome = s1.next();
			Bank.procuraCliente(nome);
			if(Bank.isClien()==true){
				System.out.println("Que tipo de conta Voce quer se Cadastrar? \n1-Conta Corrente\n2-Conta Poupanca");
				String a = s2.next();
				String Tipoconta, TC="";
				Bank.setTconta(false);
				if(a.equals("1")){
					TC="Conta Corrente";				
					Bank.procuraTipoConta(TC);
					if(Bank.isTconta()==true){
						Tipoconta="Conta Corrente";
						System.out.println("Você deseja Cadastrar esta nova conta a que Agencia? ");
						int agencia = s1.nextInt();
						Bank.lerAgencias();
						Bank.setExisteAg(false);
						Bank.procuraAgencia(agencia);
						if(Bank.isExisteAg()==true){
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}
						else if(Bank.isExisteAg()==false){
							Bank.cadastraAgencia(agencia, Tipoconta);
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
									System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}	
						Bank.setExisteAg(false);
					}
					else if (Bank.isTconta()==false){
						Bank.cadastraTipoConta(TC);
						Tipoconta="Conta Corrente";
						System.out.println("Você deseja Cadastrar esta nova conta a que Agencia? ");
						Bank.lerAgencias();
						int agencia = s1.nextInt();
						Bank.setExisteAg(false);
						Bank.procuraAgencia(agencia);
						if(Bank.isExisteAg()==true){
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==true)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}
						else if(Bank.isExisteAg()==false){
							Bank.cadastraAgencia(agencia, Tipoconta);
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==true)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}	
					}Bank.setTconta(false);	Bank.setExisteAg(false);
				}
				else if(a.equals("2")){
					Bank.setTconta(false);
					TC="Conta Poupanca";
					Bank.procuraTipoConta(TC);
					if(Bank.isTconta()==true){
						Tipoconta="Conta Poupanca";
						System.out.println("Você deseja Cadastrar esta nova conta a que Agencia? ");
						Bank.lerAgencias();
						int agencia = s1.nextInt();
						Bank.setExisteAg(false);
						Bank.procuraAgencia(agencia);
						if(Bank.isExisteAg()==true){
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}
						else if(Bank.isExisteAg()==false){
							Bank.cadastraAgencia(agencia, Tipoconta);
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}	
						Bank.setExisteAg(false);
					}
					else if (Bank.isTconta()==false){
						Bank.cadastraTipoConta(TC);
						Tipoconta="Conta Poupanca";
						System.out.println("Você deseja Cadastrar esta nova conta a que Agencia? ");
						Bank.lerAgencias();
						int agencia = s1.nextInt();
						Bank.setExisteAg(false);
						Bank.procuraAgencia(agencia);
						if(Bank.isExisteAg()==true){
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");							
							Bank.setPCA(false);
						}	
						else if(Bank.isExisteAg()==false){
							Bank.cadastraAgencia(agencia, Tipoconta);
							Bank.cadastraConta(Tipoconta, nome, agencia);
							if(Bank.isPCA()==true)
								System.out.println("Nova Conta do cliente cadastrada na agencia\n");
							else if(Bank.isPCA()==false)
								System.out.println("Nao foi possivel realizar o cadastro da Nova Conta na agencia\n");
							Bank.setPCA(false);
						}	
						
					}Bank.setTconta(false);	Bank.setExisteAg(false);
				}	
			}
			else if(Bank.isClien() == false)
				System.out.println("Tente Novamente. Este cliente nao e cadastrado.\n");
		}	
		//exclui conta da agencia cadastrada
		if (op==6){
			System.out.println("Digite o Numero da Conta: ");
			int conta = s2.nextInt();
			Bank.setCont(false);
			Bank.procuraConta(conta);
			if(Bank.isCont()==true){
				Bank.ExcluirContaAgencia(conta);
				if(Bank.isCont()==true)
					System.out.println("Conta excluida da agencia\n");
				else if(Bank.isCont()==false)
					System.out.println("Conta nao foi excluida da agencia\n");
				Bank.lerCliente();
			}
			else if(Bank.isCont()==false){
				System.out.println("Tente Novamente. Esta conta nao existe.\n");
			}
			Bank.setCont(false);
		}
		//pesquisa se uma conta esta em uma dada agencia
		if (op==7){
			System.out.println("Digite numero da Conta: ");
			int conta = s1.nextInt();
			Bank.setCont(false);
			Bank.procuraConta(conta);
			if(Bank.isCont()==true){
				System.out.println("Digite o numero da Agencia: ");
				int agencia = s2.nextInt();
				Bank.setExisteAg(false);
				Bank.procuraAgencia(agencia);
				if(Bank.isExisteAg()==true){
					Bank.setClien(false);
					Bank.PesquisarContaAgencia(conta, agencia);
					if(Bank.isClien()==true)
						System.out.println("Esta conta esta cadastrada com esta agencia\n");
					else if(Bank.isClien()==false)
						System.out.println("Esta conta não esta cadastrada com esta agencia\n");
					Bank.setClien(false);
				}
				else if(Bank.isExisteAg()==false)
					System.out.println("Tente novamente. Esta agencia nao existe.\n");	
			}			
			else if(Bank.isCont()==false)
				System.out.println("Tente novamente. esta conta nao existe.\n");
			Bank.setExisteAg(false);
		}
		//consulta saldo de uma conta
		if (op==8){
			System.out.println("Digite o numero da conta: ");
			int cont = s1.nextInt();
			Bank.ConsultaSaldo (cont);	
		}
		//consulta o extrato de uma conta
		if (op==9){
			System.out.println("Digite o numero da conta: ");
			int cont = s1.nextInt();
			Bank.ConsultaExtrato(cont);
		}
		//faz um deposito em uma conta corrente ou poupanca
		if (op==10){
			System.out.println("Digite o numero da conta: ");
			int cont = s1.nextInt();
			Bank.procuraConta(cont);
			if(Bank.isCont()==true){
				System.out.println("Digite o valo do deposito: ");
				double dep = s2.nextInt();
				if(dep > 0){
					Bank.Deposito (cont, dep);
				}
				else System.out.println("Erro no deposito. valor negativo\n");
			}
			else if(Bank.isCont()==false){
				System.out.println("Tente Novamente. Esta conta nao existe.\n");
			}
			Bank.setCont(false);
		}
		//faz um saque quando o cliente tem saldo suficiente na conta
		if (op==11){
			System.out.println("Digite o numero da conta: ");
			int cont = s2.nextInt();
			Bank.procuraConta(cont);
			if(Bank.isCont()==true){
				System.out.println("Digite quanto quer retirar da conta: ");
				int quantia = s1.nextInt();
				if(quantia>=0){
					Bank.Saque(cont, quantia);
				}	
				else if(Bank.isCont()==false)
					System.out.println("Erro. Saque negativo-isto nao existe\n");
			}	
			Bank.setCont(false);
		}
		//cadastra senha de cliente
		if (op==12){
			System.out.println("Digite seu nome: ");
			String cliente = s1.next();
			Bank.procuraCliente(cliente);
			if(Bank.isClien()==true){
				System.out.println("Digite sua nova Senha");
				String senha = s2.next();
				Bank.MudarSenha(cliente, senha);
			}else if(Bank.isClien()==false) 
				System.out.println("Este cliente nao existe\n");	
			
			Bank.setClien(false);
		}
		//salva estado do sistema 
		if (op==13){
			System.out.println("Seu Sistema Salvo\n\n");
			Bank.lerCliente();
		}
		//cria um novo cliente
		if(op==14){
			String tipodeConta=""; int conta=0, agencia=0; double saldo=0;
			System.out.println("Nome do Cliente: ");
			String client = s1.next();
			System.out.println("Endereco: ");
			String endereco = s1.next();
			System.out.println("Nascimento: ");
			String nascimento = s1.next();
			System.out.println("CPF: ");
			int cPF = s1.nextInt();
			System.out.println("Digite sua Senha: ");
			String senh = s1.next();
			
			Bank.cadastraCliente(client, endereco, nascimento, cPF, agencia, conta, saldo, senh, tipodeConta);
			System.out.println("\nCliente Cadastrado");
		}
		//sai do programa
		if (op==15){
			System.exit(0);
		}	
}
}


