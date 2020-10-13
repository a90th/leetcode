public class EntityOne implements PolicyOne {

    @Override
    public String getRealClassName() {
        return this.getClass().getCanonicalName();
    }
}
