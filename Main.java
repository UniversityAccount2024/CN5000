import java.util.Scanner;

public class Main {

    static SingleLinkedList list = new SingleLinkedList();

    public static void main(String[] args) {

        // Defining variable for user input.
        int Input;
        int n;
        int index;
        int delete;

        // Creating Scanner for user input.
        Scanner S = new Scanner(System.in);
        System.out.println("Number of desired elements: ");
        n = S.nextInt();

        // Check for valid input
        if (n > 0) {
            System.out.println("First element: ");
            Input = S.nextInt();
            list.AddNode(Input, false); // Add first element (head)
        }

        while (n > 1) { // Only add additional elements
            System.out.println("Next element: ");
            Input = S.nextInt();
            list.AddNode(Input, true);
            n--;
        }

        // Executing PrintMe method.
        PrintMe();

        System.out.println();
        System.out.println("Index Number: ");
        index = S.nextInt();

        PrintElement(index, list);

        // Deleting an element.
        System.out.println("Enter index to delete: ");
        delete = S.nextInt();
        DeleteIndex(delete, list);

        System.out.println("New List:");
        PrintMe();
    }

    // Method to print all elements in the array.
    static void PrintMe() {
        list.PrintAllData();
    }

    // Method to print the element at a specified index.
    static void PrintElement(int index, SingleLinkedList list) {
        // Check if the index is valid
        if (index < 0 || index >= list.GetSize()) {
            System.out.println("Invalid index");
            return;
        }

        Node current = list.head;
        for (int counter = 0; counter < index; counter++) {
            current = current.GetNext();
        }

        // After the loop, current should point to the node at the specified index
        if (current != null) { // Check if current is not null
            System.out.println("Element at index " + index + ": " + current.GetData());
        } else {
            System.out.println("Node at index " + index + " does not exist.");
        }
    }

    // Method to delete a value at index
    static void DeleteIndex(int delete, SingleLinkedList list) {
        // Validate the index
        if (delete < 0 || delete >= list.GetSize()) {
            System.out.println("Invalid index");
            return;
        }

        // If deleting the head
        if (delete == 0) {
            Node temp = list.head;
            list.head = list.head.GetNext();
            if (list.head == null) {
                list.tail = null;
            }
            temp.SetNext(null);
            System.out.println("Deleted head node with value: " + temp.GetData());
        }
        else {
            // Move to the node before the one to be deleted
            Node current = list.head;
            for (int i = 0; i < delete - 1; i++) {
                current = current.GetNext();
            }

            Node nodeToDelete = current.GetNext();
            if (nodeToDelete == null) { // Safety check
                System.out.println("Invalid index");
                return;
            }

            current.SetNext(nodeToDelete.GetNext());
            if (nodeToDelete == list.tail) {
                list.tail = current;
            }
            nodeToDelete.SetNext(null);
            System.out.println("Deleted node with value: " + nodeToDelete.GetData());
        }
    }
}
