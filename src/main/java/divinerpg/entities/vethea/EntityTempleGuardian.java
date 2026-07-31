package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.cermile_lump;

public class EntityTempleGuardian extends EntityGifterNPC {
    public EntityTempleGuardian(EntityType<? extends EntityTempleGuardian> type, Level worldIn) {super(type, worldIn);}
    @Override protected ItemStack getGift() {return new ItemStack(cermile_lump.get(), 10);}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.temple_guardian.1",
            "message.temple_guardian.2",
            "message.temple_guardian.3",
            "message.temple_guardian.4",
            "message.temple_guardian.5"
        };
    }
}