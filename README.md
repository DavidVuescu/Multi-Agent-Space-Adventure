# JADE Multi-Agent System

This project implements a multi-agent system using the JADE (Java Agent DEvelopment Framework) framework. The system consists of seven agents that communicate with each other periodically and simulate a random termination event after approximately 40 seconds of runtime.

## Agents

The project defines the following agents, each with periodic and occasional unique messages:

1. `MissionCommander`
2. `Navigator`
3. `ScienceOfficer`
4. `Engineer`
5. `CommunicationOfficer`
6. `MedicalOfficer`
7. `Pilot`

## Project Structure

- `StartAgents.java`: The main class that initializes and starts all agents. It also schedules a termination event after 40 seconds.
- `SpaceAgent.java`: An abstract class extended by all agents, providing common behavior for message receiving and periodic message sending.
- Specific agent classes (`MissionCommander.java`, `Navigator.java`, etc.): Each class extends `SpaceAgent` and defines its own periodic and unique messages.

## How It Works

### Initialization

1. **Main Class**: `StartAgents`
    - Creates and starts each agent.
    - Schedules a termination event after 40 seconds using a `Timer`.

2. **Agent Setup**: Each agent's `setup()` method:
    - Adds a `CyclicBehaviour` for receiving messages.
    - Adds a `TickerBehaviour` for sending periodic messages at random intervals (3-8 seconds).

### Communication

- **Receiving Messages**:
    - Agents use `CyclicBehaviour` to continuously check for and print received messages.
    - Removes redundant sender name from the message content for cleaner output.

- **Sending Messages**:
    - Periodic messages are sent to specific agents.
    - Unique messages are occasionally sent based on a random chance.

### Termination Event

- **Random Event Scheduling**:
    - A `TimerTask` is executed after 40 seconds to determine the termination event.
    - Uses `Random` to decide between two outcomes:
        - 2/3 chance of successful termination.
        - 1/3 chance of crash.
    - Terminates the JVM with `System.exit(0)`.

## Running the Project

1. Ensure JADE library is included in the project.
2. Compile and run `StartAgents.java`.
3. Observe the console for periodic agent messages and the final termination event.

## Example Output

```text
MissionCommander - received "Navigation is on course." - from Navigator
...
The mission has landed successfully at the destination.
```

## Dependencies

- JADE library (version 4.5.0 or compatible)
