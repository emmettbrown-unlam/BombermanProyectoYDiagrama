package mapa.y.objetos;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBomba {

	@Before
	public void separacionAntes() {
		System.out.println("-----------------------------------------------");
	}

	@After
	public void separacionDespues() {
		System.out.println("-----------------------------------------------");
	}
	
	
	@Test
	public void queBombaMataBomberman() {
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[1];
		listaBomb[0] = new Bomberman(2, 2, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].ponerBomba();
		listaBomb[0].moverAIzquierda();
		m.explotarBomba(2,2);
		Assert.assertEquals(false,listaBomb[0].verSiEsVisible());
	}
	
	@Test
	public void queBombaMataBombermans() {
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		listaBomb[0] = new Bomberman(2, 2, m);
		listaBomb[1] = new Bomberman(1, 2, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].ponerBomba();
		listaBomb[0].moverADerecha();
		m.explotarBomba(2,2);
		Assert.assertEquals(false,listaBomb[0].verSiEsVisible());
		Assert.assertEquals(false,listaBomb[1].verSiEsVisible());
	}

	@Test
	public void queExplotaEnCadena() {
		Mapa m = new Mapa(1);
		Bomberman[] listaBomb = new Bomberman[2];
		
		listaBomb[1] = new Bomberman(1, 2, m);
		listaBomb[0] = new Bomberman(2, 2, m);
		m.agregarBombermans(listaBomb);
		listaBomb[0].ponerBomba();
		listaBomb[0].moverADerecha();
		listaBomb[0].ponerBomba();
		listaBomb[0].moverArriba();
		listaBomb[0].ponerBomba();
		listaBomb[0].moverADerecha();

		m.explotarBomba(2,2);
		Assert.assertEquals(false,listaBomb[0].verSiEsVisible());
		Assert.assertEquals(false,listaBomb[1].verSiEsVisible());
	}
	
	@Test
	public void queExplotaObstaculos() {
		Mapa m = new Mapa();
		Bomba b = new Bomba(new Ubicacion (0,0));
		m.agregarBomba(b.ubicacion);
		
		m.explotarBomba(0,0);
		Assert.assertEquals(true, m.estaLibre(new Ubicacion(0,1)));
	}
	
	@Test
	public void queNoPuedeExplotaMuros() {
		Mapa m = new Mapa();
		Bomba b = new Bomba(new Ubicacion (1,0));
		m.agregarBomba(b.ubicacion);
		
		m.explotarBomba(1,0);
		Assert.assertEquals(false, m.estaLibre(new Ubicacion(1,1)));
	}
	

}
