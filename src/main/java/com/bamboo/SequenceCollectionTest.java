package com.bamboo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wangsaisai
 * @date 2023/10/2
 */
public class SequenceCollectionTest {

  public static void sequencedCollectionTest() {
    SequencedCollection<String> collection = new ArrayList<>();
    collection.add("second");
    collection.addFirst("first");
    collection.addLast("third");

    // first
    System.out.println(collection.getFirst());
    // third
    System.out.println(collection.getLast());
    // [first, second, third]
    System.out.println(collection);
    // [third, second, first]
    System.out.println(collection.reversed());
  }

  public static void sequencedSetTest() {
    SequencedSet<Integer> sets = new LinkedHashSet<>(List.of(1, 2, 3));
    System.out.println(sets.getFirst());   // 1
    System.out.println(sets.getLast());    // 3

    sets.addFirst(0);  // [0, 1, 2, 3]
    sets.addLast(4);   // [0, 1, 2, 3, 4]

    System.out.println(sets);
    System.out.println(sets.reversed());   // [4, 3, 2, 1, 0]
  }

  public static void sequencedMapTest() {
    SequencedMap<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "One");
    map.put(2, "Two");
    map.put(3, "Three");

    System.out.println(map.firstEntry());   // 1=One
    System.out.println(map.lastEntry());    // 3=Three
    System.out.println(map);  // {1=One, 2=Two, 3=Three}

    System.out.println(map.pollFirstEntry());   // 1=One
    System.out.println(map.pollLastEntry());    // 3=Three
    System.out.println(map);  // {2=Two}

    map.putFirst(1, "One");
    map.putLast(3, "Three");

    System.out.println(map);  //{1=One, 2=Two, 3=Three}
    System.out.println(map.reversed());   // {3=Three, 2=Two, 1=One}
  }

  // 有排序功能的集合，不能使用addFirst, addLast等方法
  public static void treeSetTest() {
    TreeSet<Integer> treeSet = new TreeSet<>();
    try {
      treeSet.addFirst(1);
    } catch (UnsupportedOperationException e) {
      System.out.println("TreeSet.addFirst() unsupported");
    }
  }

  // 有排序功能的map，不能使用putFirst, putLast等方法
  public static void treeMapTest() {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    try {
      treeMap.putFirst(1, "One");
    } catch (UnsupportedOperationException e) {
      System.out.println("TreeMap.putFirst() unsupported");
    }
  }

  public static void emptyCollectionTest() {
    SequencedCollection<String> collection = new ArrayList<>();
    try {
      collection.getFirst();
    } catch (NoSuchElementException e) {
      System.out.println("SequencedCollection.getFirst throw NoSuchElementException");
    }

    try {
      collection.getLast();
    } catch (NoSuchElementException e) {
      System.out.println("SequencedCollection.getLast throw NoSuchElementException");
    }
  }

  public static void main(String[] args) {
    sequencedCollectionTest();
    sequencedSetTest();
    sequencedMapTest();
    treeSetTest();
    treeMapTest();
    emptyCollectionTest();
  }

}
