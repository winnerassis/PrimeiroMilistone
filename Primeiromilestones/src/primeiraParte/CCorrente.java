package primeiraParte;

//classe que contem todos os requisitos para criacao de uma nova conta corrente
public class CCorrente extends Conta{

	/**
	 * Construtor padrao.
	 */
	public CCorrente() {
		super();
	}
	/**
	 * Construtor modificado, que recebe parametros.
	 * @param numero da Agencia
	 */
	public CCorrente (int conta){
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

