package divinerpg.api.armor.cap;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
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
        NBTTagList list = new NBTTagList();
        instance.wearing().forEach(x -> list.appendTag(new NBTTagString(x.toString())));
        return list;
    }

    @Override
    public void readNBT(Capability<IArmorPowers> capability, IArmorPowers instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagList) {
            ((NBTTagList) nbt).forEach(x -> {
                if (x instanceof NBTTagString) {
                    ResourceLocation id = new ResourceLocation(((NBTTagString) x).getString());
                    instance.putOn(id, false);
                }
            });
        }
    }
}
