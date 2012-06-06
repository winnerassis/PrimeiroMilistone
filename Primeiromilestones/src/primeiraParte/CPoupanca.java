package primeiraParte;

//classe que contem todos os requisitos para criacao de uma nova conta poupanca
public class CPoupanca extends Conta{

	/**
	 * Construtor padrao.
	 */
	public CPoupanca (){
		super();
	}
	/**
	 * Construtor modificado, que recebe parametros.
	 * @param numero da Agencia
	 */
	public CPoupanca (int conta){
		super(conta);
	}
	/**
	 * Metodo sobrescrito do toString.
	 */
	@Override
	public String toString(){
		return "Conta: "+getNconta();
	}
	
}
