package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;

public class EntityTheHunger extends EntityDivineMerchant {
    public EntityTheHunger(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
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

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return 1.8125F;
	}

    @Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();

		DivineTrades[] tradetrades = new DivineTrades[]{
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 1), new ItemStack(ItemRegistry.dream_carrot.get(), 2), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.dream_melon.get(), 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 5), new ItemStack(ItemRegistry.dream_pie.get(), 5), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 10), new ItemStack(ItemRegistry.dream_cake.get(), 8), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 10), new ItemStack(ItemRegistry.dream_shovel.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 10), new ItemStack(ItemRegistry.dream_pickaxe.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 10), new ItemStack(ItemRegistry.dream_axe.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 5), new ItemStack(BlockRegistry.barredDoor.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.disk_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 5), new ItemStack(ItemRegistry.dissipator_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.cannon_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.backsword_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.hammer_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.bow_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.staff_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 3), new ItemStack(ItemRegistry.claw_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 5), new ItemStack(ItemRegistry.degraded_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 1), new ItemStack(BlockRegistry.lightDreamBricks.get(), 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 1), new ItemStack(BlockRegistry.darkDreamBricks.get(), 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 1), new ItemStack(BlockRegistry.redDreamBricks.get(), 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 2), new ItemStack(BlockRegistry.dreamDirt.get(), 64), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 1), new ItemStack(BlockRegistry.smoothGlass.get(), 16), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 4), new ItemStack(BlockRegistry.firelight.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 4), new ItemStack(Blocks.CHEST, 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 2), new ItemStack(ItemRegistry.teaker_arrow.get(), 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.dirty_pearls.get(), 25), new ItemStack(BlockRegistry.mortumBlock.get(), 4), random.nextInt(5), 1),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 1), new ItemStack(ItemRegistry.dream_sweets.get(), 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 5), new ItemStack(ItemRegistry.finished_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 2), new ItemStack(ItemRegistry.darven_arrow.get(), 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 4), new ItemStack(ItemRegistry.pardimal_arrow.get(), 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 6), new ItemStack(ItemRegistry.karos_arrow.get(), 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.clean_pearls.get(), 15), new ItemStack(ItemRegistry.miners_amulet.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polished_pearls.get(), 20), new ItemStack(ItemRegistry.dream_flint.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polished_pearls.get(), 5), new ItemStack(ItemRegistry.glistening_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.polished_pearls.get(), 5), new ItemStack(ItemRegistry.demonized_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shiny_pearls.get(), 40), new ItemStack(ItemRegistry.moon_clock.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shiny_pearls.get(), 25), new ItemStack(ItemRegistry.band_of_lheiva_hunting.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shiny_pearls.get(), 1), new ItemStack(ItemRegistry.dream_sours.get(), 4), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shiny_pearls.get(), 4), new ItemStack(ItemRegistry.ever_arrow.get(), 32), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.shiny_pearls.get(), 5), new ItemStack(ItemRegistry.tormented_template.get(), 1), random.nextInt(7), 0),
				new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.rock_chunks.get(), 25), new ItemStack(ItemRegistry.karos_rockmaul.get(), 1), random.nextInt(7), 0),
		};
		this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
	}
}