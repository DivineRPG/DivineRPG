package divinerpg.objects.entities.entity.vethea;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModSounds;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class AcidHag extends VetheaMob {
	
    public AcidHag(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        BlockPos current = new BlockPos((int)posX - 1, (int)posY, (int)posZ - 1);
        BlockPos below = new BlockPos((int)posX - 1, (int)posY - 1, (int)posZ - 1);
        IBlockState belowState = this.world.getBlockState(below);

        if(this.world.getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.isOpaqueCube() && belowState.isFullCube()) {
                this.world.setBlockState(current, ModBlocks.acidBlock.getDefaultState());
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
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
    public boolean attackEntityAsMob(Entity par1Entity) {
        int var2 =  5;

        if (this.isPotionActive(MobEffects.INSTANT_DAMAGE)) {
            var2 += 3 << this.getActivePotionEffect(MobEffects.INSTANT_DAMAGE).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            var2 -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        int var3 = 0;

        if (par1Entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEfficiencyModifier(this);
            var3 += EnchantmentHelper.getKnockbackModifier(this);
            ((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 16 * 5, 1));
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

    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/vethea/acid_hag");

    private ResourceLocation deathLootTable = LOOT;

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}
}
