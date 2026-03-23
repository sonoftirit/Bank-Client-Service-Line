import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * This program uses a PriorityQueue<Client> with ClientComparator so that VIP clients
 * are served first, then BUSINESS, then REGULAR, and ties are broken by smaller
 * arrivalOrder. The menu keeps running until the user chooses Exit. For showing the
 * waiting list and removing by name safely, the program makes a copy of the queue
 * and polls from the copy so the original queue is not destroyed.
 */
public class BankQueueSystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Client> queue = new PriorityQueue<>(new ClientComparator());
        int nextArrivalOrder = 0;
        boolean running = true;

        while (running) {
            printMenu();
            int action = readMenuChoice(in);

            switch (action) {
                case 1:
                    nextArrivalOrder = addClient(in, queue, nextArrivalOrder);
                    break;
                case 2:
                    serveNextClient(queue);
                    break;
                case 3:
                    viewNextClient(queue);
                    break;
                case 4:
                    removeClientByName(in, queue);
                    break;
                case 5:
                    showWaitingList(queue);
                    break;
                case 6:
                    running = false;
                    break;
            }

            System.out.println();
        }

        in.close();
    }

    public static void printMenu() {
        System.out.println("=== Bank Queue System ===");
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1) Add client");
        System.out.println("2) Serve next client");
        System.out.println("3) View next client");
        System.out.println("4) Remove client by name");
        System.out.println("5) Show waiting list");
        System.out.println("6) Exit");
    }

    public static int readMenuChoice(Scanner in) {
        while (true) {
            System.out.print("Choose 1-6: ");
            String input = in.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
            } catch (NumberFormatException e) {
        
            }

            System.out.println("Invalid menu choice. Please enter a number 1-6.");
        }
    }

    public static int addClient(Scanner in, PriorityQueue<Client> queue, int nextArrivalOrder) {
        String name;
        while (true) {
            System.out.print("Enter client name: ");
            name = in.nextLine();

            if (name.isBlank()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else {
                name = name.trim();
                break;
            }
        }

        String type;
        while (true) {
            System.out.print("Enter client type (VIP / BUSINESS / REGULAR): ");
            type = in.nextLine().trim().toUpperCase();

            if (type.equals("VIP") || type.equals("BUSINESS") || type.equals("REGULAR")) {
                break;
            } else {
                System.out.println("Invalid type. Enter VIP, BUSINESS, or REGULAR.");
            }
        }

        Client newClient = new Client(name, type, nextArrivalOrder);
        queue.offer(newClient);
        System.out.println("Added: " + newClient);

        return nextArrivalOrder + 1;
    }

    public static void serveNextClient(PriorityQueue<Client> queue) {
        if (queue.isEmpty()) {
            System.out.println("No clients waiting.");
        } else {
            System.out.println("Serving: " + queue.poll());
        }
    }

    public static void viewNextClient(PriorityQueue<Client> queue) {
        if (queue.isEmpty()) {
            System.out.println("No clients waiting.");
        } else {
            System.out.println("Next: " + queue.peek());
        }
    }

    public static void removeClientByName(Scanner in, PriorityQueue<Client> queue) {
        if (queue.isEmpty()) {
            System.out.println("No clients waiting.");
            return;
        }

        String nameToRemove;
        while (true) {
            System.out.print("Enter name to remove: ");
            nameToRemove = in.nextLine();

            if (nameToRemove.isBlank()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else {
                nameToRemove = nameToRemove.trim();
                break;
            }
        }

        PriorityQueue<Client> copy = new PriorityQueue<>(queue);
        Client clientToRemove = null;

        while (!copy.isEmpty()) {
            Client current = copy.poll();
            if (current.getName().equalsIgnoreCase(nameToRemove)) {
                clientToRemove = current;
                break;
            }
        }

        if (clientToRemove != null) {
            queue.remove(clientToRemove);
            System.out.println("Removed: " + clientToRemove);
        } else {
            System.out.println("Client not found.");
        }
    }

    public static void showWaitingList(PriorityQueue<Client> queue) {
        if (queue.isEmpty()) {
            System.out.println("No clients waiting.");
            return;
        }

        PriorityQueue<Client> copy = new PriorityQueue<>(queue);

        System.out.println("Sorted view (copy of queue):");
        while (!copy.isEmpty()) {
            System.out.println(" - " + copy.poll());
        }
    }
}