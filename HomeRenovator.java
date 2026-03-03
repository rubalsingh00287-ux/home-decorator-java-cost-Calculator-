import java.util.Scanner;

public class HomeRenovator{
  private static final double DOOR_AREA = 21.0;
  private static final double WINDOW_AREA = 12.0;
  private static final double PAINT_COVERAGE = 350.0;
  private static final double PAINT_PRICE = 34.99;

  private static final double TAX_RATE = 0.06;
  private static final double LAMINATE_PRICE = 2.25;
  private static final double HARDWOOD_PRICE = 5.50;
  private static final double TILE_PRICE = 3.90;

  private static final double LAMINATE_WASTE = 0.07;
  private static final double HARDWOOD_WASTE = 0.10;
  private static final double TILE_WASTE = 0.08;
  private static double  subtotal = 0.0;

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int choice;
      do{
        printMenu();
        choice = getIntInput(scanner,"choice: ");
        switch(choice){
          case 1:
            paintRoom(scanner);
            break;
          case 2:
            flooring(scanner);
            break;
          case 3:
            viewTotals();
            break;
          case 0:
    System.out.println("\nExiting Home Renovator...");
    System.out.println("Thank you for using the program!");
        break;
          default:
      System.out.println("\n(Press Enter to continue...)");
            scanner.nextLine();
        }
      } while( choice != 0);
     scanner.close();
  }

  private static void printMenu(){
    System.out.println("\n=== Home Renovator ===");
    System.out.println("1) Paint Room");
    System.out.println("2) Flooring");
    System.out.println("3) View Totals");
    System.out.println("0) Exit");
  }
     private static void paintRoom(Scanner scanner){
        System.out.println("\n-- Paint Room --");
        double length = getPositiveDouble(scanner,"Enter room length (ft): ");
        double width = getPositiveDouble(scanner,"Enter room width (ft): ");
        double height = getPositiveDouble(scanner,"Enter room height (ft): ");

        int doors = getNonNegativeInt(scanner,"Enter number of doors: ");
        int windows = getNonNegativeInt(scanner,"Enter number of windows: ");

        double perimeter = 2 * (length + width);
        double wallArea = perimeter * height;
        double openingArea = (doors * DOOR_AREA) + (windows * WINDOW_AREA);
        double netArea = wallArea - openingArea;
          if( netArea < 0 ) netArea = 0;

          double gallons = Math.ceil( netArea / PAINT_COVERAGE );
          double materialCost = gallons * PAINT_PRICE;
          double tax = materialCost * TAX_RATE ;
          double lineTotal = materialCost + tax;
          subtotal += materialCost;
        System.out.printf("\nWall area: %.2f sq ft\n",wallArea);
        System.out.printf("Opeinings area: %.2f sq ft\n",openingArea);
        System.out.printf("Net paint area: %.2f sq ft\n",netArea);
        System.out.printf("Gallons required: %.2f\n",gallons);
        System.out.printf("Material cost (@ $%.2f/gal): $%.2f\n",PAINT_PRICE,materialCost);
        System.out.printf("Line total (with tax): $%.2f\n",lineTotal);
        System.out.printf("\n[Paint module complete. Added $%.2f to running total.]\n",lineTotal);
  }
   private static void flooring(Scanner scanner){
      System.out.println("\n-- Flooring --");
     double length = getPositiveDouble(scanner, "Enter room length (ft): ");
     double width = getPositiveDouble(scanner, "Enter room width (ft): ");

     System.out.println("\nSelect flooring type:");
     System.out.println("1) Laminate ($2.25/sq ft, 7% waste)");
     System.out.println("2) Hardwood ($5.50/sq ft, 10% waste)");
     System.out.println("3) Tile ($3.90/sq ft, 8% waste)"); 

     int type;
     double price = 0.0;
     double waste = 0.0;
     while(true){
       type = getIntInput(scanner, "choice ");
       if( type == 1){
       price = LAMINATE_PRICE;
       waste = LAMINATE_WASTE;
       break;
     } else if( type == 2){
       price = HARDWOOD_PRICE;
       waste = HARDWOOD_WASTE;
       break;
   } else if( type == 3){
       price = TILE_PRICE;
       waste = TILE_WASTE;
       break;
} else {
  System.out.println("Invalid flooring option. Try again.");
}}
  double area = length * width;
  double adjustedArea = area * (1 + waste);
  double materialCost = adjustedArea * price;
  double tax = materialCost * TAX_RATE;
  double lineTotal = materialCost + tax;
  subtotal += materialCost;

 System.out.printf("\nFlooring area: %.2f sq ft\n",area);
 System.out.printf("Adjusted area (with %.0f%% waste): %.2f sq ft\n", waste * 100, adjustedArea);
 System.out.printf("Price per sq ft: $%.2f\n",price);
 System.out.printf("Material cost: $%,.2f\n",materialCost);
 System.out.printf("Line total (with tax): $%,.2f\n",lineTotal);
 System.out.printf("\n[Flooring module complete. Added $%,.2f to running total.]\n",lineTotal);
}

   private static void viewTotals(){
     double tax = subtotal * TAX_RATE;
     double grandTotal = subtotal + tax;
     System.out.println("\n-- Current Totals --");
     System.out.printf("Subtotal: $%,.2f\n",subtotal);
     System.out.printf("Tax: $%.2f\n",tax);
     System.out.printf("Grand Total: $%,.2f\n",grandTotal);
   }

private static double getPositiveDouble(Scanner scanner, String prompt){
   double value;
    while(true){
    System.out.print(prompt);
    if(scanner.hasNextDouble()) {
      value = scanner.nextDouble();
      scanner.nextLine();
      if( value > 0) {
        return value;
      }
    } else {
      scanner.nextLine();
    }
    System.out.println("Invalid input. Please enter a positive value.");
    }}
 private static int getNonNegativeInt( Scanner scanner, String prompt){
    int value;
   while(true) {
     System.out.print(prompt);
     if(scanner.hasNextInt()){
       value = scanner.nextInt();
       if( value >= 0){
         return value;
       }
     }else {
       scanner.nextLine();
     }
    System.out.println("Invalid input. Please enter 0 or greater.");
   }}
  private static int getIntInput(Scanner scanner, String prompt){
    int value;
    while(true)
      {
      System.out.print(prompt);
      if(scanner.hasNextInt()){
        value = scanner.nextInt();
        scanner.nextLine();
        return value;
      } else {
        scanner.nextLine();
        System.out.println("Invalid input. Please enter a valid number.");
      }}
  }
}

      
     

     















    
    
    




















  
      
        












            
        
  
