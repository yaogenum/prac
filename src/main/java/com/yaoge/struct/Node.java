package com.yaoge.struct;

public class Node<E> {
	
	E element;
	Node<E> beforeNode ;
	Node<E> afterNode ;
	
	Node (E element , Node<E> beforeNode ,Node<E> afterNode) {
		this.element = element ;
		this.beforeNode = beforeNode ;
		this.afterNode = afterNode ;
	}
	
	
}
