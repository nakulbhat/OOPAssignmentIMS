import java.util.*;

class Comments1
{
    String comment;
    
    Comments1(String comment) {this.comment=comment;}
    
    void display() {System.out.println(comment);}
}

class Comments1Demo
{
    public static void main(String[] args)
    {
        String x="------------This is first Comment.------------";
        Comments1 ob=new Comments1(x);
        ob.display();
    }
}