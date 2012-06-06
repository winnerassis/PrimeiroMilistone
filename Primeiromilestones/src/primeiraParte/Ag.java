package primeiraParte;

//classe que contem todos os requisitos permite a criacao de uma nova agencia
public class Ag extends Agencia {
	/**
	 * Construtor padrao.
	 */
	public Ag (){
		super();
	}
	/**
	 * Construtor modificado, que recebe parametros.
	 * @param numero da Agencia
	 */
	public Ag (int agencia){
		super(agencia);
	}
	/**
	 * Metodo sobrescrito do toString.
	 */
	@Override
	public String toString(){
		return "Agencia: "+getNumeroagencia();
	}
	
}

