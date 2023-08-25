public class Hideout<T> {
    private T hiddenObject;

    public Hideout() {
        hiddenObject = null;
    }
    
    public void putIntoHideout(T toHide) {
        hiddenObject = toHide;
    }
    
    public T getFromHideout() {
        return hiddenObject;
    }
    
    public T takeFromHideout() {
        if (hiddenObject == null) {
            return null;
        }
        T object = hiddenObject;
        hiddenObject = null;
        return object;
    }
    
    public boolean isInHideout() {
        if (hiddenObject == null) {
            return false;
        }
        return true;
    }
    
    
}
