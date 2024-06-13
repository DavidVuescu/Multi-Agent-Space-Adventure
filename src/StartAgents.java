import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartAgents {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        AgentContainer mainContainer = rt.createMainContainer(p);

        try {
            AgentController mc = mainContainer.createNewAgent("MissionCommander", MissionCommander.class.getName(), null);
            AgentController nav = mainContainer.createNewAgent("Navigator", Navigator.class.getName(), null);
            AgentController so = mainContainer.createNewAgent("ScienceOfficer", ScienceOfficer.class.getName(), null);
            AgentController eng = mainContainer.createNewAgent("Engineer", Engineer.class.getName(), null);
            AgentController comm = mainContainer.createNewAgent("CommunicationOfficer", CommunicationOfficer.class.getName(), null);
            AgentController med = mainContainer.createNewAgent("MedicalOfficer", MedicalOfficer.class.getName(), null);
            AgentController pilot = mainContainer.createNewAgent("Pilot", Pilot.class.getName(), null);

            mc.start();
            nav.start();
            so.start();
            eng.start();
            comm.start();
            med.start();
            pilot.start();

            // Schedule a task to happen after 40 seconds
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Random random = new Random();
                    if (random.nextInt(3) < 2) {
                        // 2/3 chance to land
                        System.out.println("The mission has landed successfully at the destination.");
                    } else {
                        // 1/3 chance to crash
                        System.out.println("The mission has crashed. All agents are lost.");
                    }
                    // Terminate the JVM
                    System.exit(0);
                }
            }, 40000); // 40 seconds
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}
