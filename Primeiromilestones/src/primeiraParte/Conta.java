package primeiraParte;

//classe que contem todos os requisitos para criar uma conta
public class Conta{
	
	private int Nconta;
	
	public Conta() {}
	
	public Conta(int conta) {
		super();
		this.Nconta = conta;
	}
	
	public int getNconta() {
		return Nconta;
	}
	
	public void setNconta(int nconta) {
		if (nconta > 0 )this.Nconta = nconta;
	}

	@Override
	public String toString() {
		return "Conta: " + Nconta;
	}
	
	public double calculaCP(double quantia){
		quantia = (quantia * 0.1)+ quantia;
		return quantia;
	}
	
	public double calculaCPMF(double quantia){
		quantia = quantia * 0.01;
		return quantia;
	}
	
	public double descontaCPMF(double quantia) {
		return quantia + calculaCPMF(quantia);
	}
	
}
