package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Deathcryx extends EntityDivineRPGMob {
	
    public Deathcryx(World var1) {
        super(var1);   
        addAttackingAI();
    }
	public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/arcana/deathcryx");
	private ResourceLocation deathLootTable = LOOT;
	@Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
	 

		    @Override
		    protected void applyEntityAttributes() {
		        super.applyEntityAttributes();
		        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.deathcryxHealth);
		        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityStats.deathcryxDamage);
		        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.deathcryxSpeed);
		        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.deathcryxFollowRange);
		    }


		    @Override
		    protected float getSoundVolume() {
		        return 0.7F;
		    }

		    @Override
		    protected SoundEvent getAmbientSound() {
		        return ModSounds.DEATHCRYX;
		    }
		 
		    @Override
		    protected SoundEvent getHurtSound(DamageSource source) {
		        return ModSounds.DEATHCRYX_HURT;
		    }
		 
		    @Override
		    protected SoundEvent getDeathSound() {
		        return ModSounds.DEATHCRYX_HURT;
		    }
		 
		    @Override
		    protected Item getDropItem() {
		        return ModItems.collector;
		    }

		    @Override
		    public boolean attackEntityAsMob(Entity par1Entity) {
		        float var2 = (float)EntityStats.deathcryxDamage;

		        if (this.isPotionActive(MobEffects.INSTANT_DAMAGE)) {
		            var2 += 3 << this.getActivePotionEffect(MobEffects.INSTANT_DAMAGE).getAmplifier();
		        }

		        if (this.isPotionActive(MobEffects.WEAKNESS)) {
		            var2 -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
		        }

		        int var3 = 0;

		        if (par1Entity instanceof EntityLivingBase) {
		            var2 += EnchantmentHelper.getEfficiencyModifier((EntityLivingBase)par1Entity);
		            var3 += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)par1Entity);
		            ((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 16 * 20, 2));
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
		    public boolean getCanSpawnHere() {
		        return this.posY < 40.0D && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
		    }
		}