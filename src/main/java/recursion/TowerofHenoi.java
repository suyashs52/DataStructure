package recursion;

public class TowerofHenoi {
    //recursive program ; small problem solve first, terminal condition, minimum memory usage, min func call, repeat

    public static void main(String[] args) {
        //put slack in increasing order from top 3 pillers
        //source, destination, auxiliary
        //transfer s to aux n-1 in same order, transfer s to d 1 brick
        //again now transfer a to d using s n-1 brick
        towerofHenoi('s', 'd', 'a', 3);

    }

    static void towerofHenoi(char s, char d, char a, int n) {
        if (n == 0) return; //if no brick then dont go next
        towerofHenoi(s, d, a, n - 1);
        System.out.printf("transfer %c to %c brick no %d\n", s, d, n); //transfer
        towerofHenoi(a, d, s, n - 1);

    }
}
