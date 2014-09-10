package com.yaoge.struct;

public class RunStruct {
	public static void main(String args[]) {
		TryLinkdeList trylist=new TryLinkdeList();
		Node<String> node=new Node<String>("a");
		Node<String> nodec=new Node<String>("c");
		Node<String> nodeb=new Node<String>("b");
		
		trylist.addNode(node);
		trylist.addNode(nodeb);
		trylist.addNode(nodec);
		
	
		Node nodes=null;
		nodes=trylist.searchNode(node);
		
		
		
		System.out.println(nodes.element);
		
		
	}
}
