public class Main {

    private static int passed = 0;
    private static int total = 0;

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    public static void runDemo() {
        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        check("T1", "Circle + VectorRenderer",
                new Circle(1, 2, vector).execute(), "VECTOR circle radius=2");
        check("T2", "Circle + RasterRenderer",
                new Circle(1, 2, raster).execute(), "RASTER circle radius=2");
        check("T3", "Square + VectorRenderer",
                new Square(2, 3, vector).execute(), "VECTOR square side=3");
        check("T4", "Square + RasterRenderer",
                new Square(2, 3, raster).execute(), "RASTER square side=3");

        checkSwitch(vector, raster);

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void check(String id, String classes, String actual, String expected) {
        total++;
        if (actual.equals(expected)) {
            passed++;
            System.out.println(id + " PASS | " + classes + " | result=" + actual);
        } else {
            System.out.println(id + " FAIL | " + classes + " | result=" + actual
                    + " | expected=" + expected);
        }
    }

    private static void checkSwitch(Renderer first, Renderer second) {
        total++;
        Circle circle = new Circle(5, 2, first);
        Shape original = circle;

        String before = circle.execute();
        circle.setImplementation(second);
        String after = circle.execute();

        boolean sameObject = (original == circle);
        boolean stateUnchanged = circle.getId() == 5 && circle.getRadius() == 2;
        boolean resultsOk = before.equals("VECTOR circle radius=2")
                && after.equals("RASTER circle radius=2");

        if (sameObject && stateUnchanged && resultsOk) {
            passed++;
            System.out.println("T5 PASS | sameObject=" + sameObject
                    + " | stateUnchanged=" + stateUnchanged);
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject
                    + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" expected before=VECTOR circle radius=2"
                    + " | after=RASTER circle radius=2");
        }
        System.out.println(" before=" + before + " | after=" + after);
    }
}