package com.yaoge.struct;

public class TryLinkdeList {

	private volatile static Node header;
	private volatile static Node laster;

	/**
	 * 添加子元素
	 * 先判断header,laster是否为空
	 * @param node
	 * @return
	 */
	public synchronized boolean addNode(Node node) {

		if (header == null) {
			header = node;
		}
		if (laster == null) {
			laster = node;
			header.afterNode = laster;
			laster.beforeNode = header;
			return true;
		}

		laster.afterNode = node;
		node.beforeNode = laster;

		laster = node;

		return true;
	}

	/**
	 * 从laster向上清除节点
	 */
	public void removeLastNode() {
		if (laster == header) {
			header = laster = null;
		}
		synchronized (this) {
			Node tmpNode = laster.beforeNode;
			tmpNode.afterNode = null;
			laster.beforeNode = null;
			laster = tmpNode;
		}

	}
	/**
	 * 清除指定节点
	 * @param node
	 */
	public synchronized void removeNode(Node node) {
		if (laster.element.equals(header.element)) {
			header = laster = null;
		} else if (header.element.equals(node.element)) {
			header = header.afterNode;
			header.beforeNode = null;
		} else if (laster.element.equals(node.element)) {
			laster = laster.beforeNode;
			laster.afterNode = null;
		} else {
			Node beforeNode = node.beforeNode;
			Node afterNode = node.afterNode;
			beforeNode.afterNode = afterNode;
			afterNode.beforeNode = beforeNode;
		}

	}

	public Node searchNode(Node node) {

		if (header == null || laster == null) {

			return null;
		} else {
			synchronized (this) {
				Node tmpNode = header;

				while (tmpNode != null) {

					if (node.element.equals(tmpNode.element)) {
						return tmpNode;
					} else {
						tmpNode = tmpNode.afterNode;
					}

				}

			}

		}
		return null;
	}

}
