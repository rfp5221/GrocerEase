package Controller;

import Model.ShoppingList;
import Model.ShoppingListMaintenance;
import View.IOHelper;

public class ImportExport {
  private static final String baseFolder = "ImportExport";

  // format the file name before use
  // Yihang Liu (email: yvl5590@psu.edu; github: yihang314)
  /*
  static String filenameFormation (String fileName){
    String formattedFileName = fileName.replaceAll(" ", "_");
    return formattedFileName;
  }

   */

  public static final void exportList(ShoppingList shoppingList) {
    // TODO 10 - Write Controller.ImportExport
    // Yihang Liu (email: yvl5590@psu.edu; github: yihang314)
    /*
     * I used the ShoppingListMaintenanceTest and ImportExport as my references
     */

    //setup the path and file name base on the list name
    String filePath = baseFolder + "/" + shoppingList.getName() + ".txt";


    if (ShoppingListMaintenance.exportList(shoppingList, filePath) == true) {
      System.out.println("File Name (will write to 'ImportExport' folder in project): "
              + shoppingList.getName() + ".txt");

    } else {
      System.out.println("File already existed");
    }

  }

  public static final ShoppingList importList() {
    String fileName = IOHelper.readNonBlankStringFromKeyboard("File Name (will read from 'ImportExport' folder in project)");
    ShoppingList imported = ShoppingListMaintenance.importList(baseFolder + "/" + fileName);
    return imported;
  }
}

