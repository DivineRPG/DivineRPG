package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

import javax.annotation.*;

public class EntityTheHunger extends EntityDivineMerchant {


	public EntityTheHunger(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
		super(type, worldIn);
	}

    public String[] getChatMessages() {
        return new String[] {
                "message.hunger.closer",
                "message.hunger.dinner",
                "message.hunger.fatten",
                "message.hunger.hungry"
        };
    }

	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 1), new ItemStack(ItemRegistry.dreamCarrot, 2), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.dreamMelon, 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 5), new ItemStack(ItemRegistry.dreamPie, 5), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 10), new ItemStack(ItemRegistry.dreamCake, 8), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 10), new ItemStack(ItemRegistry.dreamShovel, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 10), new ItemStack(ItemRegistry.dreamPickaxe, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 10), new ItemStack(ItemRegistry.dreamAxe, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 5), new ItemStack(BlockRegistry.barredDoor, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.diskTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.cannonTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.backswordTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.hammerTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.bowTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.staffTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 3), new ItemStack(ItemRegistry.clawTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 5), new ItemStack(ItemRegistry.degradedTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 1), new ItemStack(BlockRegistry.lightDreamBricks, 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 1), new ItemStack(BlockRegistry.darkDreamBricks, 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 1), new ItemStack(BlockRegistry.redDreamBricks, 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 2), new ItemStack(BlockRegistry.dreamDirt, 64), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 1), new ItemStack(BlockRegistry.smoothGlass, 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 4), new ItemStack(BlockRegistry.firelight, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 4), new ItemStack(Blocks.CHEST, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirtyPearls, 2), new ItemStack(ItemRegistry.teakerArrow, 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 1), new ItemStack(ItemRegistry.dreamSweets, 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 5), new ItemStack(ItemRegistry.finishedTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 2), new ItemStack(ItemRegistry.darvenArrow, 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 4), new ItemStack(ItemRegistry.pardimalArrow, 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 6), new ItemStack(ItemRegistry.karosArrow, 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.cleanPearls, 15), new ItemStack(ItemRegistry.minersAmulet, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polishedPearls, 20), new ItemStack(ItemRegistry.dreamFlint, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polishedPearls, 5), new ItemStack(ItemRegistry.glisteningTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polishedPearls, 5), new ItemStack(ItemRegistry.demonizedTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shinyPearls, 40), new ItemStack(ItemRegistry.moonClock, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shinyPearls, 25), new ItemStack(ItemRegistry.bandOfHeivaHunting, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shinyPearls, 1), new ItemStack(ItemRegistry.dreamSours, 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shinyPearls, 4), new ItemStack(ItemRegistry.everArrow, 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shinyPearls, 5), new ItemStack(ItemRegistry.tormentedTemplate, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.rockChunks, 25), new ItemStack(ItemRegistry.karosRockmaul, 1), random.nextInt(7), 0),
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
		super.updateTrades();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.WOLF_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.PLAYER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.WOLF_DEATH;
	}

	@Override
	public void setTradingPlayer(@Nullable PlayerEntity player) {
		boolean flag = this.getTradingPlayer() != null && player == null;
		super.setTradingPlayer(player);
		if (flag) {
			this.stopTrading();
		}

	}

	@Nullable
	@Override
	public PlayerEntity getTradingPlayer() {
		return super.getTradingPlayer();
	}
}