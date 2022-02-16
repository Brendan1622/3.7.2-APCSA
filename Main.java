import java.util.ArrayList;
import java.util.Scanner;

class Main {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);  
    
    ArrayList<String> partList = new ArrayList<String>();
    partList.add("10/32 bolts");
    partList.add("10/32 nuts");
    partList.add("30A sushi rollers");
    partList.add("water jet");
    partList.add("spark max");
    partList.add("neo 550");

    boolean cont = true;

    while (cont) {
      System.out.println(partList);
      System.out.print("What do you want to do? The options are: add, addi, remove, or replace: ");

      String task = sc.nextLine().toLowerCase();

      switch (task) {
        case "add": partList = add(partList); break;
        case "addi": partList = addI(partList); break;
        case "remove": partList = remove(partList); break;
        case "replace": partList = replace(partList); break;
        default:
          System.out.println("That's invalid, quitting program.");
          cont = false;
          break;
      }
    }
  }

  public static ArrayList<String> add(ArrayList<String> partList) {
    System.out.print("Please enter what you want to add to the ArrayList: ");
    String text = sc.nextLine();
    partList.add(text);
    return partList;
  }

  public static ArrayList<String> remove(ArrayList<String> partList) {
    System.out.print("What index do you want to remove? ");
    
    int index = Integer.parseInt(sc.nextLine());
    while (index < 0 || index >= partList.size()) {
      System.out.print("Sorry, that index is out of bounds. Please enter the index you want to remove at: ");
      index = Integer.parseInt(sc.nextLine());
    }

    partList.remove(index);
    return partList;
  }

  public static ArrayList<String> addI(ArrayList<String> partList) {
    System.out.print("Please enter what you want to add to the ArrayList: ");
    String text = sc.nextLine();

    System.out.print("What index do you want to add at? ");
    int index = Integer.parseInt(sc.nextLine());
    while (index < 0 || index >= partList.size()) {
      System.out.print("Sorry, that index is out of bounds. Please enter the index you want to remove at: ");
      index = Integer.parseInt(sc.nextLine());
    }
    
    partList.add(index, text);
    return partList;
  }

  public static ArrayList<String> replace(ArrayList<String> partList) {
    System.out.print("What do you want to replace? ");
    String target = sc.nextLine();

    while (partList.indexOf(target) == -1) {
      System.out.print(target + "is not in the array, what do you want to replace? ");
      target = sc.nextLine();
    }
    
    System.out.print("What do you want to replace " + target + " with? ");
    String thingToReplaceWith = sc.nextLine();

    partList.set(partList.indexOf(target), thingToReplaceWith);
    return partList;
  }
}