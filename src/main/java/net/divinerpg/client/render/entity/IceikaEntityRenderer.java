package net.divinerpg.client.render.entity;

import net.divinerpg.blocks.iceika.tileentity.TileEntityFrostedChest;
import net.divinerpg.blocks.iceika.tileentity.TileEntityPresentBox;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.RenderIconProjectile;
import net.divinerpg.client.render.RenderSizeable;
import net.divinerpg.client.render.RenderSpecialProjectile;
import net.divinerpg.client.render.block.RenderFrostedChest;
import net.divinerpg.client.render.block.RenderPresentBox;
import net.divinerpg.client.render.entity.iceika.RenderFrosty;
import net.divinerpg.client.render.entity.iceika.model.ModelAlicanto;
import net.divinerpg.client.render.entity.iceika.model.ModelFractite;
import net.divinerpg.client.render.entity.iceika.model.ModelGlacide;
import net.divinerpg.client.render.entity.iceika.model.ModelHastreus;
import net.divinerpg.client.render.entity.iceika.model.ModelRollum;
import net.divinerpg.client.render.entity.iceika.model.ModelWorkshop;
import net.divinerpg.client.render.entity.vanilla.RenderModBiped;
import net.divinerpg.client.render.item.ItemRendererFrostedChest;
import net.divinerpg.client.render.item.ItemRendererPresentBox;
import net.divinerpg.entities.iceika.EntityAlicanto;
import net.divinerpg.entities.iceika.EntityFractite;
import net.divinerpg.entities.iceika.EntityFrostArcher;
import net.divinerpg.entities.iceika.EntityFrosty;
import net.divinerpg.entities.iceika.EntityGlacide;
import net.divinerpg.entities.iceika.EntityHastreus;
import net.divinerpg.entities.iceika.EntityRollum;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityFractiteShot;
import net.divinerpg.entities.iceika.projectile.EntitySerenadeOfIce;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.entities.iceika.projectile.EntitySnowflakeShuriken;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class IceikaEntityRenderer {

    public static void init() {

        RenderingRegistry.registerEntityRenderingHandler(EntityCarol.class, new RenderSpecialProjectile(EntityResourceLocation.music));
        RenderingRegistry.registerEntityRenderingHandler(EntityMusic.class, new RenderSpecialProjectile(EntityResourceLocation.music));
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowflakeShuriken.class, new RenderIconProjectile(IceikaItems.snowflakeShuriken));
        RenderingRegistry.registerEntityRenderingHandler(EntityFractiteShot.class, new RenderSpecialProjectile(EntityResourceLocation.fractiteShot, 2.0F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySerenadeOfIce.class, new RenderSpecialProjectile(EntityResourceLocation.blank));

        RenderingRegistry.registerEntityRenderingHandler(EntityAlicanto.class, new RenderDivineMob(new ModelAlicanto(), 0.0F, EntityResourceLocation.ALICANTO));
        RenderingRegistry.registerEntityRenderingHandler(EntityFractite.class, new RenderDivineMob(new ModelFractite(), 0.5F, EntityResourceLocation.FRACTITE));
        RenderingRegistry.registerEntityRenderingHandler(EntityGlacide.class, new RenderSizeable(new ModelGlacide(), 0.0F, 1.0F, EntityResourceLocation.GLACON));
        RenderingRegistry.registerEntityRenderingHandler(EntityHastreus.class, new RenderDivineMob(new ModelHastreus(), 0.0F, EntityResourceLocation.HASTERUS));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostArcher.class, new RenderModBiped(new ModelBiped(), EntityResourceLocation.FROZEN_ARCHER));
        RenderingRegistry.registerEntityRenderingHandler(EntityRollum.class, new RenderDivineMob(new ModelRollum(), 0.0F, EntityResourceLocation.ROLLUM));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrosty.class, new RenderFrosty());
        RenderingRegistry.registerEntityRenderingHandler(EntityWorkshopTinkerer.class, new RenderDivineMob(new ModelWorkshop(), 0.0F, EntityResourceLocation.WORKSHOP_TINKER));
        RenderingRegistry.registerEntityRenderingHandler(EntityWorkshopMerchant.class, new RenderDivineMob(new ModelWorkshop(), 0.0F, EntityResourceLocation.WORKSHOP_MERCHANT));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostedChest.class, new RenderFrostedChest());
        MinecraftForgeClient.registerItemRenderer(Util.toItem(IceikaBlocks.frostedChest), new ItemRendererFrostedChest());
        MinecraftForgeClient.registerItemRenderer(Util.toItem(IceikaBlocks.decorativeFrostedChest), new ItemRendererFrostedChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresentBox.class, new RenderPresentBox());
        MinecraftForgeClient.registerItemRenderer(Util.toItem(IceikaBlocks.presentBox), new ItemRendererPresentBox());
    }
}
