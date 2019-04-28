package mapa.y.objetos;

public class Bomberman extends Entidad {
	private static int nroBomberman = 0;
	private int idBomberman;
	private Mapa miMapa;

	public Bomberman(final int posIniX, final int posIniY, Mapa miMapa) {
		super(posIniX, posIniY);
		this.miMapa = miMapa;
		idBomberman = nroBomberman;
		nroBomberman++;
	}

	public void moverAIzquierda() {
		if (miMapa.estaLibre(ubicacion) && ubicacion.posX > 0) {
			ubicacion.posX--;
			System.out.println("Se movio hacia la izquierda");
		}
	}

	public void moverAbajo() {
		if (miMapa.estaLibre(ubicacion) && ubicacion.posY > 0) {
			ubicacion.posY--;
			System.out.println("Se movio hacia abajo");
		}
	}

	public void moverADerecha() {
		if (ubicacion.posX < Mapa.ANCHO && miMapa.estaLibre(ubicacion)) {
			ubicacion.posX++;
			System.out.println("Se movio hacia la derecha");
		}
	}

	public void moverArriba() {
		if (ubicacion.posY < Mapa.ALTO && miMapa.estaLibre(ubicacion)) {
			ubicacion.posY++;
			System.out.println("Se movio hacia arriba");
		}
	}

	@Override
	public boolean verSiEsVisible() {
		return this.esVisible;
	}

	public void morir() {
		if (this.esVisible == true) {
			esVisible = false;
			System.out.println("El bomberman ha muerto");
		}

	}

	public void ponerBomba() {
		miMapa.agregarBomba(ubicacion);
		System.out.println("SE HA PUESTO LA BOMBA");
	}
}
