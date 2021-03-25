package to.geekbang;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Test test = new Test();
        String closestTime = test.nextClosestTime("19:34");
        System.out.println(closestTime);
        closestTime = test.nextClosestTime("23:59");
        System.out.println(closestTime);
    }

    public String nextClosestTime(String time) {
        String closestTime = time;
        int closestCount = 24 * 60;

        //step1: 获取到time字符串含有的数字集合
        List<Integer> allNums = getNumList(time);
        //step2：遍历256中选择
        for (int indexA = 0; indexA < allNums.size(); indexA++)
            for (int indexB = 0; indexB < allNums.size(); indexB++)
                for (int indexC = 0; indexC < allNums.size(); indexC++)
                    for (int indexD = 0; indexD < allNums.size(); indexD++) {
                        int a = allNums.get(indexA);
                        int b = allNums.get(indexB);
                        int c = allNums.get(indexC);
                        int d = allNums.get(indexD);

                        String newTime = composeTime(a, b, c, d);
                        if (!isRightTime(newTime)) continue;
                        else {
                            int offset = countOffset(time, newTime);
                            if (offset < closestCount) {
                                closestCount = offset;
                                closestTime = newTime;
                            }
                        }

                    }
        return closestTime;
    }

    public List<Integer> getNumList(String time) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c <= '9' && c >= '0') {
                int num = c - '0';
                if (!nums.contains(num)) {
                    nums.add(num);
                }
            }
        }
        return nums; // eg. 19:34-> [1,9,3,4]
    }

    public String composeTime(int a, int b, int c, int d) {
        StringBuilder builder = new StringBuilder();
        builder.append(a);
        builder.append(b);
        builder.append(":");
        builder.append(c);
        builder.append(d);
        return builder.toString();
    }

    public boolean isRightTime(String time) {
        String[] hm = time.split(":");
        assert 2 == hm.length;
        if (Integer.valueOf(hm[0]) >= 0 && Integer.valueOf(hm[0]) <= 23
                && Integer.valueOf(hm[1]) >= 0 && Integer.valueOf(hm[1]) <= 59)
            return true;
        return false;
    }

    public int countOffset(String origin, String newTime) {
        String[] ohm = origin.split(":");
        int oCount = Integer.valueOf(ohm[0]) * 60 + Integer.valueOf(ohm[1]);
        String[] nhm = newTime.split(":");
        int nCount = Integer.valueOf(nhm[0]) * 60 + Integer.valueOf(nhm[1]);
        if (oCount < nCount) {
            return nCount - oCount;
        } else {
            return 24 * 60 + nCount - oCount;
        }
    }
}
