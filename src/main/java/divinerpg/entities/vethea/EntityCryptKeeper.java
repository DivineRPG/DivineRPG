package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.amthirmis_lump;

public class EntityCryptKeeper extends EntityGifterNPC {
    public EntityCryptKeeper(EntityType<? extends EntityCryptKeeper> type, Level worldIn) {super(type, worldIn);}
    @Override protected ItemStack getGift() {return new ItemStack(amthirmis_lump.get(), 5);}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.crypt_keeper.1",
            "message.crypt_keeper.2",
            "message.crypt_keeper.3",
            "message.crypt_keeper.4",
            "message.crypt_keeper.5"
        };
    }
}