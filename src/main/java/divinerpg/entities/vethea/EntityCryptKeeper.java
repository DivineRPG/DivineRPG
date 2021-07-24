package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityGifterNPC;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityCryptKeeper extends EntityGifterNPC {

    public EntityCryptKeeper(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
	}
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.6F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createLivingAttributes().add(Attributes.MAX_HEALTH, EntityStats.cryptKeeperHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.cryptKeeperSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.cryptKeeperFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.amthirmisLump, 5);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.crypt_keeper.1", "message.crypt_keeper.2", "message.crypt_keeper.3", "message.crypt_keeper.4", "message.crypt_keeper.5" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.crypt_keeper.name";
    }
}