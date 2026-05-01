package LinkedList;

class Nodes{
    int val;
    Nodes next;
}

public class Basics {
    public static void main(String[] args) {
        // 10 -> 20 -> 30 -> 40 -> 50
        // Nodes
        Nodes a = new Nodes(); a.val = 10;
        Nodes b = new Nodes(); b.val = 20;
        Nodes c = new Nodes(); c.val = 30;
        Nodes d = new Nodes(); d.val = 40;
        Nodes e = new Nodes(); e.val = 50;

        // Connecting / Linking the Nodes
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
    }
}