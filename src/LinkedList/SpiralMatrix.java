package LinkedList;

public class SpiralMatrix {
    // method - 1
    /*public static int[][] resultMatrix(int m, int n, Node head) {
        int[][] ans = new int[m][n];
        Node temp = head;

        int fr = 0, lr = m-1, fc = 0, lc = n-1;
        while(fr <= lr && fc <= lc){

            for(int i = fc; i <= lc; i++){
                if(temp == null) ans[fr][i] = -1;
                else{
                    ans[fr][i] = temp.val;
                    temp = temp.next;
                }
            }
            fr++;
            if(fr > lr || fc > lc) break;

            for(int i = fr; i <= lr; i++){
                if(temp == null) ans[i][lc] = -1;
                else{
                    ans[i][lc] = temp.val;
                    temp = temp.next;
                }
            }
            lc--;
            if(fr > lr || fc > lc) break;


            for(int i = lc; i >= fc; i--){
                if(temp == null) ans[lr][i] = -1;
                else{
                    ans[lr][i] = temp.val;
                    temp = temp.next;
                }
            }
            lr--;
            if(fr > lr || fc > lc) break;

            for(int i = lr; i >= fr; i--){
                if(temp == null) ans[i][fc] = -1;
                else{
                    ans[i][fc] = temp.val;
                    temp = temp.next;
                }
            }
            fc++;
        }

        return ans;
    }*/

    // method - 2
    public static int[][] resultMatrix(int m, int n, Node head) {
        int[][] ans = new int[m][n];

        for(int i = 0; i <m; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = -1;
            }
        }

        int fr = 0, lr = m-1, fc = 0, lc = n-1;
        while(head != null){

            for(int i = fc; i <= lc && head != null; i++){
                ans[fr][i] = head.val;
                head = head.next;
            }
            fr++;

            for(int i = fr; i <= lr && head != null; i++){
                ans[i][lc] = head.val;
                head = head.next;
            }
            lc--;

            for(int i = lc; i >= fc && head != null; i--){
                ans[lr][i] = head.val;
                head = head.next;
            }
            lr--;

            for(int i = lr; i >= fr && head != null; i--){
                ans[i][fc] = head.val;
                head = head.next;
            }
            fc++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(0);
        Node i = new Node(8);
        Node j = new Node(10);
        Node k = new Node(3);
        Node l = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        k.next = l;
        l.next = null;

        int m = 4, n = 4;

        System.out.println("Resultant matrix is: ");
        for (int[] arr : resultMatrix(m, n, a)) {
            for (int x : arr) {
                System.out.print(x + "   ");
            }
            System.out.println();
        }
    }
}