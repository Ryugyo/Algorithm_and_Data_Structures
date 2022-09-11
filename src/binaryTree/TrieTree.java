package binaryTree;

/**
 * Created by Jason Tan on 2022-09-11 14:43
 */
public class TrieTree {

    public static class TrieNode{
        //pass值指通过多少次，如果有字符串经过当前node那么每pass一次就+1
        public int pass;
        //end指当前node是否是一个字符串的end节点，如果是就+1
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            //总共26个字母，所以nexts的长度是26
            //nexts[0] == null说明没有走向‘a'的路，不为null说明有
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //insert一个字符串
        public void insert(String word){
            if (word == null){
                return;
            }

            char[] chs = word.toCharArray();

            //从root开始走
            TrieNode node = root;
            //先给root的pass+1，说明又有新的字符串经过了root
            node.pass++;
            int index = 0;
            for (int i = 0; i<chs.length; i++){
                //一开始index指向第一个字符代表的0-26某一点（比如说a）
                index = chs[i] - 'a';
                //如果当前node的nexts表里对应字母（比如说a，也就是index 0位置）是null
                //说明还没有建立通向目前字母（比如说a）的路，新建一个node将路搭建起来
                if (node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                //将node沿着路往下走到toNode，然后toNode的pass也++因为被经过了一次
                node = node.nexts[index];
                node.pass++;
            }
            //循环结束后说明当前字符串已经添加进tree，所以此node为这个字符串的结束点，end+1
            node.end++;
        }

        //查询word出现过几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;

            //只需要遍历整个字符串，然后从root顺着往下
            for(int i =0; i<chs.length; i++){
                index = chs[i] - 'a';
                //如果当前node的字母位置是null说明没有通往字母的路，返回0
                if (node.nexts[index] == null){
                    return 0;
                }
                //一直沿着字符串的字母走下去
                node = node.nexts[index];
            }
            //最后一位node的end就代表了这一系列的字符出现了几次
            return node.end;
        }

        //所有加入的字符串有多少是word作为前缀的
        public int prefixNumber(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;

            //只需要遍历整个字符串，然后从root顺着往下
            for(int i =0; i<chs.length; i++){
                index = chs[i] - 'a';
                //如果当前node的字母位置是null说明没有通往字母的路，返回0
                if (node.nexts[index] == null){
                    return 0;
                }
                //一直沿着字符串的字母走下去
                node = node.nexts[index];
            }
            //最后一位node的pass就代表了tree里有多少字符串是以node以上一系列作为开头的
            return node.pass;
        }

        //删除word
        public void delete(String word){
            //只有word加入过tree才可以删除，没加入就不删
            if (search(word) != 0){
                //删除很简单，沿途的所有node的pass值--，最后一个node的值end--
                char[] chars = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;
                for (int i=0; i<chars.length; i++){
                    index = chars[i] - 'a';
                    node.nexts[index].pass--;
                    if (node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }
    }
}
