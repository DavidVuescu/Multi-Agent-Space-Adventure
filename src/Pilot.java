import java.util.Random;

public class Pilot extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "Piloting is proceeding smoothly.");
        sendMessage("Navigator", "Trajectory is as planned.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Performing a routine check on navigation systems.",
                    "Adjusting course for optimal travel.",
                    "Monitoring fuel levels and efficiency.",
                    "Ensuring smooth operation of flight controls.",
                    "Preparing for upcoming maneuvers."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
