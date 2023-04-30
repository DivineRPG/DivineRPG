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

public class EntityCryptKeeper extends EntityGifterNPC {

    public EntityCryptKeeper(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
	}
    
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.9275F;
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "amthirmis_lump")), 5);
    }

    @Override
    protected ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<>();
        messages.addAll(ImmutableList.of("message.crypt_keeper.1", "message.crypt_keeper.2", "message.crypt_keeper.3", "message.crypt_keeper.4", "message.crypt_keeper.5"));
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.crypt_keeper";
    }
}