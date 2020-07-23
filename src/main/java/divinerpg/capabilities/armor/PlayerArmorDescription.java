package divinerpg.capabilities.armor;

import divinerpg.DivineRPG;
import divinerpg.api.armor.IEquipped;
import divinerpg.api.armor.binded.IPlayerArmorDescription;
import divinerpg.api.armor.binded.IPlayerForgeEvent;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.networking.message.ArmorStatusChangedMessage;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerArmorDescription implements IPlayerArmorDescription {

    private final WeakReference<EntityLivingBase> player;
    private final IArmorDescription source;
    private final List<IPlayerForgeEvent<?>> handlers = new ArrayList<>();
    private final ResourceLocation id;

    public PlayerArmorDescription(EntityLivingBase player, IArmorDescription source) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(source);

        this.player = new WeakReference<>(player);
        this.source = source;
        id = source.getRegistryName();

        source.getHandlers().forEach(x -> handlers.add(new PlayerForgeEvent<>(x, player)));
    }

    @Override
    public List<IPlayerForgeEvent<?>> getHandlers() {
        return handlers;
    }

    @Override
    public void changeStatus(boolean isOn, boolean sendMessage) {
        IEquipped handler = source.getEquippedHandler();
        if (handler != null) {
            handler.onEquppedChanged(getPlayer(), isOn);
        }

        if (isOn) {
            handlers.forEach(IPlayerForgeEvent::subscribe);
        } else {
            handlers.forEach(IPlayerForgeEvent::unsubscribe);
        }

        // sending message to client
        if (sendMessage && getPlayer() instanceof EntityPlayerMP) {
            DivineRPG.network.sendTo(new ArmorStatusChangedMessage(id, isOn), (EntityPlayerMP) getPlayer());
        }
    }

    @Override
    public EntityLivingBase getPlayer() {
        return player.get();
    }
}
