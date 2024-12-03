package cs145.labs.lab7;

class Node {
    // where each entry is stored
    String primaryKey;
    String firstName;
    String lastName;
    String streetAddress;
    String city;
    String state;
    String zip;
    String email;
    String phoneNumber;

    Node left, right;

    // initseach node
    public Node(String primaryKey, String firstName, String lastName, String streetAddress,
            String city, String state, String zip, String email, String phoneNumber) {
        this.primaryKey = primaryKey; // un for this Node
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        left = right = null; // child nodes set to null
    }
}
