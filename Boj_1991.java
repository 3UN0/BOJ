import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1991 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char value[] = new char[3]; // ��Ʈ ��� ��, �� �ڽ� ��� ��, �� �ڽ� ��� ��
		Node node[] = new Node[26], left, right;
		
		int N = Integer.parseInt(br.readLine());	// ��� ����
		
		for(int i=0;i<26;i++) {
			node[i]=new Node();
		}
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				value[j] = st.nextToken().charAt(0);
			}
			int root = value[0] - 'A';
			left = value[1] == '.' ? null : node[value[1] - 'A'];
			right = value[2] == '.' ? null : node[value[2] - 'A'];
			
			node[root].setVal(value[0]);
			node[root].setLeftNode(left);
			node[root].setRightNode(right);
			
		}
		
		preOrder(node[0]);
		sb.append("\n");
		inOrder(node[0]);
		sb.append("\n");
		postOrder(node[0]);
		sb.append("\n");
		
		System.out.println(sb);
	}
	
	static class Node {
		private char val;	// �θ� ��� ��
		private Node leftNode, rightNode;	// ���� �ڽ� ���, ������ �ڽ� ���
		
		public char getVal() {
			return val;
		}
		
		public void setVal(char val) {
			this.val = val;
		}
		
		public Node getLeftNode() {
			return leftNode;
		}
		
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		
		public Node getRightNode() {
			return rightNode;
		}
		
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		
	}
	
	// ���� ��ȸ
	public static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		// ��Ʈ -> �� -> ��
		sb.append(root.getVal());
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}
	
	// ���� ��ȸ
	public static void inOrder (Node root) {
		if(root == null) {
			return;
		}
		// �� -> ��Ʈ -> ��
		inOrder(root.getLeftNode());
		sb.append(root.getVal());
		inOrder(root.getRightNode());
	}
	
	// ���� ��ȸ
	public static void postOrder (Node root) {
		if(root == null) {
			return;
		}
		// �� -> �� -> ��Ʈ
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		sb.append(root.getVal());
	}
		
			
	
	
}


