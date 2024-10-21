public class Node {
    // Our Data
    int Data;

    // Our Pointer
    Node Next;

    public Node(int _data, Node _next) {
        Next = _next;
        Data = _data;
    }

    public Node GetNext() {
        return Next;
    }

    public int GetData() {
        return Data;
    }

    public void SetData(int _data) {
        Data = _data;
    }

    public void SetNext(Node _next) {
        Next = _next;
    }
}