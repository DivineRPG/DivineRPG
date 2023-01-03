package divinerpg.entities.vethea;

import com.google.common.collect.ImmutableList;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityGifterNPC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class EntityMysteriousManLayer3 extends EntityGifterNPC {

    public EntityMysteriousManLayer3(EntityType<? extends PathfinderMob> type, Level worldIn) {
    	super(type, worldIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "pardimal_lump")), 10);
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

    public int getSpawnLayer() {
        return 3;
    }

    @Override
    public boolean checkSpawnRules(LevelAccessor world, MobSpawnType spawnReason) {
        int spawnLayer = this.getSpawnLayer();

        if(spawnLayer == 0) {
            return super.checkSpawnRules(world, spawnReason);
        }
        else {
        	return this.getY() < 48.0D * spawnLayer && this.getY() > 48.0D * (spawnLayer - 1) && super.checkSpawnRules(world, spawnReason);
        }
    }
}