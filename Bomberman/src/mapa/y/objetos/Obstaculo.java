package mapa.y.objetos;

public class Obstaculo extends Entidad{
	private static int nroObstaculo = 0;
	private int idObstaculo;
	//private boolean estaDestruido;
	
	public Obstaculo(final int posIniX,final int posIniY) {
		super(posIniX,posIniY);
		//estaDestruido = false;
		idObstaculo = nroObstaculo;
		nroObstaculo++;
	}
	
	public void destruir() {
		if(esVisible == true) {
			esVisible = false;
			//estaDestruido = true;
			System.out.println("Obstaculo "+ idObstaculo +" Destruido");
		}
	}
	
	@Override
	public boolean verSiEsVisible() {
		return this.esVisible;
	}
	
//	public boolean estaDestruido() {
//		return estaDestruido;
//	}
}
