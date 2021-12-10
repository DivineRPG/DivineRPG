package divinerpg.entities.vethea;

import com.google.common.collect.*;
import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityMysteriousManLayer3 extends EntityGifterNPC {

    public EntityMysteriousManLayer3(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.pardimalLump, 10);
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
    public boolean checkSpawnRules(IWorld world, SpawnReason spawnReason) {
        int spawnLayer = this.getSpawnLayer();

        if(spawnLayer == 0) {
            return super.checkSpawnRules(world, spawnReason);
        }
        else {
        	return this.getY() < 48.0D * spawnLayer && this.getY() > 48.0D * (spawnLayer - 1) && super.checkSpawnRules(world, spawnReason);
        }
    }
}