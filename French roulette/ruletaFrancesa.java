
import java.util.Random;
import java.util.Scanner;
public class RuletaFrancesa {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int fichas=1,ganancias=0,tipoApuesta=0, repeticion=0;
		/*llamada a las funciones*/
		fichas=fichasIniciales();
		do {
		/*pide apuesta al usuario*/
		int fichasApostadas=fichasApostadas(fichas);
		fichas-=fichasApostadas;
		
		/*me retorna las ganancias según la apuesta*/
		tipoApuesta=selectorApuesta();
		
		switch(tipoApuesta)
		{
		case 1:ganancias=rojoNegro(fichasApostadas);break;
		case 2:ganancias=imparPar(fichasApostadas);break;
		case 3:ganancias=columnas(fichasApostadas);break;
		case 4:ganancias=passeManque(fichasApostadas);break;
		case 5:ganancias=numeroApuesta(fichasApostadas);break;
		default:System.out.println("Solo opciones válidas [1-6]");selectorApuesta();break;
		}
		mensajeGanancias(ganancias);
		if (ganancias<0)/*pongo las ganancias negativas para clasificar la tirada como 0*/
		{
		fichas+=fichasApostadas;
		}
		else 
		{
			if(ganancias>0)
			{
				fichas=fichas+fichasApostadas+ganancias;
			}
		}
		/*mensaje de bancarrota*/
		if(fichas<=0) {System.out.println("Lo sentimos, debe abandonar la sala");break;}
		/*mensaje de repeticion*/
		System.out.println("¿Desea jugar otra partida (escriba 1 para Si o 2 para No)?");
		repeticion=sc.nextInt();
		
		}while(repeticion!=2);
		
