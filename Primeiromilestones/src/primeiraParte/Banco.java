/**
 * 
 */
package primeiraParte;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author gislanio e Winner
 *
 */
public class Banco { // esta classe e a classe que guarda todas as funcoes que serao chamadas
					//pelo programa.
		private String nomeBanco;
		private boolean clien=false;
		private boolean cont=false;
		private boolean permissao=false;
		private boolean tconta=false;
		private boolean existeAg=false;
		private boolean PCA=false;
		private boolean ECA=false;
		private double saldoAnterior;
		
		Conta C = new Conta();		
		
		private ArrayList<Cliente> clientes = new ArrayList<Cliente>(); //Array que cadastra um cliente
		private ArrayList<Agencia> Agencias = new ArrayList<Agencia>();//Array que cadastra uma agencia
		private ArrayList<Conta> Count = new ArrayList<Conta>();//Array que cadastra uma conta seja poupanca ou corrente
		private ArrayList<Conta> TipodeConta = new ArrayList<Conta>();//Array que cadastra um tipo de conta
		/**
		 * Construtor padrao da classe.
		 * @param Banco
		 */
		public Banco(String nomeBanco){	
			this.nomeBanco=nomeBanco;
		}
		// TODO Auto-generated constructor stub
		public Banco() {}
		
		/**
		 * Retorna o nome do Banco.
		 * @return
		 */
		public String getNomeBanco() {
			return nomeBanco;
		}
			//variaveis de verificacao se a funcao chamada deu certo ou nao 	
		public boolean isECA() {
			return ECA;
		}
		
		public void setECA(boolean eCA) {
			ECA = eCA;
		}
		
		public boolean isPCA() {
			return PCA;
		}
		
		public void setPCA(boolean pCA) {
			this.PCA = pCA;
		}
		
		public boolean isTconta() {
			return tconta;
		}
		
		public void setTconta(boolean tconta) {
			this.tconta = tconta;
		}
		
		public boolean isExisteAg() {
			return existeAg;
		}

		public void setExisteAg(boolean existeAg) {
			this.existeAg = existeAg;
		}

		public void setNomeBanco(String nomeBanco) {
			this.nomeBanco = nomeBanco;
		}

		public boolean isClien() {
			return clien;
		}

		public void setClien(boolean clien) {
			this.clien = clien;
		}

		public boolean isCont() {
			return cont;
		}

		public void setCont(boolean cont) {
			this.cont = cont;
		}
		/**
		 * @return the permissao
		 */
		public boolean isPermissao() {
			return permissao;
		}
		/**
		 * @param permissao the permissao to set
		 */
		public void setPermissao(boolean permissao) {
			this.permissao = permissao;
		}
		//parametros de get e set dos array list criados
		public ArrayList<Agencia> getAgencias() {
			return Agencias;
		}
		
		public void setAgencias(ArrayList<Agencia> agencias) {
			Agencias = agencias;
		}
		/**
		 * @param agencias the agencias to set
		 */
		
		public void setClientes(ArrayList<Cliente> cliente) {
			clientes = cliente;
		}

		public ArrayList<Cliente> getClientes() {
			return clientes;
		}
		
		public ArrayList<Conta> getCount() {
			return Count;
		}

		public void setCount(ArrayList<Conta> count) {
			Count = count;
		}

		public ArrayList<Conta> getTipodeConta() {
			return TipodeConta;
		}

