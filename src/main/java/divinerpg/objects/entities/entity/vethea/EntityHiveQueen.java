package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityHiveQueen extends EntityDivineBoss {

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


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getHealth() > 0) {
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
    }
}
