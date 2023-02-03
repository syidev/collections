package fm.austria;

import fm.austria.builder.BroadcastBuilder;
import fm.austria.model.announcer.AnnouncerEmployee;
import fm.austria.model.broadcast.Broadcast;
import fm.austria.model.radiostation.Radiostation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.run();
    }

    public void run() {
        while(true) {
            try {
                AnnouncerEmployee alan = new AnnouncerEmployee("John Doe");

                BroadcastBuilder broadcastBuilder = new BroadcastBuilder();
                alan.createFamousPersonInterview(broadcastBuilder);
                Broadcast broadcast = broadcastBuilder.getResult();

                Radiostation radiostation = new Radiostation();
                radiostation.printWelcome();

                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();

                switch (number) {
                    case 1 -> radiostation.displayPreviousBroadcastDescription();
                    case 2 -> {
                        radiostation.play(broadcast);
                        radiostation.saveBroadcastDescription(broadcast.getDescription());
                        broadcast.printProfit();
                    }
                    default -> System.out.println("Unrecognizable input");
                }

            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
