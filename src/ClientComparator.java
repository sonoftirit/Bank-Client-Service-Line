import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {

    @Override
    public int compare(Client c1, Client c2) {
        int c1Rank = getPriorityRank(c1.getType());
        int c2Rank = getPriorityRank(c2.getType());

        if (c1Rank < c2Rank) {
            return -1;
        } else if (c1Rank > c2Rank)
            return 1;
        else {
            if (c1.getArrivalOrder() < c2.getArrivalOrder())
                return -1;
            else if (c1.getArrivalOrder() > c2.getArrivalOrder())
                return 1;
            else
                return 0;
        }

    }

    private static int getPriorityRank(String type) {
        if (type.equals("VIP"))
            return 0;
        else if (type.equals("BUSINESS"))
            return 1;
        else
            return 2;
    }

}
