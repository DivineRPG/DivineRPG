package divinerpg.objects.entities.entity;

import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public abstract class EntityDivineRPGBoss extends EntityDivineRPGMob {
    private BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE,
            BossInfo.Overlay.PROGRESS));
    private int deathTicks;

    public EntityDivineRPGBoss(World par1World) {
        super(par1World);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean canDespawn() {
        return false;
    }

    @Override
    public boolean isNonBoss() {
        return false;
    }

    public Color getBarColor() {
        return Color.BLUE;
    }

    @Override
    public void addTrackingPlayer(EntityPlayerMP player) {
        super.addTrackingPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void removeTrackingPlayer(EntityPlayerMP player) {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
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
                this.world.playBroadcastSound(1028, new BlockPos(this), 0);
            }
        }

        this.move(MoverType.SELF, 0.0D, 0.10000000149011612D, 0.0D);
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