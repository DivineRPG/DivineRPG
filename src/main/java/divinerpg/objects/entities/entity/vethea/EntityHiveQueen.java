package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityHiveQueen extends EntityDivineRPGBoss {

    private int spawnTick;
    private int deathTicks;

    public EntityHiveQueen(World var1) {
        super(var1);
        addAttackingAI();
        this.spawnTick = 80;
        this.setSize(1.5F, 4.0F);
    }
    
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1500);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(60);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.spawnTick % 40 == 0 && !this.world.isRemote && this.world.getClosestPlayerToEntity(this, 20) != null) {
            if (this.rand.nextBoolean()) {
                EntityHoverStinger var2 = new EntityHoverStinger(this.world);
                var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.spawnEntity(var2);
                this.world.spawnParticle(EnumParticleTypes.REDSTONE, var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);
            } else {
                EntityHiveSoldier var2 = new EntityHiveSoldier(this.world);
                var2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.spawnEntity(var2);
                this.world.spawnParticle(EnumParticleTypes.REDSTONE, var2.posX, var2.posY + 0.5D, var2.posZ, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D, this.rand.nextGaussian() * 2.0D - 1.0D);

            }
            spawnTick = 80;
        }

        this.spawnTick--;
    }

    @Override
    protected void onDeathUpdate() {
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + var1, this.posY + 2.0D + var2, this.posZ + var3, 0.0D, 0.0D, 0.0D);
        }
        int var4, var5;
        if (!this.world.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
                var4 = 1000;
                while (var4 > 0) {
                    var5 = EntityXPOrb.getXPSplit(var4);
                    var4 -= var5;
                    this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, var5));
                }
            }
            if (this.deathTicks == 1) {
                this.world.playBroadcastSound(1018, new BlockPos((int) this.posX, (int) this.posY, (int) this.posZ), 0);
            }
        }

        this.move(MoverType.PLAYER, 0.0D, 0.10000000149011612D, 0.0D);
        this.renderYawOffset = this.rotationYaw += 20.0F;

        if (this.deathTicks == 200 && !this.world.isRemote) {
            var4 = 2000;

            while (var4 > 0) {
                var5 = EntityXPOrb.getXPSplit(var4);
                var4 -= var5;
                this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, var5));
            }
            this.setDead();
        }
    }
}
