package net.divinerpg.entities.twilight;

import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySkythernCori extends EntityEdenCori {

    public EntitySkythernCori(World var1) {
        super(var1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.skythernCoriHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.skythernCoriSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.skythernCoriFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.coriIdle);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.coriHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.coriHurt);
    }

    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.skythernSoul;
    }

	@Override
	public String mobName() {
		return "Skythern Cori";
	}
}