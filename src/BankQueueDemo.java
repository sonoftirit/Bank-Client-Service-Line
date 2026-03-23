import java.util.PriorityQueue;

public class BankQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Client> queue = new PriorityQueue<>(new ClientComparator());

        queue.offer(new Client("Mustafa", "VIP", 0));
        queue.offer(new Client("A", "BUSINESS", 1));
        queue.offer(new Client("B", "REGULAR", 2));
        queue.offer(new Client("Orhan", "VIP", 3));
        queue.offer(new Client("D", "BUSINESS", 4));
        queue.offer(new Client("E", "REGULAR", 5));
        queue.offer(new Client("Sude", "VIP", 6));
        queue.offer(new Client("F", "BUSINESS", 7));
        queue.offer(new Client("G", "REGULAR", 8));

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        
    }

}
