

public class TreeNodePractice {

    int value;
    TreeNodePractice left;
    TreeNodePractice right;

    public TreeNodePractice(int inputValue){
        this.value = inputValue;
    }

    public int getValue(){
        return this.value;

    }
    public void setValue(int inputValue){
        this.value=inputValue;
    }

    //takes in an int that 
    public static TreeNodePractice makeTree(int treeSize) {

        TreeNodePractice root = new TreeNodePractice(treeSize);


        return root;
    }

    public void setLeft(int inputValue){
        this.left = new TreeNodePractice(inputValue);
    }

    public TreeNodePractice getLeft(){
        if(this.left!=null) {
            return this.left;
        }else{
            return null;
        }
    }

    public TreeNodePractice getRight(){
        if(this.right != null) {
            return this.right;
        }else{
            return null;
        }
    }

    public void setRight(int inputValue){
        this.right = new TreeNodePractice(inputValue);
    }

    public void showTree(){

        if (this != null) {
            System.out.println("  "+this.getValue()+" ");
            System.out.println(" / " + "\\");

            if (this.getLeft() != null && this.getRight() != null) {
                System.out.println(this.getLeft().getValue() + "   " + this.getRight().getValue());
            }

            if (this.getLeft() != null && this.getRight() == null) {
                System.out.println(this.getLeft().getValue() + "   ");
            }

            if (this.getLeft() == null && this.getRight() != null) {
                System.out.println("   " + this.getRight().getValue());
            }

        }
        
       
    }

}
