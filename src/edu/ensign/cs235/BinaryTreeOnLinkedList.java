package edu.ensign.cs235;

public class BinaryTreeOnLinkedList { //Beginning of class BinaryTreeOnLinkedList

    //Root node
    private treenodes root;


    static class treenodes
    { //Beginning of class treenodes
        public treenodes m_left;
        public treenodes m_right;
        private int m_data; //Data member m_data

        public treenodes(int data)
        { //Beginning of constructor treenodes
            this.m_data = data;
            this.m_left = null;
            this.m_right = null;
        }//End of constructor treenodes
        //Method to get the data in the node
        public int get_value() //Beginning of constructor get_value
        {
            return m_data;
        } //End of Method Get value
    }//End of class treenodes
    public treenodes get_root() //Method to get_root
    {
        return root;
    }//End of method to get_root
    public boolean put(int value) //Beginning of method put
    {
        boolean output = false;
        root = put(root, value);
        if(root.m_data == value)
        {
            return true;
        }
        return output;
    }//End of method put

//    public int get_value()//Beginning of method get_value
//    {
//        return root.m_data;
//
//    }//End of method get_value

    public treenodes put(treenodes root, int value)//Beginning method to put through recursion
    {
        if(root == null)
        {
            root = new treenodes(value);
            return root;
        }

        if(value < root.m_data)
        {
            root.m_left = put(root.m_left, value);
        }
        else
        {
            root.m_right = put(root.m_right, value);
        }
        return root;
    } //End of method to insert using recursion

    public boolean remove(int value)//Beginning of method remove
    {
        if(find(value) == null)
        {
            return false;
        }
        else
        {
        treenodes temp = root;
        temp = remove(temp, value);

        return true;
        }
    }//End of method remove
    public treenodes remove(treenodes node, int value) //Beginning of method remove through recursion
    {
        if(node == null)
        {
            return null;
        }

        if(value < node.m_data)
        {
            node.m_left = remove(node.m_left, value);
        }
        else if(value > node.m_data)
        {
            node.m_right = remove(node.m_right, value);
        }
        else
        {
            if(node.m_left == null || node.m_right == null)
            {
                treenodes temp = node.m_left != null ? node.m_left : node.m_right;

                if(temp == null)
                {
                    return null;
                }
                else
                {
                    return temp;
                }
            }
            else
            {
                treenodes successor = getSuccessor(node);
                node.m_data = successor.m_data;

                node.m_right = remove(node.m_right, successor.m_data);
                return node;
            }
        }

        return node;
    }//End of method remove through recursion

    //Auxiliary methods for remove
    public treenodes getSuccessor(treenodes node)//Beginning of method getSuccessor
    {
        if(node == null)
        {
            return null;
        }

        treenodes temp = node.m_right;

        while(temp.m_left != null)
        {
            temp = temp.m_left;
        }

        return temp;
    }//End of get successor
    public treenodes find(int value) //Beginning of method find
    {
        treenodes temp = root;
        temp = find(temp, value);
        return temp;
    }//End of method find

    public treenodes find(treenodes root, int value) //Beginning of method find through recursion
    {
        // Base Cases: root is null or key is present at root
        if (root == null || root.m_data == value)
        {
            return root;
        }
        // val is greater than root's key
        if (root.m_data > value)
        {
            return find(root.m_left, value);
        }
        // val is less than root's key
        return find(root.m_right, value);
    }//End of method find through recursion


    public void pre_order(treenodes root) //Beginning of method to print in Pre_order
    {
        if(root == null)
        {
            return;
        }

        System.out.print(root.m_data + " ");
        pre_order(root.m_left);
        pre_order(root.m_right);
    }//End of method to print in Pre_order


    public void in_order(treenodes root) //Beginning of method to print in order
    {
        if(root == null)
        {
            return;
        }

        in_order(root.m_left);
        System.out.print(root.m_data + " ");
        in_order(root.m_right);
    }//End of method to print in order


    public void post_order(treenodes root) //Beginning of method to print in post_order
    {
        if(root == null)
        {
            return;
        }

        post_order(root.m_left);
        post_order(root.m_right);
        System.out.print(root.m_data + " ");

    }//End of method to print in post_order
        public void PrintPreOrder(StringBuilder tree, String padding, String pointer, treenodes Node, boolean hassiblings) //Beginning of method to draw tree through recursion
        {
            if (Node != null)
            {
                tree.append(padding);
                tree.append(pointer);
                tree.append(Node.get_value());
                tree.append("\n");

                StringBuilder paddingBuilder = new StringBuilder(padding);
                paddingBuilder.append("|  ");

                String paddingForBoth = paddingBuilder.toString();
                String pointerForRight = ("|___");
                String pointerForLeft = (Node.m_right != null) ? "|---" : "|___";

                PrintPreOrder(tree, paddingForBoth, pointer, Node.m_left, Node.m_right != null);
                PrintPreOrder(tree, paddingForBoth, pointerForRight, Node.m_right, false);
            }
        }//End of method to draw tree through recursion

        public String printTree(treenodes head)//Beginning of method to draw tree
        {
            if (root == null)
            {
                return "";
            }

            StringBuilder tree = new StringBuilder();
            tree.append(get_root().get_value());

            String pointerRight = "|___";
            String pointerLeft = (root.m_right != null) ? "|--- " : "|___";

            PrintPreOrder(tree, "", pointerLeft, root.m_left, root.m_right != null);
            PrintPreOrder(tree, "", pointerRight, root.m_right, false);

            return tree.toString();
        }//End of method to draw tree

}//End of Class Binary tree


