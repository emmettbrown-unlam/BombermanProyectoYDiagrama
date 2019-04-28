package mapa.y.objetos;

public class Obstaculo extends Entidad{
	private static int nroObstaculo = 0;
	private int idObstaculo;
	
	public Obstaculo(final int posIniX,final int posIniY) {
		super(posIniX,posIniY);
		idObstaculo = nroObstaculo;
		nroObstaculo++;
	}
	
	public void destruir() {
		if(esVisible == true) {
			esVisible = false;
			System.out.println("Obstaculo "+ idObstaculo +" Destruido");
		}
	}
	
	@Override
	public boolean verSiEsVisible() {
		return this.esVisible;
	}
	
}
