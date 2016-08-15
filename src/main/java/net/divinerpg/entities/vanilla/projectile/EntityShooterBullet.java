package net.divinerpg.entities.vanilla.projectile;

import net.divinerpg.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityShooterBullet extends EntityThrowable {
	
	protected float damage;
	private short xTile;
	private short yTile;
	private short zTile;
	private Block inTile;
	private String throwerName;
	private EntityLivingBase thrower;
	
    public EntityShooterBullet(World world) {
        super(world);
    }

    public EntityShooterBullet(World world, EntityLivingBase entity, float damage, Item ammo) {
        super(world, entity);
        this.damage = damage;
        this.dataWatcher.updateObject(17, Reference.PREFIX + "textures/items/" + ammo.getUnlocalizedName().replace("item.", "") + ".png");
    }
    
    public EntityShooterBullet(World world, EntityLivingBase entity, float damage, String texture) {
        super(world, entity);
        this.damage = damage;
        this.dataWatcher.updateObject(17, texture);
    }
    
    public EntityShooterBullet(World world, double posX, double posY, double posZ, float damage, String texture) {
        super(world, posX, posY, posZ);
        this.damage = damage;
        this.dataWatcher.updateObject(17, texture);
    }
    
    @Override
    protected void entityInit() {
    	this.dataWatcher.addObject(17, "");
    }
    
    public int getBulletId() {
    	return this.dataWatcher.getWatchableObjectInt(17);
    }
    
    @Override
    protected void onImpact(MovingObjectPosition position) {
        if (position.entityHit != null) position.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
        if (!this.worldObj.isRemote) this.setDead();
    }
    
    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        tag.setShort("xTile", (short)this.xTile);
        tag.setShort("yTile", (short)this.yTile);
        tag.setShort("zTile", (short)this.zTile);
        tag.setByte("inTile", (byte)Block.getIdFromBlock(this.inTile));
        tag.setByte("shake", (byte)this.throwableShake);
        tag.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        tag.setString("texture", this.dataWatcher.getWatchableObjectString(17));
        tag.setFloat("damage", this.damage);
        
        if ((this.throwerName == null || this.throwerName.length() == 0) && this.thrower != null && this.thrower instanceof EntityPlayer) this.throwerName = this.thrower.getCommandSenderName();

        tag.setString("ownerName", this.throwerName == null ? "" : this.throwerName);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        this.xTile = tag.getShort("xTile");
        this.yTile = tag.getShort("yTile");
        this.zTile = tag.getShort("zTile");
        this.inTile = Block.getBlockById(tag.getByte("inTile") & 255);
        this.throwableShake = tag.getByte("shake") & 255;
        this.inGround = tag.getByte("inGround") == 1;
        this.throwerName = tag.getString("ownerName");
        this.dataWatcher.updateObject(17, tag.getString("texture"));
        this.damage = tag.getFloat("damage");

        if (this.throwerName != null && this.throwerName.length() == 0) this.throwerName = null;
    }
    
    public String getTextureName() {
    	return this.dataWatcher.getWatchableObjectString(17);
    }
}