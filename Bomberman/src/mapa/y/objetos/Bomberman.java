package mapa.y.objetos;

public class Bomberman extends Entidad {
	private static int nroBomberman = 0;
	private int idBomberman;
	private Mapa miMapa;
	private static final int velocidad = 1;

	public Bomberman(int posIniX,int posIniY, Mapa miMapa) {
		super(posIniX, posIniY);
		this.miMapa = miMapa;
		idBomberman = nroBomberman;
		nroBomberman++;
		this.destructible = true;
	}

	public void moverAIzquierda() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosX(-velocidad);
		if (aux.getPosX() >= 0 && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosX(-1);
			System.out.println("Se movio hacia la izquierda");
		} else {
			System.out.println("No podes moverte hacia la izquierda");
		}
	}

	public void moverArriba() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosY(-velocidad);
		if (aux.getPosY() >= 0 && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosY(-velocidad);
			System.out.println("Se movio hacia arriba");
		} else {
			System.out.println("No podes moverte hacia arriba");
		}
	}

	public void moverADerecha() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosX(velocidad);
		if (aux.getPosX() < Mapa.ANCHO && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosX(velocidad);
			System.out.println("Se movio hacia la derecha");
		} else {
			System.out.println("No podes moverte hacia la derecha");
		}
	}

	public void moverAbajo() {
		Ubicacion aux = this.ubicacion.clone();
		aux.cambiarPosY(velocidad);
		if (aux.getPosY() < Mapa.ALTO && miMapa.estaLibre(aux)) {
			ubicacion.cambiarPosY(1);
			System.out.println("Se movio hacia abajo");
		} else {
			System.out.println("No podes moverte hacia abajo");
		}
	}

	@Override
	public boolean verSiEsVisible() {
		return this.esVisible;
	}

	public void morir() {
		if (this.esVisible == true) {
			esVisible = false;
			System.out.println("El bomberman " + idBomberman + " ha muerto");
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
