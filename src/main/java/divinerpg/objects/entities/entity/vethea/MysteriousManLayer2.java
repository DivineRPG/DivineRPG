package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityGifterNPC;
import divinerpg.registry.ModItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MysteriousManLayer2 extends EntityGifterNPC {

    public MysteriousManLayer2(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ModItems.darvenLump, 6);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.mysterious_man_layer_2.1", "message.mysterious_man_layer_2.2", "message.mysterious_man_layer_2.3", "message.mysterious_man_layer_2.4" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.mysterious_man_layer_2.name";
    }
}
