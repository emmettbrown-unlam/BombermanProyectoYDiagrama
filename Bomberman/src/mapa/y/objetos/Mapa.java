package mapa.y.objetos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mapa {
	public static final int ANCHO = 5;
	public static final int ALTO = 5;
	private Map<Ubicacion, Entidad> conjuntoEntidades = new TreeMap<Ubicacion, Entidad>();
	private Bomberman[] listaBomberman;
	private List<Ubicacion> rangoExplosion;

	public Mapa() {
		conjuntoEntidades.put(new Ubicacion(0, 1), new Obstaculo(0, 1));
		conjuntoEntidades.put(new Ubicacion(1, 1), new Muro(1, 1));
		conjuntoEntidades.put(new Ubicacion(1, 3), new Muro(1, 3));
		conjuntoEntidades.put(new Ubicacion(3, 1), new Muro(3, 1));
		conjuntoEntidades.put(new Ubicacion(3, 3), new Muro(3, 3));
		conjuntoEntidades.put(new Ubicacion(2, 2), new Obstaculo(2, 2));
	}

	public static void main(String[] args) {
		Mapa mapa1 = new Mapa();
		mapa1.mostrarMapa();
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(0, 0, mapa1);
		listaBomb[1] = new Bomberman(0, 4, mapa1);
		listaBomb[0].ponerBomba();
		listaBomb[1].ponerBomba();
//		listaBomb[0].moverAbajo();
//		listaBomb[0].ponerBomba();
//		listaBomb[0].moverAbajo();
		mapa1.agregarBombermans(listaBomb);
		mapa1.mostrarMapa();
		if (listaBomb[0].verSiEsVisible() == true)
			System.out.println("Bomberman 0 vivo");
		else
			System.out.println("Bomberman 0 muerto");
		if (listaBomb[1].verSiEsVisible() == true)
			System.out.println("Bomberman 1 vivo");
		else
			System.out.println("Bomberman 1 muerto");
		mapa1.explotarBomba(0, 0);
		mapa1.explotarBomba(0, 4);
		mapa1.mostrarMapa();
		if (listaBomb[0].verSiEsVisible() == true)
			System.out.println("Bomberman 0 vivo");
		else
			System.out.println("Bomberman 0 muerto");
		if (listaBomb[1].verSiEsVisible() == true)
			System.out.println("Bomberman 1 vivo");
		else
			System.out.println("Bomberman 1 muerto");
	}

	void explotarBomba(int posX, int posY) {
		Ubicacion ubic = new Ubicacion(posX, posY);
		Entidad obj = conjuntoEntidades.get(ubic);
		if (obj != null && obj.getClass().getSimpleName().equals("Bomba")) {
			Bomba exp = (Bomba) obj;
			exp.explotar();
			conjuntoEntidades.remove(ubic);
			rangoExplosion = generarRangoExplosion(ubic);
			Iterator<Ubicacion> iter = rangoExplosion.iterator();
			while (iter.hasNext()) {
				ubic = iter.next();
				if ((obj = conjuntoEntidades.get(ubic)) != null) {
					if (obj.getClass().getSimpleName().equals("Bomba") == true) {
						Bomba aux = (Bomba) obj;
						aux.explotar();
					} else {
						if (obj.verSiEsVisible()) {
							conjuntoEntidades.remove(ubic);
							iter.remove();
						}
					}

				}
			}
			iter = rangoExplosion.iterator();
			while (iter.hasNext()) {
				ubic = iter.next();
				if (ubic.equals(listaBomberman[0].obtenerUbicacion()) == true) {
					listaBomberman[0].morir();
				}
				if (ubic.equals(listaBomberman[1].obtenerUbicacion()) == true) {
					listaBomberman[1].morir();
				}
			}
		} else
			System.out.println("El objeto no puede explotar porque no es una bomba");
	}

	private List<Ubicacion> generarRangoExplosion(Ubicacion ubicBomba) {
		List<Ubicacion> aux = new ArrayList<Ubicacion>();
		aux.add(ubicBomba);
		if (ubicBomba.getPosX() + 1 < ANCHO)
			aux.add(new Ubicacion(ubicBomba.getPosX() + 1, ubicBomba.getPosY()));
		if (ubicBomba.getPosY() + 1 < ALTO)
			aux.add(new Ubicacion(ubicBomba.getPosX(), ubicBomba.getPosY() + 1));
		if (ubicBomba.getPosX() - 1 >= 0)
			aux.add(new Ubicacion(ubicBomba.getPosX() - 1, ubicBomba.getPosY()));
		if (ubicBomba.getPosY() - 1 >= 0)
			aux.add(new Ubicacion(ubicBomba.getPosX(), ubicBomba.getPosY() - 1));

		return aux;
	}

	public void agregarBomba(Ubicacion miUbicacion) {
		conjuntoEntidades.put(miUbicacion, new Bomba(miUbicacion));

	}

	public void mostrarMapa() {
		Ubicacion ver;
		Iterator<Ubicacion> it = conjuntoEntidades.keySet().iterator();
		int calculo, i = 1;
		while (it.hasNext()) {
			ver = it.next();
			calculo = ver.posX * ANCHO + ver.posY + 1;
			for (; i < calculo; i++) {
				System.out.printf("NULO\t");
				if (i != 0 && i % ANCHO == 0)
					System.out.println();
			}
			System.out.printf("%s\t", conjuntoEntidades.get(ver).getClass().getSimpleName().substring(0, 4));
			if (i != 0 && i % ANCHO == 0)
				System.out.println();
			i++;
		}
		i--;
		for (; i < (ANCHO * ALTO); i++) {
			if (i != 0 && i % ANCHO == 0)
				System.out.println();
			System.out.printf("NULO\t");
		}
		System.out.println();
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

	public void agregarBombermans(Bomberman[] lista) {
		listaBomberman = lista;
	}
}
