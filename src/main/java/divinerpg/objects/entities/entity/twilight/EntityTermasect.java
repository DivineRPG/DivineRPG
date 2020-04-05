package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.ArrowType;
import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightMageShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntityTermasect extends EntityDivineRPGBoss {
	//TODO - Make throw logs at player/polish loot table/add spawn method
	public EntityTermasect(World par1World) {
		super(par1World);
		this.setSize(0.9F, 3F);
	}
	
	@Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1050);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }

    @Override
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
        this.world.profiler.startSection("mobBaseTick");

        if (this.isEntityAlive() && this.rand.nextInt(1000) < this.livingSoundTime++)
        {
            this.playLivingSound();
            EntityTermid termid = new EntityTermid(world);
            termid.setLocationAndAngles(this.posX + rand.nextInt(4), this.posY, this.posZ + rand.nextInt(4), this.rotationYaw, this.rotationPitch);
            if(rand.nextInt(5) == 1) {
            world.spawnEntity(termid);
            }
        }

        this.world.profiler.endSection();
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_TERMASECT;
    }

}
