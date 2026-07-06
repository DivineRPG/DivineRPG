package net.divinerpg.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.function.BiConsumer;

import static net.divinerpg.DivineRPG.MODID;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider {
    public ModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(createKey("realmite"), onlyHumanoid("realmite"));
        output.accept(createKey("seng_fur"), onlyHumanoid("seng_fur"));
        output.accept(createKey("santa"), onlyHumanoid("santa"));
        output.accept(createKey("aquastrive"), onlyHumanoid("aquastrive"));
        output.accept(createKey("kraken"), onlyHumanoid("kraken"));
        output.accept(createKey("jack_o_man"), onlyHumanoid("jack_o_man"));
        output.accept(createKey("skeleman"), onlyHumanoid("skeleman"));
        output.accept(createKey("wither_reaper"), onlyHumanoid("wither_reaper"));
        output.accept(createKey("arlemite"), onlyHumanoid("arlemite"));
        output.accept(createKey("frozen"), onlyHumanoid("frozen"));
        output.accept(createKey("jungle"), onlyHumanoid("jungle"));
        output.accept(createKey("inferno"), onlyHumanoid("inferno"));
        output.accept(createKey("torridite"), onlyHumanoid("torridite"));
        output.accept(createKey("terran"), onlyHumanoid("terran"));
        output.accept(createKey("angelic"), onlyHumanoid("angelic"));
        output.accept(createKey("shadow"), onlyHumanoid("shadow"));
        output.accept(createKey("rupee"), onlyHumanoid("rupee"));
        output.accept(createKey("red_rupee"), onlyHumanoid("red_rupee"));
        output.accept(createKey("yellow_rupee"), onlyHumanoid("yellow_rupee"));
        output.accept(createKey("green_rupee"), onlyHumanoid("green_rupee"));
        output.accept(createKey("blue_rupee"), onlyHumanoid("blue_rupee"));
        output.accept(createKey("gray_rupee"), onlyHumanoid("gray_rupee"));
        output.accept(createKey("elite_realmite"), onlyHumanoid("elite_realmite"));
        output.accept(createKey("corrupted"), onlyHumanoid("corrupted"));
        output.accept(createKey("bedrock"), onlyHumanoid("bedrock"));
        output.accept(createKey("korma"), onlyHumanoid("korma"));
        output.accept(createKey("vemos"), onlyHumanoid("vemos"));
        output.accept(createKey("ender"), onlyHumanoid("ender"));
        output.accept(createKey("red_ender"), onlyHumanoid("red_ender"));
        output.accept(createKey("yellow_ender"), onlyHumanoid("yellow_ender"));
        output.accept(createKey("green_ender"), onlyHumanoid("green_ender"));
        output.accept(createKey("blue_ender"), onlyHumanoid("blue_ender"));
        output.accept(createKey("gray_ender"), onlyHumanoid("gray_ender"));
        output.accept(createKey("divine"), onlyHumanoid("divine"));
        output.accept(createKey("eden"), onlyHumanoid("eden"));
        output.accept(createKey("wildwood"), onlyHumanoid("wildwood"));
        output.accept(createKey("apalachia"), onlyHumanoid("apalachia"));
        output.accept(createKey("skythern"), onlyHumanoid("skythern"));
        output.accept(createKey("mortum"), onlyHumanoid("mortum"));
        output.accept(createKey("halite"), onlyHumanoid("halite"));
        output.accept(createKey("awakened_halite"), onlyHumanoid("awakened_halite"));
        output.accept(createKey("degraded_helmet"), onlyHumanoid("degraded_helmet"));
        output.accept(createKey("degraded_hood"), onlyHumanoid("degraded_hood"));
        output.accept(createKey("degraded_mask"), onlyHumanoid("degraded_mask"));
        output.accept(createKey("degraded"), onlyHumanoid("degraded"));
        output.accept(createKey("finished_helmet"), onlyHumanoid("finished_helmet"));
        output.accept(createKey("finished_hood"), onlyHumanoid("finished_hood"));
        output.accept(createKey("finished_mask"), onlyHumanoid("finished_mask"));
        output.accept(createKey("finished"), onlyHumanoid("finished"));
        output.accept(createKey("glistening_helmet"), onlyHumanoid("glistening_helmet"));
        output.accept(createKey("glistening_hood"), onlyHumanoid("glistening_hood"));
        output.accept(createKey("glistening_mask"), onlyHumanoid("glistening_mask"));
        output.accept(createKey("glistening"), onlyHumanoid("glistening"));
        output.accept(createKey("demonized_helmet"), onlyHumanoid("demonized_helmet"));
        output.accept(createKey("demonized_hood"), onlyHumanoid("demonized_hood"));
        output.accept(createKey("demonized_mask"), onlyHumanoid("demonized_mask"));
        output.accept(createKey("demonized"), onlyHumanoid("demonized"));
        output.accept(createKey("tormented_helmet"), onlyHumanoid("tormented_helmet"));
        output.accept(createKey("tormented_hood"), onlyHumanoid("tormented_hood"));
        output.accept(createKey("tormented_mask"), onlyHumanoid("tormented_mask"));
        output.accept(createKey("tormented"), onlyHumanoid("tormented"));
    }

    private ResourceKey<EquipmentAsset> createKey(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(MODID, name));
    }

    public static EquipmentClientInfo onlyHumanoid(String name) {
        return EquipmentClientInfo.builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(MODID, name)).build();
    }
}