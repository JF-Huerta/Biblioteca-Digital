package dao;

public class PruebConexion {

	public static void main(String[] args) {
		ConexionBD bd = ConexionBD.getInstancia();

		if (bd.getConexion() != null) {
		    System.out.println("TODO FUNCIONA 🎉");
		} else {
		    System.out.println("NO SE PUDO CONECTAR");
		}

	}

}
