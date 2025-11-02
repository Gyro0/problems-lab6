import java.util.*;

public class Main {

    //simple type for a Place with a name and distance from the start
    private static class Place {
        final String name;
        final int distanceKm; //distance from the start

        Place(String name,int distanceKm){
            this.name=name;
            this.distanceKm=distanceKm;
        }

        @Override
        public String toString(){
            return "%s (%dkm)".formatted(name,distanceKm);
        }
    }

    public static void main(String[] args) {
        LinkedList<Place> places=new LinkedList<>();

        addInOrder(places,new Place("Sydney",0));
        addInOrder(places,new Place("Adelaide",1374));
        addInOrder(places,new Place("Alice Springs",2771));
        addInOrder(places,new Place("Darwin",3972));
        addInOrder(places,new Place("Melbourne",878));
        addInOrder(places,new Place("Perth",3944));

        runConsole(places);
    }

    //inserts a place keeping the list sorted by distance,then name ,and forbids duplicate names.
    private static boolean addInOrder(LinkedList<Place> list,Place p) {
        //reject duplicates by name
        for(Place pl:list) {
            if(pl.name.equalsIgnoreCase(p.name)){
                return false;
            }
        }

        //find insertion point sorted by distance,then name
        ListIterator<Place> it=list.listIterator();
        while(it.hasNext()){

            Place curr=it.next();
            if ((p.distanceKm < curr.distanceKm) 
                || (p.distanceKm == curr.distanceKm && p.name.compareToIgnoreCase(curr.name) < 0))
                {
                    it.previous(); //step back to insert before curr
                    it.add(p);
                    return true;
                }

        }
        list.addLast(p); //largest distance → append
        return true;
    }

    private static void printList(LinkedList<Place> list) {
        if (list.isEmpty()) {
            System.out.println("[Places empty]");
            return;
        }
        System.out.println("Places (sorted by distance):");
        int idx=1;
        for (Place p:list) {
            System.out.println("  " + (idx++) + ". " + p);
        }
    }

    private static void printMenu() {
        System.out.println("""
                ===== MENU =====
                [F] Forward (next place)
                [B] Back (previous place)
                [L] List places
                [M] Show menu
                [Q] Quit
                """);
    }

    private static void runConsole(LinkedList<Place> places) {
        Scanner sc=new Scanner(System.in);
        ListIterator<Place> it=places.listIterator();
        boolean goingForward=true; //tracks last movement direction
        boolean running=true;

        printMenu();
        printList(places);
        if (it.hasNext()) {
            Place p=it.next();
            System.out.println("Now at: "+p);
        }

        while (running) {
            System.out.print("~ ");
            String cmd=sc.nextLine().trim().toUpperCase();

            switch (cmd) {
                case "F":{ //next
                    if (!goingForward) {
                        //Direction changed: iterator cursor is one step "behind"
                        if (it.hasNext()) it.next();
                        goingForward=true;
                    }
                    if (it.hasNext()) {
                        Place p=it.next();
                        System.out.println("Now at: "+p);
                    } else {
                        System.out.println("Reached the end of the places.");
                    }
                    break;
                }
                case "B":{ //previous
                    if (goingForward) {
                        //Direction changed: iterator cursor is one step "ahead"
                        if (it.hasPrevious()) it.previous();
                        goingForward=false;
                    }
                    if (it.hasPrevious()) {
                        Place p=it.previous();
                        System.out.println("Now at: "+p);
                    } else {
                        System.out.println("At the start of the places.");
                    }
                    break;
                }
                case "L":{
                    printList(places);
                    break;
                } 
                case "M":{
                    printMenu();
                    break;
                }
                case "Q":{
                    running=false;
                    break;
                }
                default:{
                    System.out.println("Unknown command. Type M to show the menu.");
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
