import java.util.Scanner;

public class StudentRecord {

    public static class StudentNode {
        public int id;
        public String name;
        public double gpa;
        public long phoneNumber;
        public StudentNode next;

        public StudentNode(int id, String name, double gpa, long phoneNumber) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
            this.phoneNumber = phoneNumber;
            this.next = null;
        }
    }

    public static StudentNode head = null; // Head of the linked list

    public static StudentNode insert(int id, String name, double gpa, long phoneNumber, StudentNode head) {
        StudentNode newNode = new StudentNode(id, name, gpa, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }

    public static void display(StudentNode head) {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.id + " " + temp.name + " " + temp.gpa + " " + temp.phoneNumber);
            temp = temp.next;
        }
    }

    public static void searchById(int id, StudentNode head) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.id + " " + temp.name + " " + temp.gpa + " " + temp.phoneNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Id: " + id + " not found");
    }

    public static void searchByName(String name, StudentNode head) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.gpa + " " + temp.phoneNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with name: " + name + " not found");
    }

    public static void searchByPhoneNumber(long phoneNumber, StudentNode head) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.phoneNumber == phoneNumber) {
                System.out.println(temp.id + " " + temp.name + " " + temp.gpa + " " + temp.phoneNumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with phone number: " + phoneNumber + " not found");
    }

    public static StudentNode delete(int id, StudentNode head) {
        if (head == null) {
            return null;
        }
        StudentNode temp = head;
        if (temp.id == id) {
            head = temp.next;
            System.out.println("Student with Id: " + id + " deleted successfully");
            return head;
        }
        StudentNode prev = null;
        while (temp != null) {
            if (temp.id == id) {
                prev.next = temp.next;
                System.out.println("Student with Id: " + id + " deleted successfully");
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Student with Id: " + id + " not found");
        return head;
    }

    public static StudentNode delete(String name, StudentNode head) {
        if (head == null) {
            return null;
        }
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Student with name: " + name + " deleted successfully");
            return head;
        }
        StudentNode temp = head;
        StudentNode prev = null;
        while (temp != null) {
            if (temp.name.equals(name)) {
                prev.next = temp.next;
                System.out.println("Student with name: " + name + " deleted successfully");
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Student with name: " + name + " not found");
        return head;
    }

    public static StudentNode delete(long phoneNumber, StudentNode head) {
        if (head == null) {
            return null;
        }
        if (head.phoneNumber == phoneNumber) {
            head = head.next;
            System.out.println("Student with phone number: " + phoneNumber + " deleted successfully");
            return head;
        }
        StudentNode temp = head;
        StudentNode prev = null;
        while (temp != null) {
            if (temp.phoneNumber == phoneNumber) {
                prev.next = temp.next;
                System.out.println("Student with phone number: " + phoneNumber + " deleted successfully");
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Student with phone number: " + phoneNumber + " not found");
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        head = insert(1, "Avinash", 9.3, 773198706, head);

        // Sample student records (you can add more)
        insert(2, "Raju", 9.2, 994944176, head);
        insert(3, "Shyam", 8.3, 773099663, head);
        // ... (add more students)

        while (true) {
            System.out.println("\n1. Search");
            System.out.println("2. Display Records");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.println("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nChoose searching method:");
                    System.out.println("1. Search by Id");
                    System.out.println("2. Search by Name");
                    System.out.println("3. Search by phone number");

                    int searchChoice = sc.nextInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter Id: ");
                            int id = sc.nextInt();
                            searchById(id, head);
                            break;
                        case 2:
                            System.out.println("Enter name: ");
                            String name = sc.nextLine(); // Consumes the entire line including spaces
                            searchByName(name, head);
                            break;
                        case 3:
                            System.out.println("Enter phone number: ");
                            long phoneNumber = sc.nextLong();
                            searchByPhoneNumber(phoneNumber, head);
                            break;
                        default:
                            System.out.println("Invalid search option");
                    }
                    break;
                case 2:
                    display(head);
                    break;
                case 3:
                    System.out.println("\nChoose delete option:");
                    System.out.println("1. Delete by Id");
                    System.out.println("2. Delete by Name");
                    System.out.println("3. Delete by phone number");

                    int deleteChoice = sc.nextInt();
                    switch (deleteChoice) {
                        case 1:
                            System.out.println("Enter Id to be deleted: ");
                            int id = sc.nextInt();
                            head = delete(id, head);
                            break;
                        case 2:
                            System.out.println("Enter name to be deleted: ");
                            String name = sc.nextLine();
                            head = delete(name, head);
                            break;
                        case 3:
                            System.out.println("Enter phone number to be deleted: ");
                            long phoneNumber = sc.nextLong();
                            head = delete(phoneNumber, head);
                            break;
                        default:
                            System.out.println("Invalid delete option");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting student record management system");
                        sc.close(); // Close the scanner to avoid resource leaks
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }
    
                    


