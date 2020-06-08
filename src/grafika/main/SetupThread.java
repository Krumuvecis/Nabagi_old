package grafika.main;

import calculations.KonstantesUniversal;
import calculations.lietas.LietuPreseti;

public class SetupThread implements Runnable{
	private static Thread thread;
	private static String threadName;
	public boolean running, minimized, windowActive;
	
	public Dati dati;
	protected Grafika grafika;
	protected Input input;
	
	
	public void start() {
		dati = new Dati();
		dati.initialize(); //z�m��ana var b�t atkar�ga no datiem
		
		int maxFrameRate=50; //kadri sekund�
		dati.calculationTimeCalculator.delayMin=1000/maxFrameRate; //simul�cijas solis
		
		threadName=dati.windowTitle;
		thread = new Thread(this, threadName);
		running = true;
		minimized = false;
		windowActive = true;
		
		grafika = new Grafika();
		grafika.initialize(this); //z�m��ana
		
		input = new Input();
		input.initialize(this); //nav j�z�m�, t�p�c p�c grafikas
		
		
		thread.start();
	}

	@Override
	public void run() {
		
		while (running) {
			dati.calculationTimeCalculator.time(true);

			if (!minimized) {
				dati.update();
				
				userInput();
				
				if (windowActive) {} //apr��ini
				
				grafika.main(this); //tikai z�m��ana, nek�di apr��ini
			}
			
			dati.calculationTimeCalculator.time(false);
			try{
				Thread.sleep(dati.calculationTimeCalculator.sleepT());
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		grafika.ekrans.dispose();
		System.out.println("thread finished");
		
	}

	private void userInput() {

		buttonActions(); //uz ekr�na redzamo pogu notikumi
		keyboardActions(); //keyboard nospiesto pogu notikumi

	}

	private void buttonActions() {
		
		for (int i=0; i<dati.buttonList.size();i++) {
			
			dati.buttonList.get(i).actions(this); //p�rbauda katras pogas statusu
			
			if (dati.buttonList.get(i).result) { //ja poga nostr�d�jusi
				
				buttonActionsSpecific(i);
				
				dati.buttonList.get(i).result=false; //reseto pogas statusu
			}
		}
	}

	private void buttonActionsSpecific(int i){
		if (i==0) { //pirm� poga
			calculations.Main.pauze=!calculations.Main.pauze;

		} else if (i==1) { //otr� poga
			dati.startPlayerView(false);

		} else if (i==2) { //tre�� poga
			dati.startPlayerView(true);

		} else if (i==3) { //ceturt� poga
			dati.tablo1Draw=!dati.tablo1Draw;

		} else if (i==4) { //piekt� poga
			dati.tablo2Draw=!dati.tablo2Draw;

		} else if (i==5) { //sest� poga
			dati.miniMapDraw=!dati.miniMapDraw;

		} else if (i==6) { //sept�t� poga
			dati.inputPanelDraw=!dati.inputPanelDraw;

		} else if (i==7) { //astot� poga
			dati.colorPanelDraw=!dati.colorPanelDraw;

		} else if (i==8) { //dev�t� poga
			KonstantesUniversal.overallGenRate+=0.01;

		} else if (i==9) { //desmit� poga
			KonstantesUniversal.overallGenRate-=0.01;

		}
	}

	private void keyboardActions(){
		//te var nolas�t piespiest�s keyboard pogas notikumiem
		//piem�ram ja pogas[i]==xx notiek kaut kas - piem�ram main.cilvekuList.cilveks.darbibas.kautkas
		//	vai focusfind=player+1, zoom++ / zoom--

//		for (int i=0; i<input.pogas.length;i++) {
//
//			//dati.buttonList.get(i).actions(this); //p�rbauda katras pogas statusu
//
//			if (result) { //ja poga nostr�d�jusi
//
//				keyboardActionsSpecific(i);
//
//				result=false; //reseto pogas statusu
//			}
//		}

	}
	
	
}
