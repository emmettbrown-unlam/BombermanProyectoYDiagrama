package mapa.y.objetos;

public class Bomba extends Entidad{
	private static int nroBomba = 0;
	private int idBomba;
	private int segsExplosion;
	
	public Bomba(final int posIniX,final int posIniY) {
		super(posIniX,posIniY);
		idBomba = nroBomba;
		nroBomba++;
		segsExplosion = 3;
	}
	
	public Bomba(Ubicacion miUbicacion) {
		super(miUbicacion);
		idBomba = nroBomba;
		nroBomba++;
		segsExplosion = 3;
	}
	
	public void explotar() {
		if(this.esVisible == true) {
			this.esVisible = false;
			System.out.println("BUM, la bomba "+idBomba+" Exploto");
		}
	}
}
