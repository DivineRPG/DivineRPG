package divinerpg.entities.vethea;

import com.google.common.collect.ImmutableList;
import divinerpg.entities.base.EntityGifterNPC;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

import java.util.ArrayList;

public class EntityMysteriousManLayer3 extends EntityGifterNPC {
    public EntityMysteriousManLayer3(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
    }
    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.pardimal_lump.get(), 10);
    }
    @Override
    protected ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<>();
        messages.addAll(ImmutableList.of("message.mysterious_man_layer_3.1", "message.mysterious_man_layer_3.2", "message.mysterious_man_layer_3.3", "message.mysterious_man_layer_3.4"));
        return messages;
    }
    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.mysterious_man_layer_3";
    }
}