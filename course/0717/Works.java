import java.util.*;

public class Works {

    public static void main(String[] args) {
        new Works().run();
    }

    public void run() {
        Integer[] arr =  {5,4,8,11,null,13,4,7,2,null,null,null,1};
        Queue<TreeNode> qt = new LinkedList<TreeNode>();
        for(Integer i: arr) {
            if(i == null)
                qt.add(null);
            else
                qt.add(new TreeNode(i));
        }

        TreeNode root = qt.poll();
        constructTree(root, qt);
        showFirstOrder(root, 0, 22);
        System.out.println();
        System.out.println(list);
    }
    
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
        }
    }

    
    private int count = 0;
    ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();
    /**
     * Path Sum III
     */
    public int pathSum1(TreeNode root, int sum) {
        if(root == null)
            return count;
        
        q2.add(root);
        int len = q2.size();
        int tmp = 0;
        for(int i=0; i<len; i++) {
            tmp = 0;
            for(int j=i; j<len; j++) {
                tmp += q2.get(j);
            }
            if(tmp == sum)
                count++;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        q2.remove(q2.size()-1);

        return count;
    }
    public void traverse1(TreeNode root, int target) {
        if(root == null) {
            // System.out.print("null ");
            return;
        }
        q2.add(root);
        // System.out.print(root.val+" ");
        // sum += root.val;
        int len = q2.size();
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum = 0;
            for(int j=i; j<len; j++) {
                sum += q2.get(j);
            }
            if(sum == target)
                count++;
        }
        traverse1(root.left, target);
        traverse1(root.right, target);
        q2.remove(q2.size()-1);
    }


    
    /**
     * Path Sum II
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        traverse(root, 0, sum);
        return res1;
    }
    List<List<Integer>> res1 = new ArrayList<List<Integer>>();
    LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
    public void traverse(TreeNode root, int sum, int target) {
        if(root == null) {
            // System.out.print("null ");
            return;
        }
        q1.add(root);
        // System.out.print(root.val+" ");
        sum += root.val;
        if(root.left == null && root.right == null) {
            if(sum == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                Iterator<TreeNode> it = q1.iterator();
                while(it.hasNext()) {
                    list.add(it.next().val);
                }
                res1.add(list);
            }
        } else {
            traverse(root.left, sum, target);
            traverse(root.right, sum, target);
        }
        q1.removeLast();
    }


    /**
     * Path Sum I
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        showFirstOrder(root, 0, sum);
        return !list.isEmpty();
    }

    private List<Integer> list = new ArrayList<Integer>();
    public void showFirstOrder(TreeNode root, int sum, int target) {
        if(root == null) {
            // System.out.print("null ");
            return;
        }
        // System.out.print(root.val+" ");
        sum += root.val;
        if(root.left == null && root.right == null) {
            if(sum == target) {
                list.add(root.val);
            }
        } else {
            showFirstOrder(root.left, sum, target);
            showFirstOrder(root.right, sum, target);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}