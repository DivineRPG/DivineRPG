package divinerpg.api.armor.cap;

import divinerpg.DivineRPG;
import divinerpg.capabilities.armor.ArmorPowers;
import divinerpg.networking.message.ArmorStatusChangedMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

public class ArmorProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IArmorPowers.class)
    public static final Capability<IArmorPowers> ArmorCapability = null;

    private final IArmorPowers instance;
    private final WeakReference<EntityPlayer> player;

    public ArmorProvider(EntityPlayer player) {
        instance = new ArmorPowers(player);
        this.player = new WeakReference<>(player);

        // Client side is creating more often
        // So I send request from server to confirm
        // what armor is equipped
        if (player.world.isRemote) {
            DivineRPG.network.sendToServer(new ArmorStatusChangedMessage(new ResourceLocation(""), true));
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == ArmorCapability;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return hasCapability(capability, facing)
                ? ArmorCapability.cast(instance)
                : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return ArmorCapability.getStorage().writeNBT(ArmorCapability, instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        ArmorCapability.getStorage().readNBT(ArmorCapability, instance, null, nbt);
    }
}
