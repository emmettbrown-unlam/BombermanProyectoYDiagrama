package mapa.y.objetos;

import java.util.Map;

public class Bomba extends Entidad {
	private static int nroBomba = 0;
	private int idBomba;
	private int segsExplosion;
	private int rango ;

	public Bomba(final int posIniX, final int posIniY) {
		super(posIniX, posIniY);
		idBomba = nroBomba;
		nroBomba++;
		segsExplosion = 3;
		this.destructible = true;
		this.rango = 2;
	}

	public Bomba(Ubicacion miUbicacion) {
		super(miUbicacion);
		idBomba = nroBomba;
		nroBomba++;
		segsExplosion = 3;
	}

	public void explotar(Mapa m) {
		Ubicacion uBomba = this.ubicacion.clone();
		Bomberman[] listaBomb = m.obtenerBombermans();
		Map<Ubicacion,Entidad> listaEnt = m.obtenerListaEntidades();
		int posX = uBomba.getPosX();
		for (int i = posX ; i < Mapa.ANCHO; i++) {
			Entidad e = listaEnt.get(new Ubicacion(i,uBomba.getPosY()));
			if ( e != null && e.destructible && (i - posX ) <= this.rango) {
				listaEnt.remove(new Ubicacion(i,uBomba.getPosY()));
			}else if(!e.destructible && e != null && (i - posX ) <= this.rango) {
				break;
			}
			
			for (int j = 0; j < listaBomb.length; j++) {
				if (listaBomb[j].ubicacion.equals(new Ubicacion(i,uBomba.getPosY()))) {
					
				}
			}
		}
		
		
		
//		for (int i = 0; i < listaBomb.length; i++) {
//			if (listaBomb[i].obtenerUbicacion().equals(uBomba) == true)
//				listaBomb[i].morir();
//		}
//		if (uBomba.getPosX() < Mapa.ANCHO - 1) {
//			uBomba.cambiarPosX(1);
//			if(listaEnt.get(uBomba) == null)
//			for (int i = 0; i < listaBomb.length; i++) {
//				if (listaBomb[i].obtenerUbicacion().equals(uBomba) == true)
//					listaBomb[i].morir();
//			
//					
//			}
//		}

//		if(m.)
		m.eliminarBomba(this.ubicacion);
		this.esVisible = false;
		System.out.println("BUM, la bomba " + idBomba + " Exploto");
	}
}
