import java.util.Random;

public class CommunicationOfficer extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "Maintaining communication with mission control.");
        sendMessage("MedicalOfficer", "No new updates from mission control.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Received a new transmission from mission control.",
                    "Adjusting frequency for better signal.",
                    "Logging all communication data.",
                    "Monitoring for any distress signals.",
                    "Checking signal strength and clarity."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
