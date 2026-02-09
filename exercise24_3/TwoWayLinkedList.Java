/*Program name: TwoWayLinkedList.java
* Author: Laura Amorim
* Date last updated: 02/09/2026
* Purpose: implement TwoLinkedList class (doubly linked list)
*/
import java.util.*;
import java.io.*;

public class TwoWayLinkedList <E> implements MyList <E> 
{
    protected Node<E> head, tail;
    protected int size = 0; 

    public TwoWayLinkedList() {} //constructor

    public class Node<E> 
    {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) 
        {
            element = e;
        }
    }

    public TwoWayLinkedList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]); 
    }

    public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
    }

    public E getLast() {
        if (size == 0) {
        return null;
        }
        else {
        return tail.element;
        }
    }

    public void addFirst (E e)
    {
        Node <E> newNode = new Node<> (e) //new element

        newNode.next = head;
        newNode.previous = null;

        if(head != null)
        {
            head.previous = newNode;
        }

        head = newNode;

        if(tail == null)
        {
            tail = head;
        }

        size++;
    }

    public void addLast(E e)
    {
        Node <E> newNode = new Node<> (e) //new element

        newNode.next = null;
        newNode.previous = tail;

        if(tail != null)
        {
            tail.next = newNode;
        }

        tail = newNode;

        if(head == null)
        {
            head = tail;
        }

        size++;
    }

    @Override

    public void add(int index, E e)
    {
        if (index == 0)
        {
            addFirst(e);
            return;
        } else if (index >= size) 
            {
                addLast(e);
                return;
            }
        
            Node<E> current = head;
            for (int = 0; i < index; i++)
            {
                current = current.next;
            }

            Node<E> newNode = new Node

            newNode.next = current;
            newNode.previous = current.previous;

            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }

    public E removeFirst()
    {
        if (size == 0) 
        {
            return null;
        }

        E temp = head.element;
        head = head.next;

        if(head!== null)
        {
            head.previous = null;
        } else {
            tail =null;
        }

        size--;
        return temp;
    }

   public E removeLast()
   {
        if (size == 0) 
        {
            return null;
        }

        E temp = tail.element;
        tail = tail.previous;

        if(tail != null)
        {
            tail.next = null;
        } else{
            head = null;
        }

        size--;
        return temp;
   }

   @Override
   public void remove(int index)
   {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        Node<E> previous = head;

        for (int i = 1; i < index; i++) 
        {
            current = current.next
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;

        size--;
        return current.element;
   }

    @Override
    public ListIterator<E> listIterator() 
    {
        return new TwoWayListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) 
    {
        return new TwoWayListIterator(index);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear() 
    {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object e) 
    {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.element;
    }

    @Override
    public int indexOf(Object e) 
    {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if (current.element.equals(e))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = tail;
        int index = size - 1;

        while (current != null) {
            if (current.element.equals(e))
                return index;
            current = current.previous;
            index--;
        }
        return -1;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size)
            return null;

        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        E old = current.element;
        current.element = e;
        return old;
    }

    
    private class TwoWayListIterator implements ListIterator<E>
    {
        private Node<E> current;
        private int index;

        public TwoWayLinkedList(int index) 
        {
            this.index = index;
            current = head;
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }

            @Override
            public boolean hasNext{
                return current != null;
            }

            @Override
            public E next()
            {
                E e = current.element;
                current = current.next;
                index++;
                return e;
            }

            @Override
            public boolean hasPrevious()
            {
                return (current != null && current.previous != null) || (current == null && tail != null);
            }

            @Override
            public E previous()
            {
                if (current == null)
                {
                    current = tail;
                } else {
                    current = current.previous;
                }

                index--;
                return current.element;
            }

        @Override
        public int nextIndex() 
        {
            return index;
        }   

        @Override
        public int previousIndex() 
        {
            return index - 1;
        }
        }

    }

}