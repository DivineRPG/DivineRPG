package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.pardimal_lump;

public class EntityMysteriousManLayer3 extends EntityGifterNPC {
    public EntityMysteriousManLayer3(EntityType<? extends EntityMysteriousManLayer3> type, Level worldIn) {super(type, worldIn);}
    @Override protected ItemStack getGift() {return new ItemStack(pardimal_lump.get(), 10);}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.mysterious_man_layer_3.1",
            "message.mysterious_man_layer_3.2",
            "message.mysterious_man_layer_3.3",
            "message.mysterious_man_layer_3.4"
        };
    }
}