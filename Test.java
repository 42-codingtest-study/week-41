import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test {

    static class Node implements Comparable<Node>{
        int toNode;
        int weight;

        public Node(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }

    private static ArrayList<Node>[] nodeList;
    private static PriorityQueue<Integer>[] dLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long beforeTime = System.currentTimeMillis();

        nodeList = new ArrayList[nodeNum + 1];
        dLists = new PriorityQueue[nodeNum + 1];
        for (int idx = 1; idx <= nodeNum; idx++) {
            nodeList[idx] = new ArrayList<>();
            dLists[idx] = new PriorityQueue<>(k, Collections.reverseOrder());
        }

        for (int idx = 1; idx <= edgeNum; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, weight));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        dLists[1].add(0);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node next : nodeList[cur.toNode]) {
                int cost = cur.weight + next.weight;
                if (dLists[next.toNode].size() < k) {
                    dLists[next.toNode].add(cost);
                    queue.add(new Node(next.toNode, cost));
                } else if (dLists[next.toNode].peek() > cost) {
                    dLists[next.toNode].poll();
                    dLists[next.toNode].add(cost);
                    queue.add(new Node(next.toNode, cost));
                }
            }
        }

        for (int idx = 1; idx <= nodeNum; idx++) {
            if (dLists[idx].size() == k) {
                System.out.println(dLists[idx].peek());
            } else {
                System.out.println(-1);
            }
        }
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

}
