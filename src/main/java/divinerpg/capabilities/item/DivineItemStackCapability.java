package divinerpg.capabilities.item;

public class DivineItemStackCapability {
    private float value;
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
