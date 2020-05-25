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
        //这个不能忘记；
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
            //修改value值不能忘了
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedNode addNode = new DLinkedNode(key, value);
            map.put(key, addNode);
            addToHead(addNode);
            size += 1;
            if (size > capacity) {
                //这个没考虑到。要删除map中记录。
                DLinkedNode lastNode = removeTail();
                map.remove(lastNode);
                size -= 1;
            }
        }

    }

    private DLinkedNode removeTail() {
        //这个想错了还用tail.prev.prev来做。
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
