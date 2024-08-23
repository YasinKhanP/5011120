public class CommandPatternExample {

    // Step 2: Define Command Interface
    public interface Command {
        void execute();
    }

    // Step 5: Implement Receiver Class: Light
    public static class Light {
        public void turnOn() {
            System.out.println("The light is on.");
        }

        public void turnOff() {
            System.out.println("The light is off.");
        }
    }

    // Step 3: Implement Concrete Commands
    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Step 4: Implement Invoker Class: RemoteControl
    public static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Step 6: Test Class
    public static class CommandPatternTest {
        public static void main(String[] args) {
            // Create a light object
            Light light = new Light();

            // Create command objects
            Command lightOn = new LightOnCommand(light);
            Command lightOff = new LightOffCommand(light);

            // Create the invoker object
            RemoteControl remote = new RemoteControl();

            // Turn the light on
            remote.setCommand(lightOn);
            System.out.println("Turning light on:");
            remote.pressButton();  // Output: The light is on.

            // Turn the light off
            remote.setCommand(lightOff);
            System.out.println("Turning light off:");
            remote.pressButton();  // Output: The light is off.
        }
    }
}
