package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityLheiva extends VetheaMob {

    public EntityLheiva(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.4f);
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(85.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(19.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        Entity var1 = source.getTrueSource();
        if (var1 != null && var1 instanceof EntityPlayer) {
            if (((EntityPlayer)var1).inventory.hasItemStack(new ItemStack(ModItems.bandOfHeivaHunting)))
                return super.attackEntityFrom(source, par2);
        } else if(source == DamageSource.OUT_OF_WORLD) return super.attackEntityFrom(source, par2);
        return false;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_LHEIVA;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LHEIVA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.LHEIVA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.LHEIVA_HURT;
    }
}