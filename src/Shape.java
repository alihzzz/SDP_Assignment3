public abstract class Shape {

    private final int id;
    private Renderer renderer;

    public Shape(int id, Renderer renderer) {
        this.id = id;
        this.renderer = renderer;
    }

    public int getId() {
        return id;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = renderer;
    }

    protected Renderer getRenderer() {
        return renderer;
    }

    public abstract String execute();
}