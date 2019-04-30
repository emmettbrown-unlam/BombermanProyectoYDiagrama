package mapa.y.objetos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class testBomberman {

	@Test
	public void seMueveElBombermanAbajo() {
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(0, 0, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].moverAbajo();
		listaBomb[0].moverAbajo();
		listaBomb[0].moverAbajo();
		listaBomb[0].moverAbajo();
		Ubicacion expected = new Ubicacion(0,4);
		Ubicacion actual = listaBomb[0].obtenerUbicacion();
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void seMueveElBombermanArriba() {
		System.out.println();
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(0,4, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].moverArriba();
		listaBomb[0].moverArriba();
		listaBomb[0].moverArriba();
		listaBomb[0].moverArriba();
		Ubicacion expected = new Ubicacion(0,0);
		Ubicacion actual = listaBomb[0].obtenerUbicacion();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void seMueveElBombermanDer() {
		System.out.println();
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(0,4, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].moverADerecha();
		listaBomb[0].moverADerecha();
		listaBomb[0].moverADerecha();
		listaBomb[0].moverADerecha();
		Ubicacion expected = new Ubicacion(4,4);
		Ubicacion actual = listaBomb[0].obtenerUbicacion();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void seMueveElBombermanIzq() {
		System.out.println();
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(4,4, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].moverAIzquierda();
		listaBomb[0].moverAIzquierda();
		listaBomb[0].moverAIzquierda();
		listaBomb[0].moverAIzquierda();
		Ubicacion expected = new Ubicacion(0,4);
		Ubicacion actual = listaBomb[0].obtenerUbicacion();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void queColisionaMapaObstaculos() {
		Mapa m = new Mapa();
		Bomberman[] listaBomb = new Bomberman[1];
		listaBomb[0] = new Bomberman(0,0, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].moverAbajo();
		Ubicacion expected = new Ubicacion(0,0);
		Ubicacion actual = listaBomb[0].obtenerUbicacion();
		Assert.assertEquals(expected, actual);
		
	}
}
