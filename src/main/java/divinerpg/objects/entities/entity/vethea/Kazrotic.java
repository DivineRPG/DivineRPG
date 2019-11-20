package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.entities.entity.projectiles.EntityKazroticShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Kazrotic extends VetheaMob implements IRangedAttackMob {

    public Kazrotic(World worldIn) {
		super(worldIn);
		this.setSize(1.4F, 3f);
		this.setHealth(this.getMaxHealth());
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 1, 15, 60, 15));
	}

    @Override
	protected ResourceLocation getLootTable()
	{
		return DRPGLootTables.ENTITIES_KAZROTIC;
	}

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase entity, float par2) {
        double tx = entity.posX - this.posX;
        double ty = entity.getEntityBoundingBox().minY - this.posY;
        double tz = entity.posZ - this.posZ;
        EntityKazroticShot shot = new EntityKazroticShot(this.world, this);
        shot.shoot(tx, ty, tz, 0.6F, 0.3F);
        this.playSound(ModSounds.VETHEA_BOW, 1.0F, 1.0F);
        this.world.spawnEntity(shot);
        System.out.println("Shot fired");
    }

    @Override
    public void setSwingingArms(boolean b) {
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}
