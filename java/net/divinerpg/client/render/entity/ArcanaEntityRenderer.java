package net.divinerpg.client.render.entity;

import net.divinerpg.api.entity.EntityStats;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDemonFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDramixAltar;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityExtractor;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityParasectaAltar;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.RenderDivineBoss;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.RenderIconProjectile;
import net.divinerpg.client.render.RenderProjectile;
import net.divinerpg.client.render.RenderSizeable;
import net.divinerpg.client.render.block.TileEntityDemonFurnaceRenderer;
import net.divinerpg.client.render.block.TileEntityDramixAltarRenderer;
import net.divinerpg.client.render.block.TileEntityExtractorRenderer;
import net.divinerpg.client.render.block.TileEntityParasectaAltarRenderer;
import net.divinerpg.client.render.block.item_renderer.ItemRenderAltar;
import net.divinerpg.client.render.block.item_renderer.ItemRenderDemonFurnace;
import net.divinerpg.client.render.entity.arcana.RenderStarlight;
import net.divinerpg.client.render.entity.arcana.model.ModelDeathHound;
import net.divinerpg.client.render.entity.arcana.model.ModelDeathcryx;
import net.divinerpg.client.render.entity.arcana.model.ModelDramix;
import net.divinerpg.client.render.entity.arcana.model.ModelDungeonDemon;
import net.divinerpg.client.render.entity.arcana.model.ModelDungeonPrisoner;
import net.divinerpg.client.render.entity.arcana.model.ModelLeorna;
import net.divinerpg.client.render.entity.arcana.model.ModelParasecta;
import net.divinerpg.client.render.entity.arcana.model.ModelParatiku;
import net.divinerpg.client.render.entity.arcana.model.ModelRazorback;
import net.divinerpg.client.render.entity.arcana.model.ModelRoamer;
import net.divinerpg.client.render.entity.arcana.model.ModelSeimer;
import net.divinerpg.client.render.entity.arcana.model.ModelWraith;
import net.divinerpg.client.render.entity.twilight.model.ModelSamek;
import net.divinerpg.client.render.entity.twilight.model.ModelTwilightGolem;
import net.divinerpg.entity.arcana.EntityCaptianMerik;
import net.divinerpg.entity.arcana.EntityConstructor;
import net.divinerpg.entity.arcana.EntityDatticon;
import net.divinerpg.entity.arcana.EntityDeathHound;
import net.divinerpg.entity.arcana.EntityDeathcryx;
import net.divinerpg.entity.arcana.EntityDramix;
import net.divinerpg.entity.arcana.EntityDungeonDemon;
import net.divinerpg.entity.arcana.EntityDungeonPrisoner;
import net.divinerpg.entity.arcana.EntityFyracryx;
import net.divinerpg.entity.arcana.EntityGolemOfRejuv;
import net.divinerpg.entity.arcana.EntityLeorna;
import net.divinerpg.entity.arcana.EntityLivingStatue;
import net.divinerpg.entity.arcana.EntityParasecta;
import net.divinerpg.entity.arcana.EntityParatiku;
import net.divinerpg.entity.arcana.EntityRazorback;
import net.divinerpg.entity.arcana.EntityRoamer;
import net.divinerpg.entity.arcana.EntitySeimer;
import net.divinerpg.entity.arcana.EntityVatticus;
import net.divinerpg.entity.arcana.EntityVermsillion;
import net.divinerpg.entity.arcana.EntityWraith;
import net.divinerpg.entity.arcana.EntityZelus;
import net.divinerpg.entity.arcana.projectile.EntityFirefly;
import net.divinerpg.entity.arcana.projectile.EntityGrenade;
import net.divinerpg.entity.arcana.projectile.EntityLamona;
import net.divinerpg.entity.arcana.projectile.EntityMerikMissile;
import net.divinerpg.entity.arcana.projectile.EntityReflector;
import net.divinerpg.entity.arcana.projectile.EntitySparkler;
import net.divinerpg.entity.arcana.projectile.EntityStar;
import net.divinerpg.helper.Util;
import net.divinerpg.helper.blocks.ArcanaBlocks;
import net.divinerpg.helper.items.ArcanaItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ArcanaEntityRenderer {

	private static EntityResourceLocation x;
	private static EntityStats s;

	@SuppressWarnings("fix textures for projectiles")
	public static void init(){
		RenderingRegistry.registerEntityRenderingHandler(EntityStar.class, new RenderStarlight(x.starlight));
		RenderingRegistry.registerEntityRenderingHandler(EntitySparkler.class, new RenderProjectile(x.sparkler));
		RenderingRegistry.registerEntityRenderingHandler(EntityFirefly.class, new RenderProjectile(x.sparkler));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderIconProjectile(ArcanaItems.grenade));
		RenderingRegistry.registerEntityRenderingHandler(EntityLamona.class, new RenderProjectile(x.sparkler));
		RenderingRegistry.registerEntityRenderingHandler(EntityMerikMissile.class, new RenderProjectile(x.sparkler));
		RenderingRegistry.registerEntityRenderingHandler(EntityReflector.class, new RenderProjectile(x.sparkler));

        RenderingRegistry.registerEntityRenderingHandler(EntityRoamer.class, new RenderDivineMob(new ModelRoamer(), x.roamer));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathcryx.class, new RenderDivineMob(new ModelDeathcryx(), x.deathcryx));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeathHound.class, new RenderDivineMob(new ModelDeathHound(), x.death_hound));
        RenderingRegistry.registerEntityRenderingHandler(EntityLeorna.class, new RenderDivineMob(new ModelLeorna(), x.leorna));
        RenderingRegistry.registerEntityRenderingHandler(EntityRazorback.class, new RenderDivineMob(new ModelRazorback(), x.razorback));
        RenderingRegistry.registerEntityRenderingHandler(EntityConstructor.class, new RenderSizeable(new ModelDramix(), 0.0F, 0.4F, x.constructor));
        RenderingRegistry.registerEntityRenderingHandler(EntityLivingStatue.class, new RenderDivineMob(new ModelBiped(), x.living_statue));
        RenderingRegistry.registerEntityRenderingHandler(EntityDungeonPrisoner.class, new RenderDivineMob(new ModelDungeonPrisoner(), x.dungeon_prisoner));
        RenderingRegistry.registerEntityRenderingHandler(EntityDungeonDemon.class, new RenderDivineMob(new ModelDungeonDemon(), x.dungeon_demon));
        RenderingRegistry.registerEntityRenderingHandler(EntityCaptianMerik.class, new RenderDivineMob(new ModelSamek(), x.captain_merik));
        RenderingRegistry.registerEntityRenderingHandler(EntityDatticon.class, new RenderDivineMob(new ModelSamek(), x.datticon));
        RenderingRegistry.registerEntityRenderingHandler(EntityVatticus.class, new RenderDivineMob(new ModelBiped(), x.vatticus));
        RenderingRegistry.registerEntityRenderingHandler(EntityZelus.class, new RenderDivineMob(new ModelBiped(), x.zelus));
        RenderingRegistry.registerEntityRenderingHandler(EntityFyracryx.class, new RenderDivineMob(new ModelDeathcryx(), x.fyracryx));
        RenderingRegistry.registerEntityRenderingHandler(EntityParatiku.class, new RenderDivineMob(new ModelParatiku(), x.paratiku));
        RenderingRegistry.registerEntityRenderingHandler(EntityGolemOfRejuv.class, new RenderDivineMob(new ModelTwilightGolem(), x.golem_rejuv));
        RenderingRegistry.registerEntityRenderingHandler(EntitySeimer.class, new RenderDivineMob(new ModelSeimer(), x.seimer));
        RenderingRegistry.registerEntityRenderingHandler(EntityWraith.class, new RenderDivineMob(new ModelWraith(), x.wraith));
        RenderingRegistry.registerEntityRenderingHandler(EntityDramix.class, new RenderDivineBoss(new ModelDramix(), 0.7F, 1.2F, x.dramix, s.dramixBossID));
        RenderingRegistry.registerEntityRenderingHandler(EntityParasecta.class, new RenderDivineBoss(new ModelParasecta(), 0.7F, 1.0F, x.parasecta, s.parasectaBossID));

		addBlockRendering();
	}
	
	public static void addBlockRendering(){
		Util.registerItemRenderer(ArcanaBlocks.dramixAltar, new ItemRenderAltar("dramixAltar"));
		Util.registerItemRenderer(ArcanaBlocks.parasectaAltar, new ItemRenderAltar("parasectaAltar"));
		Util.registerItemRenderer(ArcanaBlocks.extractor, new ItemRenderAltar("extractor"));
		Util.registerItemRenderer(ArcanaBlocks.demonFurnace, new ItemRenderDemonFurnace());
		Util.registerItemRenderer(ArcanaBlocks.demonFurnaceOn, new ItemRenderDemonFurnace());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new TileEntityDramixAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new TileEntityParasectaAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtractor.class, new TileEntityExtractorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonFurnace.class, new TileEntityDemonFurnaceRenderer());
	}
}