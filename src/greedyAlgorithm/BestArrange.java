package greedyAlgorithm;

import java.util.Arrays;

/**
 * Created by Jason Tan on 2022-09-12 14:24
 */
public class BestArrange {

    //会议有开始时间和结束时间
    public static class Program implements Comparable<Program> {
        public int start;
        public int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Program o) {
            return this.end - o.end;
        }
    }

    public static int bestArrange(Program[] programArr, int timePoint){
        Arrays.sort(programArr);
        int result = 0;
        for (int i=0; i<programArr.length; i++){
            //如果目前时间小于会议的开始时间，就可以安排会议
            if (timePoint <= programArr[i].start){
                result++;
                //新的目前时间设置为安排会议的end时间
                timePoint = programArr[i].end;
            }
        }
        return result;
    }
}
