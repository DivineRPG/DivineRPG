package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityGifterNPC;
import divinerpg.registries.ItemRegistry;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityMysteriousManLayer1 extends EntityGifterNPC {

    public EntityMysteriousManLayer1(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.teakerLump, 3);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.mysterious_man_layer_1.1", "message.mysterious_man_layer_1.2", "message.mysterious_man_layer_1.3" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.mysterious_man_layer_1.name";
    }

    public int getSpawnLayer() {
        return 1;
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