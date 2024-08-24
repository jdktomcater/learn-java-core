package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;


import com.jdktomcat.pack.dsa.algorithm.book.offer.tree.TreeNode;

import java.util.LinkedList;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 判断节点是否为空或者与节点相同，直接返回节点
        if (root == null || p == root || q == root) {
            return root;
        }
        // 左路径搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右路径搜索
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 判断左节点及右节点及根节点
        return left == null ? right : right == null ? left : root;

    }

    private void getPath(TreeNode root,TreeNode target,boolean[] flag,LinkedList<TreeNode> path){
        if(root!=null){
            if(flag[0]){
                return;
            }
            if(root!=target){
                path.offerLast(root);
                if(root.left!=null){
                    getPath(root.left,target,flag,path);
                    if(!flag[0] ){
                        path.pollLast();
                    }
                }
                if(root.right!=null){
                    getPath(root.right,target,flag,path);
                    if(!flag[0] ){
                        path.pollLast();
                    }
                }
                path.pollLast();
            }else{
                flag[0] = true;
            }
        }
    }

    public static TreeNode build(Integer[] target,int index){
        if(index > target.length){
            return null;
        }
        if(target[index-1]==null){
            return null;
        }
        TreeNode root = new TreeNode(target[index-1],null,null);
        root.left = build(target, 2 * index);
        root.right = build(target, 2 * index+1);
        return root;
    }

}
