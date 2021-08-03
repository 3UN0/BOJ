import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5639 {
	public static Tree tree;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new Tree(Integer.parseInt(br.readLine()));	// 루트 노드 
		
		String s;
		while((s = br.readLine()) != null) {
			Tree nextNode = new Tree(Integer.parseInt(s));
			addNode(tree, nextNode);
		}
		
		postOrder(tree);
		System.out.println(sb);
		
	}
	
	// 노드 추가
	public static void addNode(Tree startNode, Tree newNode) {
		if(newNode.num < startNode.num) {
			if(startNode.left != null) {
				addNode(startNode.left, newNode);
			} else {
				startNode.left = newNode;
			}
		} else {
			if(startNode.right != null) {
				addNode(startNode.right, newNode);
			} else {
				startNode.right = newNode;
			}
		}
	}
	
	// 후위 순회
	public static void postOrder(Tree node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		sb.append(node.num + "\n");
	}
	

	static class Tree{
		int num;
		Tree left;
		Tree right;
		
		public Tree(int num) {
			this.num = num;
			this.left = null;
			this.right = null;
		}
	}
}


