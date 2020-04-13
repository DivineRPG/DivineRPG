package divinerpg.capabilities.armor;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.binded.IPlayerForgeEvent;
import divinerpg.api.armor.registry.IForgeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Objects;

public class PlayerForgeEvent<T extends Event> implements IPlayerForgeEvent<T> {
    private final IForgeEvent<T> base;
    private final WeakReference<EntityLivingBase> player;
    private boolean isListen = false;

    public PlayerForgeEvent(IForgeEvent<T> base, EntityLivingBase player) {
        this.base = base;
        this.player = new WeakReference<>(player);

        Objects.requireNonNull(base);
        Objects.requireNonNull(player);
    }

    @Override
    public EntityLivingBase getPlayer() {
        return player.get();
    }

    @Override
    public boolean isListening() {
        return isListen;
    }

    /**
     * Subscribe on current event
     */
    @Override
    public void subscribe() {
        if (isListening())
            return;

        Method eventHandlingMethod = DivineAPI.reflectionHelper.findMethod(this.getClass(), "handleEvent", Event.class);
        if (eventHandlingMethod == null) {
            DivineRPG.logger.log(Level.WARN, "Can't find 'handleEvent' method there, maybe it was renamed or signature was changed");
            return;
        }

        Object wasCalled = DivineAPI.reflectionHelper.callMethod(MinecraftForge.EVENT_BUS, "register",
                () -> new Object[]{
                        getParameterClass(), this, eventHandlingMethod, Loader.instance().activeModContainer()
                },
                Class.class, Object.class, Method.class, ModContainer.class);

        if (Boolean.FALSE.equals(wasCalled)) {
            DivineRPG.logger.log(Level.WARN, "Can't find private 'register' method inside EventBus, maybe it was renamed or signature was changed or name was obfuscated");
            return;
        }

        isListen = true;
    }

    /**
     * Unregister from event subscribing
     */
    @Override
    public void unsubscribe() {
        if (!isListening())
            return;

        MinecraftForge.EVENT_BUS.unregister(this);
        isListen = false;
    }

    @Override
    public void handle(T event) {
        base.handle(event);
    }

    @Override
    public Class<T> getParameterClass() {
        return base.getParameterClass();
    }

    /**
     * Listening method. Can handle only if that event is assotiated with current player
     *
     * @param event - forge event
     */
    @SubscribeEvent
    public void handleEvent(T event) {
        if (!getParameterClass().equals(event.getClass()))
            return;

        if (canHandle(event)) {
            handle(event);
        }
    }
}
