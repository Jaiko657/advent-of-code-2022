package day07;

import java.util.List;

public class Tree<T> {
    private T data;
    private Tree<T> parent;
    private List<Tree<T>> children;

    public Tree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void addChild(Tree<T> child) {
        children.add(child);
        child.parent = this;
    }
}
