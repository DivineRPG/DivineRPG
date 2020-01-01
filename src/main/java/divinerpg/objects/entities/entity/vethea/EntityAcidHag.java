package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModSounds;
import divinerpg.registry.VetheaBlocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAcidHag extends VetheaMob {
	
    public EntityAcidHag(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        
        if (this.world.getBlockState(new BlockPos((int)Math.round(this.posX)-1, MathHelper.floor(this.posY) - 1, (int)Math.round(this.posZ)-1)).isOpaqueCube() && this.world.getBlockState(new BlockPos((int)Math.round(this.posX)-1, MathHelper.floor(this.posY), (int)Math.round(this.posZ)-1)) == Blocks.AIR.getDefaultState()) {
            this.world.setBlockState(new BlockPos((int)Math.round(this.posX)-1, MathHelper.floor(this.posY), (int)Math.round(this.posZ)-1), ModBlocks.acidBlock.getDefaultState());
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }


    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        int var2 =  5;

        if (this.isPotionActive(MobEffects.STRENGTH)) {
            var2 += 3 << this.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            var2 -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        int var3 = 0;

        if (par1Entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEfficiencyModifier((EntityLiving)par1Entity);
            var3 += EnchantmentHelper.getKnockbackModifier((EntityLiving)par1Entity);
            ((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 16 * 5, 1, false, false));
        }

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4) {
            if (var3 > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0) {
                par1Entity.setFire(var5 * 4);
            }
        }

        return var4;
    }

    @Override
    public int getSpawnLayer() {
    	return 1;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.ACID_HAG;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ACID_HAG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ACID_HAG_HURT;
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_ACID_HAG;
    }
}
