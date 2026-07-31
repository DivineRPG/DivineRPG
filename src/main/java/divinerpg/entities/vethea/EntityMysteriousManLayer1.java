package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.teaker_lump;

public class EntityMysteriousManLayer1 extends EntityGifterNPC {
    public EntityMysteriousManLayer1(EntityType<? extends EntityMysteriousManLayer1> type, Level worldIn) {super(type, worldIn);}
    @Override protected ItemStack getGift() {return new ItemStack(teaker_lump.get(), 3);}
    @Override public String[] getChatMessages() {
        return new String[] {
            "message.mysterious_man_layer_1.1",
            "message.mysterious_man_layer_1.2",
            "message.mysterious_man_layer_1.3"
        };
    }
}