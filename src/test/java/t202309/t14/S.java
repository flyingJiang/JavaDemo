package t202309.t14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaDemo
 * @description:
 * @author: jiangjianfei
 * @create: 2023-09-14 18:46
 **/
public class S {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Map<Integer, int[]> candidates = new HashMap<Integer, int[]>();
        int kx = king[0], ky = king[1];
        for (int[] queen : queens) {
            int qx = queen[0], qy = queen[1];
            int x = qx - kx, y = qy - ky;
            if (x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                int dx = sgn(x), dy = sgn(y);
                int key = dx * 10 + dy;
                if (!candidates.containsKey(key) || candidates.get(key)[2] > Math.abs(x) + Math.abs(y)) {
                    candidates.put(key, new int[]{queen[0], queen[1], Math.abs(x) + Math.abs(y)});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, int[]> entry : candidates.entrySet()) {
            int[] value = entry.getValue();
            List<Integer> posList = new ArrayList<Integer>();
            posList.add(value[0]);
            posList.add(value[1]);
            ans.add(posList);
        }
        return ans;
    }

    public int sgn(int x) {
        return x > 0 ? 1 : (x == 0 ? 0 : -1);
    }
}
