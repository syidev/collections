package fm.austria.model.radiostation;

import fm.austria.model.broadcast.Broadcast;
import fm.austria.model.program.Program;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Radiostation {
    public final static String NAME = "FM Austria";
    public final static String CURRENCY = "EUR";
    private final static String BROADCAST_PATH = "broadcast.txt";
    public void play(Broadcast broadcast) throws InterruptedException {
       for (Program program : broadcast.getPlayList()) {
           System.out.printf("\rNow playing: %s", program.getDescription());
           Thread.sleep(3000);
       }

       System.out.print("\r\r");
   }

    public void saveBroadcastDescription(String broadcastDescription) throws IOException {
       Path path = Path.of(BROADCAST_PATH);
       Files.writeString(path, broadcastDescription);
       System.out.printf("Broadcast description saved to %s%n", path.getFileName());
   }

    public void displayPreviousBroadcastDescription() throws Exception {
       Path path = Path.of(BROADCAST_PATH);

       if (!Files.exists(path) || Files.readAllLines(path).isEmpty()) {
            throw new Exception("Sorry, previous broadcast is not available");
       }

       List<String> content = Files.readAllLines(path);

       System.out.println("Previous broadcast:");
       for (String line : content) {
           System.out.println(line);
       }
   }

   public void printWelcome() {
       System.out.println();
       System.out.println();
       System.out.println(NAME);
       System.out.println("Enter 1 to display previous broadcast or 2 to run translation");
   }
}
