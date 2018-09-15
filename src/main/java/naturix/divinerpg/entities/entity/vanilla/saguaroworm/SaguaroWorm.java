package naturix.divinerpg.entities.entity.vanilla.saguaroworm;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SaguaroWorm extends EntityMob {

    public SaguaroWorm(World par1World) {
        super(par1World);
        this.setSize(0.5F, 3F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16);
    }

    @Override
    public void entityInit() {
        super.entityInit();

    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote) {
//            this.entityToAttack = this.world.getClosestPlayerToEntity(this, 10);
//            if(entityToAttack == null) this.dataWatcher.updateObject(17, 0);
//            else {
//                this.dataWatcher.updateObject(17, 1);
//                if(this.ticksExisted%50==0) this.attack((EntityLivingBase)entityToAttack);
//            }
//        }
//        if(this.dataWatcher.getWatchableObjectInt(17)==0)this.renderYawOffset=0;
    }
    }

    @Override
    public void dropFewItems(boolean hit, int looting) {
        this.dropItem(ModItems.shardTerran, this.rand.nextInt(3+looting));
        this.dropItem(Item.getItemFromBlock(Blocks.CACTUS), this.rand.nextInt(3)+3);
    }

    public void attack(EntityLivingBase e) {
        double y = this.getEntityBoundingBox().minY+2.7;
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - y;
        double tz = e.posZ - this.posZ;

        for(double h = -1.5; h<1.5; h+=0.3) {
            for (double r = 0; r < 1.5 - Math.abs(h); r += 0.3) {
                for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 8) {
                    SaguaroWormShot shot = new SaguaroWormShot(this.world, this);
                    shot.posX = this.posX + r * Math.cos(theta);
                    shot.posY = this.posY + 5 + h;
                    shot.posZ = this.posZ + r * Math.sin(theta);
                    shot.setPositionAndUpdate(tx, ty, tz);
                    shot.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
                    world.spawnEntity(shot);
                }
            }
        }
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos pos = this.getPosition();
    	return this.world.getBlockState(pos) == Blocks.SAND;
    }

    protected void addAttackingAI() {
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 0,false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, collided, null));
	}

}