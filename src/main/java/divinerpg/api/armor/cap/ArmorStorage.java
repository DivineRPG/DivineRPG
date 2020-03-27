package divinerpg.api.armor.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Actually we do not need to save any information.
 * All info will be calculated during the game
 */
public class ArmorStorage implements Capability.IStorage<IArmorPowers> {
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IArmorPowers> capability, IArmorPowers instance, EnumFacing side) {
        return new NBTTagCompound();
    }

    @Override
    public void readNBT(Capability<IArmorPowers> capability, IArmorPowers instance, EnumFacing side, NBTBase nbt) {
    }
}
