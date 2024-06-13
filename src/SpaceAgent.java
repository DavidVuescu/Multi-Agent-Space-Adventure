import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public abstract class SpaceAgent extends Agent {
    private final Random random = new Random();

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    String content = msg.getContent();
                    String senderName = msg.getSender().getLocalName();
                    // Remove redundant agent name from content if it exists
                    if (content.contains(senderName + ": ")) {
                        content = content.replace(senderName + ": ", "");
                    }
                    System.out.println(getLocalName() + " - received \"" + content + "\" - from " + senderName);
                } else {
                    block();
                }
            }
        });

        addBehaviour(new TickerBehaviour(this, getRandomInterval()) {
            @Override
            protected void onTick() {
                sendPeriodicMessages();
                reset(getRandomInterval());
                System.out.println();
            }
        });
    }

    private int getRandomInterval() {
        return 3000 + random.nextInt(5000); // Random interval between 3 to 8 seconds
    }

    protected void sendMessage(String receiver, String content) {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(getAID(receiver));
        msg.setContent(content);
        send(msg);
    }

    protected abstract void sendPeriodicMessages();
}
