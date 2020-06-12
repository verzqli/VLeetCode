package me.verzqli.leetcode.everyday;

class LeetCode20200611 {

    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1) {
            return new int[0];
        }
        int length = T.length;
        int result[] = new int[length];
        result[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                result[i] = 1;
            } else if (T[i] == T[i + 1]) {
                if (result[i+1]>0){
                    result[i] = result[i+1]+1;
                }else{
                    result[i]=0;
                }
            } else {
                result[i] = 1;
                int nextIndex = result[i] + i;
                //这里第一次做忽略了等于
                while (T[i] >= T[nextIndex]) {
                    if (result[nextIndex] == 0) {
                        nextIndex = 0;
                        result[i] = 0;
                        break;
                    }
                    nextIndex += result[nextIndex];
                }
                if (nextIndex > 0) {
                    result[i] = nextIndex - i;
                }

            }
        }
        return result;
    }
}
