package divinerpg.objects.entities.entity.vethea;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityHerbomancer extends VetheaMob {

    private int spawnTick;

    public EntityHerbomancer(World var1) {
        super(var1);
        addAttackingAI();
        this.spawnTick = 40;
    }

    @Override
    public int getSpawnLayer() {
    	return 2;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.spawnTick == 0 && !this.world.isRemote) {
            EntityHerbomancerMinion var2 = new EntityHerbomancerMinion(this.world);
            var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
            this.world.spawnEntity(var2);
            this.world.spawnParticle(EnumParticleTypes.REDSTONE, var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);
//            this.world.playSound(var2, var2.getPosition(), SoundRegistry.KAROT, SoundCategory.HOSTILE, 10.0F, 1.0F);
            this.spawnTick = 40;
        }

        this.spawnTick--;
    }
    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        super.playStepSound(pos, blockIn);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}
