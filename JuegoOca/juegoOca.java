import java.util.Scanner;
public class JuegoOca {

	public static void main(String[] args) {
		char casilla;
		int directorJugadas=0;/*dirige las tiradas para marcar turnos y quién tira*/
		int jugador=0;
		int computer=0;
		int tirada=0;
		int array[]=new int[2];
		while (pregunta()=='S') {
			System.out.println("casilla jugador "+jugador);
			System.out.println("casilla computer "+computer);
		tirada=tirada(directorJugadas);
		//asigna valor tirada a jugador o a maquina
			if (directorJugadas%2==0) {
				jugador+=tirada;
				System.out.println("vaya a la casilla "+ jugador);
				casilla=tablero(jugador);
				array=accionCasilla(casilla,jugador);
				jugador+=array[0];
				jugador=(jugador>62)?62:jugador;
				
			}
			else {
				computer+=tirada;
				casilla=tablero(computer);
				System.out.println("Voy a la casilla "+computer);
				array=accionCasilla(casilla,computer);
				computer+=array[0];
				computer=(computer>62)?62:computer;
			}
			if(array[0]==-1) {
				break;
			}
			
		directorJugadas+=array[1];
		directorJugadas++;
		}//final while ppal
		System.out.println("Hasta otra!!");
		
		
		
	}
	
	public static char pregunta() {
		Scanner sc=new Scanner(System.in);
		System.out.println("¿Quieres jugar un turno? S o N");
		char respuesta=sc.next().charAt(0);
		return  java.lang.Character.toUpperCase(respuesta);
	}
	/*obtengo numero dado*/
	public static int tirarDado() {
		int aleatorio=0;
		System.out.println("A ver qué sale...");
		for (int i=0;i<15;i++) {
				aleatorio=(int)Math.floor(Math.random()* (1-(6+1))+(6+1));
				System.out.print(aleatorio+" ");
				try {
					Thread.sleep (250);} catch (Exception e) {System.out.print("Algo salió mal");
					}
				
			}
		System.out.println("Salió "+aleatorio);
		return aleatorio;
	}
	/*tirada del jugador*/
	public static int tiradaPlayer() {
		int tirada=0;
		System.out.println("Buena tirada!");
		tirada=tirarDado();
		return tirada;
	}
	/*tirada de la máquina*/
	public static int tiradaComputer() {
		System.out.println("Ahora voy yo ");
		int tirada=0;
		tirada=tirarDado();
		return tirada;
	}
	/*determina el turno de la tirada*/
	public static int tirada(int contador) {
		int tirada=0;
		if(contador%2==0) {
			tirada=tiradaPlayer();
		}
		else {
			tirada=tiradaComputer();
		}return tirada;
	}
	/*indica tipo de casilla en el que caemos*/
	public static char tablero(int numeroCasilla) {
		String tablero= "SNNNOPNNONNPNONNNOINNNONNDONNNNONNNNONNNNOLNNONNNNONNCDONNNMONNNF";
		return tablero.charAt(numeroCasilla);
	}
	/*según donde caigamos pasa una u otra cosa*/
	public static int[] accionCasilla(char casilla, int numCasilla){
		int array[]=new int[2];
		String msg="hay que ir a la casilla ";
		int nuevaCasilla=0;
		int contador=0;
		if (casilla=='S') {
			System.out.println("empezamos");
		}
		
		else if (casilla=='N') {
			System.out.println("buena jugada");
		}
		
		else if(casilla=='O') {
			System.out.println("De oca a oca y tiro porque me toca");
			contador=-1;
			int casosOca[]= {5,9,14,18,23,27,32,36,41,45,50,54,59};
				for (int i=0;i<casosOca.length-1;i++) {
					if(numCasilla==casosOca[i]) {
						System.out.println(msg+ (i+1));
						nuevaCasilla=casosOca[i+1]-casosOca[i];
					}
					else if(numCasilla==59) {
						System.out.println("Enhorabuena. Has ganado!!");
						nuevaCasilla=3;
						}
				}
		}	
		else if(casilla=='P') {
			System.out.println("Puente");
			if(numCasilla==12) {
				System.out.println(msg+ " 6 ");
				nuevaCasilla=-6;
			}
			else {
				System.out.println(msg +" 12 ");
				nuevaCasilla=6;
			}
		}
		else if(casilla=='D') {
			System.out.println("Casilla dado. Vuelves a tirar");
			contador--;
		}
		else if(casilla=='L') {
			System.out.println("Laberinto. Pierdes un turno");
			contador++;
		}
		else if(casilla=='I') {
			System.out.println("Descansa un turno en la posada");
			contador++;
		}
		else if(casilla=='C') {
			System.out.println("Caes en la carcel. Espera 1 turno");
			contador++;
		}
		else if(casilla=='M') {
			System.out.println("La muerte es el final de la partida");
			nuevaCasilla=-1;//este caso es la muerte
		}
		else if(casilla=='F') {
			System.out.println("Tenemos ganador!!!");
			nuevaCasilla=-1;
		}
		
				array[0]=nuevaCasilla;//se lo incremento al contador de jugador/maquina
				array[1]=contador;	//se lo incremento a directorJugadas
				return array;
}
}
