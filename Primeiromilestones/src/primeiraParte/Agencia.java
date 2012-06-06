package primeiraParte;

//classe que contem todos os requisitos para criar uma agencia
public class Agencia {
	
	private int numeroagencia=0;
	/**
	 * Constructor padrao da classe.
	 */
	public Agencia() { }	
	
	public Agencia (int agencia){
		this.numeroagencia=agencia;		
	}	
	
	/**
 	 * Retorna Numero da Agencia.
	 * @return
	 */
	public int getNumeroagencia() {
		return numeroagencia;
	}
	/**
	 * Modifica o numero da Agencia
	 * @return
	 */
	public void setNumeroagencia(int numeroagencia) {
		this.numeroagencia = numeroagencia;
	}
	/**
	 * Imprime o objeto numero da agencia.
	 */
	@Override
	public String toString(){
		return "Numero da Agencia: "+numeroagencia;
	}
}
