package divinerpg.capabilities.item;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DivineItemStackCapabilityProvider implements ICapabilityProvider {
    @CapabilityInject(DivineItemStackCapability.class)
    public static Capability<DivineItemStackCapability> DIVINE_ITEM_STACK_CAPABILITY = null;
    private DivineItemStackCapability instance = DIVINE_ITEM_STACK_CAPABILITY.getDefaultInstance();

    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == DIVINE_ITEM_STACK_CAPABILITY) {
            return true;
        }
        return false;
    }

    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == DIVINE_ITEM_STACK_CAPABILITY) {
            return (T)instance;
        }
        return null;
    }
}
