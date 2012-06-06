/**
 * 
 */
package primeiraParte;

/**
 * @author gislanio
 *
 */
//classe que contem todos os requisitos para criar um cliente
public class Cliente {
	
	private String cliente;
	private String endereco;
	private String nascimento;
	private int CPF;	
	private int Agencia;
	private int conta;
	private double saldo;
	private String tipodeConta;
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Retorna o nome do cliente.
	 * @return
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * Modifica o nome do cliente.
	 * @param nome
	 */
	public void setCliente(String Cliente) {
		this.cliente = Cliente;
	}
	
	public String getTipodeConta() {
		return tipodeConta;
	}
	/**
	 * @param tipodeConta the tipodeConta to set
	 */
	public void setTipodeConta(String tipodeConta) {
		this.tipodeConta = tipodeConta;
	}
	/**
	 * Retorna o endereco do cliente.
	 * @return
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Modifica o enderec do cliente.
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public int getAgencia() {
		return Agencia;
	}

	public void setAgencia(int agencia) {
		Agencia = agencia;
	}

	
	public int getConta() {
		return conta;
	}

	public void setConta(int Conta) {
		conta = Conta;
	}
	/**
	 * Construtor padrao da classe Clientes.
	 */
	public Cliente(){
		
	}
	
	/**
	 * Construtor modificado para receber par�metros.
	 * @param nome
	 * @param endereco
	 * @param idade
	 */
	public Cliente(String cliente, String endereco, String nascimento, int cPF, int agencia, int conta, double saldo, String senha, String tipodeConta){
		this.setCliente(cliente);
		this.setEndereco(endereco);
		this.setNascimento(nascimento);
		this.setCPF(cPF);
		this.setAgencia(agencia);
		this.setConta(conta);
		this.setSenha(senha);
		this.setSaldo(saldo);
		this.setTipodeConta(tipodeConta);
				
	}
	/**
	 * Sobrescrebe o m�todo toString.
	 */
	@Override
	public String toString() {
		return "Cliente: " + cliente + "\nEndereco = " + endereco + "\nNascimento = " + nascimento + "\nCPF = "+ CPF;
	}
	
	public String toStringtudo() {
		return "\nCliente: " + cliente + "\nCPF=  " + CPF +"\nNascimento=  " + nascimento +"\nEndereco=  " + endereco
				+"\nAgencia=  "+ Agencia + "\nConta=  " + conta + "\nTipo de Conta= "+tipodeConta+"\nSaldo=  " + saldo;
	}	
}
