
package cs145.labs.lab7;

import java.util.Scanner;

//class to manage entries
class bst {
    Node root;

    // adds new entry
    public void add(String primaryKey, String firstName, String lastName, String streetAddress,
            String city, String state, String zip, String email, String phoneNumber) {
        // add new node using addRecursive
        root = addRecursive(root, primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
    }

    private Node addRecursive(Node current, String primaryKey, String firstName, String lastName,
            String streetAddress, String city, String state, String zip, String email, String phoneNumber) {
        // makes new node if needed
        if (current == null) {
            return new Node(primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        }
        // keeps tree stable
        if (primaryKey.compareTo(current.primaryKey) < 0) {
            // left
            current.left = addRecursive(current.left, primaryKey, firstName, lastName, streetAddress, city, state, zip,
                    email, phoneNumber);
        } else if (primaryKey.compareTo(current.primaryKey) > 0) {
            // right
            current.right = addRecursive(current.right, primaryKey, firstName, lastName, streetAddress, city, state,
                    zip, email, phoneNumber);
        }
        return current; // common
    }

    // delete
    public boolean delete(String primaryKey) {
        // checks to make sure somthing is there to be deleted
        if (find(primaryKey) == null) {
            return false; // Not found
        }
        // delete using deleteRecursive
        root = deleteRecursive(root, primaryKey);
        return true; // Successfully deleted
    }

    private Node deleteRecursive(Node current, String primaryKey) {
        // base case
        if (current == null) {
            return null;
        }

        if (primaryKey.equals(current.primaryKey)) {
            // used to delete 1 child propperly
            if (current.left == null && current.right == null) {
                return null; // no child nodes
            } else if (current.right == null) {
                return current.left; // child left
            } else if (current.left == null) {
                return current.right; // child node right
            }

            // two child delete
            String smallestValue = findSmallestValue(current.right);
            current.primaryKey = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        // find node to delete
        if (primaryKey.compareTo(current.primaryKey) < 0) {
            current.left = deleteRecursive(current.left, primaryKey);
            return current;
        }

        current.right = deleteRecursive(current.right, primaryKey);
        return current;
    }

    private String findSmallestValue(Node root) {
        return root.left == null ? root.primaryKey : findSmallestValue(root.left);
    }

    // find by key
    public Node find(String primaryKey) {
        return findRecursive(root, primaryKey);
    }

    // search for key
    private Node findRecursive(Node current, String primaryKey) {
        if (current == null || current.primaryKey.equals(primaryKey)) {
            return current;
        }

        return primaryKey.compareTo(current.primaryKey) < 0 ? findRecursive(current.left, primaryKey)
                : findRecursive(current.right, primaryKey);
    }

    // modify entry
    public void modify(String primaryKey) {
        Node node = find(primaryKey); // find node to change
        if (node != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Modify the following fields (leave blank to keep current value):");
            System.out.print("First Name (" + node.firstName + "): ");
            String input = scanner.nextLine();
            if (!input.isEmpty())
                node.firstName = input; // update first

            System.out.print("Last Name (" + node.lastName + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.lastName = input; // update last

            System.out.print("Street Address (" + node.streetAddress + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.streetAddress = input; // update street

            System.out.print("City (" + node.city + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.city = input; // update city

            System.out.print("State (" + node.state + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.state = input; // update state

            System.out.print("Zip (" + node.zip + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.zip = input; // uptade postal code

            System.out.print("Email (" + node.email + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.email = input; // email

            System.out.print("Phone Number (" + node.phoneNumber + "): ");
            input = scanner.nextLine();
            if (!input.isEmpty())
                node.phoneNumber = input; // phone number

            System.out.println("Record modified successfully.");
            scanner.close();
        } else {
            System.out.println("Record not found."); // if node DNE
        }
    }

    // pre-order
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.primaryKey + ": " + node.firstName + " " + node.lastName);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // in-order
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.primaryKey + ": " + node.firstName + " " + node.lastName);
            inOrder(node.right);
        }
    }

    // post-order
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.primaryKey + ": " + node.firstName + " " + node.lastName);
        }
    }

    // menu
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Lookup Record");
            System.out.println("5. List Number of Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // take line

            switch (choice) {
                case 1:
                    // new entry input
                    System.out.print("Enter Primary Key: ");
                    String primaryKey = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Street Address: ");
                    String streetAddress = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    add(primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber); // add
                                                                                                               // the
                                                                                                               // reccord
                    System.out.println("Record added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Primary Key to delete: ");
                    String deleteKey = scanner.nextLine();
                    if (delete(deleteKey)) {
                        System.out.println("Record deleted successfully.");
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Primary Key to modify: ");
                    String modifyKey = scanner.nextLine();
                    modify(modifyKey);
                    break;
                case 4:
                    System.out.print("Choose traversal method (1. Pre-order, 2. In-order, 3. Post-order): ");
                    int traversalChoice = scanner.nextInt();
                    switch (traversalChoice) {
                        case 1:
                            preOrder(root);
                            break;
                        case 2:
                            inOrder(root);
                            break;
                        case 3:
                            postOrder(root);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    System.out.println("Total records: " + countRecords(root));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }
    }

    // count the # of reccords
    private int countRecords(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countRecords(node.left) + countRecords(node.right);
    }
}