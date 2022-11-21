package com.wenqi.doudou.algorithm.trieTree;

import com.wenqi.doudou.algorithm.utils.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Code01_Trie {

    // 只有26个小写字母
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] next;

        public Node1() {
            next = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String s) {
            if (s == null || "".equals(s)) {
                return;
            }

            char[] chars = s.toCharArray();

            Node1 currNode = root;
            currNode.pass++;

            for (char aChar : chars) {
                int path = aChar - 'a';

                if (currNode.next[path] == null) {
                    currNode.next[path] = new Node1();
                }
                currNode = currNode.next[path];
                currNode.pass++;
            }
            currNode.end++;

        }

        public void delete(String s) {
            if (s == null || "".equals(s)) {
                return;
            }

            if (search(s) == 0) {
                return;
            }
            // 假如有s
            char[] chars = s.toCharArray();
            Node1 currNode = root;
            currNode.pass--;

            for (char aChar : chars) {
                int path = aChar - 'a';
                currNode = currNode.next[path];
                currNode.pass--;
            }
            currNode.end--;

        }

        public int search(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Node1 currNode = root;

            for (char aChar : chars) {
                int path = aChar - 'a';

                if (currNode.next[path] == null) {
                    return 0;
                }
                currNode = currNode.next[path];
            }
            return currNode.end;
        }

        // 公共前缀
        public int prefixNumber(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }

            char[] chars = s.toCharArray();
            Node1 currNode = root;

            for (char aChar : chars) {
                int path = aChar - 'a';

                if (currNode.next[path] == null) {
                    return 0;
                }
                currNode = currNode.next[path];

            }
            return currNode.pass;
        }
    }

    public static class Node2 {
        public int pass;
        public int end;
        public Map<Character, Node2> next;

        public Node2() {
            next = new HashMap<>();
        }
    }

    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String s) {
            if (s == null || "".equals(s)) {
                return;
            }

            char[] chars = s.toCharArray();

            Node2 currNode = root;
            currNode.pass++;

            for (char aChar : chars) {
                currNode.next.putIfAbsent(aChar, new Node2());
                currNode = currNode.next.get(aChar);
                currNode.pass++;
            }
            currNode.end++;

        }

        public void delete(String s) {
            if (s == null || "".equals(s)) {
                return;
            }

            if (search(s) == 0) {
                return;
            }
            char[] chars = s.toCharArray();
            Node2 currNode = root;
            currNode.pass--;

            for (char aChar : chars) {
                currNode = currNode.next.get(aChar);
                currNode.pass--;
            }
            currNode.end--;

        }

        public int search(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Node2 currNode = root;

            for (char aChar : chars) {
                if (currNode.next.get(aChar) == null) {
                    return 0;
                }
                currNode = currNode.next.get(aChar);
            }
            return currNode.end;
        }

        // 公共前缀
        public int prefixNumber(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }

            char[] chars = s.toCharArray();
            Node2 currNode = root;

            for (char aChar : chars) {
                if (currNode.next.get(aChar) == null) {
                    return 0;
                }
                currNode = currNode.next.get(aChar);
            }
            return currNode.pass;
        }
    }

    public static class Right {
        private Map<String, Integer> map;

        public Right() {
            map = new HashMap<>();
        }

        public void insert(String s) {
            if (s == null || "".equals(s)) {
                return;
            }
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }

        }

        public void delete(String s) {
            if (s == null || "".equals(s)) {
                return;
            }
            if (!map.containsKey(s)) {
                return;
            }
            Integer integer = map.get(s);
            if (integer == 1) {
                map.remove(s);
            } else {
                map.put(s, integer - 1);
            }
        }

        public int search(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            return map.getOrDefault(s, 0);
        }

        // 公共前缀
        public int prefixNumber(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }

            Set<String> keys = map.keySet();

            return keys.stream()
                    .filter(it -> it.startsWith(s))
                    .map(it -> map.get(it))
                    .mapToInt(it -> it).sum();
        }


    }


    public static void main(String[] args) {
        int testTime = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            String[] arr = Util.generateRandomStringArray(30, 8);
            Right right = new Right();
            Trie1 trie1 = new Trie1();
            Trie2 trie2 = new Trie2();
            for (int j = 0; j < arr.length; j++) {
                double random = Math.random();
                if (random < 0.5) {
                    right.insert(arr[j]);
                    trie1.insert(arr[j]);
                    trie2.insert(arr[j]);
                } else if (random < 0.6) {
                    right.delete(arr[j]);
                    trie1.delete(arr[j]);
                    trie2.delete(arr[j]);
                } else if (random < 0.8) {
                    int s0 = right.search(arr[j]);
                    int s1 = trie1.search(arr[j]);
                    int s2 = trie2.search(arr[j]);
                    if (!(s0 == s1 && s1 == s2)) {
                        System.out.println("fuck....");
                        succeed = false;
                    }
                } else {
                    int s0 = right.prefixNumber(arr[j]);
                    int s1 = trie1.prefixNumber(arr[j]);
                    int s2 = trie2.prefixNumber(arr[j]);
                    if (!(s0 == s1 && s1 == s2)) {
                        System.out.println("fuck....");
                        succeed = false;
                    }
                }
            }
        }

        System.out.println(succeed ? "Nice..." : "Fuck...");


    }


}

