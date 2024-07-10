package divinerpg.entities.vethea;

import com.google.common.collect.ImmutableList;
import divinerpg.entities.base.EntityGifterNPC;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class EntityTempleGuardian extends EntityGifterNPC {

    public EntityTempleGuardian(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.865F;
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.cermile_lump.get(), 10);
    }

    @Override
    protected ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<>();
        messages.addAll(ImmutableList.of("message.temple_guardian.1", "message.temple_guardian.2", "message.temple_guardian.3", "message.temple_guardian.4", "message.temple_guardian.5"));
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.temple_guardian";
    }
}