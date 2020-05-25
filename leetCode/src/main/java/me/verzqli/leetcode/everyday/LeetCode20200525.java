package me.verzqli.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class LeetCode20200525 {
    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode head, tail;

    public LeetCode20200525(int capacity) {
        this.size=0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        map = new HashMap<>();
        //����������ǣ�
        head.next=tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            //�޸�valueֵ��������
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedNode addNode = new DLinkedNode(key, value);
            map.put(key, addNode);
            addToHead(addNode);
            size += 1;
            if (size > capacity) {
                //���û���ǵ���Ҫɾ��map�м�¼��
                DLinkedNode lastNode = removeTail();
                map.remove(lastNode);
                size -= 1;
            }
        }

    }

    private DLinkedNode removeTail() {
        //�������˻���tail.prev.prev������
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;

    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
