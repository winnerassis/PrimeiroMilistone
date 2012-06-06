package primeiraParte;

//classe que contem todos os requisitos para criacao de um novo tipo de conta, seja corrente ou poupanca
public class TipoConta extends Conta{
	
	private String tipodeconta="";
	/**
	 * Constructor padrao da classe.
	 */
	public TipoConta() { }
	
	
	public TipoConta (String tipodeconta){
		this.tipodeconta=tipodeconta;		
	}	
	
	/**
 	 * Retorna Tipo de Conta.
	 * @return
	 */
	public String getTipodeconta() {
		return tipodeconta;
	}
	/**
	 * Modifica o numero da Agencia
	 * @return
	 */
	public void setTipodeconta(String tipodeconta) {
		this.tipodeconta = tipodeconta;
	}
	/**
	 * Imprime o objeto numero da agencia.
	 */
	@Override
	public String toString(){
		return "Tipo de Conta: "+tipodeconta;
	}
}
