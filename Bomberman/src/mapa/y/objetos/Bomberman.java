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
		this.destructible = true;
	}

	public void moverAIzquierda() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosX(-1);
		if (miMapa.estaLibre(aux) && aux.getPosX() >= 0) {
			ubicacion.cambiarPosX(-1);
			System.out.println("Se movio hacia la izquierda");
		}else {
			System.out.println("No podes moverte hacia la izquierda");
		}
	}

	public void moverAbajo() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosY(1);
		if (miMapa.estaLibre(aux) && aux.getPosY() < Mapa.ALTO) {
			ubicacion.cambiarPosY(1);
			System.out.println("Se movio hacia abajo");
		}else {
			System.out.println("No podes moverte hacia abajo");
		}
	}

	public void moverADerecha() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosX(1);
		if (aux.getPosX() < Mapa.ANCHO && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosX(1);
			System.out.println("Se movio hacia la derecha");
		}else {
			System.out.println("No podes moverte hacia la derecha");
		}
	}

	public void moverArriba() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosY(-1);
		if (aux.getPosY() >= 0 && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosY(-1);
			System.out.println("Se movio hacia arriba");
		}else {
			System.out.println("No podes moverte hacia arriba");
		}
	}

	@Override
	public boolean verSiEsVisible() {
		return this.esVisible;
	}

	public void morir() {
		if (this.esVisible == true) {
			esVisible = false;
			System.out.println("El bomberman " + nroBomberman+ " ha muerto");
		}

	}

	public void ponerBomba() {
		miMapa.agregarBomba(ubicacion);
		System.out.println("SE HA PUESTO LA BOMBA");
	}
	
	public Ubicacion obtenerUbicacion() {
		return this.ubicacion;
	}
}
