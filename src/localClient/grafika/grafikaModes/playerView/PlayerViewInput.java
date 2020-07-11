package localClient.grafika.grafikaModes.playerView;

import localClient.ClientThread;
import localClient.Dati;
import localClient.grafika.grafikaParts.InputActions;
import server.calculations.CalculationsThread;

public class PlayerViewInput extends InputActions {

    @Override
    public void headerButtonActions(int reference, ClientThread thread){
        switch (reference) {
            case 1 -> thread.dati.modeCurrent = Dati.ModeOption.spectate;
            case 2 -> thread.dati.modeCurrent = Dati.ModeOption.lobby;

            default -> System.out.println("ServerUIThread PlayerViewHeader režistrÁts nedefinÁtas pogas notikums!");
        }
    }

    @Override
    public void footerButtonActions(int reference, ClientThread thread){

        switch (reference) {
            case 1 -> CalculationsThread.pauze = !CalculationsThread.pauze;

            default -> System.out.println("ServerUIThread PlayerViewFooter režistrÁts nedefinÁtas pogas notikums!");
        }
    }

    @Override
    public void leftButtonActions(int reference, ClientThread thread){
        switch (reference) {
            case 1 -> System.out.println("PlayerView mode left panel button 1");
            case 2 -> System.out.println("PlayerView mode left panel button 2");
            case 3 -> System.out.println("PlayerView mode left panel button 3");

            default -> System.out.println("ServerUIThread PlayerViewLeftPanel režistrÁts nedefinÁtas pogas notikums!");
        }
    }

    @Override
    public void rightButtonActions(int reference, ClientThread thread){
        switch (reference) {
            case 1 -> System.out.println("PlayerView mode right panel button 1");
            case 2 -> System.out.println("PlayerView mode right panel button 2");
            case 3 -> System.out.println("PlayerView mode right panel button 3");

            default -> System.out.println("ServerUIThread PlayerViewRightPanel režistrÁts nedefinÁtas pogas notikums!");
        }
    }

}
