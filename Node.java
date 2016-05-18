import java.util.ArrayList;

/**
 * Created by Bartłomiej on 11.05.2016.
 */
public class Node {
    String word;
    Node left;
    Node right;
    Node parent;
    ArrayList<Integer> list = new ArrayList<>();

    Node(String s,int l){
        word=s;
        list.add(l);
        left=null;
        right=null;
    }
    public int compareNodes(String n2)
    {
        if(word.equals(n2)) return 0;
        else if(word.compareTo(n2)>0) return 1;
        else return -1;
    }
    public boolean cmp(String s)
    {
        boolean flaga=true;
        if(word.length()==s.length()){
            for(int i=0;i<s.length() && flaga==true;i++)
            {
                if(word.charAt(i)!=s.charAt(i)) flaga=false;
            }
        }
        else flaga=false;
        return flaga;
    }
}
