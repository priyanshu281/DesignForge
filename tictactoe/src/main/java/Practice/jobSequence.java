package Practice;

import java.util.Arrays;

class Job implements Comparable{
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    @Override
    public int compareTo(Job other) {
        return Integer.compare(this.deadline, other.deadline);

    }
}
class jobSequence{
    public int[] jobscheduling(Job arr[], int n){
        Arrays.sort(arr, (a, b) -> Integer.compare(double(b.profit), a.profit));
        Arrays.stream(arr).mapToInt(job -> job.deadline).max();

    }

    public static void main(String[] args) {

    }

}
