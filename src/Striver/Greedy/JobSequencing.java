package Striver.Greedy;

import Striver.Arrays.ArrayImpl;

import java.util.Arrays;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobSequencing {
    public static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        int[] result = new int[2];
//        Arrays.sort(arr, (a, b) -> a.deadline == b.deadline ? Integer.compare(b.profit, a.profit) : Integer.compare(a.deadline, b.deadline));

        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int  maxDeadline = 0;

        for (Job job : arr) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] jobSlots = new int[maxDeadline + 1];
        Arrays.fill(jobSlots, -1);

        int count = 0 , maxProfit = 0 ;

        for (int i = 0 ; i < n ; ++i) {
            Job job = arr[i];

            for(int j = job.deadline ; j > 0 ; --j) {
                if(jobSlots[j] == -1){
                    jobSlots[j] = i ;
                    count++;
                    maxProfit+=job.profit;
                    break;
                }
            }

//            System.out.println("( " + job.id + ", " + job.deadline + ", " + job.profit + " )");
//            if (mx >= job.deadline) continue;
//            mx = job.deadline;
//            profit += job.profit;
//            noOfJobs++;
//            System.out.println("deadline " + mx + ", profit " + profit + ", noOfJobs " + noOfJobs);
        }
        result[0] = count;
        result[1] = maxProfit;
        return result;
    }

    public static void main(String[] args) {

//        Job[] arr = {
//                new Job(1, 4, 20),
//                new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)
//        };

        Job[] arr = {
                new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27),
                new Job(4, 1, 25), new Job(5, 1, 15)
        };

        ArrayImpl.printArr(JobScheduling(arr, arr.length));
    }
}



