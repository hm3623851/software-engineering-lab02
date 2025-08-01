import edu.sharif.selab.models.Message;
import edu.sharif.selab.processor.MessageProcessor;
import edu.sharif.selab.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        MessageProcessor processor = new MessageProcessor();
        
        try {
            int userChoice;
            do {
                userChoice = ui.showMenu();
                
                if (userChoice == 0) {
                    break;
                }
                
                if (userChoice >= 1 && userChoice <= 3) {
                    Message message = ui.createMessage(userChoice);
                    processor.processMessage(message);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
                
            } while (true);
            
        } finally {
            ui.close();
        }
    }
}