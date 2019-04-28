package mapa.y.objetos;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Mapa {
	public static final int ANCHO = 5;
	public static final int ALTO = 5;
	private Map<Ubicacion, Entidad> conjuntoEntidades = new TreeMap<Ubicacion, Entidad>();

	public Mapa() {

		conjuntoEntidades.put(new Ubicacion(1, 1), new Muro(1, 1));
		conjuntoEntidades.put(new Ubicacion(1, 3), new Muro(1, 3));
		conjuntoEntidades.put(new Ubicacion(3, 1), new Muro(3, 1));
		conjuntoEntidades.put(new Ubicacion(3, 3), new Muro(3, 3));
		conjuntoEntidades.put(new Ubicacion(2, 2), new Obstaculo(2, 2));
		conjuntoEntidades.put(new Ubicacion(4, 4), new Obstaculo(4, 4)); /// DANGER

	}

	public static void main(String[] args) {
		Mapa mapa1 = new Mapa();
		mapa1.mostrarMapa();
		Bomberman jug1 = new Bomberman(0,0,mapa1);
		Bomberman jug2 = new Bomberman(0,4,mapa1);
		jug1.ponerBomba();
		jug2.ponerBomba();
		mapa1.mostrarMapa();
	}

//	static void dibujarBomba(final int posX,final int posY)
//	{
//		agregarBomba(posX,posY);	
//	}

	public void agregarBomba(Ubicacion miUbicacion) {
		conjuntoEntidades.put(miUbicacion, new Bomba(miUbicacion));

	}

	public void mostrarMapa() {
		Ubicacion ver;
		Iterator<Ubicacion> it = conjuntoEntidades.keySet().iterator();
		ver = it.next();
		for (int i = 0; i < ALTO; i++) {
			for (int j = 0; j < ANCHO; j++) {
				if (it.hasNext() && ver.equals(new Ubicacion(i, j))) {
					System.out.printf("%s\t", conjuntoEntidades.get(ver).getClass().getSimpleName().substring(0, 4));
					ver = it.next();
				} else
					System.out.printf("NULO\t");
			}
			System.out.println();
		}
	}

	public boolean estaLibre(Ubicacion miUbicacion) {
		Iterator<Ubicacion> it = conjuntoEntidades.keySet().iterator();
		Ubicacion ver;
		while (it.hasNext()) {
			ver = it.next();
			if (ver.equals(miUbicacion))
				return true;
		}
		return false;
	}
}
