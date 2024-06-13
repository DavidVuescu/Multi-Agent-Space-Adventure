import java.util.Random;

public class Engineer extends SpaceAgent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        super.setup();
    }

    @Override
    protected void sendPeriodicMessages() {
        sendMessage("MissionCommander", "All systems are operational.");
        sendMessage("Pilot", "Engine status: optimal.");

        // Occasionally send unique message
        if (random.nextInt(5) == 0) {
            String[] uniqueMessages = {
                    "Conducting routine maintenance on life support system.",
                    "Inspecting thermal control systems.",
                    "Running diagnostics on propulsion system.",
                    "Checking integrity of external hull.",
                    "Monitoring power levels and battery status."
            };
            sendMessage("MissionCommander", uniqueMessages[random.nextInt(uniqueMessages.length)]);
        }
    }
}
