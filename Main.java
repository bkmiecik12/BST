/**
 * Created by Bartłomiej on 11.05.2016.
 */
import java.util.*;
import java.io.*;
public class Main {

    public static  File file = new File("t.txt");
    public static BST tree = new BST();


    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new FileReader(file));
        int i=1;
        s.read();
        while(s.ready()){

            String line="";
            line=s.readLine();
            StringTokenizer st = new StringTokenizer(line," .,-");

            while(st.hasMoreTokens()){
                String word=st.nextToken();
              //  System.out.println(word);
                tree.insert(word,i);
            }
            //System.out.println("----"+i);
            i++;
        }
        s.close();
        //System.out.println(tree.root.word);

        tree.display2(tree.root);
        //tree.bfs(tree.root);
        System.out.println();
        tree.delete("nie");

        tree.display2(tree.root);
        System.out.println(tree.root.word);

    }


}
