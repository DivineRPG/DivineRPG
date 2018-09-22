package naturix.divinerpg.entities.entity.vanilla;

import naturix.divinerpg.DivineRPG;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class JungleBat extends EntityBat
{
	public JungleBat(World worldIn) {
		super(worldIn);
		this.setHealth(this.getMaxHealth());
	}
	public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/bat_jungle");
	private ResourceLocation deathLootTable = LOOT;
	@Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }
}