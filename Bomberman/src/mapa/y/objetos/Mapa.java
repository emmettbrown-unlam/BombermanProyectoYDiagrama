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
		conjuntoEntidades.put(new Ubicacion(1, 1), new Muro(1, 1));
		conjuntoEntidades.put(new Ubicacion(3, 3), new Muro(3, 3));
		conjuntoEntidades.put(new Ubicacion(1, 3), new Muro(1, 3));
		conjuntoEntidades.put(new Ubicacion(3, 1), new Muro(3, 1));
		conjuntoEntidades.put(new Ubicacion(0, 1), new Obstaculo(0, 1));
	}

	public Mapa(int obs) {
	}

	public Map<Ubicacion, Entidad> obtenerListaEntidades() {
		return conjuntoEntidades;
	}

//	void explotarBomba(int posX, int posY) {
//		Ubicacion ubic = new Ubicacion(posX, posY);
//		Entidad obj = conjuntoEntidades.get(ubic);
//		if (obj != null && obj.getClass().getSimpleName().equals("Bomba")) {
//			Bomba exp = (Bomba) obj;
//			exp.explotar(this);
//			conjuntoEntidades.remove(ubic);
//			rangoExplosion = generarRangoExplosion(ubic);
//			Iterator<Ubicacion> iter = rangoExplosion.iterator();
//			while (iter.hasNext()) {
//				ubic = iter.next();
//				if ((obj = conjuntoEntidades.get(ubic)) != null) {
//					if (obj.getClass().getSimpleName().equals("Bomba") == true) {
//						Bomba aux = (Bomba) obj;
//						aux.explotar(this);
//					} else {
//						if (obj.verSiEsVisible()) {
//							conjuntoEntidades.remove(ubic);
//							iter.remove();
//						}
//					}
//
//				}
//			}
//			iter = rangoExplosion.iterator();
//			while (iter.hasNext()) {
//				ubic = iter.next();
//				if (ubic.equals(listaBomberman[0].obtenerUbicacion()) == true) {
//					listaBomberman[0].morir();
//				}
//				if (ubic.equals(listaBomberman[1].obtenerUbicacion()) == true) {
//					listaBomberman[1].morir();
//				}
//			}
//		} else
//			System.out.println("El objeto no puede explotar porque no es una bomba");

//	}

//	private List<Ubicacion> generarRangoExplosion(Ubicacion ubicBomba) {
//		List<Ubicacion> aux = new ArrayList<Ubicacion>();
//		aux.add(ubicBomba);
//		if (ubicBomba.getPosX() + 1 < ANCHO)
//			aux.add(new Ubicacion(ubicBomba.getPosX() + 1, ubicBomba.getPosY()));
//		if (ubicBomba.getPosY() + 1 < ALTO)
//			aux.add(new Ubicacion(ubicBomba.getPosX(), ubicBomba.getPosY() + 1));
//		if (ubicBomba.getPosX() - 1 >= 0)
//			aux.add(new Ubicacion(ubicBomba.getPosX() - 1, ubicBomba.getPosY()));
//		if (ubicBomba.getPosY() - 1 >= 0)
//			aux.add(new Ubicacion(ubicBomba.getPosX(), ubicBomba.getPosY() - 1));
//
//		return aux;
//	}
//
	public void agregarBomba(Ubicacion miUbicacion) {
		Ubicacion copia = miUbicacion.clone();
		conjuntoEntidades.put(copia, new Bomba(copia));

	}

	public void mostrarMapa() {
		Ubicacion ver;
		Iterator<Ubicacion> it = conjuntoEntidades.keySet().iterator();
		int calculo, i = 1;
		while (it.hasNext()) {
			ver = it.next();
			calculo = ver.getPosX() * ANCHO + ver.getPosY() + 1;
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
		if (conjuntoEntidades.get(miUbicacion) == null) {
			return true;
		}
		return false;
	}

	public void agregarBombermans(Bomberman[] lista) {
		listaBomberman = lista;
	}

	public void eliminarBomba(Ubicacion ubicacion) {
		conjuntoEntidades.remove(ubicacion);
	}

	public Bomberman[] obtenerBombermans() {
		return listaBomberman;
	}
	
	public void explotarBomba(Ubicacion u) {
		Bomba b =((Bomba)conjuntoEntidades.get(u));
		b.explotar(this);
		
	}
}
