import java.util.Random;

public class MissionCommander extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
        sendMessage("Navigator", "Start navigation sequence.");
        sendMessage("ScienceOfficer", "Begin scientific experiments.");
        sendMessage("Engineer", "Check all systems.");
        sendMessage("CommunicationOfficer", "Establish communication with mission control.");
        sendMessage("MedicalOfficer", "Monitor crew health.");
        sendMessage("Pilot", "Prepare for launch.");
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("Navigator", "Update on navigation status.");
        sendMessage("ScienceOfficer", "Update on scientific experiments.");
        sendMessage("Engineer", "Update on system status.");
        sendMessage("CommunicationOfficer", "Update on communication status.");
        sendMessage("MedicalOfficer", "Update on crew health.");
        sendMessage("Pilot", "Update on piloting status.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Let's stay focused, team.",
                    "Remember to log all observations.",
                    "Keep an eye on the power levels.",
                    "Ensure all data is backed up.",
                    "Perform system diagnostics regularly."
            };
            sendMessage("All", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
