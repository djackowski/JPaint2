public class ThickConverter {


    public static int getThickInteger(String thickness) {
        if(thickness == null) {
            thickness = "Low";
        }
        switch (thickness) {
            case "Low":
                return 1;
            case "Medium":
                return 3;
            case "High":
                return 6;
            default:
                return 1;
        }
    }
}
