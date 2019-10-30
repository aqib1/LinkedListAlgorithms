package com.example.list;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class LinkedList<E> extends AbstractSequentialList<E> implements Iterable<E>, Collection<E>, List<E> {

	private Node<E> start;
	private Node<E> end;
	private int size;

	public LinkedList<E> push(E e) {
		createLinked(e);
		return this;
	}

	private void createLinked(E e) {
		if (Objects.isNull(start)) {
			createHead(e);
		} else {
			addLast(e);
		}
	}

	public LinkedList<E> addLast(E e) {
		end.next = new Node<>(e);
		end.next.previous = end;
		end = end.next;
		return this;
	}

	public LinkedList<E> addFirst(E e) {
		start.previous = new Node<>(e);
		start.previous.next = start;
		start = start.previous;
		return this;
	}

	private void createHead(E e) {
		start = new Node<>(e);
		end = start;
	}

	@Override
	public String toString() {
		Node<E> temp = end;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.previous;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	public E findMiddleElementUsingSingleDirection() {
		Node<E> fastEnd = end;
		Node<E> slowEnd = end;
		while (!Objects.isNull(fastEnd)) {
			if (!Objects.isNull(fastEnd.previous))
				fastEnd = fastEnd.previous.previous;
			else
				fastEnd = fastEnd.previous;
			slowEnd = slowEnd.previous;
		}

		return slowEnd.value;
	}

	public E findMiddleElementUtalizingSize() {
		Node<E> temp = end;
		int half = (int) (size / 2);
		while (half != 0) {
			temp = temp.previous;
			--half;
		}
		return temp.value;
	}

	public String fifoString() {
		Node<E> temp = start;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.next;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new IllegalAccessError("Access not provided");
	}

	@Override
	public int size() {
		return size;
	}

	class Node<T> {
		private T value;
		private Node<T> next;
		private Node<T> previous;

		public Node() {
			this(null);
		}

		public Node(T value) {
			this.value = value;
			size++;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}
	}
}
