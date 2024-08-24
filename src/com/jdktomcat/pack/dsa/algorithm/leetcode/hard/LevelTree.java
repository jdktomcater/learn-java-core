package com.jdktomcat.pack.dsa.algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class LevelTree {
    static class Node {

        Integer value;

        Node left;

        Node right;

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    /**
     * ceshi
     * @param root
     * @return
     */
    private static List<List<Node>> visitLevel(Node root) {
        List<List<Node>> resultList = new ArrayList<>();
        if (root != null) {
            List<Node> rootLevelList = new ArrayList<>();
            rootLevelList.add(root);
            resultList.add(rootLevelList);
            int level = 0;
            boolean isStop = false;
            do {
                if(level<resultList.size()){
                    List<Node> levelNodeList = resultList.get(level++);
                    if (levelNodeList != null && levelNodeList.size() != 0) {
                        List<Node> subLevelNodeList = new ArrayList<>();
                        for(Node node:levelNodeList){
                            if(node!=null){
                                if(node.left!=null){
                                    subLevelNodeList.add(node.left);
                                }
                                if(node.right!=null){
                                    subLevelNodeList.add(node.right);
                                }
                            }
                        }
                        resultList.add(subLevelNodeList);
                    } else{
                        isStop = true;
                    }
                }else{
                    isStop = true;
                }
            } while (isStop);
        }
        return resultList;
    }

}
