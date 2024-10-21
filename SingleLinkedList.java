public class SingleLinkedList {
    Node head = null;
    Node tail = null;
    private int size = 0;

    // Appending list to end of linked list
    // If there is no head, set the new node to head.
    public void AddNode(int Data, Boolean flag) {
        if (head == null) {
            head = new Node(Data, null);
            tail = head;
            size++;
            return;
        }

        Node Temp = new Node(Data, null);
        if (flag == true) {
            Temp.SetNext(head);
            head = Temp;

        } else {
            tail.SetNext(Temp);
            tail = Temp;
        }
        size++;
    }

    public int GetData(int index) {
        if (index <= 0) {
            return 0;
        }
        Node Current = head;

        for (int i = 1; i < index; i++) {
            if (Current.GetNext() == null) {
                return 0;
            }
            Current = Current.GetNext();
        }
        return Current.GetData();
    }

    public void PrintAllData() {
        Node current = head;
        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        while (current != null) {
            System.out.print(current.GetData() + (current.GetNext() != null ? "-->" : ""));
            current = current.GetNext(); // Move to the next node
        }
        System.out.print("null"); // Indicate the end of the list
        System.out.println();
    }


    public int GetSize() {
        return size;
    }

    public void Delete(Boolean flag) {
        if (head == null) {
            System.out.println("Error: Attempt to remove from an empty list");
            return;
        }
        if (flag == true) { // Delete from tail
            Node Current = head;
            for (int i = 0; i < size; i++) {
                if (Current.GetNext() == tail) {
                    tail = null;
                    Current.SetNext(null);
                    tail = Current;
                    size--;
                }
                Current = Current.GetNext();
            }
        } else { // Delete from head
            Node Temp = head;
            head = head.GetNext();
            Temp.SetNext(null);
            size--;
        }
    }
}



