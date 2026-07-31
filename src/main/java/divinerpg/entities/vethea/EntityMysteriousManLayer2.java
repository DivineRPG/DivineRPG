package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.darven_lump;

public class EntityMysteriousManLayer2 extends EntityGifterNPC {
    public EntityMysteriousManLayer2(EntityType<? extends EntityMysteriousManLayer2> type, Level worldIn) {super(type, worldIn);}
    @Override protected ItemStack getGift() {return new ItemStack(darven_lump.get(), 6);}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.mysterious_man_layer_2.1",
            "message.mysterious_man_layer_2.2",
            "message.mysterious_man_layer_2.3",
            "message.mysterious_man_layer_2.4"
        };
    }
}