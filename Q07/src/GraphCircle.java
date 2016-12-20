import java.util.ArrayList;

/**
 * Created by 曹利航 on 2016/12/20 00:11.
 */
public class GraphCircle {
    static private final int graphSize = 5; // 节点个数
    static private int[][] graph = {        // 图
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0}
    };
    static ArrayList<Integer> path = new ArrayList<Integer>();  // 存放已访问路径
    static boolean hasCycle = false;

    public static void main(String[] args) {
        find(0);
        if (!hasCycle)
            System.out.println("No Cycle.");
    }

    static void find(int current) {
        int index;
        if ((index = path.indexOf(current)) != -1) { // 现在所在的路径中已有此节点，即出现环路
            hasCycle = true;
            System.out.print("Cycle:");
            // 输出该环
            while (index < path.size()) {
                System.out.print(path.get(index) + " ");
                index++;
            }
            System.out.print(current + "\n");
            return;
        }
        // 将此节点加入路径中
        path.add(current);

        // 遍历从此节点出去的所有路径
        for (int i = 0; i < graphSize; i++) {
            if (graph[current][i] == 1)
                // 递归
                find(i);
        }

        // 删除最后一个节点
        path.remove(path.size() - 1);
    }
}
