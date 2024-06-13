import java.util.Random;

public class MedicalOfficer extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "Crew health is stable.");
        sendMessage("CommunicationOfficer", "No health issues to report.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Conducting a health check on the crew.",
                    "Monitoring vital signs closely.",
                    "Administering routine health tests.",
                    "Ensuring adequate supply of medical provisions.",
                    "Preparing for potential medical emergencies."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
