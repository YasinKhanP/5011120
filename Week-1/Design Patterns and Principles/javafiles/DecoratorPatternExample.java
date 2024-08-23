
// DecoratorPatternExample.java

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Step 4: Implement Decorator Classes

// Abstract decorator class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete decorator class for SMS notifications
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Concrete decorator class for Slack notifications
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

// Step 5: Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Basic Email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Email + SMS notifier
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Email + SMS + Slack notifier
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notifications via multiple channels
        System.out.println("Sending notifications via multiple channels:");
        slackNotifier.send("Hello, this is a test message!");
    }
}
