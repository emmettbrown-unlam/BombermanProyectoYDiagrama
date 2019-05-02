package mapa.y.objetos;

import org.junit.Assert;
import org.junit.Test;

public class testMapa {
	@Test
	public void mapaConObstaculos() {
		Mapa m = new Mapa();
		Assert.assertEquals(false,m.estaLibre(new Ubicacion(1,1)));
	}
	
	@Test
	public void mapaSinObstaculos() {
		Mapa m = new Mapa(1);
		Assert.assertEquals(true,m.estaLibre(new Ubicacion(1,1)));
	}
	@Test
	public void mapaSiEstaLibrePosicion() {
		Mapa m = new Mapa();
		Assert.assertEquals(false,m.estaLibre(new Ubicacion(1,1)));
		Assert.assertEquals(true,m.estaLibre(new Ubicacion(0,0)));
		Assert.assertEquals(false,m.estaLibre(new Ubicacion(3,3)));
	}

}
