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
		System.out.println("BUM");
	}
}
