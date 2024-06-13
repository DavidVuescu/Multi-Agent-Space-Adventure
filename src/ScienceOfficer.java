import java.util.Random;

public class ScienceOfficer extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "Scientific experiments are progressing well.");
        sendMessage("Engineer", "Equipment is functioning properly.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Discovered new data on cosmic radiation.",
                    "Conducting analysis on samples collected.",
                    "Preparing report on recent findings.",
                    "Adjusting instruments for better accuracy.",
                    "Reviewing data from last experiment."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