		if(repeticion==2) {System.out.println("Gracias por jugar. Vulva cuando quiera");}}
	
	/*cálculo del número que saca la ruleta*/
	public static int numeroRuleta()
	{
		System.out.println("¡No va mas! \n \n la ruleta está girando\n");
	/*simula tiempo de espera de la ruleta al girar para darle emoción*/
		for(int i=1;i<=6;i++)
		{
			switch(i)
			{
			case 1:System.out.print("S  ");break;
			case 2:System.out.print("U  ");break;
			case 3:System.out.print("E  ");break;
			case 4:System.out.print("R  ");break;
			case 5:System.out.print("T  ");break;
			case 6:System.out.print("E \n\n");break;
			}try {Thread.sleep (1000);} catch (Exception e) {System.out.println("Algo salió mal");}
		}
		Random rnd = new Random( System.currentTimeMillis() );
		int numeroRuleta= (rnd.nextInt( 36 ) );System.out.print("¡¡Salió el "+numeroRuleta+ "!!");
		
		return numeroRuleta;
		
		
	}
	public static int fichasIniciales()
	{	
		Scanner sc=new Scanner(System.in);
		System.out.println("    ***Bienvenido al casino*** \n\n ¿Qué cantidad desea cambiar en fichas?");
		int fichasIniciales=sc.nextInt();
		/*check de cantidad*/
		while(fichasIniciales<=0) {System.out.println("La cantidad ha de ser mayor que 0");fichasIniciales=sc.nextInt();}
		return fichasIniciales;
		
	}
	public static int calculoGanancias(int numeroPosibilidades, int numeroApuestas)
	{	
		int multiplicarPorEurosApostados=(numeroPosibilidades-1)*numeroApuestas;
		return multiplicarPorEurosApostados;
	}
	
	/*menu de tipo de apuesta*/
	public static int selectorApuesta()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" Hagan sus apuestas\n\n seleccione el tipo de apuesta \n\n"
				+ " Rojo o Negro---Pulse 1 \n Par o Impar---Pulse 2 \n Columna---Pulse 3 \n "
				+ "Passe o Manque---pulse 4 \n Acertar número---Pulse 5");
		int respuesta=sc.nextInt();
		return respuesta;
	}
	public static int fichasApostadas(int fichas)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("¿Cuánto quiere apostar en esta tirada? (recuerde que tiene "+fichas+" euros)");
		int fichasApostadas=sc.nextInt();
		while(fichasApostadas>fichas || fichasApostadas<=0) {System.out.println("la cantidad no puede exceder a su cantidad total ni ser negativa");fichasApostadas=sc.nextInt();}
		return fichasApostadas;
	}
	/*empiezan aqui los retornos de cada apuesta*/
	public static int rojoNegro (int fichasApostadas)
	{
		Scanner sc=new Scanner(System.in);
		int ganancia=0;
		int colorUsuario=3;
		System.out.println("Apueste escribiendo rojo o negro");
		String respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();
		switch(respuesta)
		{
		case "ROJO":System.out.println("Apuesta rojo");colorUsuario=1;break;
		case "NEGRO":System.out.println("Apuesta negro");colorUsuario=2;break;
		default:System.out.println("solo negro o rojo");respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();break;
		}
		int numero=numeroRuleta();int colorRuleta=colorNumero(numero);
		if (numero==0) 
		{	
			ganancia=-1;System.out.println("El 0 ni hace ganar ni hace perder");
				
		}
		else {if(colorUsuario==colorRuleta) {ganancia=calculoGanancias(2, 1);}}
		return ganancia*fichasApostadas;
	}
	public static int imparPar(int fichasApostadas)
	{
		Scanner sc=new Scanner(System.in);
		int paridadUsuario=3,ganancia=0;
		System.out.println("Apueste escribiendo par o impar");
		String respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();
		switch(respuesta)
		{
		case "IMPAR":System.out.println("Apuesta impar");paridadUsuario=1;break;
		case "PAR":System.out.println("Apuesta par");paridadUsuario=2;break;
		default:System.out.println("solo par o impar");respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();
		}int numero=numeroRuleta();int paridadRuleta=numeroParImpar(numero);
		
				if(paridadUsuario==paridadRuleta){ganancia=calculoGanancias(2, 1);}
				
		return ganancia*fichasApostadas;
		
		
	}
	public static int passeManque(int fichasApostadas)
	{
		Scanner sc=new Scanner(System.in);
		int passeManqueUsuario=0,ganancia=0;
		System.out.println("Apueste escribiendo Passe o Manque");
		String respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();
		switch(respuesta)
		{
		case "MANQUE":System.out.println("Apuesta Manque");passeManqueUsuario=2;break;
		case "PASSE":System.out.println("Apuesta Passe");passeManqueUsuario=1;break;
		default:System.out.println("solo Passe o Manque");respuesta=sc.nextLine();respuesta=respuesta.toUpperCase();
		}int numero=numeroRuleta();int passeRuleta=passeRuleta(numero);
		if (numero==0)
		{
		ganancia=-1;System.out.println("El 0 hace que ni gane ni pierda");
		}
		else 
			{
		if(passeRuleta==passeManqueUsuario ) {ganancia=calculoGanancias(2, 1);}
			}
		return ganancia*fichasApostadas;
	}
	public static int columnas(int fichasApostadas)
	{
		Scanner sc=new Scanner(System.in);
		int columnasUsuario=0,ganancias=0;
		System.out.println("Apueste escribiendo el número de columna a la que apuesta");
		columnasUsuario=sc.nextInt();
		switch(columnasUsuario)
		{
		case 1:System.out.println("Apuesta a la columna 1");columnasUsuario=1;break;
		case 2:System.out.println("Apuesta a la columna 2");columnasUsuario=2;break;
		case 3:System.out.println("Apuesta a la columna 3");columnasUsuario=3;break;
		default:System.out.println("solo columnas 1, 2 o 3");columnasUsuario=sc.nextInt();
		}
		int numero=numeroRuleta();int columnaRuleta=columnasRuleta(numero);
		if (numero==0)
		{
		ganancias=-1;System.out.println("El 0 hace que ni gane ni pierda");}
			{
		if(columnasUsuario==columnaRuleta) {ganancias=calculoGanancias(3, 1);}
			}
		return ganancias*fichasApostadas;
	}
	public static int numeroApuesta(int fichasApostadas)
	{
		Scanner sc=new Scanner(System.in);
		int ganancias=0;
		System.out.println(" Introduzca el número al que apuesta ");
		int numeroUsuario=sc.nextInt();
		while (numeroUsuario<=0 || numeroUsuario>36) {System.out.println("del 1 al 36 por favor");numeroUsuario=sc.nextInt();}
		int numeroRuleta=numeroRuleta();
		if (numeroRuleta==0)
		{
		ganancias=-1;
		}else 
			{
		if (numeroUsuario==numeroRuleta) {ganancias=calculoGanancias(36, 1);}
			}
		return ganancias*fichasApostadas;
		}
	public static void mensajeDespedida()
	{
		System.out.println("Gracias por jugar. Vuelva cuando quiera");
	}
	/*categorizacion del numero de la ruleta*/
	public static int colorNumero (int numeroRuleta)
	{
		int color=3;
		if (numeroRuleta==0) {System.out.println(",Ni rojo ni negro");color=0;}
		else {
		if(numeroRuleta==1||numeroRuleta==3||numeroRuleta==5||
				numeroRuleta==7||numeroRuleta==9||numeroRuleta==12||numeroRuleta==14
				||numeroRuleta==16||numeroRuleta==18||numeroRuleta==21||numeroRuleta==23||
				numeroRuleta==25||numeroRuleta==27||numeroRuleta==30||
				numeroRuleta==32||numeroRuleta==34||numeroRuleta==36) {
			System.out.print(" ROJO ");color=1;}else{System.out.print(" NEGRO ");color=2;}
		}
		
		return color;
				
		}
	public static int numeroParImpar(int numeroRuleta)
	{	int parImpar=3;
		if (numeroRuleta==0){System.out.println("el 0 no es par ni impar.");parImpar=0;}
		else 
		{
			if (numeroRuleta%2==0) {System.out.println(" PAR ");parImpar=2;}else {System.out.println(" IMPAR ");parImpar=1;}
			
		}return parImpar;
	}
	public static int columnasRuleta(int numeroRuleta)
	{
		int columna=0;
		if (numeroRuleta==1||numeroRuleta==4||numeroRuleta==7||numeroRuleta==10||numeroRuleta==
				13||numeroRuleta==16||numeroRuleta==19||numeroRuleta==22||numeroRuleta==25
						||numeroRuleta==28||numeroRuleta==31||numeroRuleta==34) {
			System.out.println(" columna 1 ");columna=1;
			}
		else if(numeroRuleta==2||numeroRuleta==5||numeroRuleta==8||numeroRuleta==11||numeroRuleta==14
				||numeroRuleta==17||numeroRuleta==20||numeroRuleta==23||numeroRuleta==26||numeroRuleta==29
				||numeroRuleta==32||numeroRuleta==35) {
			System.out.println(" columna 2 ");columna=2;
			}
		
		else if(numeroRuleta==3||numeroRuleta==6||numeroRuleta==9||numeroRuleta==12||numeroRuleta==15||numeroRuleta==18
				||numeroRuleta==21||numeroRuleta==24||numeroRuleta==27||numeroRuleta==30||numeroRuleta==33
				||numeroRuleta==36)
				{System.out.println(" columna 3 ");columna=3;
				}
				return columna;
	}
	public static int passeRuleta(int numeroRuleta)
	{	int passe=0;
		if (numeroRuleta>=1 && numeroRuleta<=18) {System.out.println("PASSE");passe=1;}
		else{System.out.println("MANQUE");passe=2;}
		return passe;
	}
	public static void mensajeGanancias(int ganancias)
	{	
		if (ganancias>0) {System.out.println("Enhorabuena.Ha ganando "+ganancias+" euros");}
		else {if (ganancias==0) {System.out.println("Lo sentimos. Ha perdido");}
		else{System.out.println("Ni gana ni pierde");}}
	}
}
