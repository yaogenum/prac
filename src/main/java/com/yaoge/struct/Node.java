package com.yaoge.struct;

public class Node<E> {
	
	E element;
	Node<E> beforeNode ;
	Node<E> afterNode ;
	
	Node () {
		
	}
	
	Node (E element){
		this.element=element;
	}
	
	Node (E element , Node<E> beforeNode ,Node<E> afterNode) {
		this.element = element ;
		this.beforeNode = beforeNode ;
		this.afterNode = afterNode ;
	}
	
	
}
