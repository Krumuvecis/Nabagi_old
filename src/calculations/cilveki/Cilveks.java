package calculations.cilveki;

import java.util.ArrayList;

import calculations.Main;
import calculations.lietas.Lieta;

public class Cilveks {
	
	public static int maxCilveks=0; //numer�cija v�rdu do�anai
	
	
	public String vards;
	public Koord xyz = new Koord(); // (x,y,v,fi) - visi double
	
	//prim�rie parametri
	public double vmax;
	public double ommax;
	public double hp;
	public double hpmax;
	
	public double paika;
	public double paikaMax;
	public double paikaMin;
	
	//sensorie parametri
	public double R1, R2; //redzesloks
	
	//c��as parametri
	public ArrayList<Lieta> inventory = new ArrayList<Lieta>();
	public ArrayList<Orderis> orderi = new ArrayList<Orderis>(); // (prece,perk(boolean),cena)
	//public ArrayList<Orderis> atminas = new ArrayList<Orderis>(); //atmi�as par tirdzniec�bas cen�m
	
	public double brunas;
	public double stiprums;
	public double gataviba;
	public double drosme;
	public String komanda;
	public int[] rangs; //0[x]-(zemnieki/amatnieki)&tirgo�i, 					1[x]-valdnieki&karot�ji
						
						//0,0-nabags - lasa �ener�tos objektus / str�d�			1,0 -apsargs - sarg� fermas un citus objektus
						//0,1-zemnieks - var uzb�v�t fermu 						1,1 -karot�js - staig� ap pili
						//0,2-tirgot�js	- iep�rk resursus un p�rdod kur vajag	1,2 -gvarde - staig� pil�/sarg� karali
						//0,3-ra�ot�js - iep�rk resursus un no tiem ra�o  citus	1,3 -dedicated karalis - dod visiem drosmi?
	
	//anim�cijai un testiem
	public String darbiba;
	
	
	public static Cilveks getPlayer(int[] chunkXY, int i){
		return Main.laukums.get(chunkXY[0]).get(chunkXY[1]).cilvekiList.get(i);
	}
	
}
