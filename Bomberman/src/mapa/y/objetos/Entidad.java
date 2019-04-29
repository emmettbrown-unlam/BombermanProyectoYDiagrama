package mapa.y.objetos;

public class Entidad {
	protected Ubicacion ubicacion;
	protected boolean esVisible;
	
	
	public Entidad(final int posX,final int posY)
	{
		this.ubicacion = new Ubicacion(posX,posY);
		this.esVisible = true;
	}
	
	public Entidad(Ubicacion ubicacionAct)
	{
		this.ubicacion = ubicacionAct;
		this.esVisible = true;
	}
	
	public boolean verSiEsVisible() {
		return this.esVisible;
	}
	
	public void cambiarVisibilidad() {
		esVisible = !esVisible;
	}
}
