import java.util.*;
public class Works {
    
    public static void main(String[] args) {
        new Works().run();
    }

    public void run() {
        // Queue<Integer> q = new LinkedList();
        // Integer[] arr =  {4, 2, 1, null, null, 3, null, null, 7, 6, null, null, 9, null, null};
        // for(Integer i: arr)
        //     q.add(i);
        Integer[] arr =  {1,2,2,3,null,null,3,4,null,null,4};
        Queue<TreeNode> qt = new LinkedList<TreeNode>();
        for(Integer i: arr) {
            if(i == null)
                qt.add(null);
            else
                qt.add(new TreeNode(i));
        }

        TreeNode root = qt.poll();
        constructTree(root, qt);
        showFirstOrder(root);
        System.out.println();
        // invertTree(root);
        // showFirstOrder(root);
        System.out.println(isBalanced(root));
    }

    /**
     * 构造二叉树
     */
    public void constructTree(TreeNode root, Queue<TreeNode> qt) {
        Queue<TreeNode> need = new LinkedList<TreeNode>();
        need.add(root);
        TreeNode tmp;
        while(!need.isEmpty()) {
            tmp = need.poll();
            if(tmp == null)
                continue;
            if(qt.isEmpty())
                break;
            tmp.left = qt.poll();
            tmp.right = qt.poll();
            need.add(tmp.left);
            need.add(tmp.right);
            // 给左构造  给右构造
        }
    }

    public void showFirstOrder(TreeNode root) {
        if(root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val+" ");
        showFirstOrder(root.left);
        showFirstOrder(root.right);
    }

    /**
     * 平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int l = calcHeight(root.left);
        int r = calcHeight(root.right);
        if(Math.abs(l-r) > 1)
            return false;
        return true && isBalanced(root.left) && isBalanced(root.right);
    }

    public int calcHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = calcHeight(root.left);
        int r = calcHeight(root.right);
        return 1+(l>r?l:r);
    }

    /**
     * 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}