		public void setTipodeConta(ArrayList<Conta> tipodeConta) {
			TipodeConta = tipodeConta;
		}
		//retorna o saldo
		public double getSaldoAnterior() {
			return saldoAnterior;
		}
		//muda o saldo
		public void setSaldoAnterior(double saldoAnterior) {
			this.saldoAnterior = saldoAnterior;
		}
		//cadastra agencia
		public void primeirocadastraAgencia(){
			int agencia = 0;
			for(int i=0;i<clientes.size();++i){
				 agencia=clientes.get(i).getAgencia();
			}
			Agencia ag = new Ag(agencia);
			getAgencias().add(ag);			
		}
		//cadastra Tipo conta
		public void cadastraTipoConta(String tipodeconta){
			Conta Tp = new TipoConta(tipodeconta);
			getTipodeConta().add(Tp);			
		}
		//pesquisa um cliente em uma dada agencia
		public void PesquisarClienteAgencia (String cliente, int agencia){
			procuraCliente(cliente);
			procuraAgencia(agencia);
			if(isClien() == false){ 
				System.out.println("Este Cliente Nao existe.\n");
				if(isExisteAg()==false)
					System.out.println("Esta Agencia Nao esxiste.\n");
			}	
			else if (isClien()== true && isExisteAg()==true){
				for (int i=0;i<clientes.size();++i){
					if((clientes.get(i).getAgencia() == agencia) && (clientes.get(i).getCliente().equals(cliente))){
						setPCA(true);
					}	
				}
			}			
			setClien(false);
			setExisteAg(false);
		}	
		//cadastra um cliente em uma dada conta
		public void cadastraConta(String tipodeconta, String cliente, int agencia){
				PesquisarClienteAgencia(cliente, agencia);
				if(isPCA()==true){
					if(tipodeconta.equals("Conta Corrente")){
						Random r = new Random();
						int conta = 100000 + r.nextInt(90000);
						cadastraCCorrente(conta);
						CadastroContaCliente(cliente, conta, tipodeconta);
					}
					else if(tipodeconta.equals("Conta Poupanca")){
						Random r = new Random();
						int conta = 200000 + r.nextInt(90000);
						cadastraCPoupanca(conta);
						CadastroContaCliente(cliente, conta, tipodeconta);
					}
				}
				else if(isPCA()==false)
					System.out.println("Tente novamente. A agencia foi digitada errada\n");
		}							
		//cadastra conta corrente		
		public void cadastraCCorrente(int conta){
			Conta Tp = new CCorrente(conta);
			getCount().add(Tp);			
		}
		//cadastra conta Poupanca
		public void cadastraCPoupanca(int conta){
			Conta Tp = new CPoupanca(conta);
			getCount().add(Tp);			
		}
		//procura uma determinada agencia
		public void procuraAgencia(int agencia){
			for (int i=0;i<Agencias.size();++i){
				if (i<Agencias.size() && Agencias.get(i).getNumeroagencia() == agencia){
					setExisteAg(true);
				}
			}	
		}
		//cadastra agencia com um parametro
		public void cadastraAgencia(int Agencia){
			Agencia ag = new Ag(Agencia);
			getAgencias().add(ag);						
		}
		//cadastra agencia com um parametro
		public void cadastraAgencia(String Tipoconta){
			if(Tipoconta.equals("Conta Poupanca")){
				Random r = new Random();
				int agencia= 2000 + r.nextInt(900);
				Agencia ag = new Ag(agencia);
				getAgencias().add(ag);
			}
			else if(Tipoconta.equals("Conta Corrente")){
				Random r = new Random();
				int agencia= 1000 + r.nextInt(900);
				Agencia ag = new Ag(agencia);
				getAgencias().add(ag);
			}
			else {
				Random r = new Random();
				int agencia= 3000 + r.nextInt(900);
				Agencia ag = new Ag(agencia);
				getAgencias().add(ag);
			}
		}
		//cadastra agencia com dois parametro
		public void cadastraAgencia(int numeroagencia, String Tipoconta){
			procuraAgencia(numeroagencia);
			if(isExisteAg()==true)
				System.out.println("Esta agencia já existe. Cadastre outra\n");
			else if(isExisteAg()==false){
				if(Tipoconta.equals("Conta Poupanca")){
					Random r = new Random();
					int agencia= 2000 + r.nextInt(900);
					Agencia ag = new Ag(agencia);
					getAgencias().add(ag);
				}
				else if(Tipoconta.equals("Conta Corrente")){
					Random r = new Random();
					int agencia= 1000 + r.nextInt(900);
					Agencia ag = new Ag(agencia);
					getAgencias().add(ag);
				}
			}			
		}
		//procura uma conta
		public void procuraConta (int conta){
			for (int i=0;i<Count.size();++i){
				if (i<Count.size() && Count.get(i).getNconta() == conta){						
					setCont(true);
					System.out.println("\nPassou pela funçao procura conta\n");
				}	
			}			
		}
		//procura um tipo de conta
		public void procuraTipoConta (String tipoconta){
			for (int i=0;i<TipodeConta.size();++i){
				if (i<TipodeConta.size() && TipodeConta.get(i).equals(tipoconta))						
					setTconta(true);
			}			
		}
		//pesquisa uma determinada conta na agencia
		public void PesquisarContaAgencia (int conta, int agencia){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta && clientes.get(i).getAgencia() == agencia){
					setClien(true);
				}	
			}
		}
		//cadastra conta ao cliente
		public void CadastroContaCliente (String cliente, int conta, String tipoconta){
			for (int i=0;i<getClientes().size();++i){
				if (getClientes().get(i).getCliente().equals(cliente)){
					clientes.get(i).setTipodeConta(tipoconta);
					clientes.get(i).setConta(conta);					
					System.out.println("\nCadastrado com exito.\n");
					break;
				}					
			}
		}
		//associa um cliente a uma dada agencia		
		public void AssociarClienteAgencia (String cliente, int agencia){
			for(int i=0;i<clientes.size();++i){
				if(clientes.get(i).getCliente().equals(cliente)){
					clientes.get(i).setAgencia(agencia);
				}			 
			}					
		}				
		//ler todas as agencias existentes
		public void lerAgencias(){
		
			for (int i=0;i<getAgencias().size();++i){			
				System.out.println(getAgencias().get(i).toString());				
			}
		}
		//remove agencia cadastrada
		public boolean removeAgencia(int index){			
			getAgencias().remove(index);
			return true;
		}
		//cadastra um cliente
		public void cadastraCliente(String cliente, String endereco, String nascimento, int cPF, int agencia, int conta, double saldo, String senha, String tipodeConta){
			Cliente a = new Cliente(cliente, endereco, nascimento, cPF, agencia, conta, saldo, senha, tipodeConta);
			clientes.add(a);
		}		
		//cadastrar senha do cliente
		public void SenhaCadastrada(String senha){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getSenha().equals(senha))
					setPermissao(true);
			}	
		}
		//mudar a senha do cliente
		public void MudarSenha(String cliente, String senha){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getCliente().equals(cliente)){
					clientes.get(i).setSenha(senha);
					System.out.println("Esta é sua nova senha, Não mostre a ninguém: " +clientes.get(i).getSenha()+"\n");
				}	
			}
		}
		//procurar um determinado cliente
		public void procuraCliente (String titular){
			for (int i=0;i<clientes.size();++i){
				if(i<clientes.size() && clientes.get(i).getCliente().equals(titular)){
					setClien(true);						
				}	
			}			
		}
		//ler todos os clientes cadastrados
		public void lerCliente(){
			for (int i=0;i<clientes.size();i++){				
				System.out.println(clientes.get(i).toStringtudo()+"\n");				
			}	
		}
		//exclui uma conta cadastrada
		public boolean excluirContaGeral(int index){
			Count.remove(index);
			return true;
		}
		//exclui uma conta de uma agencia
		public void ExcluirContaAgencia(int conta){
			int cont=0;
			for (int i=0;i<clientes.size();++i){
					if(clientes.get(i).getConta() == conta){
						clientes.get(i).setConta(cont);						
					}
			}
				for(int j=0;j<Count.size();++j){
					if(Count.get(j).getNconta() == conta){
						excluirContaGeral(j);
					}
				}	
		}		
		//exclui um cliente de uma agencia 
		public void ExcluirClienteAgencia (String cliente){
			procuraCliente(cliente);
			if(isClien() == false) 
				System.out.println("Este Cliente Nao esxiste.\n");
			else if (isClien()== true){
				for (int i=0;i<clientes.size();++i){
					if(clientes.get(i).getCliente().equals(cliente)){
						int agencia = clientes.get(i).getAgencia();
						agencia=0;
						clientes.get(i).setAgencia(agencia);
						setECA(true);
					}
				}
			}
		}
		//remove uma cliente cadastrado
		public boolean removeCliente(int index){
			clientes.remove(index);
			return true;
		}		
		//cobra tarica de cada extrato solicitado da conta corrente
		public void TarifaExtrato(int conta){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta){
					if ( 0 > (clientes.get(i).getSaldo() - 2))
						System.out.println("Desculpa voce nao tem saldo suficiente.\n");
					else if ( 0 < (clientes.get(i).getSaldo() - 2))
						clientes.get(i).setSaldo(clientes.get(i).getSaldo() - 2);
				}
			}	
		}
		
		//consulta extrato de uma conta
		public void ConsultaExtrato(int conta){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta && clientes.get(i).getTipodeConta().equals("Conta Corrente")){
					saldoAnterior =clientes.get(i).getSaldo();
					TarifaExtrato(conta);
					System.out.println("Titular da conta: " + clientes.get(i).getCliente());
					System.out.println("Conta: "+clientes.get(i).getTipodeConta());
					System.out.println("Numero da Conta: "+clientes.get(i).getConta());
					System.out.println("Saldo Anterior: R$  "+saldoAnterior);
					System.out.printf("Saldo Atual: R$  " + clientes.get(i).getSaldo());
				}
				if(clientes.get(i).getConta() == conta && clientes.get(i).getTipodeConta().equals("Conta Poupanca")){
					double valor = clientes.get(i).getSaldo();
					System.out.println("Titular da conta: " + clientes.get(i).getCliente());
					System.out.println("Conta: "+clientes.get(i).getTipodeConta());
					System.out.println("Número da Conta: "+clientes.get(i).getConta());
					System.out.println("Saldo Anterior: R$  "+saldoAnterior);
					System.out.printf("Saldo Atual: R$  " + valor); 
				}
			}
		}
		
		//consulta o saldo de uma conta
		public void ConsultaSaldo(int conta){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta){
					System.out.println("O Saldo da Conta: " +clientes.get(i).getSaldo());
				}
			}
		}	
		//faz um saque de uma conta de tiver dinheiro		
		
		public void Saque (int conta, int quantia){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta && clientes.get(i).getTipodeConta().equals("Conta Corrente")){
					if ( quantia > clientes.get(i).getSaldo() + C.calculaCPMF(quantia) ) {
						System.out.println("Desculpa voce nao tem saldo suficiente.");
					}
					else if ( quantia < clientes.get(i).getSaldo() + C.calculaCPMF(quantia) ) {
						saldoAnterior =clientes.get(i).getSaldo();
						clientes.get(i).setSaldo( clientes.get(i).getSaldo() - C.descontaCPMF(quantia));
						System.out.println("voce pode tirar o dinheiro abaixo");
					}				
				}
				else if(clientes.get(i).getConta() == conta && clientes.get(i).getTipodeConta().equals("Conta Poupanca")){
					if (quantia > clientes.get(i).getSaldo()){
						System.out.println("Desculpa voce nao tem saldo suficiente.");
					}
					else if (quantia < clientes.get(i).getSaldo()){												
						clientes.get(i).setSaldo( clientes.get(i).getSaldo() - quantia);
						System.out.println("voce pode tirar o dinheiro abaixo");
					}				
				}
			}
		}
		
		//faz um deposito na conta
		public void Deposito (int conta, double dep){
			for (int i=0;i<clientes.size();++i){
				if(clientes.get(i).getConta() == conta){
					if(clientes.get(i).getTipodeConta().equals("Conta Corrente"))
						clientes.get(i).setSaldo(clientes.get(i).getSaldo()+dep);
					if(clientes.get(i).getTipodeConta().equals("Conta Poupanca")){
						saldoAnterior =clientes.get(i).getSaldo();
						clientes.get(i).setSaldo(C.calculaCP(clientes.get(i).getSaldo()+ dep));
					}	
					else if(dep < 0 )System.out.println("Erro. valor abaixo de zero.");
				}	 				
			}			 
		}		
}
