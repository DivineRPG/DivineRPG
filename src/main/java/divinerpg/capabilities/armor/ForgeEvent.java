package divinerpg.capabilities.armor;

import divinerpg.api.armor.registry.IForgeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Objects;
import java.util.function.Consumer;

public class ForgeEvent<T extends Event> implements IForgeEvent<T> {
    private final Class<T> clazz;
    private final Consumer<T> action;

    public ForgeEvent(Class<T> clazz, Consumer<T> action) {

        this.clazz = clazz;
        this.action = action;

        Objects.requireNonNull(clazz);
        Objects.requireNonNull(action);
    }

    @Override
    public void handle(T event) {
        if (clazz.equals(event.getClass()))
            action.accept(event);
    }

    @Override
    public Class<T> getParameterClass() {
        return clazz;
    }
}
