import java.util.Random;

public class Navigator extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "Navigation is on course.");
        sendMessage("Pilot", "Continuing on current trajectory.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Minor course adjustment made to avoid space debris.",
                    "Entering a high-radiation zone, adjusting shield levels.",
                    "Calculating optimal path to next waypoint.",
                    "Monitoring asteroid belt proximity.",
                    "Checking for gravitational anomalies."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
