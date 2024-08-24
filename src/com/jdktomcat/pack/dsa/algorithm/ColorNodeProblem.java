package com.jdktomcat.pack.dsa.algorithm;

import java.util.*;

public class ColorNodeProblem {

    /**
     * 图信息初始化
     *
     * @param nodeNum   节点数量
     * @param lineArray 边信息数组
     * @return 节点列表（按照相邻节点数量从大到小排序）
     */
    private static List<Node> initNodeList(int nodeNum, int[][] lineArray) {
        List<Node> nodeList = new ArrayList<>(nodeNum);
        // 初始化节点信息
        for (int i = 0; i < nodeNum; i++) {
            nodeList.add(new Node(i));
        }
        // 初始化节点相邻节点信息
        for (int i = 0; i < lineArray.length; i++) {
            int[] line = lineArray[i];
            int start = line[0];
            int end = line[1];
            Node startNode = nodeList.get(start);
            Set<Integer> neighborStartSet = startNode.getNeighborSet();
            if (neighborStartSet == null) {
                neighborStartSet = new HashSet<>();
                startNode.setNeighborSet(neighborStartSet);
            }
            neighborStartSet.add(end);
            Node endNode = nodeList.get(end);
            Set<Integer> neighborEndSet = endNode.getNeighborSet();
            if (neighborEndSet == null) {
                neighborEndSet = new HashSet<>();
                endNode.setNeighborSet(neighborEndSet);
            }
            neighborEndSet.add(start);
        }
        // 排序
        Collections.sort(nodeList, (node1, node2) -> {
            if (node1 != null && node2 != null) {
                Set<Integer> neighborSet1 = node1.getNeighborSet();
                Set<Integer> neighborSet2 = node2.getNeighborSet();
                int size1 = neighborSet1 == null ? 0 : neighborSet1.size();
                int size2 = neighborSet2 == null ? 0 : neighborSet2.size();
                return size2 - size1;
            }
            return 0;
        });
        return nodeList;
    }

    /**
     * 涂色算法逻辑
     *
     * @param nodeList 节点列表
     */
    private static void handle(List<Node> nodeList) {
        int[] nodeColorArray = new int[nodeList.size()];
        int colorId = 0;
        while (nodeList != null && nodeList.size() != 0) {
            Set<Integer> colorSet = new HashSet<>();
            for (Node node : nodeList) {
                // 判断是否有交集
                long existCount = node.getNeighborSet().stream().filter(item -> colorSet.contains(item)).count();
                if (existCount == 0) {
                    colorSet.add(node.getId());
                    node.setColorId(colorId);
                    nodeColorArray[node.getId()] = colorId;
                }
            }
            // 剔除已经着色的节点
            nodeList.removeIf(node -> node.getColorId() != null);
            colorId++;
        }
        // 颜色个数
        System.out.println(colorId);
        for (int nodeColor : nodeColorArray) {
            System.out.print(nodeColor + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine().trim();
        String[] paramArray = content.split("\\s+");
        if (paramArray.length != 2) {
            System.out.println("输入格式有误！");
            return;
        }
        int nodeNum = Integer.parseInt(paramArray[0]);
        int lineNum = Integer.parseInt(paramArray[1]);
        int[][] lineArray = new int[lineNum][2];
        for (int i = 0; i < lineNum; i++) {
            content = scanner.nextLine().trim();
            paramArray = content.split("\\s+");
            if (paramArray.length != 2) {
                System.out.println("输入格式有误！");
                return;
            }
            lineArray[i][0] = Integer.parseInt(paramArray[0]);
            lineArray[i][1] = Integer.parseInt(paramArray[1]);
        }
        handle(initNodeList(nodeNum, lineArray));
    }
}

class Node {
    /**
     * 节点编号
     */
    private Integer id;

    /**
     * 颜色编号
     */
    private Integer colorId;

    /**
     * 相邻节点集合
     */
    private Set<Integer> neighborSet;

    public Node(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Set<Integer> getNeighborSet() {
        return neighborSet;
    }

    public void setNeighborSet(Set<Integer> neighborSet) {
        this.neighborSet = neighborSet;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
}
