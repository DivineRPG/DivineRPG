package divinerpg.entities.vethea;

import com.google.common.collect.ImmutableList;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class EntityTempleGuardian extends EntityGifterNPC {

    public EntityTempleGuardian(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "cermile_lump")), 10);
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